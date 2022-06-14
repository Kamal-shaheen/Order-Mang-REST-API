package BZU.WebServices.Assiment2.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;
@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "This ID Of User " , required = false)
    private long id ;
    @ApiModelProperty(value = "This Name Of User " , required = false)
    private String name;
    @ApiModelProperty(value = "This UserName Of User " , required = false)
    private String username;
    @Email
    @ApiModelProperty(value = "Email Of User " , required = false)
    private String email;
    @ApiModelProperty(value = "Password UserName Of User " , required = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role>roles;

}
