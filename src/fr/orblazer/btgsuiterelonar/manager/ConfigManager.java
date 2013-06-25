package fr.orblazer.btgsuiterelonar.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.orblazer.btgsuiterelonar.Main;

public class ConfigManager {
	public static ConfigManager instances = new ConfigManager();
	public Main pl;
	private FileConfiguration messages;	
	private File messagesFile;
	
	public static ConfigManager getInstance() {
		return instances;
	}
	
	public void setup(Main p) {
		this.pl = p;
		
		this.messagesFile = new File(p.getDataFolder(), "messages.yml");
		try {
			if(!this.messagesFile.exists()) {
				setDefaultConfig("messages.yml", "messages_" + p.getConfig().getString("configs.lang") + ".yml");
				reloadMessages();
			}
			
			reloadMessages();
			
			if(this.messagesFile.exists() && !getMessages().getString("LANG").equals(p.getConfig().getString("configs.lang"))) {
				deleteOld("messages.yml");
				setDefaultConfig("messages.yml", "messages_" + p.getConfig().getString("configs.lang") + ".yml");
				reloadMessages();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FileConfiguration getMessages() {
		return this.messages;
	}
	
	public void reloadMessages() {
		this.messages = YamlConfiguration.loadConfiguration(this.messagesFile);
	}
	
	public void saveMessages() {
		try {
			this.messages.save(this.messagesFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setDefaultConfig(String file, String file1) {
		try {
			InputStream in = pl.getResource(file1);
			File f = new File(pl.getDataFolder(), file);
			System.out.println(pl.name + "Writing new file: " + f.getAbsolutePath());
			
			OutputStream out = new FileOutputStream(f);
			byte[] buffer = new byte[1024];
			int l;
			while((l=in.read(buffer)) > 0) {
				out.write(buffer, 0, l);
			}
			in.close();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOld(String file)
			throws IOException {
		File f = new File(pl.getDataFolder(), file);
		if (f.isDirectory()) {
			for (File ff : f.listFiles()) {
				deleteOld(ff.getName());
			}
		}
		if (!f.delete())
			this.pl.log.warning(this.pl.name + "Can't delete '" + f + "'");
	}
}
