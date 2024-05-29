-- V3__Create_user_roles_table.sql
CREATE TABLE IF NOT EXISTS public.user_roles
(
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES public.roles (id) ON DELETE CASCADE
);
