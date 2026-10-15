package application;

import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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

            System.out.println("\nCinco primeiras vendas de 2016 de maior preço médio");

            List<Sale> topSales = sales.stream()
                    .filter(s -> s.getYear().equals(2016))
                    .sorted(Comparator.comparing(Sale::averagePrice).reversed())
                    .limit(5)
                    .toList();

            topSales.forEach(System.out::println);

            double totalLogan = sales.stream()
                    .filter(s -> s.getSeller().equals("Logan"))
                    .filter(s -> s.getMonth().equals(1) || s.getMonth().equals(7))
                    .mapToDouble(Sale::getTotal)
                    .sum();

            System.out.println("\nValor total vendido pelo vendedor Logan nos meses 1 e 7 = "
                    + String.format(Locale.US, "%.2f", totalLogan));

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}