package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.NumberHelper.ZERO;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.inventario.domain.builder.ProductoDTOBuilder.getProductoDTOBuilder;
import static edu.uco.inventario.domain.builder.ProveedorDTOBuilder.getProveedorDTOBuilder;

import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class PedidoDTO {

	private UUID id;
	private ProductoDTO producto;
	private ProveedorDTO proveedorDTO;
	private short cantidad;

	public PedidoDTO(final UUID id, final ProductoDTO producto,
			final ProveedorDTO proveedorDTO, final short cantidad) {
		setId(id);
		setProducto(producto);
		setProveedorDTO(proveedorDTO);
		setCantidad(cantidad);

	}

	public PedidoDTO() {
		super();
		setId(getNewUUID());
		setProveedorDTO(getProveedorDTOBuilder().build());
		setProducto(getProductoDTOBuilder().build());
		setCantidad(ZERO);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final ProductoDTO getProducto() {
		return producto;
	}

	public final void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	public final ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	public final void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	public final short getCantidad() {
		return cantidad;
	}

	public final void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}

	public static final PedidoDTO create(final ProductoDTO producto,
			final ProveedorDTO proveedorDTO, final short cantidad) {
		return new PedidoDTO(UUID.randomUUID(), producto, proveedorDTO, cantidad);
	}

	public static final PedidoDTO create(final String id, final ProductoDTO producto,
			final ProveedorDTO proveedorDTO, final short cantidad) {
		return new PedidoDTO(getUUIDFromString(id), producto, proveedorDTO, cantidad);
	}

	public static final PedidoDTO create(final UUID id, final ProductoDTO producto,
			final ProveedorDTO proveedorDTO, final short cantidad) {
		return new PedidoDTO(getDefaultUUID(id), producto, proveedorDTO, cantidad);
	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		// 50 minute
	}

}
