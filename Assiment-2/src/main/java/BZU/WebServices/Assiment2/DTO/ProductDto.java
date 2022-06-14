package BZU.WebServices.Assiment2.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NotEmpty
    @Size(min = 3 , message = "Product Name Must Have At Lest 3 Character")
    private String name;
    @NotEmpty
    @Size(min = 3 , message = "Product reference Must Have At Lest 3 Character")
    private String reference;
    private Double price;
    private Double  vat ;
    private boolean stockable;

}
