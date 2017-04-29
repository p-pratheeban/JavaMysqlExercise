CREATE TABLE sometbl ( ID INT, NAME VARCHAR(50) );
INSERT INTO sometbl VALUES (1, 'Smith'), (2, 'Julio|Jones|Falcons'), 
(3,'White|Snow'), (4, 'Paint|It|Red'), (5, 'Green|Lantern'), (6, 'Brown|bag');

DELIMITER $$
DROP PROCEDURE IF EXISTS SPLIT_COLUMN $$
CREATE PROCEDURE SPLIT_COLUMN(delimeter VARCHAR(1))
	BEGIN
	DECLARE split_id INT;
	DECLARE split_name VARCHAR(50);
	DECLARE done INT;
	DECLARE occurance INT;
	DECLARE i INT;
	DECLARE pipe INT;
	DECLARE splitted_name VARCHAR(50);
	DECLARE ins_query VARCHAR(500);
	DECLARE source_table  CURSOR FOR SELECT sometbl.id, sometbl.name FROM sometbl WHERE sometbl.name != '';
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;
	 
	DROP TABLE IF EXISTS newsometbl;
	CREATE TABLE newsometbl(ID INT, NAME VARCHAR(50)); 

	OPEN source_table;

	splitter_loop:LOOP
		FETCH source_table INTO split_id,split_name;
	 
		SET occurance = LOCATE(delimeter, split_name);
		IF done = 1 THEN
			LEAVE splitter_loop;
		END IF;
		
		SET pipe = LOCATE(delimeter, split_name);
		IF pipe > 0 THEN
			SET occurance=LENGTH(split_name)-LENGTH(REPLACE(split_name,delimeter,''))+1;
			SET i=1;
				WHILE i <= occurance DO
					SET splitted_name = (SELECT REPLACE(SUBSTRING(SUBSTRING_INDEX(split_name, delimeter, i), LENGTH(SUBSTRING_INDEX(split_name, delimeter, i - 1)) + 1), delimeter, ''));
					INSERT INTO newsometbl(ID,NAME) VALUES (split_id,splitted_name);
					
					SET i=i+1;
				END WHILE;
		ELSE
			INSERT INTO newsometbl(ID,NAME) VALUES (split_id,split_name);
		END IF;
		SET occurance=0;
	END LOOP;
	CLOSE source_table;
	END;
$$
DELIMITER ;

CALL SPLIT_COLUMN('|');

SELECT * FROM newsometbl;