package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.domain.builder.PedidoDTOBuilder.getPedidoDTOBuilder;
import static edu.uco.inventario.domain.builder.UsuarioDTOBuilder.getUsuarioDTOBuilder;

import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCreation;

public class EntradaDTO {
	
	private UUID id;
	private PedidoDTO pedido;
	private UsuarioDTO usuario;
	private DateTimeAtCreation fecha;
	
	public EntradaDTO(UUID id, PedidoDTO pedido, UsuarioDTO usuario,
			DateTimeAtCreation fecha) {
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

	public final UUID getid() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final PedidoDTO getPedido() {
		return pedido;
	}

	public final void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public final UsuarioDTO getUsuario() {
		return usuario;
	}

	public final void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public final DateTimeAtCreation getFecha() {
		return fecha;
	}

	public final void setFecha(DateTimeAtCreation fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	

}
