create table member
(
    memid bigint generated by default as identity,
    id varchar(255),
    name varchar(255),
    pwd varchar(255),
    primary key (memid),
    grade varchar(255),
    role varchar(255)
);

INSERT INTO MEMBER(ID, NAME, PWD, GRADE, ROLE) values ('hyunchoi', '최현지', '1234', 'A', 'ADMIN');
INSERT INTO MEMBER(ID, NAME, PWD, GRADE, ROLE) values ('namanok', '김두희', '1234', 'S1', 'USER');
INSERT INTO MEMBER(ID, NAME, PWD, GRADE, ROLE) values ('ollehing', '이재윤', '1234', 'SA', 'USER');
