4. Ponteiros em Java e C++:

Em Java, as variáveis de objetos armazenam uma referência ao objeto, não o próprio objeto. Em C++, as variáveis de objetos armazenam diretamente o objeto.

Exemplo de referência em Java:

### Java
~~~java
Car myCar = new Car();
~~~
Exemplo de ponteiro em C++:

### C++
~~~cpp
Car* myCar = new Car();
~~~

Em Java, o ponteiro (ou referência) gerenciado automaticamente pelo coletor de lixo, enquanto em C++, você precisa liberar manualmente a memória alocada usando delete.