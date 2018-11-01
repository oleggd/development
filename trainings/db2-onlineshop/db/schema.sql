DROP TABLE public.product;

DROP SEQUENCE public.product_id_seq CASCADE;

CREATE SEQUENCE public.product_id_seq START 1 INCREMENT 1;

CREATE TABLE public.product (
    id            SERIAL                   NOT NULL,
    name          CHARACTER VARYING(255)   NOT NULL,
    creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
    price         REAL                     NOT NULL
);

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pk PRIMARY KEY (id);

ALTER TABLE public.product OWNER to postgres;

DROP TABLE public.users;

DROP SEQUENCE public.product_id_seq CASCADE;

CREATE TABLE public.users (
    id            SERIAL                   NOT NULL,
    name          CHARACTER VARYING(255)   NOT NULL,
    creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
    role          CHARACTER VARYING(255)   NOT NULL
);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);

ALTER TABLE public.users OWNER to postgres;

CREATE SEQUENCE public.product_id_seq START 1 INCREMENT 1;