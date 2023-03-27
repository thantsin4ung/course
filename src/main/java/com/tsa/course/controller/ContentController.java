package com.tsa.course.controller;

import com.tsa.course.model.Content;
import com.tsa.course.repository.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContentController {

    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("/content")
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @GetMapping("/content/{id}")
    public Content findByID(@PathVariable Integer id) {
        return contentRepository.findByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @PostMapping("/add")
    public void created(@RequestBody Content content) {
        contentRepository.create(content);
    }
}
