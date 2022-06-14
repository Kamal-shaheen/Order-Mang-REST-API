package BZU.WebServices.Assiment2.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity //  specifies that the class is an entity a
@Table(name = "customers") // specifies the name of the database table
@AllArgsConstructor //  generates a constructor
@NoArgsConstructor // generate a constructor with no parameters
public class Customer {
    @Id // the pk of entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "This Id of Customer , and it's auto-Increment", required = false)
    private Long id;
    @ApiModelProperty(value = "This First Name of Customer ", required = true)
    @Column(name = "firstName")
    private String firstName;

    @ApiModelProperty(value = "This Last Name of Customer ", required = true)
    @Column(name = "lastName")
    private String lastName;

    @ApiModelProperty(value = "This the Date ", required = true)
    @Column(name = "dob")
    private LocalDate dob;
    // TODO Change Date To LOCALDATE

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", orders=" + orders +
                '}';
    }
}
