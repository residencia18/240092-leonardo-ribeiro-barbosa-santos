
import java.util.ArrayList;

public class Calculadora3 {
  





  




   



    public int somar( int a, int b) {
        return a + b;
    }

    public int subtrair(int a ,int  b) {
        return a - b;
    
    }


    public int multiplicar(int a, int b) {
        return a * b;
    
    }

    public int dividir(int a, int b) {
        if(b <= 0){
            throw new ArithmeticException("Não é possível dividir por 0");
        }
        return a / b;
    }


    public float somar(float a, float b) {
        return a + b;
    }


    public float subtrair(float a, float b) {
        return a + b;
    }

    public float multiplicar(float a, float b) {
        return a + b;
    }
    public float dividir(float a, float b) {
        if(b <= 0){
            throw new ArithmeticException("Não é possível dividir por 0");
        }
        return a + b;
    }

    public  ArrayList<Double> somar(ArrayList<Double> lista1, ArrayList<Double> lista2) {
        ArrayList<Double> resultado = new ArrayList<>();
        for(int i = 0; i < lista1.size(); i++) {
            resultado.add(lista1.get(i) + lista2.get(i));   
            
        }
        return resultado;
    }

    public ArrayList<Double> subtrair(ArrayList<Double> lista1, ArrayList<Double> lista2){
        ArrayList<Double> resultado = new ArrayList<>();
        for(int i = 0; i < lista1.size(); i++) {
            resultado.add(lista1.get(i) - lista2.get(i));   
            
        }
        return resultado;

    }

    public ArrayList<Double> multiplicar(ArrayList<Double> lista1, ArrayList<Double> lista2){
        ArrayList<Double> resultado = new ArrayList<>();
        for(int i = 0; i < lista1.size(); i++) {
            resultado.add(lista1.get(i) * lista2.get(i));   
            
        }
        return resultado;

    }

    public ArrayList<Double> dividir(ArrayList<Double> lista1, ArrayList<Double> lista2){
       
        ArrayList<Double> resultado = new ArrayList<>();
        for(int i = 0; i < lista1.size(); i++) {
            resultado.add(lista1.get(i) / lista2.get(i));   
             if(lista2.get(i) <= 0){
            throw new ArithmeticException("Não é possível dividir por 0");
        }
        }
        return resultado;

    }





    public static void main(String[] args) {

    try{
        Calculadora3 c = new Calculadora3();
        
        ArrayList<Double> lista1 = new ArrayList<>();
        lista1.add(10.10);
        lista1.add(7.5);
        lista1.add(5.10);
        lista1.add(8.50);

        ArrayList<Double> lista2 = new ArrayList<>();
        lista2.add(5.10);
        lista2.add(5.10);
        lista2.add(10.0);
        lista2.add(0.5);
        
        //Sobrecarga  de metodos com listas
        System.out.println("A soma da listas1 + lista2 = " +c.somar(lista1,lista2 ));
        System.out.println("A soma da listas1 + lista2 = " +c.subtrair(lista1,lista2 )); 
        System.out.println("A soma da listas1 + lista2 = " +c.multiplicar(lista1,lista2 ));
        System.out.println("A soma da listas1 + lista2 = " +c.dividir(lista1,lista2 ));
     
        //Sobrecarga  de metodoscom int e float
        System.out.println("A soma de a + b = " +c.somar(2.10f, 2.10f));
        System.out.println("A subtração de a - b = " +c.subtrair(5, 4));
        System.out.println("A multiplicação de a * b = " +c.multiplicar(1.5f, 3.0f));
        System.out.println("A divisão de a / b = " +c.dividir(5, 0));
    }catch(ArithmeticException e){
        System.out.println("Erro! " + e.getMessage());

    }
}

}
