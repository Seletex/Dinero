package edu.uco.inventario.domain.builder;

import static edu.uco.inventario.domain.EstanteriaDTO.create;

import java.util.UUID;

import edu.uco.inventario.domain.EstanteriaDTO;
import edu.uco.inventario.domain.ProductoDTO;
import edu.uco.inventario.domain.SeccionDTO;

public class EstanteriaDTOBuilder {
	
	private UUID id;
	private String pasillo;
	private String letra;
	private String numero;
	private String descripcion;
	private SeccionDTO seccionDTO;
	private ProductoDTO productoDTO;

	private EstanteriaDTOBuilder() {
		super();
	}

	public static final EstanteriaDTOBuilder getEstanteriaDTOBuilder() {
		return new EstanteriaDTOBuilder();
	}

	public final EstanteriaDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}	

	public EstanteriaDTO build() {
		return create(id, pasillo,letra,numero,descripcion,seccionDTO,productoDTO);
	}

	public final EstanteriaDTOBuilder setPasillo(String pasillo) {
		this.pasillo = pasillo;return this;
	}

	public final EstanteriaDTOBuilder setLetra(String letra) {
		this.letra = letra;return this;
	}

	public final EstanteriaDTOBuilder setNumero(String numero) {
		this.numero = numero;return this;
	}

	public final EstanteriaDTOBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;return this;
	}

	public final EstanteriaDTOBuilder setSeccionDTO(SeccionDTO seccionDTO) {
		this.seccionDTO = seccionDTO;
		return this;
	}

	public final EstanteriaDTOBuilder setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
		return this;
	}
	
	
	

}
