package com.example.hw244.Controller;


import com.example.hw244.Model.Blog;
import com.example.hw244.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@Controller
@RequiredArgsConstructor
public class BolgController {


    private final BlogService blogService;


    @GetMapping("/getAllBlog")
    public ResponseEntity getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/addBlog")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog) {
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PutMapping("/updateBlog/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog, @PathVariable Integer id) {
        blogService.updateBlog(id, blog);
        return ResponseEntity.status(200).body("The Blog updated");
    }

    @DeleteMapping("/deleteBlog/{id}")
    public ResponseEntity deleteCoffee(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("The Blog deleted ");
    }

    //find Blogs By id

    @GetMapping("/get-Blog/{id}")
    public ResponseEntity findBlogById(@PathVariable Integer id) {
        Blog blog = blogService.findBlogById(id);
        return ResponseEntity.status(200).body(blog);
    }

    // find by title
    @GetMapping("/get-Blog/{title}")
    public ResponseEntity findBlogByTitle(@PathVariable String title) {

        List<Blog> blog = blogService.findBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }
    //find by category

    @GetMapping("/get-Blog/{category}")
    public ResponseEntity findBlogByCategory(@PathVariable String category) {

        List<Blog> blogs = blogService.findBlogByCategory(category);
        return ResponseEntity.status(200).body(blogs);
    }

    @PutMapping("/{id}/publish{published}")
    public ResponseEntity<String> updatePublishedState(@PathVariable Integer id, @PathVariable Boolean published) {

        Blog blog = blogService.findBlogById(id);
        return ResponseEntity.ok("Published state updated successfully");
    }
}

