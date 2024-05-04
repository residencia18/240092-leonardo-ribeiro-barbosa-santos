-- V2__Create_roles_table.sql
CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.roles
(
    id BIGINT NOT NULL DEFAULT nextval('roles_id_seq'::regclass),
    role_name VARCHAR(255) COLLATE pg_catalog."default",
    PRIMARY KEY (id)
);
