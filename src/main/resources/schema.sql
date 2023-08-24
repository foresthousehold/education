-- ユーザマスタのテーブル作成
DROP TABLE IF EXISTS user;
CREATE TABLE user (
    ID serial NOT NULL,
    username VARCHAR(20) NOT NULL PRIMARY KEY COMMENT 'ユーザー名',
    password VARCHAR(100) COMMENT 'パスワード',
    total_experience int DEFAULT 0 COMMENT '累積経験値',
    level int NOT NULL COMMENT 'レベル',
    DELETE_FLG boolean DEFAULT '0' NOT NULL
) COMMENT 'ユーザマスタ';