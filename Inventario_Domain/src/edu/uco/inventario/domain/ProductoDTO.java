package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.NumberHelper.ZERO;
import static edu.uco.inventario.crosscutting.helper.NumberHelper.isLessThan;
import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.inventario.domain.builder.CuidadoDTOBuilder.getCuidadoDTOBuilder;
import static edu.uco.inventario.domain.builder.ProveedorDTOBuilder.getProveedorDTOBuilder;
import static edu.uco.inventario.domain.builder.TipoUnidadDTOBuilder.getTipoUnidadDTOBuilder;

import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class ProductoDTO {

	private UUID id;
	private String nombre;
	private String descripcion;
	private ProveedorDTO proveedor;
	private short cantidad;
	private String contenido;
	private CuidadoDTO cuidado;
	private TipoUnidadDTO unidad;

	public ProductoDTO() {
		setId(getNewUUID());
		setNombre(EMPTY);
		setDescripcion(EMPTY);
		setProveedor(getProveedorDTOBuilder().build());
		setCantidad(ZERO);
		setContenido(EMPTY);
		setCuidado(getCuidadoDTOBuilder().build());
		setUnidad(getTipoUnidadDTOBuilder().build());
	}

	public ProductoDTO(final UUID id, final String nombre, final String descripcion,
			final ProveedorDTO proveedor, final short cantidad, final String contenido,
			final CuidadoDTO cuidado, final TipoUnidadDTO unidad) {

		setId(id);
		setCantidad(cantidad);
		setContenido(contenido);
		setCuidado(cuidado);
		setDescripcion(descripcion);
		setNombre(nombre);
		setProveedor(proveedor);
		setUnidad(unidad);

	}

	

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
		this.proveedor = getDefaultIfNull(proveedor, getProveedorDTOBuilder().build());
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
		this.cuidado = getDefaultIfNull(cuidado, getCuidadoDTOBuilder().build());
	}

	public final TipoUnidadDTO getUnidad() {
		return unidad;
	}

	public final void setUnidad(final TipoUnidadDTO unidad) {
		this.unidad = getDefaultIfNull(unidad, getTipoUnidadDTOBuilder().build());
	}

	public static final ProductoDTO create(final String nombre, final String descripcion,
			final ProveedorDTO proveedor, final short cantidad, final String contenido,
			final CuidadoDTO cuidado, final TipoUnidadDTO unidad) {
		return new ProductoDTO(UUID.randomUUID(), nombre, descripcion, proveedor,
				cantidad, contenido, cuidado, unidad);
	}

	public static final ProductoDTO create(final String id, final String nombre,
			final String descripcion, final ProveedorDTO proveedor, final short cantidad,
			final String contenido, final CuidadoDTO cuidado,
			final TipoUnidadDTO unidad) {
		return new ProductoDTO(getUUIDFromString(id), nombre, descripcion, proveedor,
				cantidad, contenido, cuidado, unidad);
	}

	public static final ProductoDTO create(final UUID id, final String nombre,
			final String descripcion, final ProveedorDTO proveedor, final short cantidad,
			final String contenido, final CuidadoDTO cuidado,
			final TipoUnidadDTO unidad) {
		return new ProductoDTO(getDefaultUUID(id), nombre, descripcion, proveedor,
				cantidad, contenido, cuidado, unidad);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		// 50 minute
	}


}
