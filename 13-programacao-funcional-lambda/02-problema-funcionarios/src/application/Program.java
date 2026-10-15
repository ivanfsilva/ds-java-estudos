package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        System.out.print("Enter salary: ");
        double targetSalary = sc.nextDouble();

        List<Employee> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    String name = fields[0].trim();
                    String email = fields[1].trim();
                    double salary = Double.parseDouble(fields[2].trim());
                    list.add(new Employee(name, email, salary));
                }
                line = br.readLine();
            }

            // Filtrar e ordenar e-mails de funcionários com salário superior ao informado
            List<String> emails = list.stream()
                    .filter(emp -> emp.getSalary() > targetSalary)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList();

            System.out.println("Email of people whose salary is more than " + String.format("%.2f", targetSalary) + ":");
            emails.forEach(System.out::println);

            // Somar o salário dos funcionários cujo nome começa com a letra 'M'
            double sumM = list.stream()
                    .filter(emp -> emp.getName().startsWith("M"))
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumM));

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}