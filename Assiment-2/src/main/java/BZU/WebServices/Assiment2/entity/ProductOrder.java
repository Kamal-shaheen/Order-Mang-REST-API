package BZU.WebServices.Assiment2.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Product_order")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "This the product Order Id" , required = false)
    private Long productOrderId;
    @Column
    @ApiModelProperty(value = "This the Quantity of Product Order " , required = true)
    private int quantity;
    @Column
    @ApiModelProperty(value = "This the Price Product Order" , required = true)
    private double price;
    @Column
    @ApiModelProperty(value = "This the Vat Product Order" , required = true)
    private double vat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_Id",nullable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_Id",nullable = false)
    private Order order;
    @Override
    public String toString() {
        return "ProductOrder{" +
                "productOrderId=" + productOrderId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", vat=" + vat +
                ", product=" + product +
                ", order=" + order +
                '}';
    }
}
