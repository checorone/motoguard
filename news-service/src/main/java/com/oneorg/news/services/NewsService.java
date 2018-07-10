package com.oneorg.news.services;

import com.oneorg.news.controllers.NewsServiceController;
import com.oneorg.news.model.News;
import com.oneorg.news.repository.NewsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceController.class);

    public List<News> getNews() {
    	Iterable<News> source = newsRepository.findAllNews();
    	List<News> target = new ArrayList<>();
    	source.forEach(target::add);
        return target;
    }

    public void saveNews(News news){
        newsRepository.save(news);
    }

    public void updateNews(News news){
        newsRepository.save(news);
    }

    public void deleteNews(News news){
        newsRepository.delete( news.getId());
    }
}
