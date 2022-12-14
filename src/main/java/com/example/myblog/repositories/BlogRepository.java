package com.example.myblog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myblog.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

	Blog findByTitle(String title);

	List<Blog> findByUsername(String username);

	void editById(Long id);

}
