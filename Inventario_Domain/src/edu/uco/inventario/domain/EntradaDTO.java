package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.inventario.domain.builder.PedidoDTOBuilder.getPedidoDTOBuilder;
import static edu.uco.inventario.domain.builder.UsuarioDTOBuilder.getUsuarioDTOBuilder;

import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCreation;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class EntradaDTO {
	
	private UUID id;
	private PedidoDTO pedido;
	private UsuarioDTO usuario;
	private DateTimeAtCreation fecha;
	
	public EntradaDTO(final UUID id,final PedidoDTO pedido,final UsuarioDTO usuario,
			final DateTimeAtCreation fecha) {
		setId(id);
		setPedido(pedido);
		setUsuario(usuario);
		setFecha(fecha);
	}
	
	public EntradaDTO() {
		setId(getNewUUID());
		setPedido(getPedidoDTOBuilder().build());
		setUsuario(getUsuarioDTOBuilder().build());
		setFecha(fecha);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final PedidoDTO getPedido() {
		return pedido;
	}

	public final void setPedido(PedidoDTO pedido) {
		this.pedido = getDefaultIfNull(pedido, getPedidoDTOBuilder().build());
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
	
	public static final EntradaDTO create(final PedidoDTO pedido,final UsuarioDTO usuario,
			final DateTimeAtCreation fecha) {
		return new EntradaDTO(UUID.randomUUID(),  pedido, usuario,fecha);
	}
	
	public static final EntradaDTO create(final String id,final PedidoDTO pedido,final UsuarioDTO usuario,
			final DateTimeAtCreation fecha) {
		return new EntradaDTO(getUUIDFromString(id), pedido, usuario,fecha);
	}
	
	public static final EntradaDTO create(final UUID id,final PedidoDTO pedido,final UsuarioDTO usuario,
			final DateTimeAtCreation fecha) {
		return new EntradaDTO(getDefaultUUID(id),  pedido, usuario,fecha);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		//50 minute
	}
	
	
	
	
	
	

}
