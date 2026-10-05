package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Champion;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Leitura do Primeiro Campeão
        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String name1 = sc.next();
        System.out.print("Vida inicial: ");
        int life1 = sc.nextInt();
        System.out.print("Ataque: ");
        int attack1 = sc.nextInt();
        System.out.print("Armadura: ");
        int armor1 = sc.nextInt();

        Champion c1 = new Champion(name1, life1, attack1, armor1);

        // Leitura do Segundo Campeão
        System.out.println();
        System.out.println("Digite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String name2 = sc.next();
        System.out.print("Vida inicial: ");
        int life2 = sc.nextInt();
        System.out.print("Ataque: ");
        int attack2 = sc.nextInt();
        System.out.print("Armadura: ");
        int armor2 = sc.nextInt();

        Champion c2 = new Champion(name2, life2, attack2, armor2);

        // Leitura da quantidade de turnos
        System.out.println();
        System.out.print("Quantos turnos você deseja executar? ");
        int turnos = sc.nextInt();

        // Execução do combate por turnos
        for (int i = 1; i <= turnos; i++) {
            c1.takeDamage(c2);
            c2.takeDamage(c1);

            System.out.println();
            System.out.println("Resultado do turno " + i + ":");
            System.out.println(c1.status());
            System.out.println(c2.status());

            // Se algum dos dois morrer, interrompe o combate imediatamente
            if (c1.getLife() == 0 || c2.getLife() == 0) {
                break;
            }
        }

        System.out.println();
        System.out.println("FIM DO COMBATE");

        sc.close();
    }
}
