package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        SellerDao sellerDao = DaoFactory.createSellerDao();

        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Departamento");
            System.out.println("2. Vendedor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int mainOption = sc.nextInt();

            if (mainOption == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (mainOption) {
                case 1 -> departmentMenu(sc, departmentDao);
                case 2 -> sellerMenu(sc, sellerDao);
                default -> System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    private static void departmentMenu(Scanner sc, DepartmentDao departmentDao) {
        while (true) {
            System.out.println("\n=== Menu Departamento ===");
            System.out.println("1. Inserir");
            System.out.println("2. Atualizar");
            System.out.println("3. Deletar");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Listar todos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int option = sc.nextInt();

            if (option == 0) break;

            switch (option) {
                case 1 -> {
                    System.out.print("Digite o nome do departamento: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    Department dep = new Department(null, name);
                    departmentDao.insert(dep);
                    System.out.println("Departamento inserido com sucesso!");
                }
                case 2 -> {
                    System.out.print("Digite o ID do departamento para atualizar: ");
                    int id = sc.nextInt();
                    System.out.print("Digite o novo nome: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    Department dep = new Department(id, name);
                    departmentDao.update(dep);
                    System.out.println("Departamento atualizado com sucesso!");
                }
                case 3 -> {
                    System.out.print("Digite o ID do departamento para deletar: ");
                    int id = sc.nextInt();
                    departmentDao.deleteById(id);
                    System.out.println("Departamento deletado com sucesso!");
                }
                case 4 -> {
                    System.out.print("Digite o ID do departamento: ");
                    int id = sc.nextInt();
                    Department dep = departmentDao.findById(id);
                    System.out.println(dep);
                }
                case 5 -> {
                    List<Department> departments = departmentDao.findAll();
                    for (Department dep : departments) {
                        System.out.println(dep);
                    }
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void sellerMenu(Scanner sc, SellerDao sellerDao) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.println("\n=== Menu Vendedor ===");
            System.out.println("1. Inserir");
            System.out.println("2. Atualizar");
            System.out.println("3. Deletar");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Listar todos");
            System.out.println("6. Buscar por Departamento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int option = sc.nextInt();

            if (option == 0) break;

            switch (option) {
                case 1 -> {
                    System.out.print("Digite o nome do vendedor: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Digite o email do vendedor: ");
                    String email = sc.nextLine();
                    System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                    Date birthDate = sdf.parse(sc.nextLine());
                    System.out.print("Digite o salário base: ");
                    double baseSalary = sc.nextDouble();
                    System.out.print("Digite o ID do departamento: ");
                    int departmentId = sc.nextInt();
                    Department department = new Department(departmentId, null);
                    Seller seller = new Seller(null, name, email, birthDate, baseSalary, department);
                    sellerDao.insert(seller);
                    System.out.println("Vendedor inserido com sucesso!");
                }
                case 2 -> {
                    System.out.print("Digite o ID do vendedor para atualizar: ");
                    int id = sc.nextInt();
                    System.out.print("Digite o novo nome: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Digite o novo email: ");
                    String email = sc.nextLine();
                    System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
                    Date birthDate = sdf.parse(sc.nextLine());
                    System.out.print("Digite o novo salário base: ");
                    double baseSalary = sc.nextDouble();
                    System.out.print("Digite o novo ID do departamento: ");
                    int departmentId = sc.nextInt();
                    Department department = new Department(departmentId, null);
                    Seller seller = new Seller(id, name, email, birthDate, baseSalary, department);
                    sellerDao.update(seller);
                    System.out.println("Vendedor atualizado com sucesso!");
                }
                case 3 -> {
                    System.out.print("Digite o ID do vendedor para deletar: ");
                    int id = sc.nextInt();
                    sellerDao.deleteById(id);
                    System.out.println("Vendedor deletado com sucesso!");
                }
                case 4 -> {
                    System.out.print("Digite o ID do vendedor: ");
                    int id = sc.nextInt();
                    Seller seller = sellerDao.findById(id);
                    System.out.println(seller);
                }
                case 5 -> {
                    List<Seller> sellers = sellerDao.findAll();
                    for (Seller seller : sellers) {
                        System.out.println(seller);
                    }
                }
                case 6 -> {
                    System.out.print("Digite o ID do departamento: ");
                    int departmentId = sc.nextInt();
                    Department department = new Department(departmentId, null);
                    List<Seller> sellers = sellerDao.findByDepartment(department);
                    for (Seller seller : sellers) {
                        System.out.println(seller);
                    }
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
