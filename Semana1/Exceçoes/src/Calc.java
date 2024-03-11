public class Calc {
    public float dividir(float a, float b) throws DivisaoPorZeroException {
        if (b == 0) {
            throw new DivisaoPorZeroException("Não é possível dividir por zero.");
        }
        return a / b;
    }


    public static void main(String[] args) {
    while(true){
       
        Calc m = new Calc();
        try {
            float resultado = m.dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (DivisaoPorZeroException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
}


