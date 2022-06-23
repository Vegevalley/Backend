DROP TABLE IF EXISTS IMG_INFO;
DROP TABLE IF EXISTS VOTE_CONTENT;
DROP TABLE IF EXISTS IMG_INFO;
DROP TABLE IF EXISTS COMMENT;
DROP TABLE IF EXISTS VEGE_CONTENT;
DROP TABLE IF EXISTS RECIPE_CONTENT;
DROP TABLE IF EXISTS EMD;
DROP TABLE IF EXISTS USER;

CREATE TABLE USER(
                     ID	BIGINT	NOT NULL AUTO_INCREMENT,
                     USER_ID	VARCHAR(255) NOT NULL,
                     USER_NAME VARCHAR(255) NOT NULL,
                     LOCAL_ID BIGINT NOT NULL,
                     PASSWORD VARCHAR(255) NOT NULL,
                     DATE_CREATED DATETIME NOT NULL,
                     LAST_UPDATED DATETIME NOT NULL,
                     ROLE VARCHAR(255) NOT NULL,
                     PHONE_NUM VARCHAR(255) NOT NULL,
                     GOOD_VOTE BIGINT,
                     PRIMARY KEY(ID),
                     UNIQUE KEY(USER_NAME),
                     UNIQUE KEY(USER_ID),
                     UNIQUE KEY(PHONE_NUM)
);

CREATE TABLE EMD(
                    ID BIGINT NOT NULL AUTO_INCREMENT,
                    EMD_NAME VARCHAR(255) NOT NULL,
                    PRIMARY KEY(ID)
);

CREATE TABLE RECIPE_CONTENT(
                               RECIPE_CONTENT_ID BIGINT NOT NULL AUTO_INCREMENT,
                               AUTHOR_ID BIGINT NOT NULL,
                               TITLE VARCHAR(255) NOT NULL,
                               MAIN_TEXT LONGTEXT NOT NULL,
                               DATE_CREATED DATETIME NOT NULL,
                               LAST_UPDATED DATETIME NOT NULL,
                               PRIMARY KEY(RECIPE_CONTENT_ID),
                               FOREIGN KEY(AUTHOR_ID) REFERENCES USER(ID)
);

CREATE TABLE VEGE_CONTENT(
                             VEGE_CONTENT_ID BIGINT NOT NULL AUTO_INCREMENT,
                             AUTHOR_ID BIGINT NOT NULL,
                             TITLE VARCHAR(255) NOT NULL,
                             MAIN_TEXT LONGTEXT NOT NULL,
                             DATE_CREATED DATETIME NOT NULL,
                             LAST_UPDATED DATETIME NOT NULL,
                             VEGE VARCHAR(255) NOT NULL,
                             SELL_CHECK BOOL NOT NULL,
                             LOCAL_ID BIGINT NOT NULL,
                             DATE_BUY DATETIME NOT NULL,
                             PRIMARY KEY(VEGE_CONTENT_ID),
                             FOREIGN KEY(AUTHOR_ID) REFERENCES USER(ID),
                             FOREIGN KEY(LOCAL_ID) REFERENCES EMD(ID)
);

CREATE TABLE VOTE_CONTENT(
                             GOOD_CONTENT_ID BIGINT NOT NULL AUTO_INCREMENT,
                             USER_ID BIGINT NOT NULL,
                             TITLE VARCHAR(255) NOT NULL,
                             MAIN_TEXT LONGTEXT NOT NULL,
                             DATE_CREATED DATETIME NOT NULL,
                             LAST_UPDATED DATETIME NOT NULL,
                             PRIMARY KEY(GOOD_CONTENT_ID),
                             FOREIGN KEY(USER_ID) REFERENCES USER(ID)
);

CREATE TABLE COMMENT(
                        COMMENT_ID BIGINT NOT NULL AUTO_INCREMENT,
                        AUTHOR_ID BIGINT NOT NULL,
                        CONTENT_ID BIGINT ,
                        RECIPE_ID BIGINT,
                        COMMENT_TEXT LONGTEXT NOT NULl,
                        DATE_CREATED DATETIME NOT NULL,
                        LAST_UPDATED DATETIME NOT NULL,
                        PRIMARY KEY(COMMENT_ID),
                        FOREIGN KEY(AUTHOR_ID) REFERENCES USER(ID),
                        FOREIGN KEY(CONTENT_ID) REFERENCES VEGE_CONTENT(VEGE_CONTENT_ID),
                        FOREIGN KEY(RECIPE_ID) REFERENCES RECIPE_CONTENT(RECIPE_CONTENT_ID)
);

CREATE TABLE IMG_INFO(
                             IMG_ID BIGINT NOT NULL AUTO_INCREMENT,
                             VEGE_CONTENT_ID BIGINT ,
                             RECIPE_CONTENT_ID BIGINT,
                             IMG_EXE VARCHAR(255) NOT NULL,
                             IMG_NAME VARCHAR(255) NOT NULL,
                             IMG_MAKER VARCHAR(255) NOT NULL,
                             PRIMARY KEY(IMG_ID),
                             FOREIGN KEY(VEGE_CONTENT_ID) REFERENCES VEGE_CONTENT(VEGE_CONTENT_ID),
                             FOREIGN KEY(RECIPE_CONTENT_ID) REFERENCES RECIPE_CONTENT(RECIPE_CONTENT_ID)
);