const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 4000; // Porta ajustada para 4000

// Middleware para analisar o corpo das solicitações
app.use(bodyParser.json());

// Endpoint para lidar com solicitações PUT para /listagem-suinos
app.put('/listagem-suinos', (req, res) => {
    // Aqui você pode manipular os dados recebidos na solicitação e salvar no banco de dados, por exemplo
    console.log('Dados recebidos:', req.body);
    // Retorna uma resposta indicando que os dados foram recebidos com sucesso
    res.send('Dados recebidos com sucesso');
});

// Inicia o servidor
app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
