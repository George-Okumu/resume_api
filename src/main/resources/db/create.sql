SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS resumes (
 id int PRIMARY KEY auto_increment,
 title VARCHAR,
 companyName VARCHAR,
 location VARCHAR,
 description VARCHAR,
 educationLevel VARCHAR
);

CREATE TABLE IF NOT EXISTS reviews (
 id int PRIMARY KEY auto_increment,
 comment VARCHAR,
 resumeId INTEGER
);
