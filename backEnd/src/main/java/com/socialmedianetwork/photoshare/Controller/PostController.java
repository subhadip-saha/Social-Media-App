package com.socialmedianetwork.photoshare.Controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedianetwork.photoshare.Entity.Post;
import com.socialmedianetwork.photoshare.Service.PostService;



@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/post")

public class PostController {

	@Autowired
	PostService postService;
	
	@PostMapping("")
	private Post submitUserPost(@RequestBody Post post) {
		//return new Post();
		return postService.submitPostToDataBase(post);
	}
	
	@GetMapping("")
	private ArrayList<Post> getAllPost(){
		//return new ArrayList<Post>();
		return postService.retrivePostFromDB();
	}
}
