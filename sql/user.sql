drop table if exists user;
CREATE TABLE IF NOT EXISTS user(
	id int auto_increment not null,
	user_id int auto_increment unique default null,
    user_name varchar(50) default null,
    user_account varchar(50) unique default null,
    user_password varchar(50) default null,
    primary key(id)
);

INSERT INTO user(user_id,user_name, user_account, user_password)
VALUES
(1000, '管理员', 'admin', 'admin'),
(1001, '测试帐号', 'test', 'test');