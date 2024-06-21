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