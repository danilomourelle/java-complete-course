## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

#### Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

#### Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Anotações do curso

## Seção 4: Estrutura sequencial

### Aula 22 - Variáveis e seus tipos

As variáveis de Java são tipadas, e a sua declaração se dá indicando o tipo, depois e nome, e opcionalmente um valor de inicialização. Para os tipos de variáveis, o Java possui nativamente os tipos **byte, short, int, long** para números inteiros, onde esses tipos terão 8, 16, 32 e 64 bits de memória. Não é falado se existe o tipo *unsigned* e aparentemente por padrão se usa o tipo **int**.

Já para os números com casas decimais, os tipos disponíveis são os **float** e **double**, com 32 e 64 bits respectivamente, e aqui, aparentemente o padrão é utilizar o tipo **double**. De primitivo existem mais duas opções que é o tipo **char** que tem 16 bits de memória e vai representar um caractere da tabela Unicode. Esse tipo pode ter tanto o valor `'\u0061'` quanto `'a'` ambos com aspas simples. O outro tipo é o **boolean** que apresenta 1 bit de tamanho e é igual ao das outras linguagens.

Existe um outro tipo que vai representar texto maiores que um caractere, mas essas variáveis são declaradas com um tipo um pouco diferente que é o tipo **String**, (isso, com maiúsculo), e uma coisa engraçada aqui é que os valores desse tipo precisam ser definidos entre aspas duplas.

Quando a nomenclatura, é aquele mesmo padrão. Não pode começar com número, pode começar com ‘_’, não pode ter espaços, e por convenção se utiliza o camelCase.

Não vi nada sobre a questão de variáveis constantes e mutáveis. Aparentemente todas elas podem sofrer alterações a qualquer momento.

### Aula 23 - Saída de dados
A saída de dados nada mais é do que a impressão dos dados. Então para quem vem do JavaScript, nada mais é do que o `console.log`. Aqui no Java a coisa é um pouco mais diferente, o sistema de impressão tem algumas particularidades a mais, parecendo uma linguagem com um menor baixo nível, mas talvez dando mais opções.

O comando utilizado para imprimir algo no console é o `System.out.print`. Esse comando aceita um argumento, e aquilo que for passado será impresso no terminal. E é aqui que começa a aparecer as peculiaridades. Essa função vai fazer a impressão no terminal e manter o curso na linha, ou seja, uma nova impressão vai simplesmente aparecer logo em seguida. Grudado mesmo

```java
public static void main(String[] args) throws Exception {
	System.out.print("Hello Word");
	System.out.print("How are you?");
}
// "Hello WordHow are you?"
```

Caso você não queira esse comportamento de deixar o cursor de impressão na mesma linha, você pode utilizar uma outra função de impressão que ao final do conteúdo coloca uma quebra de linha automaticamente que é a função `System.out.println`.

```java
public static void main(String[] args) throws Exception {
	System.out.println("Hello Word");
	System.out.println("How are you?");
}
// "Hello Word
// How are you?"
```

Ambas as formas de impressão aceitam uma concatenação de valores, e considerando que podemos ter strings como valores não alocados, podemos ter algo no seguinte sentido.

```java
public static void main(String[] args) throws Exception {
	String name = "Danilo";
	int age = 36;
	
	System.out.print("Hello, my name is " + name + " and I'm " + age + " years old");
}
// "Hello, my name is Danilo and I'm 36 years old"
```

Existe uma terceira forma, e essa é para quando se deseja realizar um certo tipo de formatação nos dados antes, e também para fazer a impressão de textos concatenados mas sem toda essa estrutura de soma de valores. Essa forma utiliza a função `System.out.printf` e essa função é cheio de regras. 

A ideia é que você coloca um texto que ao invés dos dados, vai ter alguns símbolos já embutidos, e depois desse texto você passa uma lista de argumentos para substituir esses símbolos.

```java
public static void main(String[] args) throws Exception {
	String name = "Danilo";
	int age = 36;
	double height = 1.81;
	
	System.out.printf("Hi, my name is %s, I'm %d years old and %fm high", name, age, height);
}
// "Hi, my name is Danilo, I'm 36 years old and 1,810000m high"
```

Agora vamos para as regrinhas. Se você colocar uma quantidade de símbolos maior que a quantidade de parâmetros. A compilação vai gerar um erro por falta de valores. Se você trocar a ordem dos tipos dos símbolos com os tipos dos parâmetros, isso também vai levantar um erro. 

E aí já podemos aproveitar para falar que o símbolo **%s** deve ser substituído por um parâmetro do tipo string, o símbolo **%d** por um parâmetro do tipo inteiro, o símbolo **%f** por um parâmetro do tipo flutuante e o símbolo **%n** significa uma quebra de linha. Ele não é substituído.

O símbolo **%f** é que tem mais algumas regrinhas, por exemplo, como ele representa um número flutuante, é possível definir a quantidade de casas decimais que devem ser impressas, então em um caso que se queira uma impressão de duas casas o símbolo deve ficar como `%.2f` e para quatro casas `%.4f` e assim por diante.

Só que essa impressão formatada para os números flutuantes acaba tendo um efeito colateral que é o indicador da casa decimal. Esse indicador muda de região para região. Por exemplo, aqui no Brasil, nós utilizamos a `,` como o separador de decimal enquanto que outras regiões utilizam o `.`. 

O efeito colateral é que essa função formatadora, vai sempre utilizar o mesmo padrão do sistema em que ele está rodando, portanto programas que estiverem rodando com a localização do Brasil, vão imprimir o valor com `,` caso nenhuma configuração seja feita. Assim como a quantidade de casas utilizadas também vai ter um padrão caso não seja definido como já indicado antes.

Para alterar esse padrão do indicador decimal, é possível fazer de duas formas. A primeira é você alterar a localização padrão considerado pelo código, isso seria feito uma única vez mas teria um efeito no código como um todo, e a segunda é utilizar um dos *overloads* da função que vai aceitar esse parâmetro de localização, tendo um efeito apenas para essa impressão, mas teria que ser feito sempre que necessário.

```java
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        String name = "Danilo";
        int age = 36;
        double height = 1.80;
        
        Locale.setDefault(Locale.US);
        System.out.printf("Hello, my name is %d and I'm %d years old and I'm %.2fm tall%n", name, age, height);
        System.out.printf("%.2f", height)
    }
}

// "Hello, my name is Danilo and I'm 36 years old and I'm 1.80m tall"
// "1.80"
```

Ou

```java
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        String name = "Danilo";
        int age = 36;
        double height = 1.80;
        
        System.out.printf(Locale.US, "Hello, my name is %d and I'm %d years old and I'm %.2f tall", name, age, height);
        System.out.printf("%.2f", height)
    }
}

// "Hello, my name is Danilo and I'm 36 years old and I'm 1.80m tall"
// "1,80"
```
