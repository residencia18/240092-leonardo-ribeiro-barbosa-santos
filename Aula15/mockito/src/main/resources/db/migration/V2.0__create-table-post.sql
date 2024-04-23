-- Tabela associada ao relacionamento One-to-Many
CREATE TABLE Post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,  -- Chave estrangeira para "User"
    content TEXT,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);
