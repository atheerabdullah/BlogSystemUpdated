package com.example.hw244.Service;


import com.example.hw244.ApiException.ApiException;
import com.example.hw244.Model.Blog;
import com.example.hw244.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;


    //CRUD Apis

    //get all blogs
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    // add blog
    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    // update blog
    public void updateBlog(Integer id, Blog blog) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if (oldBlog == null) {
            throw new ApiException("Blog not found, sorry :( ");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setPublished(blog.isPublished());
        blogRepository.save(oldBlog);
    }

    //delete blog
    public void deleteBlog(Integer id) {
        Blog blog = blogRepository.findBlogById(id);
        blogRepository.delete(blog);
    }

    //get Blog By id

    public Blog findBlogById(Integer id) {
        Blog idBlog = blogRepository.findBlogById(id);
        if (idBlog == null) {
            throw new ApiException("The Id blog not found !");
        }
        return idBlog;
    }

    //find Blogs By Title
    public List<Blog> findBlogByTitle(String title) {
        List<Blog> BlogTitle = blogRepository.findBlogByTitle(title);
        if (BlogTitle == null) {
            throw new ApiException("not match the title");
        }
        return BlogTitle;
    }

    //find Blog By Category
    public List<Blog> findBlogByCategory(String category) {
        List<Blog> BlogCategory = blogRepository.findBlogByCategory(category);
        if (BlogCategory == null) {

            throw new ApiException("not match the Category");
        }
        return BlogCategory;


    }

    //change published states to True
    public Blog updatePublishedState(Integer id, Boolean published) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("Blog post not found");
        }
        blog.setPublished(published);
        blogRepository.save(blog);
        return blog;
    }
}
