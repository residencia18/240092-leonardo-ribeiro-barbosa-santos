package estudanteJson;


import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Estudante {
    private String nome;
    private String cpf;
    private float cra;
    private int anoDeAdmissao;

    public Estudante(String nome, String cpf, float cra, int anoDeAdmissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.cra = cra;
        this.anoDeAdmissao = anoDeAdmissao;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nome", nome);
        jsonObject.put("cpf", cpf);
        jsonObject.put("cra", cra);
        jsonObject.put("anoDeAdmissao", anoDeAdmissao);
        return jsonObject;
    }

    public static void main(String[] args) {
        GravadorEstudantes gravador = new GravadorEstudantes();
        gravador.solicitarDadosEGravar();
        
    }
}

class GravadorEstudantes {
    public void solicitarDadosEGravar() {
        JSONArray estudantesJSON = new JSONArray();

        // Simulando a entrada de dados do usuário
        estudantesJSON.put(new Estudante("Nome1", "CPF1", 8.5f, 2022).toJSON());
        estudantesJSON.put(new Estudante("Nome2", "CPF2", 7.8f, 2021).toJSON());
        // Adicionar mais estudantes conforme necessário

        // Gravar os dados em um arquivo JSON
        try (FileWriter fileWriter = new FileWriter("estudantes.json")) {
            fileWriter.write(estudantesJSON.toString());
            System.out.println("Dados dos estudantes foram gravados no arquivo 'estudantes.json'.");
        } catch (IOException e) {
     
        }
    }
}
