package com.socialmedianetwork.photoshare.Controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedianetwork.photoshare.Entity.Comments;
import com.socialmedianetwork.photoshare.Service.CommentsService;



@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/comments")

public class CommentController {
	
	@Autowired
	CommentsService commentsService;
	
	@PostMapping("")
	private Comments submitComment(@RequestBody Comments comment) {
		//return new Comments();
		return commentsService.submitCommentToDB(comment);
	}
	
	@GetMapping("/{postId}")
	private ArrayList<Comments> getCommentsForPost(@PathVariable("postId") String postId){
		//return new ArrayList<Comments>();
		return commentsService.getAllCommentsForDB(postId);
	}

}
