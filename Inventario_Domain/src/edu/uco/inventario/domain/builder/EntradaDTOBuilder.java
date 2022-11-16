package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.EntradaDTO.create;

import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCreation;

import edu.uco.inventario.domain.EntradaDTO;
import edu.uco.inventario.domain.PedidoDTO;
import edu.uco.inventario.domain.UsuarioDTO;

public class EntradaDTOBuilder {

	private UUID id;
	private PedidoDTO pedido;
	private UsuarioDTO usuario;
	private DateTimeAtCreation fecha;

	public final EntradaDTOBuilder setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
		return this;
	}

	public final EntradaDTOBuilder setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
		return this;
	}

	public final EntradaDTOBuilder setFecha(DateTimeAtCreation fecha) {
		this.fecha = fecha;
		return this;
	}

	private EntradaDTOBuilder() {
		super();
	}

	public static final EntradaDTOBuilder getEntradaDTOBuilder() {
		return new EntradaDTOBuilder();
	}

	public final EntradaDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public EntradaDTO build() {

		return create(id, pedido, usuario, fecha);
	}

	

}
