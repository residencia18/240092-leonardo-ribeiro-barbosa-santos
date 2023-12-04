package Calculadora1;

import java.util.Scanner;

class DivisionByZeroException extends Exception {

    // Construtores
    public DivisionByZeroException() {
        super("Divisão por zero não permitida.");
    }

    public DivisionByZeroException(int x, int y) {
        super("Divisão por zero: " + x + " / " + y);
    }
}


public class Calculadora1 {
	private int x;
	private int y;
	private int escolha;
	private float opcao;
	private float y1;
	private float x1;
	
	
	
	public 
	void somando()			//metodo para somar.
	{
		int somar = x + y;
		System.out.println("A Soma de " + x + "+" + y + " = "+ somar);
	}
	
	
	void subtraindo()		//metodo para subtrair.
	{
		int subtrair = x - y;
		System.out.println("A Subtracao de " + x +  "-" + y + " = " + subtrair);
	}
	
	void multiplicando()	//metodo para multiplicar.
	{
		int multiplicar = x * y;
		System.out.println("A Multiplicacao de " + x + "*" + y + " = " + multiplicar + "\n");
	}
	
	void dividindo () throws DivisionByZeroException	//metodo para dividir.
	{
		if (y < 1) {
			throw new DivisionByZeroException(x, y);
		}
		int dividir = x / y;
		System.out.println("A Divisao de "+ x + "/" + y +" = " + dividir);
	}
	
	void dividindoDecimal()	throws DivisionByZeroException	//metodo para dividir decimal.
	{
	
		if (y1 == 0) {
			throw new DivisionByZeroException();
		}
		float dividir =  x1 / y1;
		System.out.println("A Divisao de "+ x1 + "/" + y1 +" = " + dividir);
		
	
	
		
	}
	
	
	//metodo para interface e saida.
	void calculando() throws DivisionByZeroException
	{
		//um for para criar o loop da lista
		for(int i = 0; i <= 5;i++ ) {	
			Scanner sc = new Scanner(System.in);
			
			System.out.println("1. Divisão numeros decimais\n2. Calculadora Numeros inteiro");
			opcao = sc.nextFloat();
			if(opcao == 1)
			{
				System.out.println("Digite o Dividendo decimal");
				x1 = sc.nextFloat();
				System.out.println("Digite o Divisor decimal");
				y1 = sc.nextFloat();
				
				try {
					dividindoDecimal();
				}catch(DivisionByZeroException e) {
					System.out.println("Erro " + e.getMessage());
				}
				
			}
			System.out.println("Digite o Primeiro numero: ");
			
			x = sc.nextInt();
			System.out.println("Digite o numero o Segundo numero: ");
			y = sc.nextInt();
			
			System.out.println("Digite 0. Sair\nDigite 1. Somar\nDigite 2. Subtrair\nDigite 3. Multiplicar\nDigite 4. Dividir\n");
			escolha = sc.nextInt();
			
			// if para criar condiçoes a qual o usuario pode optar.
			if(escolha == 1) 
			{
				somando();
			}
			if(escolha == 2) {
				subtraindo();
			}
			if(escolha == 3) {
				multiplicando();
			}
			if(escolha == 4) {
				try {
				dividindo();
				}catch(DivisionByZeroException e) {
					System.out.println("Erro " + e.getMessage());
			}
			}
			if(escolha == 5) {
			try {
				dividindoDecimal();
			}catch(DivisionByZeroException e) {
				System.out.println("Erro " + e.getMessage());
			}
			}
			else if(escolha > 5)
			{
				System.out.println("Opção invalida. Tente novamente!");
			}
			else if(escolha == 0)
			{
				break;
			}
		}
	}
	



public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public float getOpcao() {
		return opcao;
	}


	public void setOpcao(float opcao) {
		this.opcao = opcao;
	}


	public float getY1() {
		return y1;
	}


	public void setY1(float y1) {
		this.y1 = y1;
	}


	public float getX1() {
		return x1;
	}


	public void setX1(float x1) {
		this.x1 = x1;
	}


	public void setY(int y) {
		this.y = y;
	}

	public int getEscolha() {
		return escolha;
	}

	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}

	
public static void main(String[] args) throws DivisionByZeroException 
	{	
		Calculadora1 c;
		c = new Calculadora1();
		
		
		c.calculando();
		//Impressão do codigo.
	
	}	
	
}
