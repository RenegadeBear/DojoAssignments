package com.rnc.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.events.models.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

}
