import java.util.ArrayList;


public class CarrinhoDeCompras {

    Cliente cliente;
    ArrayList<Itens> itens;
    boolean compraFechada = false;
    
    


    

    

    public CarrinhoDeCompras(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }




    public void adicionarItem(Itens item, int quantidade) 
    throws ContaClosedException{

        if(!compraFechada){
            for(int i=0; i<quantidade; i++){
                this.itens.add(item);
                System.out.println(quantidade +" " + item.descricao + " >> Adicionado ao carrinho <<");
            }
        }
        else{
            throw new ContaClosedException("A conta ainda não foi fechada");
        }
    

    }

    public void removerItem(Itens item, int quantidade)  
    throws ContaClosedException{
        if(!compraFechada){
        for(int i = 0; i < quantidade; i++){
            this.itens.remove(item);
            System.out.println(quantidade  +" "+ item.descricao + " >> Removido do carrinho <<");
           
         }
        }else{
         throw  new ContaClosedException("A conta já foi fechada");
        }
    }

    public void fecharCompra()  {
        
            if (!compraFechada) {
                System.out.println("Compra fechada com sucesso!");
                compraFechada = true;
                }
            
            else {
                System.out.println("A compra já foi fechada. Não é possível fechar novamente.");
            
            }
        }
    
        

    

    public static void main(String[] args) throws ContaClosedException {
    try{
        Cliente cliente = new Cliente("Leo");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(cliente);
        System.out.println(carrinho.cliente.nome);


        Itens item1 = new Itens("Jaqueta", 21, 122.30);
        Itens item2 = new Itens("sapato", 1, 10.20);
        
        carrinho.adicionarItem(item1, 2);

        carrinho.removerItem(item1, 1);

        carrinho.fecharCompra();
        carrinho.adicionarItem(item2, 1);

        carrinho.removerItem(item2, 2);

        carrinho.fecharCompra();
        }catch(ContaClosedException e ){
        System.out.println("Erro " + e.getMessage());  
        }
    
    
   
    
 
   
    


}

}
