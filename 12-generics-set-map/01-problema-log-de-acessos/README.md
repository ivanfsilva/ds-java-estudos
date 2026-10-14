# Problema "log de acessos"

Um site de internet registra um log de acessos dos usuários. Um registro de log consiste no nome de usuário (
apenas uma palavra) e o instante em que o usuário acessou o site no padrão ISO 8601, separados por espaço, conforme
exemplo. Fazer um programa que leia o log de acessos a partir de um arquivo, e daí informe quantos usuários
distintos acessaram o site.

## Exemplo de entrada e saída

### Arquivo de Entrada (ex: `in.txt`)

```text
amanda 2018-08-26T20:45:08Z
alex86 2018-08-26T21:49:37Z
bobbrown 2018-08-27T03:19:13Z
amanda 2018-08-27T08:11:00Z
jeniffer3 2018-08-27T09:19:24Z
alex86 2018-08-27T22:39:52Z
amanda 2018-08-28T07:42:19Z
```

## 🧠 Conhecimentos e Tecnologias Aplicadas

Neste projeto, foram aplicados conceitos importantes de Estruturas de Dados, manipulação de arquivos e Programação Orientada a Objetos (POO) para resolver o problema de contagem de acessos de forma eficiente:

- **Programação Orientada a Objetos (POO):** Modelagem do domínio utilizando classes, atributos, métodos, construtores e encapsulamento na entidade `LogEntry`.
- **Estruturas de Dados (Coleções - Set):** Utilização da interface `Set` e da implementação `HashSet` para armazenar a coleção de acessos. O uso do `Set` foi fundamental para a regra de negócio, pois ele não admite elementos duplicados e é altamente otimizado para operações de busca e inserção.
- **Igualdade de Objetos (Object Equality):** Sobrescrita dos métodos `hashCode()` e `equals()` na classe `LogEntry`. Isso permitiu ensinar à coleção `HashSet` como identificar se um usuário já estava registrado no conjunto, baseando-se unicamente no atributo `username`.
- **Leitura de Arquivos (File I/O):** Utilização de `BufferedReader` e `FileReader` para ler o arquivo de texto linha por linha de forma eficiente, processando o log de acessos externo.
- **Tratamento de Exceções e Recursos (try-with-resources):** Implementação do bloco `try-with-resources` para garantir que o fluxo de leitura do arquivo (stream) seja encerrado automaticamente, evitando vazamento de memória (memory leaks), além do tratamento de possíveis erros de leitura com `IOException`.
- **Data e Hora (API Java 8+):** Manipulação de tempo utilizando a classe `java.time.Instant` para capturar, interpretar e instanciar os horários de acesso no padrão internacional ISO 8601 (Zulu Time - UTC).
- **Manipulação de Strings:** Utilização da função `split(" ")` para separar o nome de usuário e a data/hora recebidos na mesma linha de texto do arquivo.
- **Arquitetura Básica (Pacotes):** Divisão de responsabilidades do projeto:
    * `entities`: Representação dos dados e regras de domínio (entidade de log).
    * `application`: Ponto de entrada do programa, interação com o usuário e execução do fluxo principal.

---

## 👤 Autor

Desenvolvido por Ivan Ferreira.

Copyright © 2026 Ivan Ferreira. Todos os direitos reservados.

## ☕ Sobre

Exercício prático desenvolvido durante os treinamentos de Java da plataforma ⚡**DevSuperior**, ministrados pelo Prof. Dr.
Nélio Alves.