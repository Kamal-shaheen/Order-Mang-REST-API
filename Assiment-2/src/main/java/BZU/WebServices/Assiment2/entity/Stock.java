package BZU.WebServices.Assiment2.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Table(name="stocks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "This Id of Customer " , required = false)
    private Long id;
    @Column
    @ApiModelProperty(value = "This quantity of Stock " , required = true)
    private int quantity;
    @Column
    @ApiModelProperty(value = "This Local Date Time of Stock " , required = true)
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_Id" , nullable = false)
    private Product product;


}
