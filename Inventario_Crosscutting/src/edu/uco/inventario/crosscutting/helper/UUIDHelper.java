package edu.uco.inventario.crosscutting.helper;

import static edu.uco.inventario.crosscutting.helper.ObjectHelper.getDefaultIfNull;

import java.util.UUID;

import edu.uco.inventario.crosscutting.messages.Messages;
import edu.uco.inventario.crosscutting.exception.data.CrosscuttingCustomException;

public final class UUIDHelper {
	private static final  String DEFAULT_UUID_AS_STRING="0000000-0000-0000-0000-00000000";
	private static final  UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_AS_STRING);
	
	private UUIDHelper() {
		super();
	}	
	
	public static final UUID getDefaultUUID(final UUID value) {		
		return getDefaultIfNull(value, DEFAULT_UUID);		
	}
	
	public static final UUID getNewUUID() {
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			
		}while(isDefualtUUID(uuid));
		return UUID.randomUUID();
		
		
	}
	
	public static final String getUUIDAsString(final UUID value) {
		return getDefaultUUID(value).toString();
	}
	
	public static final UUID getUUIDFromString(final String value) {
		try {
			return UUID.fromString(StringHelper.getDefaultString(value, DEFAULT_UUID_AS_STRING));
		}catch( final IllegalCallerException exception) {
			throw CrosscuttingCustomException.createTechnicalException(Messages.UUIDHelper.TECHNICAL_UUID_FROM_STRING_INVALID,exception);
					
		}catch( final Exception exception) {
			throw CrosscuttingCustomException.createTechnicalException(Messages.UUIDHelper.TECHNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR,exception);
		}
		
	}
	
	public static final boolean isDefualtUUID(final UUID value) {
		return DEFAULT_UUID.equals(value);
	}

}
