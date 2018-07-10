DROP TABLE IF EXISTS news;

CREATE TABLE news (
	id VARCHAR(150) PRIMARY KEY NOT NULL,
  	label VARCHAR(150) NOT NULL,
    shortText VARCHAR(550) NOT NULL,
    fullText VARCHAR(550) NOT NULL,
    pictureUrl VARCHAR(155) NOT NULL,
    pub_date VARCHAR(50) NOT NULL);

INSERT INTO news(id,label,shortText,fullText,pictureUrl,pub_date)
VALUES ('1','MotoGuard запускает проект по всей России!',
    'Сегодня стало известно, что компания OneOrg', 
    'Используя MotoGuard', 
    'http://www.bulgarianagriculture.com/re_images/1351544924_motogardlogo.gif', 
    '2018-04-02 19:28:37');