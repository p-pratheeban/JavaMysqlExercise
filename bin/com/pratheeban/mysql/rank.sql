CREATE TABLE votes ( name CHAR(10), votes INT );
INSERT INTO votes VALUES
('Smith',10), ('Jones',15), ('White',20), ('Black',40), ('Green',50), ('Brown',20);

SELECT name, votes, 
CASE
    WHEN @prev_value = votes THEN @rank_count
    WHEN @prev_value := votes THEN @rank_count := @rank_count + 1
END AS rank
FROM votes,(SELECT @rank_count := 0) r,(SELECT @prev_value := NULL) p
ORDER BY votes