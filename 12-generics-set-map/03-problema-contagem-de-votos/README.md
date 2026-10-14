# Problema "contagem de votos"

Na contagem de votos de uma eleição, são gerados vários registros de votação contendo o nome do candidato e a quantidade
de votos (formato .csv) que ele obteve em uma urna de votação. Você deve fazer um programa para ler os
registros de votação a partir de um arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.

## Exemplo de entrada e saída

### Exemplo de arquivo de entrada (in.txt)
#### Para facilitar, copie o arquivo `in.txt` para a pasta `c:\temp\in.txt`.

```text
Alex Blue,15
Maria Green,22
Bob Brown,21
Alex Blue,30
Bob Brown,15
Maria Green,27
Maria Green,22
Bob Brown,25
Alex Blue,31
```

## 🧠 Conhecimentos e Tecnologias Aplicadas

Neste projeto, foram aplicados conceitos importantes de Manipulação de Arquivos (I/O), Estruturas de Dados e fundamentos da linguagem Java para resolver o problema de consolidação de votos de forma eficiente:

- **Estruturas de Dados (Coleções - Map):** Utilização da interface `Map` e da implementação `LinkedHashMap` para armazenar a coleção de candidatos e seus totais de votos. O uso do mapa foi a peça-chave para a regra de negócio, pois ele permite agrupar chaves únicas (nomes dos candidatos). Ao invés de criar lógicas complexas de busca em listas tradicionais, a estrutura verifica automaticamente se a chave já existe (`containsKey`) e soma os valores. A escolha do `LinkedHashMap` garante que a ordem original de inserção seja preservada.
- **Leitura de Arquivos de Texto (I/O):** Utilização combinada das classes `BufferedReader` e `FileReader` para ler os registros do arquivo externo de forma sequencial e otimizada na memória.
- **Manipulação de Strings e Parse:** Utilização do método `split(",")` para fatiar cada linha de texto extraída do arquivo em duas partes (nome e quantidade), e o uso do `Integer.parseInt()` para converter o texto de votos em um número numérico manipulável para a soma.
- **Estruturas de Controle e Repetição:** Utilização do laço `while` para ler continuamente as linhas do arquivo até que o resultado seja vazio (`null`), garantindo a leitura total dos dados. E laço `for-each` percorrendo o `keySet()` para apresentar o relatório final consolidado de cada candidato.
- **Tratamento de Recursos (try-with-resources):** Implementação do bloco `try-with-resources` na instanciação do `BufferedReader`. Essa prática moderna (introduzida no Java 7+) garante que a conexão e o fluxo de leitura do arquivo com o sistema operacional sejam encerrados automaticamente ao final da execução ou no caso de um erro, evitando bloqueios do arquivo e vazamentos de recursos (resource leaks).
- **Arquitetura Básica (Pacotes):** Organização simples e direta do projeto:
    * `application`: Pacote estrutural contendo a classe `Program`, que atua como ponto de entrada da aplicação (`main`), responsável por solicitar o caminho do arquivo, orquestrar a leitura e executar o fluxo principal.
---

## 👤 Autor

Desenvolvido por Ivan Ferreira.

Copyright © 2026 Ivan Ferreira. Todos os direitos reservados.

## ☕ Sobre

Exercício prático desenvolvido durante os treinamentos de Java da plataforma ⚡**DevSuperior**, ministrados pelo Prof.
Dr.
Nélio Alves.