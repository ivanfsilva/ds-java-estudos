package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {
    public static void main(String[] args) {
        // Garantir que os decimais serão tratados com ponto (ex: 1290.99)
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        // Tratar caso o usuário passe apenas o nome do arquivo sem o caminho completo
        if (sourceFolderStr == null) {
            sourceFolderStr = ".";
        }

        // Criar a subpasta "out"
        File targetFolder = new File(sourceFolderStr + File.separator + "out");
        targetFolder.mkdir();

        // Caminho do arquivo summary.csv
        String targetFileStr = targetFolder.getPath() + File.separator + "summary.csv";

        // Try-with-resources para leitura do arquivo origem
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            List<Product> list = new ArrayList<>();
            String itemCsv = br.readLine(); // Lê a primeira linha

            while (itemCsv != null) {
                // Separa a linha lida onde encontrar vírgula
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                // Instancia o produto e adiciona na lista
                list.add(new Product(name, price, quantity));

                // Lê a próxima linha
                itemCsv = br.readLine();
            }

            // Try-with-resources para escrita no arquivo de destino
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Product item : list) {
                    // Grava o nome e o total (formatado com duas casas decimais com ponto)
                    bw.write(item.getName() + "," + String.format("%.2f", item.getTotal()));
                    bw.newLine(); // Pula para a próxima linha
                }

                System.out.println("SUCCESS! File created at: " + targetFileStr);

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}