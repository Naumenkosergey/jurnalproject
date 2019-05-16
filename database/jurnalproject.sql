CREATE DATABASE jurnalproject;


CREATE SCHEMA jurnalproject_schema;

SET SEARCH_PATH = jurnalproject_schema;

CREATE TABLE jurnalproject_schema.status (
  id     BIGSERIAL PRIMARY KEY,
  status VARCHAR(128) NOT NULL
);
-- Поток группы
CREATE TABLE jurnalproject_schema.flow (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);


CREATE TABLE jurnalproject_schema.groupa (
  id       BIGSERIAL PRIMARY KEY,
  name     VARCHAR(128) NOT NULL,
  semestr  INT          NOT NULL,
  potok_id BIGINT REFERENCES flow (id)
);
-- филиал
CREATE TABLE jurnalproject_schema.office (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);

CREATE TABLE jurnalproject_schema.faculty (
  id        BIGSERIAL PRIMARY KEY,
  name      VARCHAR(128) NOT NULL,
  office_id BIGINT REFERENCES office (id)
);

CREATE TABLE jurnalproject_schema.student (
  id        BIGSERIAL PRIMARY KEY,
  sername   VARCHAR(128) NOT NULL,
  name      VARCHAR(128) NOT NULL,
  otchestvo VARCHAR(128) NOT NULL,
  password  VARCHAR(128) NOT NULL,
  group_id  BIGINT REFERENCES groupa (id),
  status_id BIGINT REFERENCES status (id)
);
-- предмет
CREATE TABLE jurnalproject_schema.subject (
  id        BIGSERIAL PRIMARY KEY,
  name      VARCHAR(128) NOT NULL,
  semestr   INT          NOT NULL,
  flow_id   BIGINT REFERENCES flow (id),
  office_id BIGINT REFERENCES office (id)
);

CREATE TABLE jurnalproject_schema.role (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL
);
-- сотрудник
CREATE TABLE jurnalproject_schema.employee (
  id       BIGSERIAL PRIMARY KEY,
  name     VARCHAR(128) NOT NULL,
  sername  VARCHAR(128) NOT NULL,
  password VARCHAR(128),
  role_id  BIGINT REFERENCES role (id)
);

CREATE TABLE jurnalproject_schema.lesson (
  id          BIGSERIAL PRIMARY KEY,
  data        TIMESTAMP    NOT NULL,
  tema        VARCHAR(255) NOT NULL,
  homework    VARCHAR(255),
  subject_id  BIGINT REFERENCES subject (id),
  employee_id BIGINT REFERENCES employee (id)
);

CREATE TABLE jurnalproject_schema.mark (
  id_mark    BIGSERIAL PRIMARY KEY,
  mark       INT,
  experiance INT,
  lesson_id  BIGINT REFERENCES lesson (id),
  student_id BIGINT REFERENCES student (id)
);

DROP TABLE jurnalproject_schema.mark;
DROP TABLE jurnalproject_schema.lesson;
DROP TABLE jurnalproject_schema.employee;
DROP TABLE jurnalproject_schema.role;
DROP TABLE jurnalproject_schema.subject;
DROP TABLE jurnalproject_schema.student;
DROP TABLE jurnalproject_schema.faculty;
DROP TABLE jurnalproject_schema.office;
DROP TABLE jurnalproject_schema.groupa;
DROP TABLE jurnalproject_schema.flow;
DROP TABLE jurnalproject_schema.status;

