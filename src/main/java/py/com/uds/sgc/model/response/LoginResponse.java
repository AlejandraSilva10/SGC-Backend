package py.com.uds.sgc.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private Integer id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    
}
