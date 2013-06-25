package fr.orblazer.btgsuiterelonar.util;

import java.util.Collections;
import java.util.Map;

public final class CompoundTag extends Tag {
	private final Map<String, Tag> value;
 
	public CompoundTag(String name, Map<String, Tag> value) {
		super(name);
		this.value = Collections.unmodifiableMap(value);
	}

	public Map<String, Tag> getValue() {
		return this.value;
	}

	@SuppressWarnings("rawtypes")
	public String toString() {
		String name = getName();
		String append = "";
		if ((name != null) && (!name.equals(""))) {
			append = new StringBuilder().append("(\"").append(getName()).append("\")").toString();
		}
		StringBuilder bldr = new StringBuilder();
		bldr.append(new StringBuilder().append("TAG_Compound").append(append).append(": ").append(this.value.size()).append(" entries\r\n{\r\n").toString());

		for (Map.Entry entry : this.value.entrySet()) {
			bldr.append(new StringBuilder().append("   ").append(((Tag)entry.getValue()).toString().replaceAll("\r\n", "\r\n   ")).append("\r\n").toString());
		}
 
		bldr.append("}");
		return bldr.toString();
	}
}
