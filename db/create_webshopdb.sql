drop database webshopdb;
CREATE database webshopdb DEFAULT CHARACTER SET utf8 ;


  
CREATE TABLE IF NOT EXISTS webshopdb.users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name_user VARCHAR(20) NOT NULL,
  last_name_user VARCHAR(20),
  role ENUM('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPER_ADMIN') NOT NULL,
  birthday DATE NOT NULL,
  email VARCHAR(45) UNIQUE NOT NULL,
  phone VARCHAR(20) UNIQUE,
  `password` VARCHAR(60) NOT NULL
  );

CREATE TABLE IF NOT EXISTS webshopdb.addresses (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  id_user INT NOT NULL,
  country VARCHAR(45) NOT NULL,
  city VARCHAR(45) NOT NULL,
  postcode VARCHAR(10),
  street VARCHAR(45) NOT NULL,
  house VARCHAR(5) NOT NULL,
  apartment VARCHAR(5),
  is_default  BOOLEAN NOT NULL DEFAULT TRUE,
  FOREIGN KEY (id_user) REFERENCES webshopdb.users (id)
);

CREATE TABLE IF NOT EXISTS webshopdb.categories (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  hierarchy_number INT NOT NULL,
  id_parent INT,
  name_category VARCHAR(45) NOT NULL,
  `status` BOOLEAN NOT NULL DEFAULT TRUE,
  FOREIGN KEY (id_parent) REFERENCES webshopdb.categories(id)
);

CREATE TABLE IF NOT EXISTS webshopdb.products (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name_product VARCHAR(45) NOT NULL,
  id_category INT NOT NULL,
  price INT NOT NULL,
  brand VARCHAR(40),
  property VARCHAR(10) NOT NULL,
  image VARCHAR(100) NOT NULL,
  description TEXT NOT NULL,
  quantity_in_stock INT NOT NULL DEFAULT 250,
  `status` BOOLEAN NOT NULL DEFAULT TRUE,
  FOREIGN KEY (id_category) REFERENCES webshopdb.categories (id)
);

CREATE TABLE IF NOT EXISTS webshopdb.orders (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_user INT NOT NULL,
  address VARCHAR(100) NOT NULL,
  payment ENUM('Cash','Credit card') NOT NULL,
  delivery ENUM('Awaiting payment','Paid') NOT NULL,
  order_price INT NOT NULL,
  date_order DATE NOT NULL,
  `status` ENUM('Awaiting payment','Awaiting shipment','Shipped','Delivered','Done') NOT NULL,
  FOREIGN KEY (id_user) REFERENCES webshopdb.users (id)
   );


CREATE TABLE IF NOT EXISTS webshopdb.orders_products (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_order INT NOT NULL,
  id_product INT NOT NULL,
  amount INT NOT NULL,
  FOREIGN KEY (id_order) REFERENCES webshopdb.orders (id),
  FOREIGN KEY (id_product) REFERENCES webshopdb.products (id)
);

CREATE TABLE IF NOT EXISTS webshopdb.statistics (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_user INT UNIQUE,
  price INT,
  id_product INT UNIQUE,
  amount INT,
  FOREIGN KEY (id_user) REFERENCES webshopdb.users (id),
  FOREIGN KEY (id_product) REFERENCES webshopdb.products (id)
);