package BZU.WebServices.Assiment2.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ApiModelProperty(value = "Id Of Order " , required = false)
    private Long id;

    @Column
    @ApiModelProperty(value = "Local Date Time For Order" , required = true)
    private LocalDateTime dateTime;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Set<ProductOrder> productOrders =  new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_Id" , nullable = false)
    private Customer customer;
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", customer=" + customer +
                '}';
    }
}
