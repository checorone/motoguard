package com.oneorg.news.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "news")
public class News{
    @Id
    @Column(name = "news_id", nullable = false)
    String newsId;

	@Column(name = "label", nullable = false)
    String label;

    @Column(name = "short_text", nullable = false)
    String shortText;

    @Column(name = "full_text", nullable = false)
    String fullText;

    @Column(name = "picture_url", nullable = false)
    String pictureUrl;

    @Column(name = "pub_date", nullable = false)
    String pubDate;
    
    
    public String getNewsId() {
 		return newsId;
 	}

 	public void setNewsId(String newsId) {
 		this.newsId = newsId;
 	}

 	public String getLabel() {
 		return label;
 	}

 	public void setLabel(String label) {
 		this.label = label;
 	}

 	public String getShortText() {
 		return shortText;
 	}

 	public void setShortText(String shortText) {
 		this.shortText = shortText;
 	}

 	public String getFullText() {
 		return fullText;
 	}

 	public void setFullText(String fullText) {
 		this.fullText = fullText;
 	}

 	public String getPictureUrl() {
 		return pictureUrl;
 	}

 	public void setPictureUrl(String pictureUrl) {
 		this.pictureUrl = pictureUrl;
 	}

 	public String getPubDate() {
 		return pubDate;
 	}

 	public void setPubDate(String pubDate) {
 		this.pubDate = pubDate;
 	}

}
