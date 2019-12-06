package springboot.restApi.Helper;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import springboot.restApi.model.ActivityModel;
import springboot.restApi.storage.ActivityStorage;

public class Helper {
	
	private Helper() {}

	public static ActivityModel findModel(String name) {
		return ActivityStorage.getInstance().
				stream().
				filter(activity -> name.equals(activity.getName())).
				findAny().
				orElse(null);
	}

	public static boolean checkIfExist(ActivityModel model) {
		return ActivityStorage.getInstance().
				stream().
				anyMatch(c -> c.getName().
						equals(model.getName()));
	}

	public static List<ActivityModel> getActivityByAuthor( final String author){
		List<ActivityModel> filteredList = new ArrayList<>();
		for (ActivityModel mod : ActivityStorage.getInstance()){
			if(mod.getAuthor().equals(author))
				filteredList.add(mod);
		}
		return filteredList;
	}

	public static List<ActivityModel> getActivitysFromLastDays( final Integer days){
		List<ActivityModel> filteredList = new ArrayList<>();
		Period p = Period.ofDays(days);
		LocalDate currentDate = LocalDate.now();
		LocalDate startDate = currentDate.minus(p);

		ActivityStorage.getInstance().
		stream().
		filter(model -> model.getCreationDate().isAfter(startDate)).
		forEach(filteredList::add);

		return filteredList;
	}

	public static List<ActivityModel> getActivityByKeyword( final String keyword, final String value){
		List<ActivityModel> filteredList = new ArrayList<>();
		switch(keyword) {

		case "header": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getHeader().equals(value)).
			forEach(filteredList::add);
			return filteredList;

		case "name": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getName() .equals(value)).
			forEach(filteredList::add);
			return filteredList;

		case "short_description": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getShortDescription() .equals(value)).
			forEach(filteredList::add);
			return filteredList;

		case "procurment_channel": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getProcurementChannel().equals(value)).
			forEach(filteredList::add);
			return filteredList;

		case "creation_date": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getCreationDate().isEqual(LocalDate.parse(value))).
			forEach(filteredList::add);
			return filteredList;

		case "author": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getAuthor().equals(value)).
			forEach(filteredList::add);
			return filteredList;

		case "quantity": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getQuantity() == Integer.parseInt(value)).
			forEach(filteredList::add);
			return filteredList;

		case "price": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getPrice() == Float.parseFloat(value)).
			forEach(filteredList::add);
			return filteredList;

		case "status": 
			ActivityStorage.getInstance().stream().
			filter(e -> e.getStatus().equals(value)).
			forEach(filteredList::add);
			return filteredList;

		default:
			return filteredList;

		}
	}
}
