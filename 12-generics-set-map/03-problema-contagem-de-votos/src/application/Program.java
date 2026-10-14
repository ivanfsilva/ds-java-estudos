package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Utilizamos LinkedHashMap para manter a ordem de inserção original dos candidatos
        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String candidateName = fields[0];
                int voteCount = Integer.parseInt(fields[1]);

                // Se o candidato já existe, soma os votos. Se não, insere o primeiro registro.
                if (votes.containsKey(candidateName)) {
                    int currentVotes = votes.get(candidateName);
                    votes.put(candidateName, currentVotes + voteCount);
                } else {
                    votes.put(candidateName, voteCount);
                }

                line = br.readLine();
            }

            // Exibe o relatório consolidado
            System.out.println();
            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}