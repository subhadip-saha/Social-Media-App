package com.socialmedianetwork.photoshare.Service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedianetwork.photoshare.Entity.Post;
import com.socialmedianetwork.photoshare.Repository.PostRepo;



@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserService userService;
	
	public Post submitPostToDataBase(Post post) {
		//return new Post();
		return postRepo.save(post);
	}
	
	public ArrayList<Post> retrivePostFromDB(){

		//return new ArrayList<Post>();
		//return postRepo.findAll();
		
		ArrayList<Post> postList=postRepo.findAll();
		
		for(int i=0;i<postList.size();i++) {
			Post postItem=postList.get(i);
			postItem.setUserName(userService.displayUserMetaData(postItem.getUserId()).getUserName());
		}
		Collections.sort(postList,(a,b)->b.getId()-a.getId());
		return postList;
	}
	
}
