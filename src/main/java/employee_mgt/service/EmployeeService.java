package employee_mgt.service;
import employee_mgt.Exception.EmployeeNotFoundException;
import employee_mgt.entity.Employee;
import employee_mgt.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
//public class EmployeeService {
// public List<Employee> getEmployees(){
//     Employee emp1 =new Employee(
//             1l,
//             "krishna",
//             "krishna@gmail.com"
//     );
//     return List.of(emp1);
// }

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Get All Employees
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By Id
//    public Employee getEmployeeById(Long Id) {
//        return employeeRepository.findById(Id).orElse(null);
//    }

    // Create Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> getEmployeesSorted(String field) {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID" + id + "not found"));
    }
    public Page<Employee> getEmployeePaginated(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return employeeRepository.findAll(pageable);
    }
    public List<Employee>searchEmployees(String name){
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Employee>searchByName(String name){
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    public Page<Employee>getEmployeesPage(int page,int size){
        return employeeRepository.findAll(PageRequest.of(page,size));
    }
    public Page<Employee>getEmployeespageSorted(
            int page,
            int size,
            String field){
        return employeeRepository.findAll(
                PageRequest.of(
                        page,size,Sort.by(field)
                ));
    }
}