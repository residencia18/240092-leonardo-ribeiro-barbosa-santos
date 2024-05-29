CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass), -- Chave primária
    username character varying(255) COLLATE pg_catalog."default" NOT NULL, -- Campo não nulo
    password character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default" NOT NULL, -- Campo não nulo
    role character varying(255) COLLATE pg_catalog."default",
    PRIMARY KEY (id) -- Definindo a chave primária
);