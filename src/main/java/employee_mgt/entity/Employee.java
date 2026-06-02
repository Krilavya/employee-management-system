package employee_mgt.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Long id;
    @NotBlank(message = "Name is Required")
    private String name;
    @NotBlank(message = "Email is Required")
    @Email(message = "Enter Vaild Email")
    private String email;
}
//    public Employee() {
//    }
//    public Employee(Long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}


