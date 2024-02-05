-- ユーザ-のデータ
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ1', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 550, 5);
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ2', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 700, 7);
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ3', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 600, 6);
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ4', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 500, 5);
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ5', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 400, 4);
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ6', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 300, 3);
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ7', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 200, 2);
INSERT INTO user (username, password, total_experience, level) VALUES ('ユーザ8', 'bc7aafe1fcc4a279c26b706427dc327a159e19bf640108b7ab806bd5da3cb4180286c7022f61a2af', 100, 1);

-- ユーザログインのテストデータ
INSERT INTO user_login (user_id, login_date) values (1, '2023-10-31');
INSERT INTO user_login (user_id, login_date) values (1, '2023-11-01');
INSERT INTO user_login (user_id, login_date) values (1, '2023-11-02');
INSERT INTO user_login (user_id, login_date) values (1, '2023-12-01');
INSERT INTO user_login (user_id, login_date) values (1, '2023-12-02');
INSERT INTO user_login (user_id, login_date) values (1, '2023-12-04');
INSERT INTO user_login (user_id, login_date) values (1, '2023-12-05');
INSERT INTO user_login (user_id, login_date) values (1, '2023-12-06');

-- 料理のテストデータ
INSERT INTO dish (name) VALUES ('Miso Soup');
INSERT INTO dish (name) VALUES ('Curry');
INSERT INTO dish (name) VALUES ('Stewed Hamburger');

-- 分類のテストデータ
INSERT INTO category (name) VALUES ('継承');
INSERT INTO category (name) VALUES ('インターフェース');
INSERT INTO category (name) VALUES ('クラス');

-- 用語のテストデータ
INSERT INTO word (japanese_classification, english_classification, japanese_comment, english_comment) 
VALUES ('インターフェース', 'Interface',
'インターフェース" を一言で表すと、「接点」や「接続点」といえるでしょう。インターフェースは、異なるコンポーネント、システム、またはユーザー間で情報や機能を共有し、相互に連携できるようにする接点や仲介点を指します。',
'In a nutshell, an "interface" can be described as a "point of contact" or a "connection point. An interface is a point of contact or intermediary point that allows information and functionality to be shared and interworked between different components, systems, or users.');
INSERT INTO word (japanese_classification, english_classification, japanese_comment, english_comment)
VALUES ('継承', 'Inheritance',
'継承は、Javaにおいてクラスが他のクラスから特性（フィールドやメソッド）を引き継いで再利用する仕組みです。これにより、新しいクラスを既存のクラスに基づいて定義し、コードの再利用性と階層的な構造を実現します。簡潔に言えば、継承は「親クラスの特性を子クラスが受け継ぐ」仕組みです。',
'Inheritance is a mechanism in Java whereby a class inherits characteristics (fields and methods) from another class and reuses them. This allows new classes to be defined based on existing classes, providing code reusability and hierarchical structure. Simply put, inheritance is a mechanism whereby "a child class inherits the characteristics of a parent class.');
INSERT INTO word (japanese_classification, english_classification, japanese_comment, english_comment) 
VALUES ('ワード1', 'word1', '日本語解説1', '英語解説1');
INSERT INTO word (japanese_classification, english_classification, japanese_comment, english_comment) 
VALUES ('ワード2', 'word2','日本語解説2', '英語解説2');

-- コースのテストデータ
INSERT INTO course (course_name, image_path, sort_order) VALUES ('Cooking course', '/images/cook.jpg', 1);

-- クエストのテストデータ
INSERT INTO quest (name, course_id, dish_id, image_path, access_flg, sort_order) VALUES ('Miso soup', 1, 1,'/images/miso.png', '1', 1);
INSERT INTO quest (name, course_id, dish_id, image_path, access_flg, sort_order) VALUES ('Curry', 1, 2,'/images/carry.png', '0', 2);
INSERT INTO quest (name, course_id, dish_id, image_path, access_flg, sort_order) VALUES ('StewedHamburger', 1, 3,'/images/stewedHamburger.png', '0', 3);

-- プロセスのテストデータ
-- 味噌汁
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('1.Prepare tofu and green onion', 1, 10, '/images/process/miso/1.png', '1', 1);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('2.Cutting tofu and green onion', 1, 110, '/images/process/miso/2.png', '0', 2);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('3.Prepare water and seaweed, broth', 1, 220, '/images/process/miso/3.png', '0', 3);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('4.Boil after add water and broth', 1, 220, '/images/process/miso/4.png', '0', 4);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('5.Add tofu and seaweed', 1, 220, '/images/process/miso/5.png', '0', 5);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('6.Dissolve miso after add miso', 1, 220, '/images/process/miso/6.png', '0', 6);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('7.Add the green onions and broth and mix to complete the dish', 1, 220, '/images/process/miso/7.png', '0', 7);
-- カレー
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('1.Prepare ingredient', 2, 110, '/images/process/curry/1.png', '1', 1);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('2.Cutting Ingredients', 2, 220, '/images/process/curry/2.png', '0', 2);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('3.Adding Ingredients.', 2, 220, '/images/process/curry/3.png', '0', 3);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('4.Stir-fry ingredients', 2, 220, '/images/process/curry/4.png', '0', 4);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('5.Add water, simmer & add roux', 2, 220, '/images/process/curry/5.png', '0', 5);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('6.Complete', 2, 220, '/images/process/curry/6.png', '0', 6);
-- 煮込みハンバーグ(id=14~18)
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('1.Make Base Hamburger Steak', 3, 110, '/images/process/stewed/process1.png', '1', 1);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('2.Make Hamburger Steak', 3, 220, '/images/process/stewed/process2.png', '0', 2);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('3.Make Hamburger Sauce', 3, 220, '/images/process/stewed/process3.png', '0', 3);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('4.Make Stewed Hamburger', 3, 220, '/images/process/stewed/process4.png', '0', 4);
INSERT INTO process (process_name, quest_id, experience, image_path, access_flg, sort_order) VALUES ('5.Complete', 3, 220, '/images/process/stewed/process5.png', '0', 5);

-- 大問のテストデータ
-- 味噌汁(id=1~7)
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ1大問1', 1, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ2大問1', 2, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ3大問1', 3, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ4大問1', 4, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ5大問1', 5, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ6大問1', 6, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('みそ7大問1', 7, 1);
-- カレー(id=8~14)
INSERT INTO problem (name, process_id, problem_no) VALUES ('カレー1-1大問1', 8, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('カレー1-2大問1', 8, 2);
INSERT INTO problem (name, process_id, problem_no) VALUES ('カレー2大問1', 9, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('カレー3大問1', 10, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('カレー4大問1', 11, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('カレー5大問1', 12, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('カレー6大問1', 13, 1);
-- 煮込みハンバーグ(id=15~27)
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ1-1大問1', 14, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ1-2大問1', 14, 2);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ1-3大問1', 14, 3);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ1-4大問1', 14, 4);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ2-1大問1', 15, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ2-2大問1', 15, 2);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ2-3大問1', 15, 3);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ3-1大問1', 16, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ3-2大問1', 16, 2);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ3-3大問1', 16, 3);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ4-1大問1', 17, 1);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ4-2大問1', 17, 2);
INSERT INTO problem (name, process_id, problem_no) VALUES ('煮込みハンバーグ5大問1', 18, 1);

-- 大問用語のテストデータ
INSERT INTO problem_word (problem_id, word_id) VALUES (1, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (1, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (2, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (2, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (3, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (3, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (4, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (4, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (5, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (5, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (6, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (6, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (7, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (7, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (8, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (8, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (9, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (9, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (10, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (10, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (11, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (11, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (12, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (12, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (13, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (13, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (14, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (15, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (15, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (16, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (16, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (17, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (17, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (18, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (19, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (19, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (20, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (20, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (21, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (21, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (22, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (22, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (23, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (23, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (24, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (24, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (25, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (25, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (26, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (26, 2);
INSERT INTO problem_word (problem_id, word_id) VALUES (27, 1);
INSERT INTO problem_word (problem_id, word_id) VALUES (27, 2);

-- 小問のテストデータ
-- みそのデータ(id=19まで)
INSERT INTO question (problem_id, sort_order) VALUES (1, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (1, 2);
INSERT INTO question (problem_id, sort_order) VALUES (1, 3);
INSERT INTO question (problem_id, sort_order) VALUES (2, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (3, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (3, 2);
INSERT INTO question (problem_id, sort_order) VALUES (3, 3);
INSERT INTO question (problem_id, sort_order) VALUES (4, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (4, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (4, 3);
INSERT INTO question (problem_id, sort_order) VALUES (5, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (5, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (6, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (6, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (6, 3);
INSERT INTO question (problem_id, sort_order) VALUES (6, 4);
INSERT INTO question (problem_id, sort_order) VALUES (7, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (7, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (7, 3);
-- カレーのデータ(id=20~43)
INSERT INTO question (problem_id, sort_order) VALUES (8, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (8, 2);
INSERT INTO question (problem_id, sort_order) VALUES (9, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (9, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (9, 3); 
INSERT INTO question (problem_id, sort_order) VALUES (9, 4); 
INSERT INTO question (problem_id, sort_order) VALUES (9, 5); 
INSERT INTO question (problem_id, sort_order) VALUES (9, 6); 
INSERT INTO question (problem_id, sort_order) VALUES (10, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (10, 2);
INSERT INTO question (problem_id, sort_order) VALUES (10, 3);
INSERT INTO question (problem_id, sort_order) VALUES (11, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (11, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (11, 3);
INSERT INTO question (problem_id, sort_order) VALUES (12, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (12, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (12, 3); 
INSERT INTO question (problem_id, sort_order) VALUES (13, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (13, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (13, 3);
INSERT INTO question (problem_id, sort_order) VALUES (13, 4);
INSERT INTO question (problem_id, sort_order) VALUES (13, 5);
INSERT INTO question (problem_id, sort_order) VALUES (13, 6);
INSERT INTO question (problem_id, sort_order) VALUES (14, 1);
-- 煮込みハンバーグのデータ(id=44~75)
INSERT INTO question (problem_id, sort_order) VALUES (15, 1);
INSERT INTO question (problem_id, sort_order) VALUES (15, 2);
INSERT INTO question (problem_id, sort_order) VALUES (15, 3);
INSERT INTO question (problem_id, sort_order) VALUES (15, 4);
INSERT INTO question (problem_id, sort_order) VALUES (16, 1);
INSERT INTO question (problem_id, sort_order) VALUES (16, 2);
INSERT INTO question (problem_id, sort_order) VALUES (17, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (17, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (17, 3); 
INSERT INTO question (problem_id, sort_order) VALUES (18, 1);
INSERT INTO question (problem_id, sort_order) VALUES (18, 2);
INSERT INTO question (problem_id, sort_order) VALUES (18, 3); 

INSERT INTO question (problem_id, sort_order) VALUES (19, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (19, 2);
INSERT INTO question (problem_id, sort_order) VALUES (20, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (20, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (21, 1); 

INSERT INTO question (problem_id, sort_order) VALUES (22, 1); 
INSERT INTO question (problem_id, sort_order) VALUES (22, 2); 
INSERT INTO question (problem_id, sort_order) VALUES (22, 3);
INSERT INTO question (problem_id, sort_order) VALUES (22, 4);
INSERT INTO question (problem_id, sort_order) VALUES (22, 5);
INSERT INTO question (problem_id, sort_order) VALUES (23, 1);
INSERT INTO question (problem_id, sort_order) VALUES (24, 2);
INSERT INTO question (problem_id, sort_order) VALUES (24, 3);
INSERT INTO question (problem_id, sort_order) VALUES (24, 4);
INSERT INTO question (problem_id, sort_order) VALUES (24, 5);

INSERT INTO question (problem_id, sort_order) VALUES (25, 1);
INSERT INTO question (problem_id, sort_order) VALUES (25, 2);
INSERT INTO question (problem_id, sort_order) VALUES (25, 3);
INSERT INTO question (problem_id, sort_order) VALUES (26, 1);
INSERT INTO question (problem_id, sort_order) VALUES (26, 2);

INSERT INTO question (problem_id, sort_order) VALUES (27, 1);

-- 解答選択肢のテストデータ
-- みそのデータ
-- 大問１
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (1, true, 'Ingredient', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (1, false, 'Tohu', 'TofuクラスはIngredientクラスを継承しています。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (1, false, 'Negi', 'NegiはIngredientクラスを継承しています。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (2, false, 'new Negi(false)', 'TofuとNegiは別オブジェクトです。インスタンスを生成できません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (2, true, 'new Tohu(false)', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (3, true, 'new Negi(false)', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (3, false, 'new Tohu(false)', 'TofuとNegiは別オブジェクトです。インスタンスを生成できません。');
-- 大問2
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (4, true, 'cut()', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (4, false, 'ingredient()', 'ingredientはメソッドではありません。オブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (4, false, 'new Cut()', 'Cutはオブジェクトではありません。メソッドです。');
-- 大問3
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (5, true, 'new Water()', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (5, false, 'new Dashi()', 'DashiとWaterは別オブジェクトです。インスタンスを生成できません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (5, false, 'new Wakame()', 'WakameとWaterは別オブジェクトです。インスタンスを生成できません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (6, false, 'new Water()', 'DashiとWaterは別オブジェクトです。インスタンスを生成できません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (6, true, 'new Dashi()', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (6, false, 'new Wakame()', 'WakameとDashiは別オブジェクトです。インスタンスを生成できません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (7, false, 'new Water()', 'WakameとWaterは別オブジェクトです。インスタンスを生成できません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (7, false, 'new Dashi()', 'WakameとDashiは別オブジェクトです。インスタンスを生成できません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (7, true, 'new Wakame()', '正解です。');
-- 大問4
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (8, true, 'Soup', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (8, false, 'BoiledSoup', 'BoiledSoupはSoupクラスを継承しています。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (8, false, 'Soup()', 'BoiledSoupはSoupクラスを継承しています。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (9, true, 'water', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (9, false, 'dashi', '間違いではありませんが、waterを追加する必要があります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (10, true, 'boil()', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (10, false, 'boil', 'boilメソッドを実装する必要があります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (10, false, 'Boil', 'Boilクラスではなくboilメソッドを実装する必要があります。');
-- 大問5
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (11, true, 'tofu', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (11, false, 'Tofu', '生成した変数名はtofuです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (12, true, 'seaweed', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (12, false, 'Seaweed', '生成した変数名はseaweedです。');
-- 大問6
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (13, true, 'Ingredient', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (13, false, 'ingredient', 'MisoはIngredientクラスを継承しています。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (14, false, 'miso()', 'Misoインスタンスを生成してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (14, true, 'new Miso()', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (14, false, 'Miso()', 'Misoインスタンスを生成してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (15, true, 'miso', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (15, false, 'Miso', '生成した変数名はmisoです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (16, false, 'dissolve', 'メソッドを選択してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (16, true, 'dissolve()', '正解です。');
-- 大問7
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (17, true, 'negi', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (17, false, 'dashi', '間違いではありませんが、negiを追加する必要があります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (18, true, 'mix()', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (18, false, 'Mix()', 'Mixメソッドは宣言されていません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (19, true, 'MisoSoup', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (19, false, 'misoSoup', 'MisoSoup型を宣言してください。');
-- カレーのデータ
-- 大問１
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (20, true, 'Ingredient', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (20, false, 'ingredient', '各素材はIngredientを継承しています。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (21, true, 'name', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (21, false, 'Name', 'コンストラクタの引数を用いてください');
-- 大問2
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (22, true, 'new Carrot', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (22, false, 'new Potato', 'CarrotとPotatoは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (22, false, 'new Onion', 'CarrotとOnionは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (23, true, 'new Potato', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (23, false, 'new Carrot', 'PotatoとCarrotは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (23, false, 'new Meat', 'PotatoとMeatは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (24, true, 'new Onion', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (24, false, 'new Potato', 'OnionとPotatoは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (24, false, 'new Meat', 'PotatoとMeatは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (25, true, 'new Meat', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (25, false, 'new Water', 'MeatとWaterは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (25, false, 'new Onion', 'MeatとOnionは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (26, true, 'new CurryRoux', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (26, false, 'new Carrot', 'CurryRouxとCarrotは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (26, false, 'new Potato', 'CurryRouxとPotatoは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (27, true, 'new Water', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (27, false, 'new Carrot', 'WaterとCarrotは異なるオブジェクトです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (27, false, 'new Onion', 'WaterとOnionは異なるオブジェクトです。');
-- 大問3
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (28, true, 'cut', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (28, false, 'add', 'addメソッドはCutステータスを付与しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (28, false, 'boil', 'boilメソッドはCutステータスを付与しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (29, true, '"Cut"', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (29, false, '"Flied"', 'cutメソッドはCutステータスを付与します。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (29, false, '"Boil"', 'cutメソッドはCutステータスを付与します。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (30, true, 'cut(i)', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (30, false, 'cut()', 'cutメソッドはIngredient型を引数に必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (30, false, 'cut', 'cutメソッドを選択してください。');
-- 大問4
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (31, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (31, false, 'cut', 'Cookingインターフェースのaddメソッドを実装してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (31, false, 'boil', 'Cookingインターフェースのaddメソッドを実装してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (32, true, 'ingredient', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (32, false, 'Ingredient', '変数名がIngredientは宣言されていません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (33, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (33, false, 'cut', '間違いではありませんが、baseCurryに材料を追加する必要があります。');
-- 大問5
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (34, true, 'fly', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (34, false, 'cut', 'Cookingインターフェースのflyメソッドを実装してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (34, false, 'add', 'Cookingインターフェースのflyメソッドを実装してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (35, true, '"Flied"', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (35, false, 'Cut', '間違いではありませんが、Fliedをセットする必要があります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (36, true, 'fly(i)', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (36, false, 'fly()', 'flyメソッドはIngredient型を引数に必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (36, false, 'fly', 'flyメソッドを選択してください。');
-- 大問6
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (37, true, 'boil', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (37, false, 'cut', 'Cookingインターフェースのboilメソッドを実装してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (37, false, 'fly', 'Cookingインターフェースのboilメソッドを実装してください。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (38, true, '"Boiled"', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (38, false, '"Cut"', '間違いではありませんが、Boiledをセットする必要があります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (38, false, '"Flied"', '間違いではありませんが、Boiledをセットする必要があります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (39, true, 'curry', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (39, false, 'baseCurry', 'baseCurryという変数名は宣言されていません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (40, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (40, false, 'boil', '間違いではありませんが、addメソッドを使用してルーを追加する必要があります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (41, true, 'convertToCurry', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (41, false, 'cut', 'cutメソッドは引数にIngredient型が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (41, false, 'fly', 'flyメソッドは引数にIngredient型が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (42, true, 'boil(i)', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (42, false, 'boil()', 'boilメソッドはIngredient型を引数に必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (42, false, 'boil', 'boilメソッドを選択してください。');
-- 大問7
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (43, true, '①', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (43, false, '②', '人参、ジャガイモ、玉ねぎ、肉、水は２回煮込まれています。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (43, false, '③', 'カレーのルーを追加した後に、煮込まれています。もう一度コードを確認してみましょう。');

-- 煮込みハンバーグのデータ
--プロセス1 大問1
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (44, true, 'new GroundMeat("ひき肉")', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (44, false, 'new GroundMeat()', 'GroundMeatインスタンスの生成をするには、引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (44, false, 'GroundMeat("ひき肉")', 'インスタンスを生成するには,newが必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (45, true, 'new SaltAndPepper("塩胡椒")', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (45, false, 'new SaltAndPepper()', 'SaltAndPepperインスタンスの生成をするには、引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (45, false, 'SaltAndPepper("塩胡椒")', 'インスタンスを生成するには,newが必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (46, true, 'new Egg("卵")', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (46, false, 'new Egg()', 'Eggインスタンスの生成をするには,引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (46, false, 'Egg("卵")', 'インスタンスを生成するには、newが必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (47, true, 'new Knife()', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (47, false, 'new Knife("包丁")', 'Knifeインスタンスの生成には、引数が必要ありません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (47, false, 'Knife("包丁")', 'インスタンスを生成するには、newが必要です。');
-- 大問2
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (48, true, 'smallCut(onion)', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (48, false, 'thinlyCut()', 'cutメソッドには引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (48, false, 'cut', 'メソッドの記法は\'メソッド名()\'です');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (49, true, 'BaseHamburgerSteak', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (49, false, 'StepForStewedHamburger', 'createBaseHamburgerSteakメソッドの返り値の型と異なります。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (49, false, 'baseHamburgerSteak', 'baseHamburgerSteakというクラスは存在しません。');
-- 大問3
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (50, true, 'groundMeat', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (50, false, 'GroundMeat', 'GroundMeatという変数名は存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (50, false, 'new GroundMeat("ひき肉")', '新しくインスタンスを生成する必要はありません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (51, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (51, false, 'mix', '間違いではありませんが、ここで適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (51, false, 'fly', '間違いではありませんが、ここで適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (52, true, 'mix', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (52, false, 'add', '間違いではありませんが、ここで適切なメソッドはmixです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (52, false, 'fly', '間違いではありませんが、ここで適切なメソッドはmixです。');
-- 大問4
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (53, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (53, false, 'mix', '間違いではありませんが、ここで適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (53, false, 'fly', '間違いではありませんが、ここで適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (54, true, 'flour', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (54, false, 'Flour', 'Flourという変数名は存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (54, false, 'onion', '間違いではありませんが、ここで適切な変数はflourです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (55, true, 'BaseHamburgerSteak', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (55, false, 'baseHamburgerSteak', 'baseHamburgerSteakというクラスは存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (55, false, 'StepForStewedHamburger', 'Mainクラスを確認して、メソッドの呼び出し元を確認しましょう。');
-- プロセス2 大問1
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (56, true, 'baseHamburgerSteak', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (56, false, 'BaseHamburgerSteak', 'BaseHamburgerSteakという変数名は存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (56, false, 'FryingPan', 'addメソッドの引数にはIngredient型が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (57, true, 'HamburgerSteak', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (57, false, 'hamburgerSteak', 'hamburgerSteakというクラスは存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (57, false, 'baseHamburgerSteak', 'createHamburgerSteakメソッドの返り値の型はHamburgerSteakです。');
--大問2
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (58, true, 'fly', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (58, false, 'mix', '間違いではありませんが、ここで適切なメソッドはflyです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (58, false, 'add', '間違いではありませんが、ここで適切なメソッドはflyです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (59, true, 'HamburgerSteak', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (59, false, 'hamburgerSteak', 'HamburgerSteakというクラス名は存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (59, false, 'BaseHamburgerSteak', 'createHamburgerSteakメソッドの返り値の型はHamburgerSteakです。');
-- 大問3
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (60, true, 'remove', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (60, false, 'fly', '間違いではありませんが、ここで適切なメソッドはremoveです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (60, false, 'mix', '間違いではありませんが、ここで適切なメソッドはremoveです。');
-- プロセス3大問1
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (61, true, 'new Onion("玉ねぎ")', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (61, false, 'new Onion()', 'Onionインスタンスの生成をするには,引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (61, false, 'Onion("玉ねぎ")', 'インスタンスを生成するには、newが必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (62, true, 'new Butter("バター")', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (62, false, 'new Butter()', 'Butterインスタンスの生成をするには,引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (62, false, 'Butter("バター")', 'インスタンスを生成するには、newが必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (63, true, 'new Consome("コンソメ")', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (63, false, 'new Consome()', 'Consomeインスタンスの生成をするには,引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (63, false, 'Consome("コンソメ")', 'インスタンスを生成するには、newが必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (64, true, 'new Sauce("ソース")', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (64, false, 'new Sauce()', 'Sauceインスタンスの生成をするには,引数が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (64, false, 'Sauce("ソース")', 'インスタンスを生成するには、newが必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (65, true, 'HamburgerSauce', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (65, false, 'hamburgerSauce', 'hamburgerSauceというクラスは存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (65, false, 'BaseHamburgerSteak', 'createHamburgerSauceの返り値の型はHamburgerSauceです。');
--大問2
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (66, true, 'thinlyCut', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (66, false, 'smallCut', '間違いではありませんが、適切なメソッドはthinlyCutです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (66, false, 'cut', 'Knifeクラスはcutメソッドを持っていません。');
-- 大問3
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (67, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (67, false, 'mix', '間違いではありませんが、適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (67, false, 'fly', '間違いではありませんが、適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (68, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (68, false, 'mix', '間違いではありませんが、適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (68, false, 'fly', '間違いではありませんが、適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (69, true, 'boil', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (69, false, 'mix', '間違いではありませんが、適切なメソッドはboilです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (69, false, 'fly', '間違いではありませんが、適切なメソッドはboilです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (70, true, 'HamburgerSauce', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (70, false, 'hamburgerSauce', 'hamburgerSauceというクラスは存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (70, false, 'BaseHamburgerSteak', 'createHamburgerSauceの返り値の型はHamburgerSauceです。');
-- プロセス4 大問1
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (71, true, 'add', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (71, false, 'fly', '間違いではありませんが、適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (71, false, 'mix', '間違いではありませんが、適切なメソッドはaddです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (72, true, 'hamburgerSauce', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (72, false, 'hamburgerSteak', '間違いではありませんが、hamburgerSteakはすでに追加済みです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (72, false, 'fryingPan', 'addメソッドの引数にはIngredient型が必要です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (73, true, 'StewedHamburger', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (73, false, 'stewedHamburger', 'stewedHamburgerというクラスは存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (73, false, 'BaseHamburgerSteak', 'createStewedHamburgerメソッドの返り値の型はStewedHamburgerです。');
-- 大問2
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (74, true, 'boil', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (74, false, 'mix', '間違いではありませんが、適切なメソッドはboilです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (74, false, 'add', '間違いではありませんが、適切なメソッドはboilです。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (75, true, 'StewedHamburger', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (75, false, 'stewedHamburger', 'stewedHamburgerというクラスは存在しません。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (75, false, 'BaseHamburgerSteak', 'createStewedHamburgerメソッドの返り値の型はStewedHamburgerです。');

-- プロセス5 大問2
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (76, true, '①', '正解です。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (76, false, '②', '出力箇所をみて出力される順番に着目しましょう。');
INSERT INTO answer_choice (question_id, correct_flg, content, advice)
    VALUES (76, false, '③', '出力箇所をみて出力される順番に着目しましょう。');

-- 画像のテストデータ
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso1-1.png', 1, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso1-2.png', 1, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso2-1.png', 2, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso2-2.png', 2, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso3-1.png', 3, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso3-2.png', 3, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso4-1.png', 4, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso4-2.png', 4, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso4-3.png', 4, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso5-1.png', 5, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso5-2.png', 5, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso5-3.png', 5, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso6-1.png', 6, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso6-2.png', 6, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso6-3.png', 6, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso7-1.png', 7, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso7-2.png', 7, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/miso/miso7-3.png', 7, 3);
-- カレー
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry1-1.png', 8, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry1-2.png', 8, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry1-3.png', 8, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry1-4.png', 9, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry2-1.png', 10, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry2-2.png', 10, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry2-3.png', 10, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry3-1.png', 11, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry3-2.png', 11, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry3-3.png', 11, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry4-1.png', 12, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry4-2.png', 12, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry4-3.png', 12, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry5-1.png', 13, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry5-2.png', 13, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry5-3.png', 13, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry5-4.png', 13, 4);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry6-1.png', 14, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry6-2.png', 14, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry6-3.png', 14, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry6-4.png', 14, 4);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry6-5.png', 14, 5);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry6-6.png', 14, 6);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/curry/curry6-7.png', 14, 7);

-- 煮込みハンバーグ
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-1-1.png', 15, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-1-2.png', 15, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-2-1.png', 16, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-2-2.png', 16, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-3-1.png', 17, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-3-2.png', 17, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-3-3.png', 17, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-4-1.png', 18, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-4-2.png', 18, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed1-4-3.png', 18, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed2-1-1.png', 19, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed2-1-2.png', 19, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed2-2-1.png', 20, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed2-2-2.png', 20, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed2-3-1.png', 21, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed2-3-2.png', 21, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-1-1.png', 22, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-1-2.png', 22, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-1-3.png', 22, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-2-1.png', 23, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-2-2.png', 23, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-2-3.png', 23, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-3-1.png', 24, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-3-2.png', 24, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-3-3.png', 24, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed3-3-4.png', 24, 4);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed4-1-1.png', 25, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed4-1-2.png', 25, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed4-1-3.png', 25, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed4-2-1.png', 26, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed4-2-2.png', 26, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed4-2-3.png', 26, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed5-1-1.png', 27, 1);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed5-1-2.png', 27, 2);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed5-1-3.png', 27, 3);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed5-1-4.png', 27, 4);
INSERT INTO image (file_path, problem_id, sort_order) VALUES ('/images/english/stewed/stewed5-1-5.png', 27, 5);

-- 動画のテストデータ
-- 味噌汁
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/miso/miso1.mov', 'ビデオ1', 1);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/miso/miso2.mov', 'ビデオ2', 2);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/miso/miso3.mov', 'ビデオ3', 3);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/miso/miso4.mov', 'ビデオ4', 4);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/miso/miso5.mov', 'ビデオ5', 5);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/miso/miso6.mov', 'ビデオ6', 6);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/miso/miso7.mov', 'ビデオ7', 7);
-- カレー
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/curry/curry1.mov', 'ビデオ8', 8);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/curry/curry1.mov', 'ビデオ9', 9);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/curry/curry2.mov', 'ビデオ10', 10);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/curry/curry3.mov', 'ビデオ11', 11);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/curry/curry4.mov', 'ビデオ12', 12);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/curry/curry5.mov', 'ビデオ13', 13);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/curry/curry6.mov', 'ビデオ14', 14);
-- 煮込みハンバーグ
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed1-1.mov', 'ビデオ15', 15);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed1-2.mov', 'ビデオ16', 16);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed1-3.mov', 'ビデオ17', 17);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed1-4.mov', 'ビデオ18', 18);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed2-1.mov', 'ビデオ19', 19);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed2-1.mov', 'ビデオ20', 20);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed2-1.mov', 'ビデオ21', 21);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed3-1.mov', 'ビデオ22', 22);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed3-2.mov', 'ビデオ23', 23);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed3-3.mov', 'ビデオ24', 24);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed4-1.mov', 'ビデオ25', 25);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed4-1.mov', 'ビデオ26', 26);
INSERT INTO video (file_path, title, problem_id) VALUES ('/videos/stewed/stewed5-1.mov', 'ビデオ27', 27);

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

-- クエスト分類のテストデータ
INSERT INTO quest_category (quest_id, category_id) VALUES (1, 1);
INSERT INTO quest_category (quest_id, category_id) VALUES (1, 2);
INSERT INTO quest_category (quest_id, category_id) VALUES (1, 3);
INSERT INTO quest_category (quest_id, category_id) VALUES (2, 1);
INSERT INTO quest_category (quest_id, category_id) VALUES (2, 2);
INSERT INTO quest_category (quest_id, category_id) VALUES (3, 1);
INSERT INTO quest_category (quest_id, category_id) VALUES (3, 2);
INSERT INTO quest_category (quest_id, category_id) VALUES (3, 3);

-- メモのテストデータ
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル1', 'コンテンツ1', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル2', 'コンテンツ2', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル3', 'コンテンツ3', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル4', 'コンテンツ4', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル1', 'コンテンツ1', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル2', 'コンテンツ2', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル3', 'コンテンツ3', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル4', 'コンテンツ4', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル1', 'コンテンツ1', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル2', 'コンテンツ2', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル3', 'コンテンツ3', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル4', 'コンテンツ4', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル1', 'コンテンツ1', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル2', 'コンテンツ2', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル3', 'コンテンツ3', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル4', 'コンテンツ4', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル1', 'コンテンツ1', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル2', 'コンテンツ2', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル3', 'コンテンツ3', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル4', 'コンテンツ4', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル1', 'コンテンツ1', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル2', 'コンテンツ2', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル3', 'コンテンツ3', '2020-09-11', '2020-09-11', 1);
INSERT INTO memo (title, content, created_date, edited_date, user_id) VALUES ('タイトル4', 'コンテンツ4', '2020-09-11', '2020-09-11', 1);
