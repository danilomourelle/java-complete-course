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

### Aula 25 - Processamento e Casting
O fato de o Java ter mais de um tipo para variáveis de mesma intenção, por exemplo os tipos **int** e **double**, faz com que alguns comportamentos estranhos possam acontecer. Por exemplo, caso você tente assinalar uma variável **int** para uma variável **double**, você precisaria apenas adicionar um 0 como casas decimais. Mas ao contrário, o Java imagina que isso vai gerar uma perda do dado, e por isso levanta um erro. 

Nesses casos, se o valor decimal realmente pode ser desprezado, não basta alocar a variável **double** na **int**, também é preciso fazer o *casting* indicando na operação que você está ciente dessa perda dos dados e que quer seguir com essa intenção.

Agora, imagina que você tenha dois valores **int** e faça uma conta que gere um resultado decimal, por exemplo 9 / 4 que deveria gerar 2.25. Nesse caso, caso o Java entende que se os inputs da conta foram de dois números inteiros, o esperado para a saída também seja um número inteiro, portanto, mesmo que você coloque em uma variável do tipo float, ela já teve o seu valor decimal desprezado.

```java
public class App {
    public static void main(String[] args) throws Exception {
        int a, b;
        double resultado;
        a = 9;
        b = 4;

        resultado = a / b;
        
        System.out.println(resultado);
    }
}

// 2.0
```

Então, você além de fazer a declaração da variável no tipo adequado, no momento do alocar o valor, você ainda precisa indiciar que o processamento deve ser feito no formato desejado também. Então o exemplo acima ficaria da seguinte forma:

```java
public class App {
    public static void main(String[] args) throws Exception {
        int a, b;
        double resultado;
        a = 9;
        b = 4;

        resultado = (double) a / b;
        
        System.out.println(resultado);
    }
}

// 2.25
```

### Aula 26-27 - Entrada de dados

Em uma interação com o usuário, é provável que se faça necessário a entrada de dados que serão utilizados para um processamento. Para entradas de texto via terminal, o Java disponibiliza uma classe chamada **Scanner** que pode se acoplar ao sistema de entrada padrão do programa, e com isso coletar informações em durante a execução.

Essa classe também precisa ser importada da lib *utils* e um objeto deve ser instanciado. E aqui acontece uma outra coisa estranha do Java, esse objeto, em algum momento, precisa indicar que parou de observar o input. Inclusive o VSCode já mostra um warnning caso não identifique o fechamento do objeto. Então um exemplo simples de como usar a classe ficaria assim:

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
       
       scanner.close(); // fecha a observação do objeto 
       }
}
```

Esse objeto, como vai ficar escutando pelos inputs do terminal, apresenta alguns métodos que vão fazer a captura do valor inserido. Entre eles temos o método `next` que pega pela primeira palavra inserida, mesmo que mais de uma seja enviada, apenas a primeira será capturada.

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
       
       String text = scanner.next();
       // Digitado "Foo Bar" no terminal
       System.out.println(text);
       scanner.close();
       }
}

// "Foo"
```

Outro método do objeto Scanner é o `nextInt` que vai pegar esse valor mas no formato numérico e não na sua correspondência de texto como o anterior faz.

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
       
       int num = scanner.next();
       // Digitado "23 45" no terminal
       System.out.println(num);
       scanner.close();
       }
}

// 23
```

Porém esse último caso tem um detalhe, todo número tem o seu correspondente em string, então o método **next**, se receber um número, ele converte para o formato string. Uma soma desse valor, iria concatenar as strings ao invés de somar, mas o input seria aceito. Já o método **nextInt** ele precisa receber um número inteiro, e como nem todo texto pode ser convertido, caso o input seja algo como “lorem ipsum”, isso vai gerar uma exceção na entrada do valor.

Se for necessário ler um número flutuante, existe o método `nextDouble` e este sofre efeitos do indicador de decimal, igual já comentado anteriormente. Então se o programa for configurado para receber um número utilizando `.` como indicador, e o input ser passado com uma `,` vai gerar um erro.

O único detalhe desse caso é que diferente dos métodos de impressão, o objeto Scanner não aceita um parâmetro de localização, e por isso é preciso fazer no contexto do programa, e se necessário desfazer após a captura do dado.

```java
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Locale.setDefault(Locale.US);
       Scanner scanner = new Scanner(System.in);
       
       double num = scanner.nextDouble();
       // 2324.12313 23411.12314 no terminal
       System.out.println(num);
       scanner.close();
       }
}

// 2324.12313
```

Sem a linha `Locale.setDefault(Locale.US)`, ao inserir números usando `.` como indicador decimal, um erro será lançado. Agora, depois da definição de Locale, teremos um erro caso um valor com `,` seja enviado.

Em todos os exemplos acima, a gente passou mais de um valor, separado por espaços, e os métodos pegavam apenas o primeiro. Isso quer dizer que o espaço cria um ponto de quebra da informação, e isso pode ser utilizado para solicitar mais de um dado em um mesmo input. 

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
       
       String text = scanner.next();
       int num = scanner.nextInt();
       double num2 = scanner.nextDouble();
       
       // Digitado "Foo 23 35.696" no terminal
       System.out.printf("Texto: %s\nNúmero inteiro: %d\nNúmero decimal: %.3f\n", text, num, num2);
       scanner.close();
    }
}

// "Texto: Foo"
// "Número inteiro: 23"
// "Número decilmal: 35,696"
```

Obviamente, da mesma forma que um input individual, essa forma de vários dados em uma mesma linha então sujeitos a uma validação do tipo, lançando uma exceção caso o tipo passado não corresponda ao tipo esperado.

Além dessas formas de dados individuais, também é possível pegar todo o conteúdo de uma linha como se fosse um único dado, como um texto. Para isso você deve usar o método `nextLine`. Porém, vamos para mais uma bizarrice da linguagem, você pode ter uma quebra de linha presa nessas situações. Como assim?

Caso você utilize algum dos outros métodos comentados acima, você vai inserir o valor e digitar o *Enter* como uma confirmação de dado, mas acontece que isso insere uma quebra de linha que fica presa, já que os métodos param ao final do dado em si e não do EOL, então essa quebra fica acumulada, fazendo com que o primeiro uso desse método, que busca pelo EOL, já encontre esse acúmulo, sem nenhum dado.

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
	    Scanner scanner = new Scanner(System.in);
       
	    int x;
			String s1, s2, s3;
			x = scanner .nextInt();    // Vai gerar uma quebra de linha presa;
			s1 = scanner .nextLine();  // Vai pegar a quebra pendente sem valor
			s2 = scanner .nextLine();  
			s3 = scanner .nextLine();
			
			// Digitado 32 -> Enter
			// Digitado "Hello There!" -> Enter
			// Digitado "How are you?" -> Enter
			
			System.out.println("DADOS DIGITADOS:");
			System.out.println(x);
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
	    
	    scanner.close();
    }
}
// DADOS DIGITADOS:
// 23
// ""
// "Hello There!"
// "How are you?"

```

Então, senta que lá vem a gambiarra. Nesses casos você faz uma chamada extra para o `nextLine` apenas para descartar essa quebra de linha pendente.

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
	    Scanner scanner = new Scanner(System.in);
       
	    int x;
			String s1, s2, s3;
			x = scanner .nextInt();    // Vai gerar uma quebra de linha presa;
			scanner.nextLine();        // Vai descartar a quebra pendente;
			s1 = scanner .nextLine();  // Vai pegar o valor desejado
			s2 = scanner .nextLine();  
			s3 = scanner .nextLine();
			
			// Digitado 32 -> Enter
			// Digitado "Hello There!" -> Enter
			// Digitado "How are you?" -> Enter
			// Digitado "Let's have some dinner tonight?" -> Enter
			
			System.out.println("DADOS DIGITADOS:");
			System.out.println(x);
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
	    
	    scanner.close();
    }
}
// DADOS DIGITADOS:
// 23
// "Hello There!"
// "How are you?"
// "Let's have some dinner tonight?"
```

## Seção 5: Estrutura condicional

### Aula 33 - Expressões comparativas

É basicamente a mesma coisa do JavaScript, mas aqui a comparação de igualdade se dá com apenas `==`. O vídeo não fala, mas fazendo um teste no VSCode, uma comparação entre tipos diferentes, ele já nem deixou fazer, por exemplo `10 == "10"`. Não é que vai retornar um falso, ele simplesmente nem deixa fazer essa comparação.

Agora entre subtipos numéricos, ele aceita a comparação mas o comportamento pareceu meio errante. Comparando **float** com **double**, ele retorna verdadeiro para `0.0f` e `0.0`, mas retorna falso para `0.5f` e `0.5`. Comparação entre **float** e **int** funciona com valores diferentes de 0, e vão retornar verdadeiro apenas nos casos em que o número decimal apresentar apenas 0 após a vírgula. Esse mesmo comportamento acontece ao compartar **int** e **double.**

A questão da comparação entre **float** e **double**, segundo o Inteligência Artificial (GitHub Copilot), vai ter esse comportamento pela questão que o primeiro é um número flutuante de 32 bits de única precisão, enquanto que o segundo é um valor de 64 bits com uma dupla precisão. Então 0.4 nos dois tipos acaba apresentando um diferença nesse calculo da precisão. O que faz essa comparação ser considerada falso. (Nessa o JavaScript também tem as suas loucuras).

### Aula 35-40 - Condicionais

O Java tem basicamente a mesma programação condicional do JavaScript. 

Vai ter a estrutura de `if/else` podendo aninhar mais de um e até fazer a cadeia com os `else if`.

```java
public class App {
    public static void main(String[] args) throws Exception {
        int x = 10;

        if (x < 10) {
            System.out.println("Menor que 10");
        } else if (x == 10) {
            System.out.println("Igual a 10");
        } else {
            System.out.println("Maior que 10");
        }
    }
}
```

Vai ter a estrutura de `switch/case`:

```java
public class App {
    public static void main(String[] args) throws Exception {
        int number;
        String weekDay;

       switch (number) {
        case 1:
            weekDay = "Sunday";
            break;
        case 2:
            weekDay = "Monday";
            break;
        case 3:
            weekDay = "Tuesday";
            break;
        case 4:
            weekDay = "Wednesday";
            break;
        case 5:
            weekDay = "Thursday";
            break;
        case 6:
            weekDay = "Friday";
            break;
        case 7:
            weekDay = "Saturday";
            break;
        default:
            weekDay = "Invalid day";
            break;
       }
    }
}
```

E tem também o operador ternário, que funciona como uma espécie de `if/else` mas com uma complexidade bem mais baixa e normalmente utilizada para se atribuir um valor em formato condicional

```java
public class App {
    public static void main(String[] args) throws Exception {
        int hours = 0;
        String greetings = hours < 12 ? "Good Morning" : "Good Afternoon";
    }
}
```

## Seção 6: Estruturas de repetição

Também como o JavaScript, o Java possui as mesmas estruturas básicas de repetição, tanto o `while`, `do/while`, e o `for`. Todos funcionam da mesma maneira que no JS.

## Seção 7: Outros tópicos básicos

Como o Java é uma linguagem orientada a objeto (de orientada não tem nada, parece mais uma obrigatoriedade mesmo), as funções basicamente serão métodos em alguma classe.

A declaração de uma função se dá pelas indicações dela na classe, por exemplo `public static`, e depois precisa indicar o tipo do dado que será retornado pela função. Então se ela volta um número inteiro, precisa colocar `int`, se ela volta um texto, precisa colocar `String`.

Depois dessa indicação do retorno, ela fica um pouco mais normal. Você coloca o nome da função, abre os parênteses e coloca os parâmetros. Um detalhe é que como a linguagem é fortemente tipada, esse parâmetros precisam indicar o tipo de dado que ele espera receber.

Com essa assinatura feita, basta abrir as chaves e implementar a lógica da mesma forma que outras linguagens. Para retornar um valor, também como no JavaScript, basta colocar a palavra chave `return` juntamente do valor a ser retornado. Se a função não tiver um **return**, então precisa indicar que a função tem um retorno do tipo `void`.

Por serem métodos, não há nada que determine uma ordem de declaração e depois de utilização. Então um método lá embaixo no arquivo pode estar sendo usado lá na parte de cima, sem problemas. Mas vale ressaltar que caso a classe tenha algum método marcado como estático, este só poderá utilizar outros métodos desde que eles também sejam do tipo estático. Por outro lado, métodos de instância estão livres para utilizar métodos estáticos.

## Seção 8: Introdução a Programação Orientada a Objetos

### Aula 64-67: Utilizando Orientação a Objeto

Vamos fazer um programa que vai receber as 3 medidas de dois triângulos, calcular a área de cada um e imprimir qual dos dois triângulos é maior. A fórmula para se calcular a área de um triângulo utilizando as medidas dos lados é `sqrt(p * (p - A) * (p - B) * (p - C))` onde `p = (A + B + C) / 2` e A, B e C são as medidas do triângulo.

Se a gente fosse fazer isso tudo dentro do método *main* da classe principal, seria algo desse tipo:

```java
import java.util.Locale;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		double xA, xB, xC, yA, yB, yC;
		
		System.out.println("Enter the measures of triangle X: ");
		xA = scanner.nextDouble();
		xB = scanner.nextDouble();
		xC = scanner.nextDouble();
		
		System.out.println("Enter the measures of triangle Y: ");
		yA = scanner.nextDouble();
		yB = scanner.nextDouble();
		yC = scanner.nextDouble();
		
		double p = (xA + xB + xC) / 2.0;
		double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));
		
		p = (yA + yB + yC) / 2.0;
		double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

		if (areaX > areaY) {
			System.out.println("Larger area: X");
		} else {
			System.out.println("Larger area: Y");
		}

		scanner.close();
	}
}
```

Mas a gente pode começar a migrar isso para orientação e objeto. Com isso a gente já consegue imaginar que o principal sujeito do programa é o triângulo. Então a gente pode representar o triângulo em uma classe (nesses casos é chamada de entidade).

```java
public class Triangle {

  public double a;
  public double b;
  public double c;
}
```

Aqui, tem uma coisa interessante que o curso não comentou, mas arquivos de classes irmãs podem se ver sem problemas de importação. Então caso essa nova classe **Triangle** seja irmã da classe **App**, basta sair usando sem maiores problemas. Agora, com a separação de conceitos, a ideia é que até os arquivos sejam separados em pastas com o mesmo contexto. Essas pastas acabam tendo um conceito de *package* no Java.

Um *package* tem algumas regrinhas. Primeiro que todas as classes dentro desse package precisam ter em seu início uma expressão para indicar que faz parte dele, então se nós consideramos a nossa classe **Triangle** como um elemento no *package entities*, o nosso arquivo vai estar localizado em `src/entities` e ele vai ter a seguinte alteração:

```java
package entities;

public class Triangle {

  public double a;
  public double b;
  public double c;
}
```

Já a nossa **main** vai poder utilizar essa classe depois de importar o `entities.Triangle`. Então uma alteração apenas considerando que agora as medidas dos lados vão fazer parte de um objeto seria mais ou menos assim:

```java
import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class App {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		Triangle x, y;
		x = new Triangle();
		y = new Triangle();

		System.out.println("Enter the measures of triangle X: ");
		x.a = scanner.nextDouble();
		x.b = scanner.nextDouble();
		x.c = scanner.nextDouble();

		System.out.println("Enter the measures of triangle Y: ");
		y.a = scanner.nextDouble();
		y.b = scanner.nextDouble();
		y.c = scanner.nextDouble();
		
		double p = (x.a + x.b + x.c) / 2.0;
		double areaX = Math.sqrt(p * (p - x.a) * (p - x.b) * (p - x.c));
		
		p = (y.a + y.b + y.c) / 2.0;
		double areaY = Math.sqrt(p * (p - y.a) * (p - y.b) * (p - y.c));

		if (areaX > areaY) {
			System.out.println("Larger area: X");
		} else {
			System.out.println("Larger area: Y");
		}

		scanner.close();
	}
}
```

Beleza, os dados já ficaram relacionados, mas ainda tem muita coisa para melhorar, como o calculo da área. Se a fórmula calcula a área do triângulo, então faz sentido que isso seja um método da classe.

```java
package entities;

public class Triangle {

  public double a;
  public double b;
  public double c;

  public double calculateArea() {
    double p = (a + b + c) / 2.0;
    double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

    return area;
  }
}
```

Engraçado, aparentemente não tem o `this` em Java. Não sei se isso é bom, porque ôô tópico difícil né, ou ruim, porque eu finalmente entendi essa bagaça. Vamos esperar as próximas aulas para ver o que rola.

A nossa **main** agora pode ficar assim:

```java
import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class App {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		Triangle x, y;
		x = new Triangle();
		y = new Triangle();

		System.out.println("Enter the measures of triangle X: ");
		x.a = scanner.nextDouble();
		x.b = scanner.nextDouble();
		x.c = scanner.nextDouble();

		System.out.println("Enter the measures of triangle Y: ");
		y.a = scanner.nextDouble();
		y.b = scanner.nextDouble();
		y.c = scanner.nextDouble();
		
		double areaX = x.calculateArea();
		double areaY = y.calculateArea();

		if (areaX > areaY) {
			System.out.println("Larger area: X");
		} else {
			System.out.println("Larger area: Y");
		}

		scanner.close();
	}
}
```

A aula 67 traz a demonstração do `this` em Java. Aparentemente você pode acessar diretamente qualquer atributo da classe dentro dos métodos. O uso do `this` vai acabar ficando restrito apenas em casos de conflitos de nome entre um atributo e um parâmetro de um método. Então nesses casos, você usa para explicitamente reforçar quem é quem.

```java
package entities;

public class Product {
  public String name;
  public double price;
  public int quantity;

  public double totalValueInStock() {
    return price * quantity;
  }

  public void addItens(int quantity) {
    this.quantity += quantity;
  }

  public void removeItens(int quantity) {
    this.quantity -= quantity;
  }
}
```

Bom, poderia apenas proibir o conflito de nome, forçar que o parâmetro se chamasse por exemplo `quantityToAdd`, `quantityToRemove`. Vamos continuar a ver as próximas aulas.

### Aula 68: Imprimindo um objeto

Uma coisa interessante do Java é que toda classe existente é criada herdando os métodos da classe nativa `Object`. Essa classe apresenta um método `.toString()` que faz a conversão do objeto em uma string. Essa conversão acontece automaticamente quando o sistema identifica que o objeto está sendo impresso, isso significa que para imprimir no console basta utilizar o `System.out.print(objeto)`, e ele automaticamente faz a chamada do **.toString** por baixo do panos.

Acontece que isso pode gerar um comportamento estranho, já que a função original pode não ser aquilo que se imagina, então é comum que classes tenham um método de mesmo nome para sobrescrever o comportamento original.

Aí foi apresentado alguns macetes de conversão de números, sem que seja dentro da própria função de impressão. Então no exemplo da classe de Produtos, poderíamos ter uma função assim:

```java
public String toString() {
	return name
		+ ", $ "
		+ String.format("%.2f", price)
		+ ", "
		+ quantity
		+ " units, Total: $ "
		+ String.format("%.2f", totalValueInStock());
}
```

Repare que o objeto nativo **String** apresenta um método que vai receber a formatação e o valor numérico a ser formatado. Inclusive esse método pode ser utilizado como uma forma de se fazer uma espécie de *template string* do JavaScript. Na verdade, ela faz igual no **.printf**, mas ao invés de imprimir, ela retorna a string formatada.

```java
@Override
public String toString() {
    return String.format("%s, $ %.2f, %d units, Total: $ %.2f", name, price, quantity, totalValueInStock());
}
```

Coisas ensinadas pela IA: A anotação `@Override` mostra para o compilador que está é uma função que irá sobrescrever um método de uma super classe. Ela não é obrigatória, mas é legal usar porque com ela, o compilador checa a cadeia para ver se a função realmente existe e se tem a mesma assinatura. Se essa verificação falhar, ele interrompe a compilação. 

Por outro lado, sem a anotação, ele simplesmente vai compilar e você pode acabar tendo um método novo em caso de erro de digitação, ou criar um comportamento errante caso a assinatura não seja a mesma. Portanto use isso.

### Aula 71 - Membros estáticos

A ideia é que você pode colocar alguns elementos de uma classe, sejam atributos, sejam métodos como sendo do tipo estáticos. Isso vai indicar que o elemento não depende de uma instância da classe, eles são independentes dos valores do objeto em si, fazendo com que esse elementos sejam chamados sempre a partir da classe e não do objeto, por exemplo `Math.sqrt()`.

Esse tipo de uso vai ser muito comum quando se cria uma coleção de funções em um mesmo contexto, e você agrupa todas elas em uma classe que vai representar esse contexto. Os métodos devem sempre utilizar dados recebidos por parâmetros. Novamente um exemplo é a classe `Math`. Vale ressaltar que em classes com métodos estáticos e não estáticos, você não pode chamar um método não estático em um estático, uma vez que isso abre a possibilidade dele depender de dados do objeto, o que vai na contra mão do conceito de estático.

Outra situação é que se usa uma classe com elementos estáticos é quando você tem um conjunto de dados constantes, que não devem ser alterados, e também apresentam um contexto em comum. Então você declara uma classe como todos esses atributos como estáticos. Um exemplo disso é o `Locale.US` onde **US** é um atributo estático da classe **Locale**.

Para criar um método estático basta indicar na sua declaração utilizando a palavra chave `static`, e nos casos de um atributo que representa uma constante, é com `static final`. No caso de uma Classe que possua apenas elementos estáticos, é possível indicar que ela vai ser uma classe estática, o que impede que seja feita uma instância a partir dela.

## Seção 9: Construtores, this, sobrecarga e encapsulamento

### Aula 76 - Construtores

Para se ter um construtor nas classes do Java, é preciso criar uma função pública, que vai ter o mesmo nome da classe. Ela não tem indicação do retorno e ela deve receber como parâmetro qualquer dado que seja necessário durante a instanciação do objeto. Então um exemplo para a nossa classe Produto seria algo como:

```java
package entities;

public class Product {
  public String name;
  public double price;
  public int quantity;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public double totalValueInStock() {
    return price * quantity;
  }

  public void addItens(int quantity) {
    this.quantity += quantity;
  }

  public void removeItens(int quantity) {
    this.quantity -= quantity;
  }
}
```

### Aula 78 - Sobrecarga

Também conhecido como overload. É um conceito em que você cria mas de uma assinatura de função utilizando o mesmo nome, mas com parâmetros diferentes. Um exemplo disso é quando a gente vai chamar uma função quando abre o parêntese o VSCode mostra mais de uma opção de argumentos.

Isso em Java acontece mais pelo fato de que ela não apresenta os parâmetros opcionais ou com valores padrão. Então o que você precisa fazer é declarar a mesma função considerando todas formas viáveis, e escolher a forma certa quando for utilizar. 

O estranho é que isso vale inclusive para o construtos da classe, mas isso é, novamente, pelo fato de ele não ter assinaturas com parâmetros com valor padrão. Então um exemplo para a nossa classe de **Produtos** seria algo mais ou menos assim

```java
package entities;

public class Product {
  public String name;
  public double price;
  public int quantity;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
  public Product(String name, double price) {
    this.name = name;
	this.price = price;
  }

  public double totalValueInStock() {
    return price * quantity;
  }

  public void addItens(int quantity) {
    this.quantity += quantity;
  }

  public void removeItens(int quantity) {
    this.quantity -= quantity;
  }
}
```

Repare que temos duas funções construtoras sendo que na segunda, ela dispensa o valor de quantidade. Ou seja, ao se fazer a instanciação de um objeto do tipo **Product**, você vai poder fazer tanto passando a quantidade, quanto sem passar. Neste último caso, vale ressaltar que o valor para o atributo *quantity* não vai ser inicializado na instanciação, mas o Java, sempre inicializa uma variável **int** com o valor 0, então você teria um produto com uma quantidade 0.

### Aula 79 - Encapsulamento

A ideia é proteger qualquer dado do objeto para que ele permaneça consistente. Por exemplo, um objeto criado com uma informação que alguém pode simplesmente alterar e depois isso vai gerar uma quebra do programa. 

Para isso, uma convenção é que todos os atributos sejam declarados como privados e que qualquer manipulação seja feita utilizando métodos conhecidos como *getters* e *setters*. 

Os *getters* normalmente são funções que vão ter como nome a concatenação da expressão “get” mais no nome do atributo, por exemplo `getName`, vai ter como retorno o mesmo tipo do atributo e vair retornar o valor do atributo. Ele pode apresentar alguma lógica, a fim de verificar se é adequado retornar o valor na ocasião.

Os *setters* são funções para alterar o valor do atributo. A nomenclatura também segue um padrão onde se tem a concatenação da expressão “set” mais o nome do atributo, por exemplo `setName`. Obviamente ela vai apresentar pelo menos 1 argumento, que seria o novo valor, e pode ter uma lógica, por exemplo, impedir valores negativos em um atributo de tamanho.

Vamos ao exemplo da classe **Product**

```java
package entities;

public class Product {
  private String name;
  private double price;
  private int quantity;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity < 0 ? 0 : quantity;
  }

  public double totalValueInStock() {
    return price * quantity;
  }

  public void addItens(int quantity) {
    this.quantity += quantity;
  }

  public void removeItens(int quantity) {
    this.quantity -= quantity;
  }
}
```

Veja nesse exemplo, como para o atributo `quantity` não foi criado um *setter* já que ele já tem os outros métodos que vão realizar o incremento e o decremento.

Mas assim, se é para ter um *getter* e um *setter* que apenas retorne o valor e também possa alterar sem nenhum tipo de validação, então não faz sentido marcar o atributo como privado. As IDEs já disponibilizam uma ferramenta que automaticamente gera esses *getters* e *setters* simples para todos os atributos, para na minha opinião, usar isso dessa forma é um erro. Vá criando conforme você identifique a necessidade e condições de acesso ao atributo.

### Aula 81 - Modificadores de acesso

A gente já viu que os elementos de uma classe, pode estar `public` e `private`, mas também existem outras opções que vão ter os seus efeitos.

Apenas para fins de esclarecimento, um elemento declarado como `public` poderá ser acessado por todas as classes, a não ser que essa classe faça parte de um outro módulo que não exporte o pacote da qual ela faz parte.

Já os elementos `private` são elementos que só podem ser acessados dentro da própria classe. Ou seja, nem pelo objeto ela fica acessível se não tiver o *getter* e o *setter.* Mas existem também os elementos `protected` que serão elementos que vão poder ser acessados por outras classes que façam parte de um mesmo pacote, ou por subclasses que estendam essa. Por fim, podemos não colocar nenhum modificador de acesso, e o efeito disso é deixar os elementos visíveis apenas dentro de classes que fazem parte do mesmo pacote;

## Seção 10 - Memória, Arrays e Listas

### Aula 87: Tipos referência vs Tipos valor
    
Valores primitivos, como **int**, **double**, **char**, **boolean** vão ter o valor da variável armazenado diretamente o setor `stack` da memória. Isso significa que caso você assinale uma variável primitiva com o valor de uma outra variável, quando ele copiar esse conteúdo da stack, ele vai copiar o valor, e portanto você terá dois valores iguais porém independentes.

Agora para valores complexos, de objeto. O que acontece é que como eles precisam de mais memória, os valores em si são armazenados em uma outra sessão, chamada `heap`. Com isso a variável que fica na stack vai armazenar o endereço dos dados na heap. Isso faz com que ao assinalar uma variável de objeto para outra variável, ao copiar o conteúdo da stack, ele copia o endereço da heap, e aí você passa a ter duas variáveis apontando para um mesmo lugar.

Algo me diz que o JavaScript deve fazer alguma coisa desse tipo, e por isso que comparar dois objetos com os mesmo valores vai dar `false` e copiar um objeto faz com que alterações na cópia também reflitam no original.

Agora, tem um outro detalhe importante, se você declara uma variável ou um método sem inicializar o valor, ele vai dar erro caso você tente utilizá-la. Os valores padrão do Java só são aplicados aos atributos da classe, e não a todas as variáveis. Então, uma classe que tenha um atributo não inicializado no seu construtor, esse sim vai apresentar um valor padrão de acordo com o tipo.
    
### Aula 88: Desalocação e Garbage Collector
    
Quando um programa inicia, o que acontece é que são criados dois tipos de memória, uma chamada de **Stack** e outra de **Heap**. O que acontece é que uma função, ao ser executada, vai ter o seu contexto, e esse contexto é como se fosse um bloco dentro da **Stack** e lá serão salvas as variáveis primitivas dessa função.

Já no caso dessas variáveis ser um objeto, os dados do objeto, por serem mais complexos, são salvos na **Heap** e o endereço onde foi salvo é que vai parar na variável da **Stack**. Já falamos disso na aula 87.

Aí como funciona a reciclagem de memória? Durante a execução da função, o bloco dentro da **Stack** está lá, então suas variáveis primitivas com seus valores e as de referência armazenando o endereço a **Heap**. O que acontece é que ao finalizar a execução, esse bloco da **Stack** é totalmente apagado, então todos os valores primitivos somem, e os ponteiros também, abrindo espaço para novas alocações.

Mas e os dados que estavam na **Heap**? Bom, esses acabam ficando lá, sem ninguém estar apontando para eles, e é aí que entra o conceito de *Garbage Collector*. O *GC* vai ficar observando a **Heap** e sempre que identificar dados sem ninguém apontando para ele, esses dados serão deletados e a memória ficará disponível para reutilização.
    
### Aulas 89-95: Arrays
    
Um array obrigatoriamente deve ter todos os elementos do mesmo tipo, e um outro detalhe é que ele deve ter um tamanho pré determinado na sua criação e esse tamanho não pode ser alterado.

Para criar um array você precisa indicar o tipo dos dados, seguido do símbolo `[]`, então o nome. No caso de você não ter os elementos do array ainda, então essa declaração precisa indicar pelo menos a quantidade de elementos que ele vai ter, e para isso você vai usar a palavra chave `new` depois o tipo utilizado na primeira parte e entre parênteses a quantidade desse array.

Veja um exemplo de um array de `double`:

```java
public class App {
  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    int quantity = scanner.nextInt();
    double[] height = new double[quantity];

    for (int i = 0; i < quantity; i++) {
      height[i] = scanner.nextDouble();
    }

    scanner.close();
  }
}
```

Agora, caso você tenha os valores desse array, é possível fazer a criação dele logo de cara, por exemplo `double[] height = {1.75, 1.80, 1.65, 1.90};` 

Apenas ressaltando que isso vale tanto para valores primitivos quanto para tipo de objetos, então uma declaração do tipo `Product[] products = new Product[length]`. É, eu sei, é estranho, porque parece que vc quer instanciar a classe com o valor de length no construtor, mas basta reparar que nos arrays são usados chaves e não parênteses. Aliás, falando em length, vale dizer que os arrays de Java apresentam essa propriedade então o exemplo acima poderia ser:

```java
public class App {
  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    int quantity = scanner.nextInt();
    double[] height = new double[quantity];

    for (int i = 0; i < height.length ; i++) {
      height[i] = scanner.nextDouble();
    }

    scanner.close();
  }
}
```
    
