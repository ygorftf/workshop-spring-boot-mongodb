package com.ygorftf.workshopmongo.services;

import com.ygorftf.workshopmongo.domain.Post;
import com.ygorftf.workshopmongo.domain.User;
import com.ygorftf.workshopmongo.dto.UserDTO;
import com.ygorftf.workshopmongo.repository.PostRepository;
import com.ygorftf.workshopmongo.repository.UserRepository;
import com.ygorftf.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}