package example.codeclan.com.employee_starter;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;

import db.SqlRunner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;

    public Employee(String name, Department department, double salary) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    public Employee(int id, String name, Department department, double salary) {
        this(name, department, salary);
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void save() {
        int department_id = department.getId();
        String sql = String.format(
                "INSERT INTO employees (name, salary, department_id) VALUES ('%s', %7.2f, %d); "
                , this.name, this.salary, department_id);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM employees;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                Double salary = rs.getDouble("salary");
                int depId = rs.getInt("department_id");
                System.out.println(name);
                System.out.println(salary);
                System.out.println(depId);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }


    public static void deleteAll(){
        String sql = "DELETE FROM employees;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();

    }

    public void update() {
        String sql = String.format("UPDATE employees SET name = '%s' , SET salary = %7.2f, SET department_id = %d " +
                        "WHERE id = %d;",
                this.name, this.salary, this.department.getId(), this.id
        );
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static Employee getEmployeeByName(String searchName) {
        Employee employee = null;
        String sql = String.format
                ("SELECT employees.id, employees.name, employees.salary, employees.department_id, departments.title as department_title FROM employees INNER JOIN departments ON employees.department_id = departments.id WHERE employees.name = '%s';", searchName);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            if (rs.next()) {
                int department_id = rs.getInt("department_id");
                String department_title = rs.getString("department_title");

                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int employee_id = rs.getInt("id");

                Department dep = new Department(department_id, department_title);
                employee = new Employee(employee_id, name, dep, salary);
                return employee;
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
            return employee;

        }
    }
}
