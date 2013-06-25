package fr.orblazer.btgsuiterelonar.util;

public final class ByteArrayTag extends Tag {
	private final byte[] value;
 
	public ByteArrayTag(String name, byte[] value) {
		super(name);
		this.value = value;
	}

	public byte[] getValue() {
		return this.value;
	}

	public String toString() {
		StringBuilder hex = new StringBuilder();
		for (byte b : this.value) {
			String hexDigits = Integer.toHexString(b).toUpperCase();
			if (hexDigits.length() == 1)
				hex.append("0");
			hex.append(hexDigits).append(" ");
		}
		String name = getName();
		String append = "";
		if ((name != null) && (!name.equals("")))
			append = new StringBuilder().append("(\"").append(getName()).append("\")").toString();

		return new StringBuilder().append("TAG_Byte_Array").append(append).append(": ").append(hex.toString()).toString();
	}
}
