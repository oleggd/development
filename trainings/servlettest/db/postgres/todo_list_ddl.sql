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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: todo_list; Type: TABLE; Schema: public; Owner: postgres
--
drop table public.todo_list;

CREATE TABLE public.todo_list (
    id       INTEGER NOT NULL,
    name     CHARACTER VARYING(255) NOT NULL,
    due_date DATE,
    priority INTEGER
);

--
-- Name: todo_list todo_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.todo_list
    ADD CONSTRAINT todo_list_pkey PRIMARY KEY (id);


ALTER TABLE public.todo_list OWNER TO postgres;

--
-- Name: TABLE todo_list; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.todo_list IS 'TODO list table';

CREATE SEQUENCE public.todo_list_id_seq START 1 INCREMENT 1;

--
-- PostgreSQL database dump complete
--

