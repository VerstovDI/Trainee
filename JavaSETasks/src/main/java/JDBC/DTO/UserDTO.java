package JDBC.DTO;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Integer userId;
    private String username;
    private Date birthdayDate;
    private Integer age;
    private Integer securityLevel;
}
