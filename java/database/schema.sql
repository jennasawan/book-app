BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, book, reading_log, user_book;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE book (
	id SERIAL,
	isbn varchar(100),
	cover_url varchar,
	title varchar(400) NOT NULL,
	description varchar(5000),
	author varchar(50) NOT NULL,
	page_count int,
	CONSTRAINT PK_book PRIMARY KEY (id)
);

CREATE TABLE reading_log (
	id SERIAL,
	user_id int NOT NULL,
	book_id int NOT NULL,
	page_number int NOT NULL,
	star_rating int,
	thoughts varchar(3000)
);

CREATE TABLE user_book (

    user_id int NOT NULL,
    book_id int NOT NULL,
    book_status varchar(15) NOT NULL,
    percent_finished int DEFAULT 0,
    CONSTRAINT PK_user_book PRIMARY KEY (user_id, book_id)

);

ALTER TABLE reading_log ADD FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE reading_log ADD FOREIGN KEY (book_id) REFERENCES book (id);

ALTER TABLE user_book ADD FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE user_book ADD FOREIGN KEY (book_id) REFERENCES book (id);



COMMIT TRANSACTION;
