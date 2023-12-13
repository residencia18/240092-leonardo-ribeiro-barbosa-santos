import java.util.ArrayList;


public class CarrinhoDeCompras {

    Cliente cliente;
    ArrayList<Itens> itens;
    
    


    

    

    public CarrinhoDeCompras(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }




    public void adicionarItem(Itens item, int quantidade){
        
        for(int i=0; i<quantidade; i++){
            this.itens.add(item);
            System.out.println("index " + i + " " + quantidade +" " + item.descricao + " adicionado ao carrinho!");
        }
    

    }
    public void removerItem(Itens item, int quantidade){
        for(int i = 0; i < quantidade; i++){
            this.itens.remove(item);
            System.out.println("index " + i + " " + item.descricao + " item removido!");

         }
    }
    public void fecharCompra(Itens item, boolean fechar){
            //incluir um tratamento para bloquear acões
            

        
    }





    public static void main(String[] args) {
    
    Cliente cliente = new Cliente("Leo");
    
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras(cliente);

    Itens item1 = new Itens("Jaqueta", 21, 122.30);
    Itens item2 = new Itens("sapato", 1, 10.20);
    
    carrinho.adicionarItem(item1, 2);

    carrinho.removerItem(item1, 1);

  
    carrinho.adicionarItem(item2, 1);

    carrinho.removerItem(item2, 2);

 
    
    


}

}
