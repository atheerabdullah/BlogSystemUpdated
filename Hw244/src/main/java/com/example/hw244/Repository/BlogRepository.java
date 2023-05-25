package com.example.hw244.Repository;

import com.example.hw244.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog , Integer> {

    //get Blog By id
    Blog findBlogById(Integer id);

    // get blog by tittle
    List<Blog> findBlogByTitle(String title);

    // get all blogs by Category
    List<Blog> findBlogByCategory(String category);

    // change status
    Blog updatePublishedState(boolean published);



}
