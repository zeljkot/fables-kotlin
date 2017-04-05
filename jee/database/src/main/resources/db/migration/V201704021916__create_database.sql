CREATE SCHEMA IF NOT EXISTS kotlin_jee;

CREATE TABLE IF NOT EXISTS kotlin_jee.kittens
(
  id       SERIAL PRIMARY KEY NOT NULL,
  name     TEXT               NOT NULL,
  cuteness INT                NOT NULL
);