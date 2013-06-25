package fr.orblazer.btgsuiterelonar.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import fr.orblazer.btgsuiterelonar.Main;
import fr.orblazer.btgsuiterelonar.util.ByteArrayTag;
import fr.orblazer.btgsuiterelonar.util.CompoundTag;
import fr.orblazer.btgsuiterelonar.util.NBTInputStream;
import fr.orblazer.btgsuiterelonar.util.Schematic;
import fr.orblazer.btgsuiterelonar.util.ShortTag;
import fr.orblazer.btgsuiterelonar.util.StringTag;
import fr.orblazer.btgsuiterelonar.util.Tag;

public class BuildManager {
	public static BuildManager instances = new BuildManager();
	public Main pl;
	public String StartedMessage = "";
	public String CompleteMessage = "";
	public String CancelMessage = "";
	
	public static BuildManager getInstance() {
		return instances;
	}
	
	public void setup(Main p) {
		this.pl = p;
	}
	
	public void init() {
		File folder = new File(pl.getDataFolder(), "schematics");
		
		if(!folder.exists()) {
			System.out.println(pl.name + "The folder is created.");
			folder.mkdir();
		}
	}
	
	public String listFile() {
		File folder = new File(pl.getDataFolder(), "schematics");
		File[] list = folder.listFiles();
		String out = "";
		int i = 0;
		
		if(list.length == 0) {
			return pl.plName + MainManager.getInstance().replaceColor(pl.getMessages().getString("NOBUILD"));
		}
		
		for(i=0; i< list.length-1; i++) {
			if(list[i].isFile()) {
				String file = list[i].getName();
				
				if(file.endsWith(".schematic"))
					out += file.replace(".schematic", ", ");
			}
		}
		
		if(list[i].isFile()) {
			String file = list[i].getName();
			
			if(file.endsWith(".schematic"))
				out += file.replace(".schematic", ".");
		}
		
		return pl.plName + MainManager.getInstance().replaceColor(pl.getMessages().getString("BUILD")
								.replace("<list>", out));
	}
	
	public void Build(World w, Location l, Schematic s) {
		byte[] b = s.getBlocks();
		byte[] bData = s.getData();
		
		short le = s.getLenght();
		short wi = s.getWidth();
		short h = s.getHeight();
		
		for(int x=0; x<wi; x++) {
			for(int y=0; y<h; y++) {
				for(int z=0; z<le; z++) {
					int i = y*wi*le + z*wi + x;
					Block bl = new Location(w, l.getX(), l.getY(), l.getX()).getBlock();
					bl.setTypeIdAndData(b[i], bData[i], true);
				}
			}
		}
	}
	
	public Schematic loadSchematic(File f)
			throws IOException {
		FileInputStream stream = new FileInputStream(f);
		NBTInputStream nbtStream = new NBTInputStream(new GZIPInputStream(stream));
		
		CompoundTag schematicTag = (CompoundTag) nbtStream.readTag();
        if (!schematicTag.getName().equals("Schematic")) {
            throw new IllegalArgumentException("Tag \"Schematic\" does not exist or is not first");
        }
 
        Map<String, Tag> schematic = schematicTag.getValue();
        if (!schematic.containsKey("Blocks")) {
            throw new IllegalArgumentException("Schematic file is missing a \"Blocks\" tag");
        }
 
        short width = getChildTag(schematic, "Width", ShortTag.class).getValue();
        short length = getChildTag(schematic, "Length", ShortTag.class).getValue();
        short height = getChildTag(schematic, "Height", ShortTag.class).getValue();
 
        String materials = getChildTag(schematic, "Materials", StringTag.class).getValue();
        if (!materials.equals("Alpha")) {
            throw new IllegalArgumentException("Schematic file is not an Alpha schematic");
        }
 
        byte[] blocks = getChildTag(schematic, "Blocks", ByteArrayTag.class).getValue();
        byte[] blockData = getChildTag(schematic, "Data", ByteArrayTag.class).getValue();
        return new Schematic(blocks, blockData, width, length, height);
	}
	
	private static <T extends Tag> T getChildTag(Map<String, Tag> items, String key, Class<T> expected) 
			throws IllegalArgumentException {
		if (!items.containsKey(key))
			throw new IllegalArgumentException("Schematic file is missing a \"" + key + "\" tag");

		Tag tag = items.get(key);
        if (!expected.isInstance(tag)) {
            throw new IllegalArgumentException(key + " tag is not of tag type " + expected.getName());
        }
        return expected.cast(tag);
    }
}
