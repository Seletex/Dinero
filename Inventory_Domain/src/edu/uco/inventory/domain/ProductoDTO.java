package edu.uco.inventory.domain;

import static edu.uco.inventory.crosscutting.helper.NumberHelper.ZERO;
import static edu.uco.inventory.crosscutting.helper.NumberHelper.isLessThan;
import static edu.uco.inventory.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventory.crosscutting.helper.UUIDHelper.getDefaultUUID;

import java.util.UUID;

public class ProductoDTO {
	
	private UUID id;
	private String nombre;
	private String descripcion;
	private ProveedorDTO proveedor;
	private short cantidad;
	private String contenido;
	private CuidadoDTO cuidado;
	private TipoUnidadDTO unidad;
	public final UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(final String nombre) {
		this.nombre = applyTrim(nombre);
	}
	public final String getDescripcion() {
		return descripcion;
	}
	public final void setDescripcion(final String descripcion) {
		this.descripcion = applyTrim(descripcion);
	}
	public final ProveedorDTO getProveedor() {
		return proveedor;
	}
	public final void setProveedor(final ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}
	public final short getCantidad() {
		return cantidad;
	}
	public final void setCantidad(final short cantidad) {
		this.cantidad = (isLessThan(cantidad, ZERO) ? ZERO : cantidad);
	}
	public final String getContenido() {
		return contenido;
	}
	public final void setContenido(final String contenido) {
		this.contenido = applyTrim(contenido);
	}
	public final CuidadoDTO getCuidado() {
		return cuidado;
	}
	public final void setCuidado(final CuidadoDTO cuidado) {
		this.cuidado = cuidado;
	}
	public final TipoUnidadDTO getUnidad() {
		return unidad;
	}
	public final void setUnidad(final TipoUnidadDTO unidad) {
		this.unidad = unidad;
	}
	
	

}
