# Desafio "Contribuintes OO e Lista"

Para calcular o imposto de renda que uma pessoa deve pagar, um país aplica as seguintes regras:

1. **Imposto sobre salário:** a pessoa paga imposto sobre seu salário conforme a tabela abaixo:

| Salário Mensal                   | Imposto |
|:---------------------------------|:--------|
| Abaixo de 3000.00                | Isento  |
| De 3000.00 até 5000.00 exclusive | 10%     |
| 5000.00 ou acima                 | 20%     |

2. **Renda com prestação de serviços:** o imposto cobrado é de 15%.
3. **Ganho de capital** (imóveis, ações, etc.): o imposto cobrado é de 20%.
4. **Abatimento:** a pessoa pode abater até 30% do seu imposto bruto devido com gastos médicos ou educacionais. Porém,
   se seus gastos médicos e educacionais forem abaixo desses 30%, apenas os gastos efetivos podem ser abatidos.

Você deve fazer um programa para ler os dados de **N** contribuintes, armazenando os dados desses contribuintes em uma
lista do tipo `List<TaxPayer>`. Depois, você deve mostrar, para cada contribuinte, um resumo do imposto conforme o
exemplo.

---

## Diagrama UML da Classe `TaxPayer`

| TaxPayer                                                                                                                                                          |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| - salaryIncome : double <br> - servicesIncome : double <br> - capitalIncome : double <br> - healthSpending : double <br> - educationSpending : double             |
| + salaryTax() : double <br> + servicesTax() : double <br> + capitalTax() : double <br> + grossTax() : double <br> + taxRebate() : double <br> + netTax() : double |

---

## Exemplo de entrada e saída

### Entrada

| Entrada                                     | Exemplo (N = 2) |
|:--------------------------------------------|:----------------|
| **Quantos contribuintes você vai digitar?** | 2               |
| **Digite os dados do 1o contribuinte:**     |                 |
| **Renda anual com salário:**                | 48000.00        |
| **Renda anual com prestação de serviço:**   | 0.00            |
| **Renda anual com ganho de capital:**       | 800.00          |
| **Gastos médicos:**                         | 400.00          |
| **Gastos educacionais:**                    | 5400.00         |
| **Digite os dados do 2o contribuinte:**     |                 |
| **Renda anual com salário:**                | 189000.00       |
| **Renda anual com prestação de serviço:**   | 55184.93        |
| **Renda anual com ganho de capital:**       | 20000.00        |
| **Gastos médicos:**                         | 600.00          |
| **Gastos educacionais:**                    | 7500.00         |

### Saída

| Saída                          | Exemplo  |
|:-------------------------------|:---------|
| **Resumo do 1o contribuinte:** |          |
| **Imposto bruto total:**       | 4960.00  |
| **Abatimento:**                | 1488.00  |
| **Imposto devido:**            | 3472.00  |
| **Resumo do 2o contribuinte:** |          |
| **Imposto bruto total:**       | 50077.74 |
| **Abatimento:**                | 8100.00  |
| **Imposto devido:**            | 41977.74 |

---

## Critérios de Avaliação

1. Nomes de classes, atributos, métodos e argumentos respeitando o projeto UML, bem como as convenções de nome para
   Java (classe com primeira letra maiúscula, e padrão *camelCase* para atributos, variáveis e métodos).
2. Atributos corretos e devidamente encapsulados com métodos `get`/`set`.
3. Todos os métodos calculando os valores corretamente.
4. Comportamento do programa correto conforme exemplo.