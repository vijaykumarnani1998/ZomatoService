INSERT INTO address (city, area, pincode) VALUES
('Bangalore','BTM','560042'),
('Bangalore','HSR','560102'),
('Hyderabad','Ameerpet','500016'),
('Hyderabad','Kukatpally','500072'),
('Chennai','Anna Nagar','600017'),
('Chennai','Velachery','600042'),
('Mumbai','Andheri','400053'),
('Mumbai','Bandra','400050'),
('Delhi','Karol Bagh','110005'),
('Pune','Hinjewadi','411057');


INSERT INTO restaurant (restaurant_name, cuisine, open, rating, owner_id, address_id) VALUES
('Spicy Hub','Indian',true,4.5,101,1),
('Biryani House','Biryani',true,4.3,102,2),
('Paradise','Biryani',true,4.6,103,3),
('Food Junction','Chinese',false,4.1,104,4),
('Anand Bhavan','South Indian',true,4.4,105,5),
('Murugan Idli','South Indian',true,4.7,106,6),
('Mumbai Masala','Indian',true,4.2,107,7),
('Cafe Bandra','Cafe',true,4.3,108,8),
('Punjabi Tadka','North Indian',false,4.0,109,9),
('Techie Treats','Fast Food',true,4.1,110,10);



INSERT INTO menu (item_name, price, veg, available, restaurant_id) VALUES
('Chicken Biryani', 250, false, true, 1),
('Paneer Butter Masala', 220, true, true, 1),
('Gobi Manchurian', 180, true, false, 1);


INSERT INTO users(user_name,email,address,phone_num) VALUES
('Vijay Kumar','vijaykumar@gmail.com','Bangalore',951517135),
('Karthik Kumar','karthik@gmail.com','Madanapalle',996363324),
('Vanaja','vanaja@gmail.com','Vempalli',63034489),
('kaira','kaira@gmail.com','MPL',1234567);