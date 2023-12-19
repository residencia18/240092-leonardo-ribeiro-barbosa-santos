import java.util.ArrayList;

public class Carro extends Veiculos {
   


     
   
    public Carro(String modelo, String ano, String cor, boolean eletrico) {
        super(modelo, ano, cor, eletrico);
        
    }

    public void acelerar(){
        System.out.println("Carro acelerando...");
    }

    public void ligar() {
        System.out.println("Carro ligado.");
    }

    public void parar() {
        System.out.println("Carro parado.");
    }



     public void estacionar(Garagem  garage){
        this.garagem = new ArrayList<>();
        this.garagem.add(garage);
        System.out.println("Carro estacionado " + getModelo() + " eletrico: " + isEletrico());
        if(isEletrico() == true && garage.isTomada() == true){
            System.out.println("Carro Carregando");
        }

    }


}
