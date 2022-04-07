-- Users

-- INSERT INTO users (id, name)
-- VALUES (1, 'first user');
--
-- INSERT INTO users (id, name)
-- VALUES (2, 'second user');
--
-- INSERT INTO users (id, name)
-- VALUES (3, 'third user');
--
-- INSERT INTO users (id, name)
-- VALUES (4, 'fourth user');
--
-- INSERT INTO users (id, name)
-- VALUES (5, 'fifth user');

-- Posts

-- INSERT INTO post (id, content, title, user_id)
-- VALUES (1,'Some wise title goes here', 'Enticing title',1);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (2,'Some wise title goes here', 'Enticing title',1);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (3,'Some wise title goes here', 'Enticing title',2);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (4,'Some wise title goes here', 'Enticing title',4);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (5,'Some wise title goes here', 'Enticing title',4);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (6,'Some wise title goes here', 'Enticing title',3);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (7,'Some wise title goes here', 'Enticing title',5);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (8,'Some wise title goes here', 'Enticing title',2);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (9,'Some wise title goes here', 'Enticing title',2);
--
-- INSERT INTO post (id, content, title, user_id)
-- VALUES (10,'Some wise title goes here', 'Enticing title',2);


-- Comments
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (1, 'Insightful post', 1);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (2, 'Most comments on the internet are mean', 2);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (3, 'Good read', 3);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (4, 'Interesting points raised', 4);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (5, 'Interesting points raised', 5);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (6, 'Interesting points raised', 6);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (7, 'Interesting points raised', 7);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (8, 'Interesting points raised', 8);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (9, 'Interesting points raised', 9);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (10, 'Interesting points raised', 10);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (11, 'Insightful post', 1);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (12, 'Most comments on the internet are mean', 2);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (13, 'Good read', 3);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (14, 'Interesting points raised', 1);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (15, 'Interesting points raised', 1);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (16, 'Interesting points raised', 1);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (17, 'Interesting points raised', 7);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (18, 'Interesting points raised', 8);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (19, 'Interesting points raised', 9);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (20, 'Interesting points raised', 10);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (21, 'Interesting points raised', 5);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (22, 'Interesting points raised', 6);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (23, 'Interesting points raised', 7);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (24, 'Interesting points raised', 8);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (25, 'Interesting points raised', 2);
--
-- INSERT INTO comment (id, name, post_id)
-- VALUES (26, 'Interesting points raised', 2);


-- reset the sequence values

-- alter sequence comment_id_seq restart with 27;
-- alter sequence post_id_seq restart with 11;
-- alter sequence users_id_seq restart with 6;

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, first_name, last_name, password)
VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, first_name, last_name, password)
VALUES (3, 'dean@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');


INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (users_id, roles_id)
VALUES (2, 2);
INSERT INTO users_roles (users_id, roles_id)
VALUES (3, 2);

INSERT INTO post (id, content, title, user_id)
VALUES (1, 'iPhonesjfkjskajlkasjdf;asjdf', 'some title', 1);
INSERT INTO post (id, content, title, user_id)
VALUES (2, 'iPasjfkjskajlkasjdf;asjdf', 'some title', 1);
INSERT INTO post (id, content, title, user_id)
VALUES (3, 'sjfkjskajlkasjdf;asjdf', 'some title', 1);
