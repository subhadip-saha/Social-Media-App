package com.socialmedianetwork.photoshare.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedianetwork.photoshare.Entity.Status;
import com.socialmedianetwork.photoshare.Repository.StatusRepo;



@Service
public class StatusService {

	@Autowired
	StatusRepo statusRepo;
	
	@Autowired
	UserService userService;
	
	public Status submitDataIntoDB(Status status) {
		//return new Status();
		return statusRepo.save(status);
		
	}
	
	public ArrayList<Status> retrieveStatus(){
		
		//return new ArrayList<Status>();
		//return statusRepo.findAll();
		
		ArrayList<Status> statusList=statusRepo.findAll();
		
		for(int i=0;i<statusList.size();i++) {
			Status statusItem=statusList.get(i);
			statusItem.setUserName(userService.displayUserMetaData(statusItem.getUserId()).getUserName());
		}
		
		return statusList;
	}
}
