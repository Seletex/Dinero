package edu.uco.inventory.crosscutting.helper;

import static edu.uco.inventory.crosscutting.helper.ObjectHelper.getDefaultIfNull;

public final class StringHelper {

	public static final String EMPTY = "";

	private StringHelper() {
		super();
	}

	public static final String getDefaultString(String value,String defaultValue) {
		return getDefaultIfNull(value, EMPTY);
	}

	public static final String getDefaultString(String value) {
		return getDefaultString(value, EMPTY);
	}
	
	public static final String applyTrim(String value) {
		return getDefaultString(value).trim();
	}
	

}
