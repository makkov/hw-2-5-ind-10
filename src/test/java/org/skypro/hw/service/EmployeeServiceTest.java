package org.skypro.hw.service;

import org.junit.jupiter.api.Test;
import org.skypro.hw.entity.Employee;
import org.skypro.hw.exception.EmployeeNotFoundException;
import org.skypro.hw.exception.EmployeeStorageIsFullException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.skypro.hw.service.generator.EmployeeGenerator.*;

class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void add_success() {
        //Подготовка входных данных
        String firstName = IVAN_FIRST_NAME;
        String lastName = IVAN_LAST_NAME;
        double salary = IVAN_SALARY;
        int depId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = getIvanFirstDep();

        //Начало теста
        Employee addedEmployee = employeeService.add(firstName, lastName, salary, depId);
        assertEquals(expectedEmployee, addedEmployee);
    }

    @Test
    void add_withEmployeeStorageIsFullException() {
        //Подготовка входных данных
        String firstName = PETR_FIRST_NAME;
        String lastName = PETR_LAST_NAME;
        double salary = PETR_SALARY;
        int depId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        employeeService.add(IVAN_FIRST_NAME, IVAN_LAST_NAME, IVAN_SALARY, depId);
        String expectedMessage = "400 Массив сотрудников переполнен";

        //Начало теста
        Exception exception = assertThrows(
                EmployeeStorageIsFullException.class,
                () -> employeeService.add(firstName, lastName, salary, depId)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void find_success() {
        //Подготовка входных данных
        String firstName = IVAN_FIRST_NAME;
        String lastName = IVAN_LAST_NAME;
        double salary = IVAN_SALARY;
        int depId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        employeeService.add(IVAN_FIRST_NAME, IVAN_LAST_NAME, IVAN_SALARY, depId);
        Employee expectedEmployee = getIvanFirstDep();

        //Начало теста
        Employee actualEmployee = employeeService.find(firstName, lastName, salary, depId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void find_withEmployeeNotFoundException() {
        //Подготовка входных данных
        String firstName = IVAN_FIRST_NAME;
        String lastName = IVAN_LAST_NAME;
        double salary = IVAN_SALARY;
        int depId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        String expectedMessage = "404 Такого сотрудника нет";

        //Начало теста
        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.find(firstName, lastName, salary, depId)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата

        //Начало теста
    }
}