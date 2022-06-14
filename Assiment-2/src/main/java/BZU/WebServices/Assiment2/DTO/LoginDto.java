package BZU.WebServices.Assiment2.DTO;
import lombok.Data;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
