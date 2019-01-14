create table if not exists user
(
  id       bigint auto_increment
    primary key,
  name     varchar(32)     not null,
  age      int(3)          null,
  password varchar(32)     null,
  gender   enum ('F', 'M') null
);

INSERT INTO user(name, age, password, gender) VALUES ('wcc',22,'handhand','M');