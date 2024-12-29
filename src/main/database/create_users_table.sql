create table users (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   email_id  VARCHAR(100) UNIQUE NOT NULL,
   first_name TEXT NOT NULL,
   last_name TEXT NOT NULL,
   hashed_password TEXT NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);