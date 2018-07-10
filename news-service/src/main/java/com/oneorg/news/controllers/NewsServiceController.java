package com.oneorg.news.controllers;

import com.oneorg.news.model.News;
import com.oneorg.news.services.NewsService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(value="v1")
public class NewsServiceController {
    @Autowired
    private NewsService newsService;
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceController.class);

    @RequestMapping(value="",method = RequestMethod.GET)
    public @ResponseBody List<News> getNews() {
        logger.info("Looking up for news");
        List<News> ns = newsService.getNews();
        logger.info(String.valueOf(ns.size()));
        return ns;
    }

    @RequestMapping(value="",method = RequestMethod.PUT)
    public void updateNews( @RequestBody News news) {
        newsService.updateNews( news );

    }

    @RequestMapping(value="",method = RequestMethod.POST)
    public void saveDevice(@RequestBody News news) {
       newsService.saveNews( news );
    }

    @RequestMapping(value="/{newsId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews( @PathVariable("newsId") Long newsId,  @RequestBody News news) {
        newsService.deleteNews( news );
    }
}
