package edu.uco.inventario.domain.builder;

import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCreation;

import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.SalidaDTO;
import edu.uco.inventario.domain.UsuarioDTO;

public class SalidaDTOBuilder {

	private UUID id;
	private ProductoDTO productoDTO;
	private UsuarioDTO usuario;
	private short cantidad;
	private DateTimeAtCreation fecha;

	public final SalidaDTOBuilder setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
		return this;
	}

	public final SalidaDTOBuilder setCantidad(short cantidad) {
		this.cantidad = cantidad;
		return this;
	}

	public final SalidaDTOBuilder setFecha(DateTimeAtCreation fecha) {
		this.fecha = fecha;
		return this;
	}

	private SalidaDTOBuilder() {
		super();
	}

	public static final SalidaDTOBuilder getEstanteriaDTOBuilder() {
		return new SalidaDTOBuilder();
	}

	public final SalidaDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public SalidaDTO build() {
		return SalidaDTO.create(id, usuario, cantidad, productoDTO, fecha);
	}

	public final SalidaDTOBuilder setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
		return this;
	}

}
