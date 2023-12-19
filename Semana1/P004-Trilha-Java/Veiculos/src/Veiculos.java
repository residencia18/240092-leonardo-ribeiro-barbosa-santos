public class Veiculos {

    private String modelo, ano, cor;
    private boolean eletrico = false;





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

    
    public void Dados(String modelo, String ano, String cor) {
        System.out.println("Modelo: "+ modelo + " ano: "+ ano + " cor: "+ cor + "eletrico" + eletrico);
    }


    public void acelerar(){
        System.out.println("Veiculo acelerando...");
    }


    public void ligar() {
        System.out.println("Veiculo ligado.");
    }

    public void parar() {
        System.out.println("Veiculo parado.");
    }

    public void estacionar(){
        
    }






}
