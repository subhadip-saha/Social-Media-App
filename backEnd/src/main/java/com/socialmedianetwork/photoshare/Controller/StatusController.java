package com.socialmedianetwork.photoshare.Controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedianetwork.photoshare.Entity.Status;
import com.socialmedianetwork.photoshare.Service.StatusService;



@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/status")

public class StatusController {

	@Autowired
	StatusService statusService;
	
	@PostMapping("")
	private Status submitStatus(@RequestBody Status status) {
		return statusService.submitDataIntoDB(status);
		//return new Status();
	}
	
	@GetMapping("")
	private ArrayList<Status> getAllStatus(){
		return statusService.retrieveStatus();
		//return new ArrayList<Status>();
	}
}
