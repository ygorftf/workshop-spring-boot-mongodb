package com.ygorftf.workshopmongo.repository;

import com.ygorftf.workshopmongo.domain.Post;
import com.ygorftf.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
