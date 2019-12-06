package springboot.restApi.service;

import static springboot.restApi.Helper.Helper.checkIfExist;
import static springboot.restApi.Helper.Helper.findModel;
import static springboot.restApi.Helper.Helper.getActivityByAuthor;
import static springboot.restApi.Helper.Helper.getActivityByKeyword;
import static springboot.restApi.Helper.Helper.getActivitysFromLastDays;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springboot.restApi.model.ActivityModel;
import springboot.restApi.storage.ActivityStorage;

@Service
public class ActivityService {

	public ResponseEntity<ActivityModel> addActivity(ActivityModel model) {
		boolean itemExists = checkIfExist(model);
		if(!itemExists) {
			ActivityStorage.getInstance().add(model);
			return new ResponseEntity<>(model, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(model,HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<ActivityModel> deleteActivity(String name) {
		ActivityModel model = findModel(name);
		if(model != null) {
			ActivityStorage.getInstance().remove(model);
			return new ResponseEntity<>(model, HttpStatus.OK);
		}
		return new ResponseEntity<>(model, HttpStatus.NO_CONTENT); 
	}

	public ResponseEntity<ActivityModel> updateActivity(String name, ActivityModel inputData) {
		ActivityModel model = findModel(name);
		if(model!= null) {
			int index = ActivityStorage.getInstance().indexOf(model);
			ActivityStorage.getInstance().set(index, inputData);
			return new ResponseEntity<>(inputData, HttpStatus.OK);

		}else {
			inputData.setName(name);
			ActivityStorage.getInstance().add(inputData);
			return new ResponseEntity<>(inputData, HttpStatus.CREATED);
		}	
	}

	public ResponseEntity<ActivityModel> filterActivitiesByName(String name) {
		ActivityModel model = findModel(name);
		if(model ==null)
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(model, HttpStatus.OK);
	}

	public ResponseEntity<List<ActivityModel>> filterActivitiesByAuthor(String author) {
		return new ResponseEntity<>(getActivityByAuthor(author), HttpStatus.OK);
	}

	public ResponseEntity<List<ActivityModel>> filterActivitiesByDays(Integer days) {
		return new ResponseEntity<>(getActivitysFromLastDays(days), HttpStatus.OK);

	}
	public ResponseEntity<List<ActivityModel>> filterActivitiesByKeyword(String keyword, String value){
		return new ResponseEntity<>(getActivityByKeyword(keyword, value), HttpStatus.OK);
	}

}
