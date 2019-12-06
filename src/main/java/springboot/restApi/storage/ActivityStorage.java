package springboot.restApi.storage;

import java.util.ArrayList;
import java.util.List;

import springboot.restApi.model.ActivityModel;

public class ActivityStorage {
	
	private ActivityStorage() {}
	
	private static List<ActivityModel> acitivesList = null;
	
	public static List<ActivityModel> getInstance(){
		if(acitivesList == null)
			acitivesList = new ArrayList<>();
		
		return acitivesList;
	}
}
