package employee_mgt.Exception;
import employee_mgt.Exception.EmployeeNotFoundException;

public class EmployeeNotFoundException  extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);

    }
}
