package com.ftrihardjo.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BlogController {
    @Autowired
    private BlogService service;
    @GetMapping("/blog")
    public List<Blog> list() {
        return service.listAll();
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> get(@PathVariable Integer id) {
        try {
            Blog blog = service.get(id);
            return new ResponseEntity<Blog>(blog, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/blog")
    public void add(@RequestBody Blog blog) {
        service.save(blog);
    }
    @PutMapping("/blog/{id}")
    public ResponseEntity<?> update(@RequestBody Blog blog, @PathVariable Integer id) {
        try {
            service.delete(id);
            service.save(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/blog/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
