package py.com.uds.sgc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PeriodoFiscalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "anho_fiscal")
    private Integer anhoFiscal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contribuyente")
    private Integer idContribuyente;
    
}
