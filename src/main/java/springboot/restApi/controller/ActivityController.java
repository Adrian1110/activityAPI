package springboot.restApi.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springboot.restApi.model.ActivityModel;
import springboot.restApi.service.ActivityService;


@RestController
@Api(value = "Create activites controller")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostMapping(value = "/activity/")
	@ResponseBody 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ActivityModel> createActivity(@RequestBody ActivityModel inputData){
		return activityService.addActivity(inputData);
	}

	@PutMapping(value = "/activity/{name}")
	@ResponseBody 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ActivityModel> updateActivity(@PathVariable String name, @RequestBody ActivityModel inputData){
		return activityService.updateActivity(name, inputData);
	}

	@DeleteMapping(value = "/activity/{name}")
	@ResponseBody 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ActivityModel> deleteActivity(@PathVariable String name){
		return activityService.deleteActivity(name);
	}

	@GetMapping(value = "/filterActivitiesByName")
	@ResponseBody 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ActivityModel> filterActivitiesById(@RequestParam String name){
		return activityService.filterActivitiesByName(name);			
	}

	@GetMapping(value = "/filterActivitiesByAuthor")
	@ResponseBody 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ActivityModel>> filterActivitiesByAuthor(@RequestParam String author){
		return activityService.filterActivitiesByAuthor(author);			
	}

	@GetMapping(value = "/filterActivitiesByDays")
	@ResponseBody 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ActivityModel>> filterActivitiesByDays(@RequestParam Integer days ){
		return activityService.filterActivitiesByDays(days);					
	}

	@GetMapping(value = "/filterActivitiesByKeyword")
	@ResponseBody 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ActivityModel>> filterActivitiesByKeyword(@RequestParam String keyword, @RequestParam String value ){
		return activityService.filterActivitiesByKeyword(keyword, value);					
	}
}
