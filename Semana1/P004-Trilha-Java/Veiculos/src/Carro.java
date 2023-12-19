public class Carro extends Veiculos {
   








    public void acelerar(){
        System.out.println("Carro acelerando...");
    }

    public void ligar() {
        System.out.println("Carro ligado.");
    }

    public void parar() {
        System.out.println("Carro parado");
    }



    public static void main(String[] args) {
    
    Carro carro = new Carro();
    
    carro.Dados("HB20", "2017", "Prata");

    carro.ligar();
    carro.acelerar();
    carro.parar();




    }

}
