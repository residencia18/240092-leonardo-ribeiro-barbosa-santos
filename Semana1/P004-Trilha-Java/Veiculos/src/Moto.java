public class Moto extends Veiculos {


   




    public void acelerar(){
        System.out.println("Moto acelerando...");
    }
    
    public void ligar() {
        System.out.println("Moto ligado.");
    }
    
    public void parar() {
        System.out.println("Moto parado");
    }
    
    
    
        public static void main(String[] args) {
        
        Moto moto = new Moto();
        
        moto.Dados("CG160 Titan", "2023", "Vermelha");
    
        moto.ligar();
        moto.acelerar();
        moto.parar();
    
    
    
    
        }
    
    }

