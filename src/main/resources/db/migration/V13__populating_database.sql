INSERT INTO categories (name)
VALUES ('Fruits'),
       ('Vegetables'),
       ('Beverages'),
       ('Dairy'),
       ('Snacks');


INSERT INTO products (name, price, category_id, description)
VALUES ('Bananas', 45.00, 1, 'Fresh yellow bananas, rich in potassium'),
       ('Apples', 120.00, 1, 'Crisp and juicy red apples'),
       ('Carrots', 30.00, 2, 'Organic carrots, perfect for salads and cooking'),
       ('Spinach', 25.50, 2, 'Fresh green spinach, high in iron'),
       ('Orange Juice', 80.00, 3, '100% pure squeezed orange juice'),
       ('Green Tea', 150.00, 3, 'Premium green tea leaves for a healthy drink'),
       ('Milk', 60.00, 4, 'Full cream cow milk, 1 liter'),
       ('Cheddar Cheese', 250.00, 4, 'Aged cheddar cheese block, 200g'),
       ('Potato Chips', 40.00, 5, 'Crispy salted potato chips, 100g pack'),
       ('Chocolate Cookies', 90.00, 5, 'Soft and chocolaty cookies, pack of 6');
