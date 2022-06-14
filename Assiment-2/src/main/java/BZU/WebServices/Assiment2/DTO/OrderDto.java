package BZU.WebServices.Assiment2.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDto {
    private long id;
    private LocalDateTime dateTime;
    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }

}
