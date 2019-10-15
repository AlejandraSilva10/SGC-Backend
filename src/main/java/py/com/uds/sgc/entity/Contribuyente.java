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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "contribuyentes")
public class Contribuyente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contribuyente")
    private Integer idContribuyente;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "razon_social")
    private String razonSocial;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ruc")
    private String ruc;
    
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    
    @JsonIgnore
    @JoinColumn(name = "id_plan_cuentas", referencedColumnName = "id_plan_cuentas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PlanCuenta idPlanCuentas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contribuyentes", fetch = FetchType.LAZY)
    private List<PeriodoFiscal> periodosFiscalesList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContribuyente", fetch = FetchType.LAZY)
    private List<Compra> comprasList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContribuyente", fetch = FetchType.LAZY)
    private List<Sucursal> sucursalesList;

    @JsonIgnore    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContribuyente", fetch = FetchType.LAZY)
    private List<Venta> ventasList;
    
}
