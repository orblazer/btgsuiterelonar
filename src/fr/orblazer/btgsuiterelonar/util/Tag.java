package fr.orblazer.btgsuiterelonar.util;

public abstract class Tag {
	private final String name;

	public Tag(String name){
		this.name = name;
	}

	public final String getName() {
		return this.name;
	}

  public abstract Object getValue();
}
