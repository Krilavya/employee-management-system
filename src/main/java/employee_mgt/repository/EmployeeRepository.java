package employee_mgt.repository;

import employee_mgt.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);

    List<Employee> findByNameContainingIgnoreCase(String name);

}