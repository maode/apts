
CREATE
    VIEW `apts`.`v_house_his_last` 
    AS
(
SELECT a.* FROM t_house_his a 
WHERE NOT EXISTS (
		SELECT 1 FROM t_house_his b WHERE b.houseid = a.houseid AND b.createTime > a.createTime
		)
);
