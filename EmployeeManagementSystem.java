import java.util.*;

public class EmployeeManagementSystem {

    // Employee class
    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        void display() {
            System.out.println(id + "\t" + name + "\t" + department + "\t" + salary);
        }
    }

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, dept, salary));
        System.out.println("Employee added successfully!");
    }

    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\nID\tName\tDepartment\tSalary");
        for (Employee e : employees) {
            e.display();
        }
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Employee Found:");
                System.out.println("ID\tName\tDepartment\tSalary");
                e.display();
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                sc.nextLine();
                System.out.print("New Name: ");
                e.name = sc.nextLine();

                System.out.print("New Department: ");
                e.department = sc.nextLine();

                System.out.print("New Salary: ");
                e.salary = sc.nextDouble();

                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}
