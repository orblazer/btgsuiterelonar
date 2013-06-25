package fr.orblazer.btgsuiterelonar;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.orblazer.btgsuiterelonar.manager.BuildManager;
import fr.orblazer.btgsuiterelonar.manager.ConfigManager;
import fr.orblazer.btgsuiterelonar.manager.MainManager;

public class Main extends JavaPlugin {
	public Logger log = Logger.getLogger("Minecraft");
	public String plName;
	public String name;
	
	@Override
	public void onLoad() {
 		setup();
	}
	
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		
		if (pm.getPlugin("BTGSuiteCore") == null) {
 			this.log.warning(this.name + "BTGSuiteCore is not installed. This plugin is required!");
 			pm.disablePlugin(this);
 		}
 		else
 			this.log.info(this.name + "BTGSuiteCore is enable.");
	}
	
	@Override
	public void onDisable() {
	}
	
	public void setup() {
		PluginDescriptionFile pdFile = getDescription();
 		this.name = ("[" + pdFile.getName() + "] ");
 		this.plName = ("[" + ChatColor.YELLOW + pdFile.getName() + ChatColor.RESET + "] ");
 		
 		ConfigManager.getInstance().setup(this);
 		MainManager.getInstance().setup(this);
 		BuildManager.getInstance().setup(this);
 		
 		init();
	}
	
	public void init() {
		BuildManager.getInstance().init();
	}
	
	public FileConfiguration getMessages() {
		return ConfigManager.getInstance().getMessages();
	}
}
