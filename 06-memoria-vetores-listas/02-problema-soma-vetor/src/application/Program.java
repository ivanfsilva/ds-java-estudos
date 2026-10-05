package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar? ");
        int quantidadeNumeros = sc.nextInt();

        double[] vetor = new double[quantidadeNumeros];
        double soma = 0;
        double media =0;

        for (int i = 0; i<quantidadeNumeros;i++){
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextDouble();
            soma += vetor[i];
        }

        media = soma / quantidadeNumeros;

        System.out.println(); // Quebra de linha necessária
        System.out.print("VALORES = ");

//        for (int i = 0; i < quantidadeNumeros; i++) {
//            System.out.printf("%.1f ", vetor[i]);
//        }

        // for refatorado
        for(double numero : vetor){
            System.out.printf("%.1f ", numero);
        }

        System.out.println(); // Quebra de linha necessária
        // Imprime Soma e Média formatadas com 2 casas decimais
        System.out.printf("SOMA = %.2f%n", soma);
        System.out.printf("MEDIA = %.2f%n", media);

        sc.close();

    }
}


