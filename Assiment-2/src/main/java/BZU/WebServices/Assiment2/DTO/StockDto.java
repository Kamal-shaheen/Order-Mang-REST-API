package BZU.WebServices.Assiment2.DTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class StockDto {
    private long id;
    private int quantity;
    private LocalDateTime dateTime;
    public StockDto (long id ,int quantity , LocalDateTime dateTime){
        this.quantity=quantity;
        this.dateTime=dateTime;
        this.id = id;
    }
}
