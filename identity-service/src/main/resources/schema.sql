create table user_credentials
(
    id       int auto_increment
        primary key,
    name     varchar(30) not null,
    password varchar(150) not null,
    email    varchar(30) not null
);

CREATE UNIQUE INDEX idx_unique_name_email
    ON user_credentials (name, email);

