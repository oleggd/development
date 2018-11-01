--
-- PostgreSQL database dump
--

-- Dumped from database version 11.0
-- Dumped by pg_dump version 11.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: todo_list; Type: TABLE DATA; Schema: public; Owner: postgres
--
truncate table public.todo_list;

INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Read documentation', '2018-10-29', 5);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Do home work', '2018-10-30', 10);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Test scripts', '2018-11-01', 15);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Read documentation', '2018-10-29', 5);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Do home work', '2018-10-30', 10);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Test scripts', '2018-11-01', 15);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Read documentation', '2018-10-29', 5);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Do home work', '2018-10-30', 10);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Test scripts', '2018-11-01', 15);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Read documentation', '2018-10-29', 5);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Do home work', '2018-10-30', 10);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Test scripts', '2018-11-01', 15);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Read documentation', '2018-10-29', 5);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Do home work', '2018-10-30', 10);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Test scripts', '2018-11-01', 15);
INSERT INTO public.todo_list (id, name, due_date, priority) VALUES (nextval('public.todo_list_id_seq'), 'Test task 1', '2018-11-10', 25);


--
-- PostgreSQL database dump complete
--

