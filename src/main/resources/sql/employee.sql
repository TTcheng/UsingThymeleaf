-- auto-generated definition
drop table if exists user ;
create table if not exists user
(
  name   varchar(32)     not null,
  id     bigint auto_increment
    primary key,
  age    int(3)          null,
  gender enum ('F', 'M') null
--   `OBJECT_VERSION_NUMBER` decimal(20,0) DEFAULT '1',
--   `REQUEST_ID` bigint(20) DEFAULT '-1' COMMENT '请求号',
--   `PROGRAM_ID` bigint(20) DEFAULT '-1',
--   `CREATION_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
--   `CREATED_BY` decimal(20,0) DEFAULT '-1',
--   `LAST_UPDATED_BY` decimal(20,0) DEFAULT '-1',
--   `LAST_UPDATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
--   `LAST_UPDATE_LOGIN` decimal(20,0) DEFAULT NULL,
);


INSERT INTO employee(name, age, gender) VALUES ('Jesse',23,'M');
INSERT INTO employee(name, age, gender) VALUES ('Jessie',22,'F');
INSERT INTO employee(name, age, gender) VALUES ('Jessica',26,'F');
INSERT INTO employee(name, age, gender) VALUES ('Alice',25,'F');
INSERT INTO employee(name, age, gender) VALUES ('Angela',22,'F');
INSERT INTO employee(name, age, gender) VALUES ('Morgan',25,'M');
INSERT INTO employee(name, age, gender) VALUES ('Jackson',25,'M');
INSERT INTO employee(name, age, gender) VALUES ('Jack',25,'M');
INSERT INTO employee(name, age, gender) VALUES ('Bob',25,'M');
INSERT INTO employee(name, age, gender) VALUES ('Zhangsan',25,'M');
INSERT INTO employee(name, age, gender) VALUES ('Lisi',28,'M');
INSERT INTO employee(name, age, gender) VALUES ('Wangwu',26,'M');
INSERT INTO employee(name, age, gender) VALUES ('Zhaoliu',27,'M');
INSERT INTO employee(name, age, gender) VALUES ('Jenifer',25,'F');

