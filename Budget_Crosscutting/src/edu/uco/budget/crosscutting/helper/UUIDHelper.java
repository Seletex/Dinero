package edu.uco.budget.crosscutting.helper;

import java.util.UUID;

public final class UUIDHelper {
	
	private UUIDHelper() {
		super();
	}
	
	public static final UUID getDefaultUUID(final UUID value) {
		if(ObjectHelper.isNull(value)) {
			return 
		}
		return value;
		
	}
	
	public static final UUID getNewUUID() {
		return UUID.randomUUID();
	}

}
