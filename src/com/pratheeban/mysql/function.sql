DROP FUNCTION IF EXISTS UC_FIRST;
CREATE FUNCTION UC_FIRST(oldWord VARCHAR(255)) RETURNS VARCHAR(255)
RETURN CONCAT(UCASE(SUBSTRING(oldWord, 1, 1)),LCASE(SUBSTRING(oldWord, 2)));

DROP FUNCTION IF EXISTS INITCAP;
DELIMITER //
CREATE FUNCTION INITCAP(oldName VARCHAR(255)) RETURNS VARCHAR(255)
BEGIN
	SET @oldString := oldName;
	SET @newString := "";
 
	tokenLoop: LOOP
		SET @splitPoint := LOCATE(" ", @oldString);
	 
		IF @splitPoint = 0 THEN
			SET @newString := CONCAT(@newString, UC_FIRST(@oldString));
			LEAVE tokenLoop;
		END IF;
		
		SET @newString := CONCAT(@newString, UC_FIRST(SUBSTRING(@oldString, 1, @splitPoint)));
		SET @oldString := SUBSTRING(@oldString, @splitPoint+1);
	END LOOP tokenLoop;
	
	RETURN @newString;
END//
DELIMITER ;
SELECT INITCAP('UNITED states Of AmERIca');


