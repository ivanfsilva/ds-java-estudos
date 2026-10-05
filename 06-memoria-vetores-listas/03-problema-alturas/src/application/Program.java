package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Pessoa;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();

        // Vetor de objetos do tipo Pessoa
        Pessoa[] vetor = new Pessoa[n];

        // Leitura e instanciação das pessoas
        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            // Guardando o objeto no vetor
            vetor[i] = new Pessoa(nome, idade, altura);
        }

        // Cálculo da altura média usando for-each
        double somaAlturas = 0.0;
        for (Pessoa p : vetor) {
            somaAlturas += p.getAltura();
        }
        double alturaMedia = somaAlturas / n;

        // Contagem de pessoas com menos de 16 anos usando for-each
        int menores16 = 0;
        for (Pessoa p : vetor) {
            if (p.getIdade() < 16) {
                menores16++;
            }
        }
        double porcentagemMenores = ((double) menores16 / n) * 100.0;

        // Exibição dos resultados
        System.out.println();
        System.out.printf("Altura média: %.2f%n", alturaMedia);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", porcentagemMenores);

        // Nomes das pessoas com menos de 16 anos usando for-each
        for (Pessoa p : vetor) {
            if (p.getIdade() < 16) {
                System.out.println(p.getNome());
            }
        }

        sc.close();
    }
}