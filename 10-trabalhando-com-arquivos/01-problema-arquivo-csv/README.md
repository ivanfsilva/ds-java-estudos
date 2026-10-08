# Problema "processamento de arquivo CSV"

Fazer um programa para ler o caminho de um arquivo .csv contendo os dados de itens vendidos. Cada item possui
um nome, preço unitário e quantidade, separados por vírgula. Você deve gerar um novo arquivo chamado"
summary.csv", localizado em uma subpasta chamada "out" a partir da pasta original do arquivo de origem, contendo apenas
o nome e o valor total para aquele item (preço unitário multiplicado pela quantidade), conforme exemplo.

## Exemplo de entrada e saída

### Source file (Arquivo de origem)

| Conteúdo do arquivo       |
|:--------------------------|
| TV LED,1290.99,1          |
| Video Game Chair,350.50,3 |
| Iphone X,900.00,2         |
| Samsung Galaxy 9,850.00,2 |

### Output file (Arquivo gerado em out/summary.csv)

| Conteúdo do arquivo      |
|:-------------------------|
| TV LED,1290.99           |
| Video Game Chair,1051.50 |
| Iphone X,1800.00         |
| Samsung Galaxy 9,1700.00 |

---

### Como testar:

1. Na mesma pasta onde você vai executar o seu projeto, crie um arquivo chamado source.csv.

2. Cole os dados de exemplo exatamente como listado no exemplo:

```
TV LED,1290.99,1
Video Game Chair,350.50,3
Iphone X,900.00,2
Samsung Galaxy 9,850.00,2
```

3. Execute o seu programa. Quando o console pedir Enter file path:, digite o caminho onde você salvou o seu arquivo. (
   Exemplo se estiver na pasta principal do projeto: source.csv ou caminho completo C:\temp\source.csv).
4. O programa criará a pasta out no mesmo local de origem e dentro dela o arquivo summary.csv contendo o resultado da
   multiplicação.

---

## 👤 Autor

Desenvolvido por Ivan Ferreira.

Copyright © 2026 Ivan Ferreira. Todos os direitos reservados.

## ☕ Sobre

Exercício prático desenvolvido durante os treinamentos de Java da plataforma ⚡**DevSuperior**, ministrados pelo Prof.
Dr.
Nélio Alves.