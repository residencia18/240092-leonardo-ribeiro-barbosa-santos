import java.util.ArrayList;


public class CarrinhoDeCompras {

    Cliente cliente;
    ArrayList<Itens> itens;
    boolean compraFechada = false;

    
    


    

    

    public CarrinhoDeCompras(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }




    public void adicionarItem(Itens item) 
    throws ContaClosedException{

        if(!compraFechada){
            for(int i=0; i<item.getQuantidade(); i++){
                this.itens.add(item);
                System.out.println(item.getQuantidade() +" " + item.descricao + " >> Adicionado ao carrinho <<" + cliente.getNome());
            }
        }
        else{
            throw new ContaClosedException("A conta ainda não foi fechada");
        }
    

    }

    public void removerItem(Itens item)  
    throws ContaClosedException{
        if(!compraFechada){
        
            this.itens.remove((item));
            System.out.println( " "+ item.getDescricao()+ " >> Removido do carrinho <<" + cliente.getNome());
         }
         
        else{
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


    public void CalcularTotalCompra(Itens item){
        double total = 0;
        for (int i = 0; i < itens.size(); i++) {
            total +=  item.getPreco();
            
           
              
        }
       System.out.println("O valor da compra : " + total  + " <-" +cliente.getNome());
    }
        
    
    

    public static void main(String[] args) throws ContaClosedException {
    try{
        Cliente cliente = new Cliente("Leo");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(cliente);
        System.out.println(carrinho.cliente.nome);


        Itens item1 = new Itens("Jaqueta", 21, 122.30, 3);
      
        
        carrinho.adicionarItem(item1);
        
        
        
        carrinho.removerItem(item1);

        carrinho.CalcularTotalCompra(item1);

        carrinho.adicionarItem(item1);
        

        carrinho.fecharCompra();

        carrinho.CalcularTotalCompra(item1);
        }catch(ContaClosedException e ){
        System.out.println("Erro " + e.getMessage());  
        }
    
    
    }
    
 
   
    


}


