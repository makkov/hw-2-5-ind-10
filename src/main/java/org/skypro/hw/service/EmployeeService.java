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


    public Employee add(String firstName, String lastName) {
        return null;
    }

    public Employee find(String firstName, String lastName) {
        return null;
    }

    public Employee remove(String firstName, String lastName) {
        return null;
    }

    public List<Employee> getAll() {
        return null;
    }
}
