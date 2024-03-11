
public class ListaDeItems {
    private int quantidade;
    private String descricao;
    private double preco;



    





    public ListaDeItems(int quantidade, String descricao, double preco) {
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

   
    
}
