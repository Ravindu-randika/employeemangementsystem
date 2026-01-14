import java.util.*;

// Main Class (Only ONE public class)
public class EmployeeManagementSystem {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.addEmployee();
                case 2 -> service.viewEmployees();
                case 3 -> service.searchEmployee();
                case 4 -> service.updateEmployee();
                case 5 -> service.deleteEmployee();
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

// Employee Class
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.println(id + "\t" + name + "\t" + department + "\t" + salary);
    }
}

// Employee Service Class
class EmployeeService {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("ID\tName\tDepartment\tSalary");
        for (Employee e : employees) {
            e.display();
        }
    }

    public void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println("Employee Found:");
                System.out.println("ID\tName\tDepartment\tSalary");
                e.display();
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.getId() == id) {
                sc.nextLine();
                System.out.print("New Name: ");
                e.setName(sc.nextLine());

                System.out.print("New Department: ");
                e.setDepartment(sc.nextLine());

                System.out.print("New Salary: ");
                e.setSalary(sc.nextDouble());

                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}
