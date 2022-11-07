--CREATE TABLE element(
--    id INT PRIMARY KEY AUTO_INCREMENT,
--    first_el VARCHAR(255),
--    second_el VARCHAR(255)
--);
--
--CREATE TABLE content(
--    content VARCHAR(1023),
--    attribute_name VARCHAR(511),
--    attribute_value VARCHAR(511),
--    id_el INT PRIMARY KEY AUTO_INCREMENT
--#     ,FOREIGN KEY (id_el) REFERENCES element (id) ON DELETE CASCADE
--);

DROP TABLE element;
DROP TABLE content;

SELECT * FROM element;
SELECT * FROM content;