# Problema "portal de cursos"

Em um portal de cursos online, cada usuário possui um código único, representado por um número inteiro.

Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se matricular em quantos cursos quiser.
Assim, o número total de alunos de um instrutor não é simplesmente a soma dos alunos de todos os cursos que ele possui,
pois pode haver alunos repetidos em mais de um curso.

O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.

Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a quantidade total e alunos dele,
conforme exemplo.

## Exemplo de entrada e saída

### Exemplo de Console

```text
How many students for course A? 3
21
35
22
How many students for course B? 2
21
50
How many students for course C? 3
42
35
13
Total students: 6
```

## 🧠 Conhecimentos e Tecnologias Aplicadas

Neste projeto, foram aplicados conceitos importantes de Estruturas de Dados e fundamentos da linguagem Java para
resolver o problema de contagem de alunos únicos de forma eficiente:

- **Estruturas de Dados (Coleções - Set):** Utilização da interface `Set` e da implementação `HashSet` para armazenar a
  coleção de códigos dos alunos. O uso do `Set` foi a peça-chave para a regra de negócio, pois ele recusa
  automaticamente elementos duplicados. Isso resolveu a contagem de alunos matriculados em múltiplos cursos de forma
  nativa, sem a necessidade de criar lógicas complexas de verificação (`if/else`).
- **Classes Wrapper e Igualdade:** Utilização da classe wrapper `Integer` no conjunto (`Set<Integer>`). Como a
  classe `Integer` nativa do Java já possui os métodos `hashCode()` e `equals()` implementados, a coleção `HashSet`
  consegue identificar corretamente as duplicatas de códigos de forma automática e otimizada (Tempo O(1)).
- **Entrada de Dados iterativa (Console):** Utilização da classe `Scanner` para realizar a leitura sequencial de dados (
  códigos inteiros) diretamente do terminal do usuário.
- **Estruturas de Controle e Repetição:** Utilização de laços `for` para iterar sobre a exata quantidade de alunos
  informada para cada curso (A, B e C), lendo e inserindo cada matrícula individualmente.
- **Tratamento de Recursos (try-with-resources):** Implementação do bloco `try-with-resources` na instanciação
  do `Scanner`. Essa prática moderna (introduzida no Java 7+) garante que o fluxo de leitura do teclado seja encerrado
  automaticamente ao final da execução, evitando o bloqueio do recurso e vazamento de memória (memory leaks).
- **Arquitetura Básica (Pacotes):** Organização simples e direta do projeto:
    * `application`: Pacote estrutural contendo a classe `Program`, que atua como ponto de entrada da
      aplicação (`main`), responsável pela interação com o usuário e execução do fluxo principal.

---

## 👤 Autor

Desenvolvido por Ivan Ferreira.

Copyright © 2026 Ivan Ferreira. Todos os direitos reservados.

## ☕ Sobre

Exercício prático desenvolvido durante os treinamentos de Java da plataforma ⚡**DevSuperior**, ministrados pelo Prof.
Dr.
Nélio Alves.