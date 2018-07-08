package com.oneorg.news.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News {
    @Id
    @Column(name = "id", nullable = false)
    String id;

	@Column(name = "label", nullable = false)
    String label;

    @Column(name = "shortText", nullable = false)
    String shortText;

    @Column(name = "fullText", nullable = false)
    String fullText;

    @Column(name = "pictureUrl", nullable = false)
    String pictureUrl;

    @Column(name = "pub_date", nullable = false)
    String pub_date;
    
    
    public String getId() {
 		return id;
 	}

 	public void setId(String id) {
 		this.id = id;
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

 	public String getPub_date() {
 		return pub_date;
 	}

 	public void setPub_date(String pub_date) {
 		this.pub_date = pub_date;
 	}

}
