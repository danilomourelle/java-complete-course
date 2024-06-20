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