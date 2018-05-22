package com.rnc.events.services;

import org.springframework.stereotype.Service;

import com.rnc.events.models.Comment;
import com.rnc.events.repositories.CommentRepo;

@Service
public class CommentService {
	private CommentRepo commentRepo;
	
	public CommentService(CommentRepo commentRepo) {
		this.commentRepo = commentRepo;
	}
	
	public Comment create(Comment comment) {
		return commentRepo.save(comment);
	}
	
	
}
