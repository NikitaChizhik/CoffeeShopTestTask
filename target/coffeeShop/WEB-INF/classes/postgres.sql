CREATE DATABASE "coffeeShop"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Belarusian_Belarus.1251'
    LC_CTYPE = 'Belarusian_Belarus.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;





CREATE TABLE public.sort_of_coffee
(
    id serial ,
    name name,
    CONSTRAINT sort_of_coffee_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.sort_of_coffee
    OWNER to postgres;
    
    INSERT INTO public.sort_of_coffee(
     name)
    VALUES ( 'Espresso');
    
    INSERT INTO public.sort_of_coffee(
     name)
    VALUES ( 'Americano');

    
    
    

CREATE TABLE public.time_of_delivery
(
    id serial ,
    start_time timestamp with time zone,
    end_time timestamp with time zone,
    CONSTRAINT time_of_delivery_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.time_of_delivery
    OWNER to postgres;
    
    
    INSERT INTO public.time_of_delivery(
     start_time, end_time)
    VALUES ('2017-06-22 14:03:00','2017-06-22 21:00:00');
    
    
    
    
    
    
    
    CREATE TABLE public.orders
(
    id serial ,
    sort_of_coffee_id integer,
    need_of_delivery boolean,
    cost_of_delivery double precision,
    amount_in_grams integer,
    time_of_delivery_id integer,
    cost_of_order double precision,
    is_done boolean,
    description text,
    
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT sort_of_coffee_id FOREIGN KEY (sort_of_coffee_id)
        REFERENCES public.sort_of_coffee (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT time_of_delivery_id FOREIGN KEY (time_of_delivery_id)
        REFERENCES public.time_of_delivery (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.orders
    OWNER to postgres;
    
    
    INSERT INTO public.orders(
     sort_of_coffee_id, need_of_delivery, cost_of_delivery, amount_in_grams, time_of_delivery_id, cost_of_order, is_done, description)
    VALUES ( 2, true, 6.5, 500, 1, 50, false, 'very tasty coffee ');