package BZU.WebServices.Assiment2.DTO;
import BZU.WebServices.Assiment2.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    @NotEmpty
    @Size(min = 3 , message = "Customer First Name Must Have At Lest 3 Character")
    private String firstName;
    @NotEmpty
    @Size(min = 3 , message = "Customer Last Name Must Have At Lest 3 Character") // The annotated element size must be between the specified boundaries
    private String lastName;
    private LocalDate dob;
    private Set<Order> orders = new HashSet<>() ;
    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", orders=" + orders +
                '}';
    }
}
