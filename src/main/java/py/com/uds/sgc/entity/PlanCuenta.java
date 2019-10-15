package py.com.uds.sgc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "plan_cuentas")
public class PlanCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plan_cuentas")
    private Integer idPlanCuentas;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanCuentas", fetch = FetchType.LAZY)
    private List<Contribuyente> contribuyentesList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planCuentas", fetch = FetchType.LAZY)
    private List<DetallePlanCuentas> detallePlanCuentasList;
    
}
