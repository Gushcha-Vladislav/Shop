INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('1',NULL,'Meat',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','1','Chicken meat',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','1','Sausages',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','1','Fish',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('1',NULL,'Dairy products',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','5','Sour-milk',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','5','Dessert',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','5','Milk butter',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('1',NULL,'Bread',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','9','Wheat bread',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','9','Loaf of bread',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','9','Roll',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('1',NULL,'Sweet-stuff',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','13','Turkish delight',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','13','Marmalade',TRUE);
INSERT INTO webshopdb.categories (hierarchy_number,id_parent,name_category,`status`)
	VALUES ('2','13','Мarshmallows',TRUE);



INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Shin with skin','2','340','Петеленька','1 kg','image/food/item1.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Chicken fillet','2','440','Петеленька','1 kg','image/food/item2.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Chicken-broiler ','2','250','Чебаркульская птица','1 kg','image/food/item3.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Dairy sausages','3','400','Малаховский','1 kg','image/food/item4.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Smoked sausages','3','420','Малаховский','1 kg','image/food/item5.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Prosciutto','3','1120','Ремит','1 kg','image/food/item6.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Salmon smoked','4','455','7Морей','570 g','image/food/item7.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Sliced ​​Herring','4','600','Матиас','150 g','image/food/item8.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Herring in oil','4','320','Рыбоlove','200 g','image/food/item9.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Kefir','6','45','OOO "Семейноя долина"','980 ml','image/food/item10.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Biolact','6','72','Простоквашино','450 g','image/food/item11.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Cottage cheese 2%','7','241','Простоквашино','150 g','image/food/item12.jpeg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Glazed cheese','7','32','Чудо','40 g','image/food/item13.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Yollibox juicy red','7','250','FROZEN YOGHURT','150 g','image/food/item14.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Milk 2,5%','8','56','Простоквашино','980 ml','image/food/item15.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Milk 3,6%','8','80','Молокия','980 ml','image/food/item16.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Butter','8','250','Viola','200 g','image/food/item17.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);


INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Loaf','10','22','Столичный','1 loaf','image/food/item18.jpeg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Loaf of sliced','10','35','ХлебныйДом','1 loaf','image/food/item19.jpeg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Homemade bread','10','87','ХлебныйДом','250 g','image/food/item20.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Зерновик','11','56','Столичный','1 loaf','image/food/item21.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Darnytskiy bread','11','36','Московский','1 loaf','image/food/item22.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);


INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Puff bun with raspberries','12','34','Мама сдоба','1 p','image/food/item23.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Cornet with apple','12','56','ХлебныйДом','1 p','image/food/item24.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Bun with poppy seeds','12','36','Славянская хата','2 p','image/food/item25.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Kozinaki sunflower','14','34','Тимоша','40 g','image/food/item26.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Asia syrian sweets','14','480','Asia sweets','500 g','image/food/item27.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Chak-chak','14','220','ХлебЗавоз','300 g','image/food/item28.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);


INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('GoldBaren','15','134','Haribo','250 g','image/food/item29.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Berry bears','15','169','БонПари','250 g','image/food/item30.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Sour snakes','15','159','БонПари','250 g','image/food/item31.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);


INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Marshmallow','16','150','Воздушный поцелуй','250 g','image/food/item32.jpeg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Maigums','16','250','Laima','250 g','image/food/item33.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);
INSERT INTO webshopdb.products (name_product,id_category,price,brand,property,image,description,status)
	VALUES ('Mini marshmallows','16','116','CorNichE','200 g','image/food/item34.jpg'
	,'Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients Ingredients '
  ,true);

