DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS word;
DROP TABLE IF EXISTS problem_word;
DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS video;
DROP TABLE IF EXISTS answer_choice;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS problem;
DROP TABLE IF EXISTS process;
DROP TABLE IF EXISTS quest;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS experience;


-- ユーザマスタのテーブル作成
CREATE TABLE user (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    username VARCHAR(20) NOT NULL COMMENT 'ユーザー名',
    password VARCHAR(100) COMMENT 'パスワード',
    total_experience int DEFAULT 0 COMMENT '累積経験値',
    level int NOT NULL COMMENT 'レベル',
    DELETE_FLG boolean DEFAULT '0' NOT NULL
) COMMENT 'ユーザマスタ';

-- 用語マスタのテーブル作成
CREATE TABLE word (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    japanese_classification VARCHAR(20) NOT NULL COMMENT '分類名(日本語)',
    english_classification VARCHAR(20) NOT NULL COMMENT '分類名(英語)',
    japanese_comment VARCHAR(500) NOT NULL COMMENT '解説(日本語)',
    english_comment VARCHAR(500) NOT NULL COMMENT '解説(英語)',
    DELETE_FLG boolean DEFAULT '0' NOT NULL
) COMMENT '用語マスタ';

-- 大問用語マスタのテーブル作成
CREATE TABLE problem_word (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    problem_id BIGINT NOT NULL,
    word_id BIGINT NOT NULL,
    DELETE_FLG boolean DEFAULT '0' NOT NULL
) COMMENT '大問用語マスタ';

-- コースマスタのテーブル作成
CREATE TABLE course (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(255) NOT NULL,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    sort_order BIGINT NOT NULL
);

-- クエストマスタのテーブル作成
CREATE TABLE quest (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    course_id BIGINT NOT NULL,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    access_flg BOOLEAN NOT NULL,
    sort_order BIGINT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course(id)
);

-- プロセスマスタのテーブル
CREATE TABLE process (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    process_name VARCHAR(255) NOT NULL,
    quest_id BIGINT NOT NULL,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    experience BIGINT NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    access_flg BOOLEAN NOT NULL,
    sort_order BIGINT NOT NULL,
    FOREIGN KEY (quest_id) REFERENCES quest(id)
);

-- 大問マスタのテーブル
CREATE TABLE problem (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    process_id BIGINT NOT NULL,
    problem_no BIGINT NOT NULL,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    FOREIGN KEY (process_id) REFERENCES process(id)
);

-- 小問マスタのテーブル
CREATE TABLE question (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    problem_id BIGINT NOT NULL,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    sort_order BIGINT NOT NULL,
    FOREIGN KEY (problem_id) REFERENCES problem(id)
);

-- 解答選択肢マスタのテーブル作成
CREATE TABLE answer_choice (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    question_id BIGINT NOT NULL,
    correct_flg BOOLEAN,
    content VARCHAR(255),
    advice VARCHAR(255) NOT NULL,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(id)
);

-- 問題画像のマスタテーブル
CREATE TABLE image (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    file_path VARCHAR(255),
    problem_id BIGINT NOT NULL,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    sort_order BIGINT,
    FOREIGN KEY (problem_id) REFERENCES problem(id)
);

-- ビデオのマスタテーブル
CREATE TABLE video (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    file_path VARCHAR(255) NOT NULL,
    problem_id BIGINT,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL,
    FOREIGN KEY (problem_id) REFERENCES problem(id)
);

-- 経験値テーブル
CREATE TABLE experience (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    level BIGINT,
    need_total_experience BIGINT,
    DELETE_FLG BOOLEAN DEFAULT '0' NOT NULL
);