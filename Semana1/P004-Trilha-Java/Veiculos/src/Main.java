public class Main {






    public static void main(String[] args) {
        
        

        //veiculo eletrico
        Moto moto = new Moto("CG160 Titan", "2023", "Vermelha", true);
            
       
        
        moto.ligar();
        moto.acelerar();
        moto.parar();
        //veiculo  nao é eletrico
        Carro carro = new Carro("Hb20","2028", "preto", false);
    
        

        carro.ligar();
        carro.acelerar();
        carro.parar();

        //Garagem tem carregador
        Garagem garagem = new Garagem(true);


        carro.estacionar(garagem);
        
        moto.estacionar(garagem);
        
        





        
        
    }


}


