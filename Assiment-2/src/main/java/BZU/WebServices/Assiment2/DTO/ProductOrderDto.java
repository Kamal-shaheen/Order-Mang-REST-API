package BZU.WebServices.Assiment2.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDto {
    private long productOrderId;
    private int quantity;
    private Double price;
    private Double  vat ;
}
