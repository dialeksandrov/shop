CREATE SEQUENCE public.products_id_seq;

create table public.products
(
    id              bigint not null default nextval('public.products_id_seq'),
    created_at      timestamp default now(),
    manufacturer    varchar(100),
    series          varchar(100),
    amount          decimal,
    type            varchar(30),
    stock_count     integer,


    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE SEQUENCE public.product_params_id_seq;

create table public.product_params
(
    id              bigint not null default nextval('public.product_params_id_seq'),
    name            varchar(50),
    param           varchar(100),
    product_id      bigint,

    CONSTRAINT pk_product_params PRIMARY KEY (id)
);

ALTER TABLE public.product_params ADD CONSTRAINT product_params_product_id_fk
    FOREIGN KEY (product_id)
        REFERENCES public.products (id)
        ON DELETE CASCADE;

-- INSERT INTO public.products (id, created_at, manufacturer, series, amount, type, stock_count)
-- VALUES (1, current_timestamp, 'Intel', 'ASD12312', 40000, 'PC', 12),
--        (2, current_timestamp, 'SAMSUNG', 'M7', 32000, 'MONITOR', 10);
--
-- INSERT INTO public.product_params (id, name, param, product_id)
-- VALUES (1, 'type', 'monoblock', 1),
--        (2, 'size', '32', 2);