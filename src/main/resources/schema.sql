-- ユーザマスタのテーブル作成
DROP TABLE IF EXISTS user;
CREATE TABLE user (
    ID serial NOT NULL,
    username VARCHAR(20) NOT NULL PRIMARY KEY COMMENT 'ユーザー名',
    password VARCHAR(100) COMMENT 'パスワード',
    DELETE_FLG boolean DEFAULT '0' NOT NULL
) COMMENT 'ユーザマスタ';