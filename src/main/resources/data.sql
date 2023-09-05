-- ユーザ-のデータ
INSERT INTO user (username, password, total_experience, level) VALUES ('test', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 0, 1);
INSERT INTO user (username, password, total_experience, level) VALUES ('admin', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 0, 1);

-- 用語のテストデータ
INSERT INTO word (classification_name, comment) 
VALUES ('インターフェース', 'インターフェース" を一言で表すと、「接点」や「接続点」といえるでしょう。インターフェースは、異なるコンポーネント、システム、またはユーザー間で情報や機能を共有し、相互に連携できるようにする接点や仲介点を指します。');
INSERT INTO word (classification_name, comment) 
VALUES ('継承', '継承は、Javaにおいてクラスが他のクラスから特性（フィールドやメソッド）を引き継いで再利用する仕組みです。これにより、新しいクラスを既存のクラスに基づいて定義し、コードの再利用性と階層的な構造を実現します。簡潔に言えば、継承は「親クラスの特性を子クラスが受け継ぐ」仕組みです。');

-- 大問用語のテストデータ
INSERT INTO problem_word (problem_id, word_id) VALUES (1, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (1, 2);

-- コースのテストデータ
INSERT INTO course (course_name, image_path, sort_order) VALUES ('料理コース', '/images/cook.jpg', 1); 

-- クエストのテストデータ
INSERT INTO quest (name, course_id, image_path, sort_order) VALUES ('味噌汁', 1, '/images/miso.png', 1);
INSERT INTO quest (name, course_id, image_path, sort_order) VALUES ('カレー', 1, '/images/carry.png', 2);

-- プロセスのテストデータ
INSERT INTO process (process_name, quest_id, experience, image_path, sort_order) VALUES ('出汁と味噌を用意しよう', 1, 550, '/images/carry.png', 1);
INSERT INTO process (process_name, quest_id, experience, image_path, sort_order) VALUES ('プロセス2', 1, 20, '/images/carry.png', 2);

-- 大問のテストデータ
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ1大問1', 1, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ2大問1', 2, 1);

-- 小問のテストデータ
INSERT INTO question (problem_id, sort_order) VALUES (1, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (1, 2);
INSERT INTO question (problem_id, sort_order) VALUES (1, 3);

-- 解答選択肢のテストデータ
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
VALUES (1, true, 'Ingredient', '正解の選択肢です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
VALUES (1, false, '不正解の選択肢1', '不正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
VALUES (2, true, 'Ingredient', '正解の選択肢です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
VALUES (2, false, '不正解の選択肢2', '不正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
VALUES (3, true, 'getName', '正解の選択肢です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
VALUES (3, false, '不正解の選択肢3', '不正解です。');

-- 画像のテストデータ
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/miso/miso1.png', 1, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/miso/miso2.png', 1, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/miso/miso3.png', 1, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/miso/miso4.png', 1, 4);


-- 動画のテストデータ
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/test.mp4', 'ビデオ1', 1);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/test.mp4', 'ビデオ2', 2);

-- 経験値のテストデータ
INSERT INTO experience (level, need_total_experience)
VALUES
    (1, 100),
    (2, 200),
    (3, 300),
    (4, 400),
    (5, 500),
    (6, 600),
    (7, 700),
    (8, 800),
    (9, 900),
    (10, 1000),
    (11, 1100),
    (12, 1200),
    (13, 1300),
    (14, 1400),
    (15, 1500),
    (16, 1600),
    (17, 1700),
    (18, 1800),
    (19, 1900),
    (20, 2000),
    (21, 2100),
    (22, 2200),
    (23, 2300),
    (24, 2400),
    (25, 2500),
    (26, 2600),
    (27, 2700),
    (28, 2800),
    (29, 2900),
    (30, 3000),
    (31, 3100),
    (32, 3200),
    (33, 3300),
    (34, 3400),
    (35, 3500),
    (36, 3600),
    (37, 3700),
    (38, 3800),
    (39, 3900),
    (40, 4000),
    (41, 4100),
    (42, 4200),
    (43, 4300),
    (44, 4400),
    (45, 4500),
    (46, 4600),
    (47, 4700),
    (48, 4800),
    (49, 4900),
    (50, 5000);
