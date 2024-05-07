CREATE TABLE contacts
(
    id  serial not null,
    first_name  VARCHAR(25) not null,
    middle_name VARCHAR(25) not null,
    last_name   VARCHAR(25) not null,
    address     VARCHAR(100) not null,
    city        VARCHAR(50) not null,
    province    VARCHAR(50) not null,
    occupation  VARCHAR(100) not null,
    last_education  CHAR(4) not null,
    phone CHAR(15) not null,
    email   VARCHAR(50) not null,
    primary key (id),
    CONSTRAINT unique_email UNIQUE (email),
    CONSTRAINT unique_phone UNIQUE (phone)
);

CREATE TABLE users
(
    id  serial not null,
    username VARCHAR(100) not null,
    password VARCHAR(100) not null,
    name VARCHAR(100) not null,
    token VARCHAR(100),
    token_expired_at BIGINT,
    primary key (id),
    CONSTRAINT unique_username UNIQUE (username),
    CONSTRAINT unique_token UNIQUE (token)
);

INSERT INTO users(username, password, name) VALUES('test', '$2a$10$uSZSPGSddrMQBAxNjrmoSuLkHvKhvf7SASFfkSMSYH4e9keWKJ/gS', 'Test Account');