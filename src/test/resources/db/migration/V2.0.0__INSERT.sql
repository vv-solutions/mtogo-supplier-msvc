INSERT INTO address (zip_code, address, city, create_stamp) VALUES
(2800, 'Ulrikkenborg Alle 33', 'Kgs. Lyngby',NOW()),
(56789, '456 Oak Ave', 'Sometown',NOW()),
(98765, '789 Pine Ln', 'Othercity',NOW()),
(54321, '321 Elm St', 'Anothercity',NOW()),
(87654, '654 Maple Rd', 'Newtown',NOW()),
(23456, '456 Birch Blvd', 'Someplace',NOW()),
(78901, '901 Cedar Ct', 'Anotherplace',NOW());



INSERT INTO supplier (name, address_id, active, create_stamp) VALUES
('Tasty Bites', 1, true, NOW()),
('Savory Delights', 2, true, NOW()),
('Gourmet Grains', 3, true, NOW()),
('Flavorsome Fusion', 4, true, NOW()),
('Urban Spice Kitchen', 5, true, NOW()),
('Fresh Harvest Foods', 6, false, NOW()),
('Epicurean Eats', 7, true, NOW());

