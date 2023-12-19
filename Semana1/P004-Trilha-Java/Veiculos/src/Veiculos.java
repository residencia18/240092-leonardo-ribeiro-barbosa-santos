import java.util.ArrayList;

public class Veiculos {

    private String modelo, ano, cor;
    ArrayList<Garagem> garagem;
    private boolean eletrico = false;







    


    public Veiculos(String modelo, String ano, String cor, boolean eletrico) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.eletrico = eletrico;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ArrayList<Garagem> getGaragem() {
        return garagem;
    }

    public void setGaragem(ArrayList<Garagem> garagem) {
        this.garagem = garagem;
    }

 public boolean isEletrico() {
        return eletrico;
    }

    public void setEletrico(boolean eletrico) {
        this.eletrico = eletrico;
    }





    public void acelerar(){
        System.out.println("Veiculo acelerando...");
    }


    public void ligar() {
        System.out.println("Veiculo ligado.");
    }

    public void parar() {
        System.out.println("Veiculo parando.");
    }

     public void estacionar(Garagem  garage){
        this.garagem = new ArrayList<>();
        this.garagem.add(garage);
        System.out.println("Veiculo estacionado" + getModelo() + "eletrico: " + eletrico);
        if(isEletrico() == true && garage.isTomada() == true){
            System.out.println("Veiculo Carregando");
        }
    }

}
