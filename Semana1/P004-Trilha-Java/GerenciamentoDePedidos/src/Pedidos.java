import java.util.ArrayList;

public class Pedidos {
    
    private int numeroDoPedido;
    private int cpfDoCliente;
    ArrayList<ListaDeItems> listaDeItems;

   



    public int getNumeroDoPedido() {
        return numeroDoPedido;
    }

    public void setNumeroDoPedido(int numeroDoPedido) {
        this.numeroDoPedido = numeroDoPedido;
    }

    public int getCpfDoCliente() {
        return cpfDoCliente;
    }

    public void setCpfDoCliente(int cpfDoCliente) {
        this.cpfDoCliente = cpfDoCliente;
    }

    public ArrayList<ListaDeItems> getListaDeItems() {
        return listaDeItems;
    }


    public void setListaDeItems(ArrayList<ListaDeItems> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    

    public void adicionarPedido(ListaDeItems item){
        this.listaDeItems = new ArrayList<ListaDeItems>();
        for(int i=0; i< listaDeItems.size(); i++){
        
        this.listaDeItems.add(item); 
        System.out.println("Pedido adicionado a lista:"+item.getQuantidade()+ "UND " + item.getDescricao());
        }
    }

    public void CalcularTotalPedido(ListaDeItems item){
        this.listaDeItems = new ArrayList<ListaDeItems>();
        double total = 0;
        total += item.getPreco() * item.getQuantidade();
        System.out.println("O valor total do pedido: " + total);
       
    
    }

    public double CalcularTotalPedido(ListaDeItems item, double aVista){
        this.listaDeItems = new ArrayList<ListaDeItems>();
        double total = 0;
        total += (item.getPreco() * item.getQuantidade()) * 10 / 100;
        aVista = item.getPreco() * item.getQuantidade() + total;
        System.out.println("O valor total do pedido com desconto a vista: " + aVista);
        return total;
    }
    

    public void exibirInformacoesPedido(ListaDeItems item){
        this.listaDeItems = new ArrayList<ListaDeItems>();
        System.out.println("CPF do cliente: "+ getCpfDoCliente() + "\nNumero do pedido: " + getNumeroDoPedido() +"\nPedido:"+item.getDescricao() + "\nQuantidade:" + item.getQuantidade() + "\nPreço:" + item.getPreco()+"\n");
            
    }

    public void adicionarPedido(String produto, double preco, int quantidade){
       ListaDeItems novaListaDeItems = new ListaDeItems(quantidade, produto, preco);
       listaDeItems.add(novaListaDeItems);
       System.out.println("CPF do cliente:" + getCpfDoCliente()+ "\nNumero do pedido: " + getNumeroDoPedido() +"\nPedido adicionado a lista:" + produto +"\nUND:"+ quantidade + "\nPreço:" + preco) ;
    }	
        
    
 



    public static void main(String[] args) {
        
        Pedidos pedidos = new Pedidos();

        ListaDeItems itens1 = new ListaDeItems(2, " Cafe", 5);
        ListaDeItems itens2 = new ListaDeItems(12, " Cerveja", 7.99);

        pedidos.setNumeroDoPedido(1);
        pedidos.setCpfDoCliente(999999999);
        //valor total do pedido com 10% de desconto
        pedidos.CalcularTotalPedido(itens1, 10);

        pedidos.adicionarPedido(itens1);
        //valor total do pedido sem desconto
        pedidos.CalcularTotalPedido(itens1);

        pedidos.exibirInformacoesPedido(itens1);


        


        pedidos.adicionarPedido(itens2);
        pedidos.CalcularTotalPedido(itens2);
        pedidos.exibirInformacoesPedido(itens2);


        

        ListaDeItems itens3 = new ListaDeItems(1, " frango", 12.78);
        ListaDeItems itens4 = new ListaDeItems(3, " Macarrão", 3.99);

        pedidos.setNumeroDoPedido(2);
        pedidos.setCpfDoCliente(654456546);

        pedidos.adicionarPedido(itens3);
        pedidos.CalcularTotalPedido(itens3);
        pedidos.exibirInformacoesPedido(itens3);


        pedidos.adicionarPedido(itens4);
        pedidos.CalcularTotalPedido(itens4);
        pedidos.exibirInformacoesPedido(itens4);


        pedidos.setNumeroDoPedido(3);
        pedidos.setCpfDoCliente(323232323);
        //pedido com paramentro
        pedidos.adicionarPedido("jaca", 10.00, 3);



    

        
      
       
        
    }

}



