--
-- File generated with SQLiteStudio v3.2.1 on ?? ??? 30 22:40:57 2018
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

TRUNCATE TABLE todo_list;

INSERT INTO todo_list (id, name, due_date, priority) VALUES (1, 'Read documentation', '2018-10-29', 5);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (2, 'Do home work', '2018-10-30', 10);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (3, 'Test scripts', '2018-11-01', 15);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (4, 'Read documentation', '2018-10-29', 5);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (5, 'Do home work', '2018-10-30', 10);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (6, 'Test scripts', '2018-11-01', 15);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (7, 'Read documentation', '2018-10-29', 5);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (8, 'Do home work', '2018-10-30', 10);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (9, 'Test scripts', '2018-11-01', 15);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (10, 'Read documentation', '2018-10-29', 5);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (11, 'Do home work', '2018-10-30', 10);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (12, 'Test scripts', '2018-11-01', 15);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (13, 'Read documentation', '2018-10-29', 5);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (14, 'Do home work', '2018-10-30', 10);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (15, 'Test scripts', '2018-11-01', 15);
INSERT INTO todo_list (id, name, due_date, priority) VALUES (16, 'Test task 1', '2018-11-10', 25);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
