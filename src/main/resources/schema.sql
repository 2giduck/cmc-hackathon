DROP TABLE IF EXISTS SUB_TOPIC;
DROP TABLE IF EXISTS MAIN_TOPIC;
DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER(
                       member_no BIGINT auto_increment primary key,
                       device_id VARCHAR(128) unique NOT NULL
);

CREATE TABLE MAIN_TOPIC(
                           main_no BIGINT auto_increment primary key,
                           member_no BIGINT NOT NULL,
                           title TEXT NOT NULL,
                           start_date DATE NOT NULL,
                           end_date DATE NOT NULL,
                           FOREIGN KEY (member_no) REFERENCES MEMBER(member_no)
);

CREATE TABLE SUB_TOPIC(
                          sub_no BIGINT auto_increment primary key,
                          main_no BIGINT NOT NULL,
                          title TEXT NOT NULL,
                          plan_dt DATETIME NOT NULL,
                          description TEXT,
                          is_complete BOOLEAN NOT NULL DEFAULT false,
                          latitude DOUBLE PRECISION NOT NULL,
                          longitude DOUBLE PRECISION NOT NULL,
                          address VARCHAR(128),
                          FOREIGN KEY (main_no) REFERENCES MAIN_TOPIC(main_no)
);