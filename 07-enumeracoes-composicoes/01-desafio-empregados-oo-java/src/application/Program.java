package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String deptName = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        sc.nextLine(); // Limpeza do buffer
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String phone = sc.nextLine();

        // Instancia o endereço e o departamento
        Address address = new Address(email, phone);
        Department dept = new Department(deptName, payDay, address);

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do funcionário " + i + ":");
            sc.nextLine(); // Limpeza do buffer
            System.out.print("Nome: ");
            String empName = sc.nextLine();
            System.out.print("Salário: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(empName, salary);
            dept.addEmployee(emp);
        }

        System.out.println();
        showReport(dept);

        sc.close();
    }

    private static void showReport(Department dept) {
        System.out.println("FOLHA DE PAGAMENTO:");
        System.out.printf("Departamento %s = R$ %.2f%n", dept.getName(), dept.payroll());
        System.out.println("Pagamento realizado no dia " + dept.getPayDay());
        System.out.println("Funcionários:");
        for (Employee emp : dept.getEmployees()) {
            System.out.println(emp.getName());
        }
        System.out.printf("Para dúvidas favor entrar em contato: %s%n", dept.getAddress().getEmail());
    }
}