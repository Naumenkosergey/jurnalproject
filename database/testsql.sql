CREATE DATABASE jurnalproject;

CREATE SCHEMA jurnalproject_schema;

SET SEARCH_PATH = jurnalproject_schema;
DROP TABLE status;

CREATE TABLE status (
  id_status BIGSERIAL PRIMARY KEY,
  status    VARCHAR(128) NOT NULL
);

CREATE TABLE potok (
  id_potok BIGSERIAL PRIMARY KEY,
  potok    VARCHAR(128) NOT NULL
);

CREATE TABLE groupa (
  id_group   BIGSERIAL PRIMARY KEY,
  name_group VARCHAR(128) NOT NULL,
  semestr    INT          NOT NULL,
  potok_id   BIGINT REFERENCES potok (id_potok)
);

CREATE TABLE filial (
  id_filial BIGSERIAL PRIMARY KEY,
  filial    VARCHAR(128) NOT NULL
);

CREATE TABLE fakultet (
  id_fakultet BIGSERIAL PRIMARY KEY,
  fakultet    VARCHAR(128) NOT NULL,
  filial_id   BIGINT REFERENCES filial (id_filial)
);

CREATE TABLE students (
  id_student BIGSERIAL PRIMARY KEY,
  sername    VARCHAR(128) NOT NULL,
  name       VARCHAR(128) NOT NULL,
  otchestvo  VARCHAR(128) NOT NULL,
  password   VARCHAR(128) NOT NULL,
  group_id   BIGINT REFERENCES groupa (id_group),
  status_id  BIGINT REFERENCES status (id_status)
);

CREATE TABLE predmet (
  id_predmet  BIGSERIAL PRIMARY KEY,
  namepredmet VARCHAR(128) NOT NULL,
  semestr     INT          NOT NULL,
  potok_id    BIGINT REFERENCES potok (id_potok),
  fakultet_id BIGINT REFERENCES fakultet (id_fakultet)
);

CREATE TABLE roles (
  id_role BIGSERIAL PRIMARY KEY,
  role    VARCHAR(128) NOT NULL
);

CREATE TABLE sotrudnik (
  id_sotrudnik BIGSERIAL PRIMARY KEY,
  name         VARCHAR(128) NOT NULL,
  sername      VARCHAR(128) NOT NULL,
  password     VARCHAR(128),
  role_id      BIGINT REFERENCES roles (id_role)
);

CREATE TABLE lesson (
  id_lesson  BIGSERIAL PRIMARY KEY,
  data       TIMESTAMP    NOT NULL,
  tema       VARCHAR(255) NOT NULL,
  homework   VARCHAR(255),
  predmet_id BIGINT REFERENCES predmet (id_predmet),
  prepod_id  BIGINT REFERENCES sotrudnik (id_sotrudnik)
);

CREATE TABLE marks (
  id_mark    BIGSERIAL PRIMARY KEY,
  mark       INT,
  experiance INT,
  lesson_id  BIGINT REFERENCES lesson (id_lesson),
  student_id BIGINT REFERENCES students (id_student)
);


