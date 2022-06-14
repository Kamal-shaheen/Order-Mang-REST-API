package BZU.WebServices.Assiment2.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "This Id of Products" , required = false)
    private Long id;
    @ApiModelProperty(value = "This Name of Products" , required = true)
    @Column(name = "name")
    private String name;
    @ApiModelProperty(value = "This Reference of Products" , required = true)
    @Column(name = "reference")
    private String reference;
    @ApiModelProperty(value = "This Price of Products" , required = true)
    @Column(name = "price")
    private Double price;
    @ApiModelProperty(value = "This Vat of Products" , required = true)
    @Column(name = "vat")
    private Double  vat ;
    @ApiModelProperty(value = "This Stockable of Products" , required = true)
    @Column(name = "stockable")
    private boolean stockable;
    @OneToMany (mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Stock> stock = new HashSet<>();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                ", stockable=" + stockable +
                ", stock=" + stock +
                '}';
    }
}
