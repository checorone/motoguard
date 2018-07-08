package com.oneorg.news.controllers;


import com.oneorg.news.model.News;
import com.oneorg.news.services.NewsService;
import com.oneorg.news.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value="v1")
public class NewsServiceController {
    @Autowired
    private NewsService newsService;
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceController.class);

    @RequestMapping(value="",method = RequestMethod.GET)
    public Iterable<News> getNews() {
        logger.debug("Looking up for news");
        return newsService.getNews();
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
