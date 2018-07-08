package com.oneorg.news.services;

import com.oneorg.news.model.News;
import com.oneorg.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> getNews() {
    	Iterable<News> source = newsRepository.findAll();
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
