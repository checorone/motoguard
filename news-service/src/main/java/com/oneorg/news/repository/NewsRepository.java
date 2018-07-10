package com.oneorg.news.repository;

import com.oneorg.news.model.News;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News,String>  {
	@Query("select * from news")
	public Iterable<News> findAllNews();
}
