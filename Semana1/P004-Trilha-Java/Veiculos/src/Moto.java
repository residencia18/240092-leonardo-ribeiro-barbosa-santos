import java.util.ArrayList;

public class Moto extends Veiculos {


   


    public Moto(String modelo, String ano, String cor,boolean eletrico) {
        super(modelo, ano, cor, eletrico);
        
    }

    public void acelerar(){
        System.out.println("Moto acelerando...");
    }
    
    public void ligar() {
        System.out.println("Moto ligado.");
    }
    
    public void parar() {
        System.out.println("Moto parada.");
    }
    
    public void estacionar(Garagem  garage){
        this.garagem = new ArrayList<>();
        this.garagem.add(garage);
        System.out.println("Moto estacionado " + getModelo() + " eletrico: " + isEletrico());
        if(isEletrico() == true && garage.isTomada() == true){
            System.out.println("Moto Carregando...");
        }
    }
    
    
}

