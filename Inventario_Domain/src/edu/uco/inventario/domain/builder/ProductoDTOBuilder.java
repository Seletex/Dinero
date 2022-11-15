package edu.uco.inventario.domain.builder;

import java.util.UUID;

import edu.uco.inventario.domain.CuidadoDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.ProveedorDTO;
import edu.uco.inventario.domain.TipoUnidadDTO;
import static edu.uco.inventario.domain.ProductoDTO.create;

public class ProductoDTOBuilder {
	
	private UUID id;
	private String nombre;
	private String descripcion;
	private ProveedorDTO proveedor;
	private short cantidad;
	private String contenido;
	private CuidadoDTO cuidado;
	private TipoUnidadDTO unidad;

	

	private ProductoDTOBuilder() {
		super();
	}

	public static final ProductoDTOBuilder getProductoDTOBuilder() {
		return new ProductoDTOBuilder();
	}

	public final ProductoDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final ProductoDTOBuilder setYearNumber(final String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ProductoDTO build() {
		return create(id, nombre,descripcion,proveedor,cantidad,contenido,cuidado,unidad);
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ProveedorDTO getProveedor() {
		return proveedor;
	}

	public final short getCantidad() {
		return cantidad;
	}

	public final String getContenido() {
		return contenido;
	}

	public final CuidadoDTO getCuidado() {
		return cuidado;
	}

	public final TipoUnidadDTO getUnidad() {
		return unidad;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
