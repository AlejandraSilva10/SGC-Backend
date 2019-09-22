package py.com.locex.systemcontrol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;	

@Data
@Entity
@Table(name="comprobantes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comprobante {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	@JsonProperty("id")	
	private Long id;
	
	@JsonProperty("cliente")
	@OneToOne
    @JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@JsonProperty("fecha")
	private Date fecha;
	
	@JsonProperty("proveedor")
    @OneToOne
    @JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@JsonProperty("tipo_documento")
    @OneToOne
    @JoinColumn(name = "id_tipo_documento")	
	private TipoDocumento tipoDocumento;
	
	@JsonProperty("numero_comprobante")
	@Column(name="nro_comprobante")
	private String numeroComprobante;	
	
	@JsonProperty("numero_timbrado")
	@Column(name="nro_timbrado")
	private Long numeroTimbrado;
	
	@JsonProperty("importe_total")
	@Column(name="importe_total")
	private String importeTotal;
	
	@JsonProperty("exentas")
	private String exentas;
	
	@JsonProperty("iva_10")
	@Column(name="iva_10")
	private String iva10;
	
	@JsonProperty("iva_5")
	@Column(name="iva_5")
	private String iva5;

	@JsonProperty("concepto")
	private String concepto;		
}
