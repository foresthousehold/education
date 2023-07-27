-- ユーザマスタのテーブル作成
CREATE TABLE m_user (
    username VARCHAR(20) NOT NULL PRIMARY KEY COMMENT 'ユーザー名',
    password VARCHAR(100) COMMENT 'パスワード'
) COMMENT 'ユーザマスタ';