create table categories(
id tinyint AUTO_INCREMENT primary key,
name varchar(255) not null);

CREATE TABLE products (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) Not null,
  price DECIMAL(10,2) not null,
  category_id TINYINT,
  CONSTRAINT fk_category
  FOREIGN KEY (category_id) REFERENCES categories(id)
    ON DELETE RESTRICT
);