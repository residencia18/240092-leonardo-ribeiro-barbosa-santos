import java.util.ArrayList;

public class Garagem {
    
    ArrayList<Veiculos> veiculos;
    boolean tomada = false;





    public Garagem(boolean tomada) {
        this.tomada = tomada;
    }


    public boolean isTomada() {
        return tomada;
    }


    public void setTomada(boolean tomada) {
        this.tomada = tomada;
    }


    public void estacionar(Veiculos veiculo){
        this.veiculos = new ArrayList<>();
        veiculos.add(veiculo);
        System.out.println("veiculo estacionado" + veiculo.getModelo() + "tomada: " + veiculo.isEletrico());
        if(veiculo.isEletrico() == true && isTomada() == true){
            System.out.println("Veiculo Carregando");
        }

    }
    





    
}