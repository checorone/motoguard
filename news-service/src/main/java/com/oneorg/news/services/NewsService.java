package com.oneorg.news.services;

import com.oneorg.news.model.News;
import com.oneorg.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public Iterable<News> getNews() {
        return newsRepository.findAll();
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
