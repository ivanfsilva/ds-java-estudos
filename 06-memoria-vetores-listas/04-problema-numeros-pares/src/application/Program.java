package application;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();

        int[] vet = new int[n];

        // Leitura dos N números inteiros
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            vet[i] = sc.nextInt();
        }

        // Impressão dos números pares na mesma linha
        System.out.println("\nNUMEROS PARES:");
        int quantidadePares = 0;

        for (int numero : vet) {
            if (numero % 2 == 0) {
                System.out.print(numero + " ");
                quantidadePares++;
            }
        }

        // Exibição da quantidade total de números pares
        System.out.println();
        System.out.println("\nQUANTIDADE DE PARES = " + quantidadePares);

        sc.close();
    }
}
