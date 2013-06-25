package fr.orblazer.btgsuiterelonar.util;

import java.util.Collections;
import java.util.List;

public final class ListTag extends Tag {
	private final Class<? extends Tag> type;
	private final List<Tag> value;

	public ListTag(String name, Class<? extends Tag> type, List<? extends Tag> value) {
		super(name);
		this.type = type;
		this.value = Collections.unmodifiableList(value);
	}

	public Class<? extends Tag> getType() {
		return this.type;
	}

	public List<Tag> getValue() {
		return this.value;
	}

	public String toString() {
		String name = getName();
		String append = "";
		if ((name != null) && (!name.equals(""))) {
			append = new StringBuilder().append("(\"").append(getName()).append("\")").toString();
		}
		StringBuilder bldr = new StringBuilder();
		bldr.append(new StringBuilder().append("TAG_List").append(append).append(": ").append(this.value.size()).append(" entries of type ").append(NBTUtils.getTypeName(this.type)).append("\r\n{\r\n").toString());

		for (Tag t : this.value) {
			bldr.append(new StringBuilder().append("   ").append(t.toString().replaceAll("\r\n", "\r\n   ")).append("\r\n").toString());
		}

		bldr.append("}");
		return bldr.toString();
	}
}