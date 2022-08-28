package com.example.myblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myblog.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
	static Blog findByTitle(String title) {
		return null;
	}
}
