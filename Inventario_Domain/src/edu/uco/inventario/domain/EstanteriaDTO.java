package edu.uco.inventario.domain;

import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.inventario.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.inventario.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.inventario.crosscutting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.inventario.domain.builder.ProductoDTOBuilder.getProductoDTOBuilder;
import static edu.uco.inventario.domain.builder.SeccionDTOBuilder.getSeccionDTOBuilder;

import java.util.UUID;

import edu.uco.inventario.crosscutting.helper.UUIDHelper;

public class EstanteriaDTO {
	
	private UUID id;
	private String pasillo;
	private String letra;
	private String numero;
	private String descripcion;
	private SeccionDTO seccionDTO;
	private ProductoDTO productoDTO;

	public EstanteriaDTO() {
		setId(getNewUUID());
		
		
		setDescripcion(EMPTY);
		setPasillo(EMPTY);
		setLetra(EMPTY);
		setNumero(EMPTY);		
		setSeccionDTO(getSeccionDTOBuilder().build());
		setProductoDTO(getProductoDTOBuilder().build());
		setDescripcion(EMPTY);


	}

	public EstanteriaDTO(final UUID id, final String pasillo,final String letra,
			final String numero,final String descripcion, final SeccionDTO seccion, final ProductoDTO productoDTO) {
		setId(id);
		setPasillo(pasillo);
		setLetra(letra);
		setNumero(numero);		
		setSeccionDTO(seccion);
		setProductoDTO(productoDTO);
		setDescripcion(descripcion);

	}

	public final String getPasillo() {
		return pasillo;
	}

	public final void setPasillo(String pasillo) {
		this.pasillo = applyTrim(pasillo);
	}

	public final String getLetra() {
		return letra;
	}

	public final void setLetra(String letra) {
		this.letra = applyTrim(letra);
	}

	public final String getNumero() {
		return numero;
	}

	public final void setNumero(String numero) {
		this.numero = applyTrim(numero);
	}

	public final SeccionDTO getSeccionDTO() {
		return seccionDTO;
	}

	public final void setSeccionDTO(SeccionDTO seccionDTO) {
		this.seccionDTO = getDefaultIfNull(seccionDTO, getSeccionDTOBuilder().build());
	}

	public final ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	public final void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO =  getDefaultIfNull(productoDTO, getProductoDTOBuilder().build());
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final void setDescripcion(String descripcion) {
		this.descripcion = applyTrim(descripcion);
	}	

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = getDefaultUUID(id);
	}

	public static final EstanteriaDTO create( final String pasillo,final String letra,
			final String numero,final String descripcion, final SeccionDTO seccion, final ProductoDTO productoDTO) {
		return new EstanteriaDTO(UUID.randomUUID(), pasillo, letra,numero,descripcion,seccion,productoDTO);
	}
	
	public static final EstanteriaDTO create(final String id, final String pasillo,final String letra,
	final String numero,final String descripcion, final SeccionDTO seccion, final ProductoDTO productoDTO) {
		return new EstanteriaDTO(getUUIDFromString(id), pasillo, letra,numero,descripcion,seccion,productoDTO);
	}
	
	public static final EstanteriaDTO create(final UUID id, final String pasillo,final String letra,
			final String numero,final String descripcion, final SeccionDTO seccion, final ProductoDTO productoDTO) {
		return new EstanteriaDTO(getDefaultUUID(id), pasillo, letra,numero,descripcion,seccion,productoDTO);
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public final boolean notExist() {
		return UUIDHelper.isDefualtUUID(id);
		//50 minute
	}
}


