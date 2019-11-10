package py.com.uds.sgc.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    
    private Integer id;
    private String username;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    
}
