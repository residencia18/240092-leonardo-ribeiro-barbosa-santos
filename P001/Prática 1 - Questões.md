**Prática 1 - Questões**



**1. O que é uma classe em Java e qual é a diferença entre uma classe e um objeto? Dê 5 exemplos mostrando-os em C++ e em Java.**

Em Java, uma classe é uma estrutura que define o comportamento e as propriedades de objetos. Ela é como um modelo ou plano para criar objetos. Um objeto é uma instância de uma classe, ou seja, é uma entidade real que possui comportamento e estado. A diferença principal entre classe e objeto é que a classe é a descrição abstrata e o objeto é a instância concreta dessa descrição.

**Exemplo em Java - Classe:**

public class Carro {

​	String modelo;

​	int ano;

​	public Carro(String modelo, int ano) {

​		this.modelo = modelo;

​		this.ano = ano;

​	}

}

**Exemplo em Java - Objeto:**

Carro meuCarro = new Carro("Fusca", 1980);

 

**Exemplo em C++ - Classe:**

class Carro {

​	public:

​		string modelo;

​		int ano;

​	Carro(string modelo, int ano) : modelo(modelo), ano(ano) { }

};

 

**Exemplo em C++ - Objeto:**

Carro meuCarro("Fusca", 1970);



**2. Como você declara uma variável em Java e quais são os tipos de dados primitivos mais comuns? Faça um paralelo entre isso e a mesma coisa na linguagem C++**

Em Java, você declara uma variável especificando seu tipo e nome. Os tipos de dados primitivos em Java incluem int, float, double, boolean, char, entre outros.

 

**Exemplo em Java:**

// Declaração de variável em Java

int idade = 25;

// Tipos de dados primitivos comuns em Java

float altura = 1.75f;

boolean isEstudante = true;

char letra = 'A'; 



Em C++, a declaração de variáveis é semelhante, mas os tipos de dados primitivos podem ter diferentes tamanhos dependendo da plataforma.

**Exemplo em C++:** 

// Declaração de variável em C++

int idade = 25;

// Tipos de dados primitivos comuns em C++

float altura = 1.75f;

bool isEstudante = true;

char letra = 'A';



**3. Explique o conceito de herança em Java e como você pode criar uma subclasse a partir de uma classe existente. Faça um paralelo com C++, apresentando 5 exemplos.**

Herança em Java permite que uma classe herde atributos e métodos de outra classe. Para criar uma subclasse em Java, você usa a palavra-chave `extends`.

 

**Exemplo em Java:**

// Classe base

class Animal {

​	void fazerSom() {

​	System.out.println("Barulho genérico de animal");

​	}

}

 

// Subclasse em Java

class Cachorro extends Animal {

​	void latir() {

​	System.out.println("Au au!");

​	}

}



Em C++, a herança é semelhante, mas a palavra-chave é `: public` ou `: private`.

 

**Exemplo em C++:**

// Classe base

class Animal {

​	public:

​		void fazerSom() {

​			cout << "Barulho genérico de animal" << endl;

​		}

};

 

// Subclasse em C++

class Cachorro : public Animal {

​	public:

​		void latir() {

​			cout << "Au au!" << endl;

​		}

};



**4. Quando declaramos uma variável em Java, temos, na verdade, um ponteiro. Em C++ é diferente. Discorra sobre esse aspecto.**

Em Java, as variáveis de objetos são, de fato, referências a objetos. Quando você declara uma variável de objeto em Java, está criando uma referência a um objeto na memória, mas o objeto em si não é criado até que você use a palavra-chave `new`. Isso é semelhante a um ponteiro em C++.

 

**Exemplo em Java:**

// Declaração de variável de objeto em Java

Carro meuCarro;

meuCarro = new Carro("Fusca", 1970);

 

Em C++, as variáveis de objeto são instâncias reais dos objetos. Não há a mesma distinção entre referência e objeto como em Java. Em C++, você pode ter ponteiros que apontam para objetos, mas a semântica é diferente.

 

**Exemplo em C++:**

// Declaração e inicialização de objeto em C++

Carro meuCarro("Fusca", 1970);

 

// Declaração de ponteiro para objeto em C++

Carro* ponteiroCarro;

ponteiroCarro = &meuCarro;