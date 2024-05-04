CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.users
(
    id BIGINT NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    username CHARACTER VARYING(255),
    password CHARACTER VARYING(255),
    email CHARACTER VARYING(255),
    role CHARACTER VARYING(255),
    PRIMARY KEY (id) -- Adiciona a chave primária à coluna 'id'
);
