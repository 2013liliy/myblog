package com.example.myblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myblog.models.Account;
import com.example.myblog.models.Blog;

public interface BlogRepository extends JpaRepository<Blog,Long>{
	

}
