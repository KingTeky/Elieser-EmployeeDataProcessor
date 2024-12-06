package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Management System");

        // Sample dataset
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 35, "HR", 60000));
        employees.add(new Employee("Bob", 28, "IT", 75000));
        employees.add(new Employee("Charlie", 40, "Finance", 80000));
        employees.add(new Employee("David", 32, "IT", 70000));
        employees.add(new Employee("Eve", 45, "HR", 65000));

        // Function to concatenate name and department
        Function<Employee, String> nameAndDept = emp -> emp.getName() + " - " + emp.getDepartment();

        // Generate new collection with concatenated strings
        List<String> nameAndDeptList = employees.stream()
                .map(nameAndDept)
                .collect(Collectors.toList());

        // Calculate average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        // Filter employees by age
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .collect(Collectors.toList());

        // Display results
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Name and Department: " + nameAndDeptList));
        vbox.getChildren().add(new Label("Average Salary: " + averageSalary));
        vbox.getChildren().add(new Label("Filtered Employees: " + filteredEmployees.size()));

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
