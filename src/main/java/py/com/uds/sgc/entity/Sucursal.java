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
@Table(name = "sucursales")
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
     
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal", fetch = FetchType.LAZY)
    private List<SucursalRubro> sucursalesRubrosList;
    
    @JsonIgnore    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal", fetch = FetchType.LAZY)
    private List<Compra> comprasList;
 
    @JsonIgnore    
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contribuyente idContribuyente;
    
    @JsonIgnore    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal", fetch = FetchType.LAZY)
    private List<Venta> ventasList;

    
}
