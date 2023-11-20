3. Herança em Java:

A herança em Java permite que uma classe (subclasse) herde atributos e métodos de outra classe (superclasse). A subclasse pode estender ou substituir o comportamento da superclasse.

Exemplos:


### Exemplo 1 em C++
~~~cpp
class Animal {
  public:
    void sound() {
      cout << "Some sound";
    }
}

class Dog : public Animal {
  public:
    void sound() {
      cout << "Bark";
    }
};
~~~

### Exemplo 1 em Java

~~~java
public class Animal {
    public void sound() {
        System.out.println("Some sound");
    }
}

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}
~~~

### Exemplo 2 em C++
~~~cpp
class Shape {
  private:
    int sides;
};

class Square : public Shape {
  public:
    Square() {
      sides = 4;
    }
};
~~~

### Exemplo 2 em Java

~~~java
public class Shape {
    private int sides;
}

public class Square extends Shape {
    public Square() {
        sides = 4;
    }
}
~~~