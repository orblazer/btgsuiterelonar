package fr.orblazer.btgsuiterelonar.util;

public class Schematic {
	private byte[] blocks;
	private byte[] data;
	private short width;
	private short lenght;
	private short height;
	
	public Schematic(byte[] b, byte[] d, short w, short l, short h) {
		this.blocks = b;
		this.data = d;
		this.lenght = l;
		this.height = h;
	}
	
	public byte[] getBlocks() {
		return blocks;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public short getWidth() {
		return width;
	}
	
	public short getLenght() {
		return lenght;
	}
	
	public short getHeight() {
		return height;
	}
}
