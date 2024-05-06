-- Criação da sequência para a tabela roles
CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Criação da tabela roles
CREATE TABLE IF NOT EXISTS public.roles
(
    id BIGINT NOT NULL DEFAULT nextval('roles_id_seq'::regclass),
    role_name VARCHAR(255) COLLATE pg_catalog."default",
    PRIMARY KEY (id),
    UNIQUE (role_name)
);

-- Inserir o valor 'ROLE_USER' na tabela roles
INSERT INTO roles (role_name) VALUES ('ROLE_USER') ON CONFLICT (role_name) DO NOTHING;
SELECT * FROM roles WHERE role_name = 'ROLE_USER';


