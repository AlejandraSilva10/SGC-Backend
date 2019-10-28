package py.com.uds.sgc.model.response;

import lombok.Data;

@Data
public class ContribuyenteResponse {
    private Integer id;
    private String razonSocial;
    private String ruc;
    private String telefono;
    private String direccion;
}
