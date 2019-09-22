package py.com.locex.systemcontrol.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="proveedores")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Proveedor {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("ruc")
	private String ruc;	
	
	@JsonProperty("razon_social")
	private String razonSocial;
	
	public Long getId() {
		return this.id;
	}
	
}
