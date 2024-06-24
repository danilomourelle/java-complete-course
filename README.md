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

## Seção 10: Memória, Arrays e Listas

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
    
### Aula 96: Boxing, Unboxing e Wrapper Classes
    
**Boxing** e **Unboxing** são formas de você transportar um valor que pode ser considerado em primitivo para um de referência. Por exemplo, fazer o **Boxing** de uma variável do tipo **int** seria fazer com que ela deixasse de existir na **Stack** e passasse a existir na **Heap**. Isso poderia ser feito da seguinte forma:

```java
  public class App {
  public static void main(String[] args) throws Exception {
    int x = 10;

    Object obj = x;
  }
}
```

Dessa forma a variável `obj` passou a ser um objeto armazenado com referência na **heap**. Para o processo de **Unboxing**, basta fazer o inverso:

```java
  public class App {
  public static void main(String[] args) throws Exception {
    int x = 10;

    Object obj = x;
    
    int y = (int) obj;
  }
}
```

Mas repare que nesse caso, o compilador exige que você faça o casting, porque afinal, é preciso ter a certeza que esse objeto vai ter um valor compatível com o tipo primitivo que vai fazer o **Unboxing**.

É aí que entra o conceito das **Wrapper Classes**. O Java vai ter uma classe compatível para cada tipo primitivo, sendo elas bem identificadas - *Byte, Short, Integer, Long, Float, Double, Boolean, Character*. Essas classes podem fazer essa transição de **Boxing ↔ Unboxing** sem a necessidade do casting.

Outra vantagem dessas Wrapper Classes, é que por acabar gerando um obejto, isso significa que o valor padrão desses tipos vai ser sempre `null`. Isso faz com que seja uma boa prática que os atributos de uma classe sempre sejam declarados com essas classes e não com o tipo primitivo, pois assim, em uma instanciação, os valores iniciais do objeto vão ser `null`. 

Isso é bom porque imagina que você tem um campo que armazena notas de uma prova. Antes de a prova ser aplicada, não dá pra ter valor, e caso esse campo seja declarado como primitivo, o que vai acontecer é que o valor será 0, o que não é real. Na verdade não há a nota, e portanto deveria ser nulo. Declarar esse campo com `Double` vai fazer com que esse campo possa ser e inicie com o valor nulo. Por isso é uma boa pratica que atributos de classes sejam declarados com a **Wrapper Class**.
    
### Aula 97: for each
    
Esse é um tipo de loop em um array, mas em comparação com o JavaScript, é muito mais parecido com o `for...of`.

Para usar é basicamente colocar a expressão `for` abrindo o parêntese, depois o tipo do elemento do array (pra que né??), um nome para referenciar o elemento da vez, o símbolo `:` e o array que deve ser iterado. Abaixo vai ter o exemplo.

```java
public class App {
  public static void main(String[] args) throws Exception {
    String[] names = { "Maria", "Bob", "Alex" };

    for (String currentName : names) {
      System.out.println(currentName);
    }
  }
}
```
    
### Aula 98-99: Listas
    
A ideia de lista é dar um pouco mais de maleabilidade para um array. Como comentado, você não poder alterar o tamanho do array, vai deixa tudo muito frustrante, ainda mais para quem veio do JavaScript e pode fazer isso. 

No Java, o `List` acaba sendo uma interface que é utilizada por classes como o `ArrayList` e o `LinkedList`. A ideia é que na memória, essa estrutura não precisa estar enfileirada, e para que isso seja possível, a estratégia montada é que um elemento tenha a informação da posição do próximo elemento. Isso cria a possibilidade de um tamanho dinâmico, enquanto que diminui um pouco da performance em casos de iteração.

Para se criar uma lista, você pode usar a interface para indicar o tipo da variável, mas não para assinalar o valor, uma vez que a interface não gera instância. Nesse caso você necessariamente precisa de uma classe que implemente a interface. Imagino eu que seja possível tipar a variável também com a classe, pelo menos funciona no VSCode.

```java
public static void main(String[] args) throws Exception {
    List<String> names = new ArrayList<>();

    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");
    names.add("Dave");
    names.add("Eve");

    for (String name : names) {
      System.out.println(name);
    }
  }
```

Bom, o exemplo acima traz a declaração de uma `ArrayList` assim como a forma de se adicionar elementos nessa lista. O método `add` quando apenas com um argumento, ele adiciona esse argumento no final da lista, mas ele tem a opção com dois parâmetros, onde o primeiro recebe um **int** com a posição da inserção e o segundo recebe o elemento a ser inserido - `names.add(2, "Beatriz")`.

Já para remover um elemento existe o método `remove` e este também pode ser utilizado de duas formas. A primeira é recebendo um inteiro com argumento que vai representar o index do elemento que deve ser removido `names.remove(2)` - quando usado nessa forma, o elemento removido é retornado pela operação. A segunda forma é passar o valor do elemento, por exemplo `names.remove("Charlie")`. Nessa forma ele vai passar pelos elementos, e caso encontre um que seja igual, ele irá remover (apenas o primeiro que ele encontrar). O retorno desse segundo tipo é um **boolean** uma vez que em teoria  a gente tem o valor de elemento que é o que foi passado como argumento.

Existe uma forma de fazer uma remoção de elementos através de uma verificação, e neste caso todos os elementos são verificados e todos aqueles que caírem na verificação serão removidos, esse é o método `removeIf`. É como se fosse um filtro do JavaScript, mas nesse caso, ele não vai retornar um novo array, ele vai é remover da lista original. Essa função verificadora é chamada de predicado e ela deve retornar um booleano, sendo que todo elemento que retornar **true** é removido, e os que retornarem **false** permanece - `names.removeIf(name -> name.startsWith("B")` - quase uma *arrow function* né.

```java
  public static void main(String[] args) throws Exception {
    ArrayList<String> names = new ArrayList<>();

    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");
    names.add("Dave");
    names.add("Eve");
    names.add(2, "Beatriz");

    System.out.println("AFTER ADDING");
    for (String name : names) {
      System.out.println(name);
    }

    names.remove(5);
    names.remove("Dave");

    System.out.println("\nAFTER REMOVING");
    for (String name : names) {
      System.out.println(name);
    }

    names.removeIf(name -> name.startsWith("B"));

    System.out.println("\nAFTER FILTERING");
    for (String name : names) {
      System.out.println(name);
    }
  }
  
  /*
    AFTER ADDING
    Alice
    Bob
    Beatriz
    Charlie
    Dave
    Eve
    
    AFTER REMOVING
    Alice
    Bob
    Beatriz
    Charlie
    
    AFTER FILTERING
    Alice
    Charlie
    */
```

Ao contrário do array que tem a propriedade `length`, esse objeto vai ter o método `size()` para indicar a quantidade de elementos na lista. Outro método que as listas apresentam é o `indexOf(elemento)` e este funciona basicamente como o JavaScipt, se tiver retorna o índice do elemento, se não tiver retorna -1.

Agora começa umas coisas estranhas. Imagina que você quer, a partir de uma lista, selecionar determinados elementos, mas mantendo a lista original. Você pode fazer uma cópia desse valor original e utilizar o **removeIf** mas isso pode ficar ineficiente conforme a lista fique muito grande uma vez que você vai copiar ele todo só para descartar uma parte dos dados, por isso, existe uma forma que é transformar a lista em um *stream*, aplicar esse predicado no *stream* e transformar esse resultado de volta em uma lista. WTF????

Calma que piora, mas vamos com a primeira parte. Para transformar uma lista em *stream* obviamente você vai chamar o método `stream()` e aí esse tipo vai dar acesso ao método `filter()` que vai aceitar o predicado como argumento. Nesse caso um retorno **true** mantém o elemento enquanto que o **false** descarta.

Agora precisamos retornar esse resultado para o tipo lista, e para fazer isso há duas formas, a primeira é simplesmente chamar o `.toList()`, mas nesse caso a lista se torna imutável, igual um array. Outra opção é chamar `.collect(Collectors.toList())`, essa forma também transforma em lista, mas em uma lista mutável, que ainda vai ter os métodos comentados no início da aula.

```java
public static void main(String[] args) throws Exception {
    ArrayList<String> names = new ArrayList<>();

    names.add("Alice");
    names.add("Alex");
    names.add("Bob");
    names.add("Brain");

    // Unmodifiable list
    List<String> namesStartingWithA = names.stream()
      .filter(name -> name.startsWith("A"))
      .toList();

    // Modifiable list
    List<String> namesStartingWithB = names.stream()
      .filter(name -> name.startsWith("B"))
      .collect(Collectors.toList());
  }
```

Essa estratégia de transformar a lista em um *stream* na verdade abre possibilidades para se aplicar vários métodos de *stream*. Um outro método interessante é o `.findFirst()`. Mas diferente do método `find()` do JavaScript, ele não aceita a função de comparação, então o que você precisa fazer é uma combinação com a **filter**. 

Só que um detalhe é que o retorno desse método é de um tipo opcional, uma vez que o *stream* pode ter ficado vazio e portanto não tem ninguém para ser encontrado, e nesse caso, você pode utilizar o método `.orElse()` que vai receber um valor que deve ser retornado nesse casos.

```java
public static void main(String[] args) throws Exception {
    ArrayList<String> names = new ArrayList<>();

    names.add("Alice");
    names.add("Alex");
    names.add("Bob");
    names.add("Brain");

    // Returns Alice
    String firstNameWithA = names.stream()
      .filter(name -> name.startsWith("A"))
      .findFirst()
      .orElse(null);

    // Returns null
    String firstNameWithD = names.stream()
      .filter(name -> name.startsWith("D"))
      .findFirst()
      .orElse(null);
  }
```
    
#### Streams
    
Eu pensei em algumas alternativas para esse treco, por exemplo, transformar o resultado do filtro em uma lista e pegar o primeiro elemento já que `findFirst` faz basicamente isso. Mas descobri que isso também não é performático, principalmente se a lista original for muito grande.

Isso acontece pelo comportamento natural de um **stream**. Quando você transforma a lista em u **stream** e monta uma cadeia de transformadores, o que acontece é que cada item desse **stream** vai passar por todos os transformadores por vez, ou seja, o primeiro item passa pelo filtro, qualquer outra coisa, e então pelo *findFirst*, e só então o segundo elemento vai passar pelo filtro.

Acontece que alguns desses transformadores apresentam uma ação de finalização de curto circuito (*shot-circuit terminal*), uma vez que elas já cumpriram a sua função no meio do processamento da lista. O *findFirst* é um desses casos, uma vez que depois de encontrar o primeiro item, não tem mais porque continuar o processamento.

Então o que acontece aqui é que o primeiro nome vai passar no predicado do filtro, se ele for eliminado, esse item cai fora, e vem o segundo. Se esse segundo passar, ele vai para o *findFirst* que como não faz nada a não ser pegar o primeiro item que chega nele, já vai avisar o **stream** que ele completou a sua missão e portanto o **stream** pode parar de mandar item, ou seja, o terceiro item nunca nem passa pelo filtro ou qualquer outro transformador. Isso é muito poderoso, tanto é que uma das definições do **stream** é que ele pode transformar algo infinito em finito, porque de fato uma vez que a “missão” foi cumprida, não tem porque aquele transformador continuar recebendo itens.

Mas aquela velha máxima né, com grandes poderes vem grandes responsabilidades, você vai precisar saber quais são os métodos do **stream** que fazem essa terminação, e saber encadear os transformadores de forma coerente. Um exemplo é a combinação do transformador `limit()` com o `skip()`. O primeiro limita a quantidade de itens que passa por ele para no máximo o valor recebido como argumento, e o segundo descarta os primeiros n itens de acordo com o valor no parâmetro. Ou seja algo como `.stream().limit(2).skip(3)` não vai fazer sentido, já que o **limit** vai falar para o **stream** parar de mandar itens depois que receber o segundo, enquanto que o **skip** só repassa do item 4 em diante. Ou seja, essa combinação causa um **stream** vazio SEMPRE.

## Seção 11: Dates

### Aula 111: Objetos do tipo de datas
    
O Java vai ter os mesmo conceitos para datas e horas, sendo o formato local, que é sem informação de um TZ associado, e padrão ISO, e por falar em padrão ISO isso independe da linguagem então ela vai ter o formato `yyyy-MM-ddThh:mm:ss.xxxZ`. 

Diferentemente do JavaScript que utiliza basicamente a classe `Date` para tudo, o Java vai apresentar classes especificas para cada tipo de situação. Uma informação de data local vai utilizar a classe `LocalDate`, enquanto que uma informação de data-hora local vai utilizar a classe `LocalDateTime`. Já a informação no formato ISO vai utilizar a classe `Instant`. Cabe ressaltar que um **LocalDateTime** pode existir sem a informação de horário, enquanto que um **LocalDate** vai descartar qualquer informação de horário.

A operação mais básica com essas classes é a obtenção de valor do momento da execução, e para isso basta utilizar o método `now()` das classes. Abaixo seguem exemplos com cada classe:

```java
LocalDate today = LocalDate.now();
LocalDateTime now = LocalDateTime.now();
Instant nowISO = Instant.now();

// 2024-06-19
// 2024-06-19T11:55:30.302942
// 2024-06-19T14:55:30.302942Z
```

Outra operação muito comum é quando nós temos uma string que representa um momento e nós precisamos converter isso em um objeto com os valores definidos pela string. Esse tipo de instancia pré-definida se dá utilizando o método `parse()`.

```java
LocalDate today = LocalDate.parse("2024-06-19");
LocalDateTime now = LocalDateTime.parse("2024-06-19T11:55:30.302942");
Instant nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");
Instant nowISOFromTZ = Instant.parse("2024-06-19T11:55:30.302942-03:00");

// 2024-06-19
// 2024-06-19T11:55:30.302942
// 2024-06-19T14:55:30.302942Z
// 2024-06-19T14:55:30.302942Z
```

Agora, no caso de essa string não estar no formato ISO, o que a gente precisa fazer é avisar o `parser()` qual é o formato que deve ser considerado na string. Para isso, existe uma outra classe utilizada para indicar o tipo do formato utilizado por uma string que é a classe `DateTimeFormatter`. A documentação da classe está nesse [link](https://docs.oracle.com/en%2Fjava%2Fjavase%2F22%2Fdocs%2Fapi%2F%2F/java.base/java/time/format/DateTimeFormatter.html) 

```java
String stringDate = "19/06/2024";
DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

LocaDate date = LocalDate.parse(stringDate, format);

// 2024-06-19
```

```java
String stringDate = "19/06/2024 12:30";
DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

LocalDateTime date = LocalDateTime.parse(stringDate, format);

// 2024-06-19T12:30
```

Como última opção, é a criação de um objeto de data quando nós temos os valores de ano, mês, hora ou minuto de forma individual. Para isso as classes apresentam um método `.of()`. Por ser uma condição com várias combinações possíveis, esse método vai ter várias sobrecargas, então é bom dar uma olhada nas opções quando for utilizar.

```java
int year = 2024;
int month = 06;
int day = 19;
int hour = 12;
int minute = 00;

LocalDate date = LocalDate.of(year, month, day);
LocalDateTime datetime = LocalDateTime.of(year, month, day, hour, minute);

// 2024-06-19
// 2024-06-19T12:00
```
    
### Aula 112: Parse Dates
    
Para fazer o parse de um objeto com informação de data, temos que os objetos vão apresentar o método `.toString()`, sendo que por padrão ele sempre vai retornar uma string representativa no formato ISO.

Agora, caso seja necessário obter um string em algum outro formato específico, basta usar a mesma classe de formatação para fazer essa conversão. Para isso há duas opções de comando, sendo uma delas `date.format(formatter)` e a outra `formatter.format(date)`. Ou seja, usando o método `.format()` seja no objeto de data, seja no objeto do estilo de formatação.

```java
LocalDate today = LocalDate.parse("2024-06-19");
DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

System.out.println(today.format(fmt1));
System.out.println(fmt1.format(today));

// 19/06/2024
// 19/06/2024
```

Esse método funciona também para o **LocalDateTime**, mas falha um pouco para um **Instant** já que ele não tem o método *.format()* e quando utilizado deve sempre ser considerado o TZ da informação. Por isso, quando utilizar o formatador com esse tipo, deve-se utilizar exclusivamente o método do formatador, passando o **Instant** como argumento. E mais do que isso, esse formatador, precisa indicar qual o TZ que vai ser considerado na impressão.

```java
LocalDate today = LocalDate.parse("2024-06-19");
LocalDateTime now = LocalDateTime.parse("2024-06-19T11:55:30.302942");
Instant nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");

DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());

System.out.println(fmt1.format(today));
System.out.println(fmt2.format(now));
System.out.println(fmt3.format(nowISO));

// 19/06/2024
// 19/06/2024 11:55:30
// 19/06/2024 11:55:30 -> repare que a data original estava como 14:55 UTC
```

Parece uma boa ideia padronizar então sempre ter a formatação com o método sendo chamado do formatador, e não ficar misturando as possibilidades. Outra detalhe é que caso se tente usar um **Instant** com um formatador sem a informação de TZ ele vai gerar um erro. Isso vale inclusive para os formatadores pré definidos na classe. 

Esse TZ que deve ser acrescentado, tem a classe `ZoneId` que além de fornecer alguns métodos que vão retornar ajudar a retornar a informação de zona, tem também um método `.getAvailableZoneIds()` que retorna uma série de valores que podem ser utilizados como referência, como IANAs por exemplo.

### Aula 113: Convertendo Instant em Local
    
Para fazer a conversão de um objeto **Instant** em um **Local** vamos ter algumas opções, sendo uma delas utilizando um método estático da classe *target* e a outra forma, é transformar o objeto **Instant** em um do tipo **ZonedDateTime** e então em um **LocalDate** com os métodos de instância.

```java
Instant nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");

LocalDate today = LocalDate.ofInstant(nowISO, ZoneId.of("America/Sao_Paulo"));
LocalDate today2 = nowISO.atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate();
```

Os objetos de data vão ter vários métodos, seria interessante ir lendo a assinatura deles conforme for abrindo no Intellisense. Eles vão ter métodos clássicos para isolar a informação de dia, de mês entre outros dados.
    
### Aula 114: Calculo com datas
    
Após a criação de uma data, esse objeto é imutável, portanto quando necessário, uma nova instancia precisa ser criada com o novo valor. Os objetos de data vão apresentar um série de métodos que podem retornar um novo objeto calculado com a diferença desejada. Os principais métodos das classes **LocalDate** e **LocalDateTime** vão somar ou subtrair uma quantidade de tempo e por isso eles vão ter um prefixo comum como `.minusDays()` e `.minusWeeks()` para subtrair e `.plusDays()` e `.plusWeeks()` para somar.

Já os objetos da classe **Instant**, eles vão apresentar um método um pouco diferente. Ele apresenta menos métodos, mas em compensação tem um mais genérico que é o `.minus()` que vai aceitar um número, e uma unidade de medida. O mesmo acontece para o método `.plus()`.

Para essa unidade de medida o Java disponibiliza a classe `ChronoUnit` que vai conter valores estáticos que vão servir para preencher o campo da forma correta.

```java
LocalDate today = LocalDate.parse("2024-06-19");
LocalDate yesterday = today.minusDays(1);

LocalDateTime now = LocalDateTime.parse("2024-06-19T11:55:30.302942");
LocalDateTime minus24Hours = now.minusHours(24);

Instant nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");
Instant tomorrow = nowISO.plus(1, ChronoUnit.DAYS);
```

Para calcular a distância entre duas data, o Java vai ter a classe `Duration` e ela vai ter um método estético `.between()` que pode ser utilizado para se obter o objeto de duração entre duas datas. Esse objeto vai ter os seu métodos para que o seu valor possa ser obtido em um formato mais adequado. Por exemplo, é possível utilizar o método `.toDays()` que vai retornar o valore dessa duração em dias.

```java
LocalDate today = LocalDate.parse("2024-06-19");
LocalDate yesterday = today.minusDays(1);

Duration duration = Duration.between(today, yesterday);
System.out.println(duration.toDays());
```

Porém, esse método aceita apenas **LocalDateTime**, ou seja, se a gente tiver objetos do tipo **LocalDate**, a gente precisa primeiro transformá-los para acrescentar a informação de horário, e para isso a gente pode utilizar o método `.atTime()` onde a gente pode especifica uma hora e minuto, ou podemos usar o método `.atStartOfDay()` que vai considerar o 00:00.
    
## Seção 13: Enumeração, composição

### Aula 147: Enums
    
Um `enum` é um tipo especial onde você aglomera valores que vão ter um contexto muito próximo, como uma lista de status. Esse enum vai tanto facilitar indicando os valores através do intellisense quanto limitando as possibilidades apenas para os valores conhecidos pelo sistema. Um exemplo de como declarar um enum:

```java
package entities.enums;

public enum OrderStatus {
  PENDING_PAYMENT,
  PROCESSING,
  SHIPPED,
  DELIVERED;
}
```

Agora esse enum vira um tipo que pode ser utilizado para identificar um atributo em alguma classe, por exemplo numa classe `Order`:

```java
package entities;

import entities.enums.OrderStatus;

public class Order {
  private Integer id;
  private String moment;
  private OrderStatus status; // Utilização do enum como um tipo

  public Order(Integer id, String moment, OrderStatus status) {
    this.id = id;
    this.moment = moment;
    this.status = status;
  }
}
```

E a ideia de utilização do `enum` em si é que você pode definir o valor a partir do enum, como se fosse um atributo estático de uma classe.

```java
import entities.Order;
import entities.enums.OrderStatus;

public class App {
  public static void main(String[] args) throws Exception {
    Order order = new Order(1080, "2021-06-20T19:53:07Z", OrderStatus.PENDING_PAYMENT);
  }
}
```

Repare que para definir o valor de status, eu primeiro chamo o meu `enum` que vai ter os possíveis valores, e então a própria IDE já me mostra a lista limitada com os valores aplicáveis.

Mas vale ressaltar que um enum não é exatamente uma lista de strings, repare que os valores não estão entre aspas. Mas se você mandar imprimir algum objeto onde um dos atributos seja um enum, ele vai considerar o nome do valor como se fosse uma string e imprimir. Agora para os casos inversos, onde a gente precisa selecionar o enum a partir de uma string, aí a gente pode utilizar o método `.valueOf()` passando como string alguns dos valores existentes dentro do enum.

```java
public class App {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    System.out.println("Estado do pedido:");
    String status = sc.next();

    Order order = new Order(1080, "2021-06-20T19:53:07Z", OrderStatus.valueOf(status));
    System.out.println(order);

    sc.close();
  }
}
```

Apenas lembrando que caso o valor recebido não exista no enum, um erro será lançado.  

Uma informação obtida com a IA é que na verdade o enum é um tipo especial de classe, onde cada um dos valores que declaramos dentro dele seria uma instância pré-definida. Ou seja, é uma classe com instâncias fixas e conhecidas.

Se é uma classe, eu quis entender se ela pode ter métodos, e aparentemente pode sim, e essas instâncias pré-definidas vão ter acesso a elas também.

```java
public enum Color {
    RED, GREEN, BLUE;

    public void printColor() {
        switch (this) {
            case RED:
                System.out.println("Color is Red");
                break;
            case GREEN:
                System.out.println("Color is Green");
                break;
            case BLUE:
                System.out.println("Color is Blue");
                break;
        }
    }
}

Color.RED.printColor();  // prints "Color is Red"
```

Ai, eu tentei entender a diferença entre um `enum` e uma classe ~~estática~~ abstrata, o ponto é que a classe ~~estática~~ abstrata não pode ter instâncias associadas, enquanto que o enum vai ter essas instâncias fixas. ~~Outra coisa que eu não entendi muito bem, é que parece que uma classe estática tem que estar dentro de uma outra classe.~~ Deu pra ver que eu me confundi com conceito de estática e abstrata. 

Outra coisa é que enum podem ter métodos, campos e construtores. Os construtores serão sempre privados, impedindo a criação de uma instância de um enum, mantendo o ponto de instâncias fixas, mas eles sempre serão chamados por cada uma das instâncias indicadas dentro de enum.

Esse construtor serve para inicializar possíveis campos que o enum venha a ter, e os valores utilizados pelo construtor devem ser indicados dentro de parênteses ao lado de cada indicação de instância. Abaixo tem um exemplo de um enum de dias da semana, com os sete possíveis valores, um construtor inicializando valores de nome e número do dia na semana, e apresentando métodos que podem ser chamados por cada uma das instâncias.

```java
enum DayOfWeek {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 3),
    THURSDAY("Thursday", 4),
    FRIDAY("Friday", 5),
    SATURDAY("Saturday", 6),
    SUNDAY("Sunday", 7);

    private final String dayName;
    private final int dayNumber;

    // Constructor is implicit private
    DayOfWeek(String dayName, int dayNumber) {
        this.dayName = dayName;
        this.dayNumber = dayNumber;
    }

    // Getter for dayName
    public String getDayName() {
        return dayName;
    }

    // Getter for dayNumber
    public int getDayNumber() {
        return dayNumber;
    }

    // Method to check if it's a weekday
    public boolean isWeekday() {
        return this.dayNumber >= 1 && this.dayNumber <= 5;
    }
}
```

## Seção 14: Herança e Polimorfismo

### Aula 157 - Herança

A ideia de herança é exatamente a mesma do JavaScript, você tem uma classe base, e uma outra que vai utilizar todos os dados dessa base, e estender com mais outras informações. Essa classe base é chamada de `super` enquanto que a outra é chamada de `sub`.

Vejamos o exemplo:

```java
// Account.java
package entities;

public class Account {
  private Integer number;
  private String holder;
  private Double balance;

  public Account() {
  }

  public Account(Integer number, String holder, Double balance) {
    this.number = number;
    this.holder = holder;
    this.balance = balance;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getHolder() {
    return holder;
  }

  public void setHolder(String holder) {
    this.holder = holder;
  }

  public Double getBalance() {
    return balance;
  }

  public void deposit(Double amount) {
    balance += amount;
  }

  public void withdraw(Double amount) {
    balance -= amount + 5.0;
  }
}
```

```java
// BusinessAccount.java
package entities;

public class BusinessAccount extends Account{
  private Double loanLimit;

  public BusinessAccount() {
    super();
  }

  public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
    super(number, holder, balance);
    this.loanLimit = loanLimit;
  }

  public Double getLoanLimit() {
    return loanLimit;
  }

  public void setLoanLimit(Double loanLimit) {
    this.loanLimit = loanLimit;
  }
}
```

A sub classe `BusinessAccount` vai ter todas as informações da super classe `Account` e mais aquelas que forem exclusivas dela. Porém, vale lembrar dos modificadores de acesso, por exemplo, caso um campo seja marcado como privado numa super classe ele ainda não pode ser alterado na sub classe. Se isso for necessário, o campo deve ser alterado para protegido.

A ideia de sempre ter um construtor vazio ajuda nas questões de herança no sentido de que quando você for herdar, você pode ter um construtor vazio na sub classe invocando o super vazio. Assim se em algum momento houver uma lógica para a construtor vazio na super classe, essa possibilidade fica válida para a sub classe.

### Aula 158 - Upcasting e Downcasting

Esses conceitos basicamente indicam você classificar a instância de uma classe com o tipo de outra classe dessa cadeia de herança. Então, seguindo no exemplo que temos da aula passada, um *upcasting* seria atribuir uma instancia da sub classe `BusinessAccount` a uma variável tipada como uma super classe `Account`.

```java
import entities.Account;
import entities.BusinessAccount;

public class App {
	public static void main(String[] args) throws Exception {

		BusinessAccount businessAccount= new BusinessAccount(8010, "Bob Brown", 100.0, 500.0);

		Account acc1 = businessAccount; // OK
	}
}
```

Nós conseguimos atribuir uma instância de `BusinessAccount` como valor para uma variável do tipo `Account`, e isso acontece pelo fato de que a herança faz com que todas as informações necessárias para o tipo `Account` estejam presentes no tipo `BusinessAccount` o que possibilita essa “substituição”. Mas vale o detalhe, que como a variável é tipada como `Account`, por mais que o valor seja do tipo `BusinessAccount`, não será possível utilizar as informações exclusivas da sub classe.

Já o *downcasting* é o inverso, você tentar utilizar uma instância de uma super classe como valor para uma variável com o tipo de uma sub classe. Essa conversão não é uma conversão natural, afinal, você está usando um valor que tem menos informações que o tipo de variável requisita. Isso torna necessário um casting manual.

```java
import entities.Account;
import entities.BusinessAccount;

public class App {
	public static void main(String[] args) throws Exception {

		BusinessAccount businessAccount = new BusinessAccount(1002, "Maria", 1000.0, 500.0);
		Account account = businessAccount; // UPCASTING

		BusinessAccount businessAccount2 = (BusinessAccount) account; // DOWNCASTING
	}
}
```

Repare que para o `businessAccount2` a gente está tentando atribuir o valor de `account` que nada mais é que o valor de `businessAccount`. Porém, o fato de ela ter passado por esse *upcasting*, na hora de fazer o *downcasting*, se torna necessário a ação manual. E vale destacar que essa ação de casting manual simplesmente faz o compilador ignorar qualquer verificação de tipo, ou seja, caso ela seja feita se forma errada, vai acontecer um erro apenas no momento de execução.

Uma forma de resolver isso é a verificação prévia como o `instanceof`.

```java
import entities.Account;
import entities.BusinessAccount;

public class App {
	public static void main(String[] args) throws Exception {

		BusinessAccount businessAccount = new BusinessAccount(1002, "Maria", 1000.0, 500.0);
		Account account = businessAccount; // UPCASTING

		if (account instanceof BusinessAccount) {
			BusinessAccount businessAccount2 = (BusinessAccount) account; // DOWNCASTING
			businessAccount2.loan(100.0);
		}
	}
}
```

### Aula 159 - Sobreposição, super e Override

A sobreposição é quando você recria um método de uma super classe em uma sub classe. Dessa forma, ao utilizar uma instancia da super classe, o objeto vai ter a função original, mas uma instância da sub classe vai ter esse método com a implementação exclusiva.

Quando você estiver uma situação de sobreposição de um método, uma boa prática é adicionar a anotação `@Override`. Como já comentado, ela avisa o compilador que a função está sendo reescrita em uma sub classe, e o compilador consegue verificar se ela realmente existe e se tem a mesma assinatura na cadeia de herança, dificultando assim que erros de digitação passem despercebidos e que a função tenha alterações muito significativas entre os membros da cadeia.

```java
package entities;

public class SavingsAccount extends Account {
  private Double interestRate;

  public SavingsAccount() {
  }

  public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
    super(number, holder, balance);
    this.interestRate = interestRate;
  }

  public Double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(Double interestRate) {
    this.interestRate = interestRate;
  }

  public void updateBalance() {
    balance += balance * interestRate;
  }

  @Override
  public void withdraw(Double amount) {
    balance -= amount;
  }
}

```

### Aula 160 - Classes e métodos "final"

Quando uma classe é marcada como `final` (palavra chave adicionada logo após ao modificador de acesso), torna a classe em uma do tipo final, e isso significa que ela não poderá ser utilizada como uma super classe em uma cadeira de herança.

Já se essa indicação for aplicado em um método, o efeito vai ser que esse método não poderá mais sofrer uma sobreposição em uma sub classe. Por lógica, fica evidente que não faz sentido ter uma classe final com métodos final, já que ela por si só já não permite sub classes que poderiam sobrepor algum de seus métodos.
