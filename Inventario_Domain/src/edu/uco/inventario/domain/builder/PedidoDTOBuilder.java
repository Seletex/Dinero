package edu.uco.inventario.domain.builder;

import java.util.UUID;

import edu.uco.inventario.domain.PedidoDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.ProveedorDTO;

public class PedidoDTOBuilder {

	private UUID id;
	private ProductoDTO producto;
	private ProveedorDTO proveedorDTO;
	private short cantidad;

	public final PedidoDTOBuilder setProducto(ProductoDTO producto) {
		this.producto = producto;
		return this;
	}

	public final PedidoDTOBuilder setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
		return this;
	}

	public final PedidoDTOBuilder setCantidad(short cantidad) {
		this.cantidad = cantidad;
		return this;
	}

	private PedidoDTOBuilder() {
		super();
	}

	public static final PedidoDTOBuilder getPedidoDTOBuilder() {
		return new PedidoDTOBuilder();
	}

	public final PedidoDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public PedidoDTO build() {
		return PedidoDTO.create(id, producto, proveedorDTO, cantidad);
	}

}
