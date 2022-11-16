package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.inventario.domain.builder.ProductoDTOBuilder.getProductoDTOBuilder;
import static edu.uco.inventario.domain.builder.UsuarioDTOBuilder.getUsuarioDTOBuilder;

import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCreation;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class SalidaDTO {
	
	private UUID id;
	private ProductoDTO productoDTO;
	private UsuarioDTO usuario;
	private short cantidad;
	private DateTimeAtCreation fecha;
	
	public final ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	public final void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = getDefaultIfNull(productoDTO, getProductoDTOBuilder().build());
	}

	public final short getCantidad() {
		return cantidad;
	}

	public final void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}

	
	
	public SalidaDTO(final UUID id,final UsuarioDTO usuario, final short cantidad, final ProductoDTO productoDTO,
			final DateTimeAtCreation fecha) {
		setId(id);
		setProductoDTO(productoDTO);
		setUsuario(usuario);
		setCantidad(cantidad);
		setFecha(fecha);
	}
	
	public SalidaDTO() {
		setId(getNewUUID());
		setProductoDTO(getProductoDTOBuilder().build());
		setUsuario(getUsuarioDTOBuilder().build());
		setFecha(fecha);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public final UsuarioDTO getUsuario() {
		return usuario;
	}

	public final void setUsuario(UsuarioDTO usuario) {
		this.usuario = getDefaultIfNull(usuario, getUsuarioDTOBuilder().build());
	}

	public final DateTimeAtCreation getFecha() {
		return fecha;
	}

	public final void setFecha(DateTimeAtCreation fecha) {
		this.fecha = fecha;
	}
	
	public static final SalidaDTO create(final UsuarioDTO usuario, final short cantidad, final ProductoDTO productoDTO,
			final DateTimeAtCreation fecha) {
		return new SalidaDTO(UUID.randomUUID(),usuario,cantidad,  productoDTO, fecha);
	}
	
	public static final SalidaDTO create(final String id,final UsuarioDTO usuario, final short cantidad, final ProductoDTO productoDTO,
			final DateTimeAtCreation fecha) {
		return new SalidaDTO(getUUIDFromString(id), usuario,cantidad,productoDTO,fecha);
	}
	
	public static final SalidaDTO create(final UUID id,final UsuarioDTO usuario, final short cantidad, final ProductoDTO productoDTO,
			final DateTimeAtCreation fecha) {
		return new SalidaDTO(getDefaultUUID(id), usuario,cantidad,productoDTO,fecha);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		//50 minute
	}
	

}
