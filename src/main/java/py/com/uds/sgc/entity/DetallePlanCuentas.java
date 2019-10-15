package py.com.uds.sgc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_plan_cuentas")
public class DetallePlanCuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DetallePlanCuentasPK detallePlanCuentasPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore    
    @JoinColumn(name = "id_plan_cuentas", referencedColumnName = "id_plan_cuentas", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PlanCuenta planCuentas;
    
    @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo_cuenta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoCuenta idTipoCuenta;

}
