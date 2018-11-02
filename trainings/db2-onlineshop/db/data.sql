TRUNCATE TABLE public.product;

INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Milk', to_timestamp('01-11-2018 11:01:00', 'dd-mm-yyyy hh24:mi:ss'), 25);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Bread', to_timestamp('01-11-2018 11:02:00', 'dd-mm-yyyy hh24:mi:ss'), 10);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Sausage', to_timestamp('01-11-2018 11:03:00', 'dd-mm-yyyy hh24:mi:ss'), 100);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Juice', to_timestamp('01-11-2018 12:01:00', 'dd-mm-yyyy hh24:mi:ss'), 30);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Creams', to_timestamp('01-11-2018 12:02:00', 'dd-mm-yyyy hh24:mi:ss'), 32);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Cottage cheese', to_timestamp('01-11-2018 12:03:00', 'dd-mm-yyyy hh24:mi:ss'), 60);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Cheese', to_timestamp('01-11-2018 12:04:00', 'dd-mm-yyyy hh24:mi:ss'), 160);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Pie', to_timestamp('01-11-2018 13:10:00', 'dd-mm-yyyy hh24:mi:ss'), 6);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Meat', to_timestamp('01-11-2018 13:20:00', 'dd-mm-yyyy hh24:mi:ss'), 120);
INSERT INTO public.product(id, name, creation_date, price) VALUES (nextval('public.product_id_seq'), 'Fish', to_timestamp('01-11-2018 13:30:00', 'dd-mm-yyyy hh24:mi:ss'), 75);

TRUNCATE TABLE public.users;

INSERT INTO public.users(id, name, password, creation_date, role) VALUES (nextval('public.user_id_seq'), 'User1', 'pass1', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'User');
INSERT INTO public.users(id, name, password, creation_date, role) VALUES (nextval('public.user_id_seq'), 'User2', 'pass2', to_timestamp('02-10-2018 14:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'Admin');
INSERT INTO public.users(id, name, password, creation_date, role) VALUES (nextval('public.user_id_seq'), 'User3', 'pass3', to_timestamp('02-10-2018 15:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'Guest');

TRUNCATE TABLE public.permissions;

INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Guest', 'login', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Guest', 'logout', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'User',  'login', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'User',  'logout', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'User',  'products', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Admin', 'login', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Admin', 'logout', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Admin', 'products', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Admin', 'add', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Admin', 'edit', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
INSERT INTO public.permissions(id, role, object, creation_date) VALUES (nextval('public.permission_id_seq'), 'Admin', 'delete', to_timestamp('01-10-2018 13:00:00', 'dd-mm-yyyy hh24:mi:ss'));
