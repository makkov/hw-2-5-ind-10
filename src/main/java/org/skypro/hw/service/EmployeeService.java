package org.skypro.hw.service;

import org.skypro.hw.entity.Employee;
import org.skypro.hw.exception.EmployeeAlreadyAddedException;
import org.skypro.hw.exception.EmployeeNotFoundException;
import org.skypro.hw.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee("Иван", "Иванов", 1000.0, 1));
        employees.add(new Employee("Иван1", "Иванов1", 999.9, 1));
        employees.add(new Employee("Иван2", "Иванов2", 8.50, 1));

        employees.add(new Employee("Пётр", "Петров", 8.50, 2));

        employees.add(new Employee("Илья", "Ильин", 777.50, 3));
        employees.add(new Employee("Илья1", "Ильин1", 88.8, 3));
    }

    private final static int MAX_SIZE = 2;

    public Employee add(String firstName, String lastName, double salary, int departmentId) {

        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        Employee newEmployee = new Employee(firstName, lastName, salary, departmentId);

        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }

        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee find(String firstName, String lastName, double salary, int departmentId) {
        Employee employeeForFound = new Employee(firstName, lastName, salary, departmentId);
        for (Employee e : employees) {
            if (e.equals(employeeForFound)) {
                return e;
            }
        }

        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }

    public Employee remove(String firstName, String lastName, double salary, int departmentId) {
        Employee employeeForRemove = new Employee(firstName, lastName, salary, departmentId);

        boolean removeResult = employees.remove(employeeForRemove);
        if (removeResult) {
            return employeeForRemove;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не удален - не был найден в базе");
        }
    }

    public List<Employee> getAll() {
        return employees;
    }
}
