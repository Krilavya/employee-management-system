package employee_mgt.controller;
import employee_mgt.entity.Employee;
import employee_mgt.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List< Employee > getEmployees(){
        return employeeService.getEmployees();
    }
    @PostMapping("/employees")
    public Employee createEmployee( @Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("/employees/{id}")
    public  Employee updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee){
        employee.setId(id);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "Employee Deleted";
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);

    }
    @GetMapping("/employee/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email){
        return employeeService.getEmployeeByEmail(email);
    }
    @GetMapping("/employees/sort/{field}")
    public List< Employee > getEmployeesSorted(@PathVariable String field){
        return employeeService.getEmployeesSorted(field);
    }
    @GetMapping("/employee/page")
    public Page<Employee> getEmployeePaginated(
            @RequestParam int page,
            @RequestParam int size){
        return employeeService.getEmployeePaginated (page,size);
    }
    @GetMapping("/employee/search")
    public List<Employee>searchEmployees(
            @RequestParam String name){
        return employeeService.searchEmployees(name);
    }
    @GetMapping("/employee/search/{name}")
    public List<Employee> searchByName(
            @PathVariable String name){
        return employeeService.searchByName(name);
    }
    @GetMapping("/employees/page")
    public Page<Employee>getEmployeesPage(
            @RequestParam int page,
            @RequestParam int size){

        return employeeService.getEmployeesPage(page,size);
    }



}
