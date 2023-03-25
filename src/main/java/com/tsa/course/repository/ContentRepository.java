package com.tsa.course.repository;


import com.tsa.course.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentRepository() {

    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findByID(Integer id) {
        return contents.stream().filter(c-> c.id().equals(id)).findFirst();
    }

    public void create(Content content) {
        contents.add(content);
    }
}
