package application;

import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre o caminho do arquivo: ");
        String path = sc.nextLine();

        List<Sale> sales = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                Integer month = Integer.parseInt(fields[0]);
                Integer year = Integer.parseInt(fields[1]);
                String seller = fields[2];
                Integer items = Integer.parseInt(fields[3]);
                Double total = Double.parseDouble(fields[4]);

                sales.add(new Sale(month, year, seller, items, total));
                line = br.readLine();
            }

            // 1. Varrer a lista gerando os nomes únicos de cada vendedor utilizando Set
            Set<String> sellers = sales.stream()
                    .map(Sale::getSeller)
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            System.out.println("\nTotal de vendas por vendedor:");

            // 2. Para cada vendedor único, filtrar na lista original e somar os totais via Stream
            for (String seller : sellers) {
                double totalSold = sales.stream()
                        .filter(s -> s.getSeller().equals(seller))
                        .mapToDouble(Sale::getTotal)
                        .sum();

                System.out.printf("%s - R$ %.2f%n", seller, totalSold);
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}