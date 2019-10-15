package py.com.uds.sgc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "periodos_fiscales")
public class PeriodoFiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected PeriodoFiscalPK periodosFiscalesPK;

    @JsonIgnore    
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contribuyente contribuyentes;
    
}
