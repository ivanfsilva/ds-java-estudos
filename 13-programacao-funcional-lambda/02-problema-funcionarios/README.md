# Problema "funcionários"

Fazer um programa para ler os dados (nome, email e salário) de funcionários a partir de um arquivo em formato .csv.

Em seguida mostrar, em ordem alfabética, o email dos funcionários cujo salário seja superior a um dado valor fornecido
pelo usuário.

Mostrar também a soma dos salários dos funcionários cujo nome começa com a letra 'M'.

## Exemplo de entrada e saída

### Arquivo de entrada (`in.txt`)

#### Para facilitar, copie o arquivo `in.txt` para a pasta `c:\temp\in.txt`.

### Entrada

| Entrada                             | Exemplo                                                                                                                                                             |
|:------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Conteúdo do arquivo (`in.txt`):** | `Maria,maria@gmail.com,3200.00`<br>`Alex,alex@gmail.com,1900.00`<br>`Marco,marco@gmail.com,1700.00`<br>`Bob,bob@gmail.com,3500.00`<br>`Anna,anna@gmail.com,2800.00` |
| **Enter full file path:**           | `c:\temp\in.txt`                                                                                                                                                    |
| **Enter salary:**                   | `2000.00`                                                                                                                                                           |

### Saída

| Saída                                                   | Exemplo                                                  |
|:--------------------------------------------------------|:---------------------------------------------------------|
| **Email of people whose salary is more than 2000.00:**  | `anna@gmail.com`<br>`bob@gmail.com`<br>`maria@gmail.com` |
| **Sum of salary of people whose name starts with 'M':** | `4900.00`                                                |                               |

## Utilize a modelagem de classes UML

![Modelagem de Classes - UML](classe-uml-employee.png)

## 🧠 Conhecimentos e Tecnologias Aplicadas

Neste projeto, foram aplicados conceitos avançados de Programação Orientada a Objetos, Leitura de Arquivos e Programação Funcional em Java 17 para processar e analisar dados de funcionários contidos em um arquivo CSV:

- **Programação Funcional e Streams API:** Utilização de pipelines de `Stream` para manipulação declarativa e eficiente de coleções de dados. Foram aplicadas operações como `filter` (para selecionar funcionários por faixa salarial e inicial do nome), `map` (para extrair e-mails e salários), `sorted` (para ordenação alfabética natural) e `reduce` / `Double::sum` (para realizar o somatório de salários).
- **Expressões Lambda e Referências a Métodos (Method References):** Emprego de funções anônimas e syntaxes concisas (`Employee::getEmail`, `Double::sum`) para tornar o código mais expressivo, limpo e legível.
- **Manipulação de Arquivos e I/O de Dados:** Leitura eficiente de arquivo texto (`.csv`) linha a linha utilizando as classes `FileReader` e `BufferedReader`, realizando o parsing das linhas com `split(",")` e conversões de tipos primitivos (`Double.parseDouble`).
- **Tratamento de Exceções e Gestão de Recursos (try-with-resources):** Utilização do bloco `try-with-resources` para a instanciação do `BufferedReader`. Essa boa prática garante que o arquivo seja fechado automaticamente ao final do processamento ou em caso de erro, prevenindo vazamentos de recursos de E/S (*memory/resource leaks*).
- **Orientação a Objetos e Modelo de Domínio:** Criação e encapsulamento da entidade `Employee` com atributos privados, construtores, métodos de acesso (*getters/setters*) e padronização dos métodos `equals()` e `hashCode()`.
- **Internacionalização e Formatação (`Locale`):** Definição explícita de `Locale.US` para padronizar a leitura e exibição de números decimais utilizando o ponto (`.`) como separador.
- **Arquitetura e Organização de Pacotes:** Divisão estruturada de responsabilidades do projeto:
    * `entities`: Pacote contendo as classes de domínio (`Employee`).
    * `application`: Pacote contendo a classe executável (`Program`), responsável pela interação via console e orquestração do fluxo principal.

---

## 👤 Autor

Desenvolvido por Ivan Ferreira.

Copyright © 2026 Ivan Ferreira. Todos os direitos reservados.

## ☕ Sobre

Exercício prático desenvolvido durante os treinamentos de Java da plataforma ⚡**DevSuperior**, ministrados pelo Prof.
Dr. Nélio Alves.