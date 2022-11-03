package edu.uco.budget.crosscutting.helper;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import java.util.UUID;

public final class StringHelper {

	public static final String EMPTY = "";

	private StringHelper() {
		super();
	}

	public static final String getDefaultString(String value,String defaultValue) {
		return (String) getDefaultIfNull(value, EMPTY);
	}

	public static final String getDefaultString(String value) {
		return getDefaultString(value, EMPTY);
	}
	
	public static final String applyTrim(String value) {
		return getDefaultString(value).trim();
	}
	
	public static final String getUUIDAsString(final UUID value) {
		return getDefaultUUID(value).toString();
	}
	
	public static final boolean isEmpty(String value) {
		return true;
	}

}
