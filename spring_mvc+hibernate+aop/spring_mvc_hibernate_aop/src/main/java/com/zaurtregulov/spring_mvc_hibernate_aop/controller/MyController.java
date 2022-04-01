package com.zaurtregulov.spring_mvc_hibernate_aop.controller;

import com.zaurtregulov.spring_mvc_hibernate_aop.dao.EmployeeDAO;
import com.zaurtregulov.spring_mvc_hibernate_aop.dao.EmployeeDAOImpl;
import com.zaurtregulov.spring_mvc_hibernate_aop.entity.Employee;
import com.zaurtregulov.spring_mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> employeeList = employeeService.getAllEmployees();

        model.addAttribute("allEmpls", employeeList);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployees(Model model){

        Employee emp = new Employee();
        model.addAttribute("employee", emp);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployees(@ModelAttribute("employee") Employee emp){
        employeeService.saveEmployee(emp);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(@RequestParam("empId") int empId, Model model){

        Employee emp = employeeService.getEmployee(empId);
        model.addAttribute("employee", emp);

        return "employee-info";
    }

    @RequestMapping("/deleteInfo")
    public String deleteInfo(@RequestParam("empId") int empId, Model model){

        employeeService.deleteEmployee(empId);
        return "redirect:/";
    }

}
