package com.zaurtregulov.spring_mvc_hibernate_aop.dao;

import com.zaurtregulov.spring_mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee emp);
    Employee getEmployee(int id);
    public void deleteEmployee(int id);
}
