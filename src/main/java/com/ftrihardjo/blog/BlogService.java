package com.ftrihardjo.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repo;
    public List<Blog> listAll() {
        return repo.findAll();
    }
    public void save(Blog blog) {
        repo.save(blog);
    }
    public Blog get(Integer id) {
        return repo.findById(id).get();
    }
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
