package fr.orblazer.btgsuiterelonar.manager;

import org.bukkit.ChatColor;

import fr.orblazer.btgsuiterelonar.Main;

public class MainManager {
	public static MainManager instances = new MainManager();
	public Main pl;
	
	public static MainManager getInstance() {
		return instances;
	}
	
	public void setup(Main p) {
		this.pl = p;
	}
	
	public String replaceColor(String s) {
		if(s!=null)
			return s.replace("&4", ChatColor.DARK_RED + "")
				.replace("&c", ChatColor.RED + "")
				.replace("&6", ChatColor.GOLD + "")
				.replace("&e", ChatColor.YELLOW + "")
				.replace("&2", ChatColor.DARK_GREEN + "")
				.replace("&a", ChatColor.GREEN + "")
				.replace("&b", ChatColor.AQUA + "")
				.replace("&3", ChatColor.DARK_AQUA + "")
				.replace("&4", ChatColor.DARK_RED + "")
				.replace("&1", ChatColor.DARK_BLUE + "")
				.replace("&9", ChatColor.BLUE + "")
				.replace("&d", ChatColor.LIGHT_PURPLE + "")
				.replace("&5", ChatColor.DARK_PURPLE + "")
				.replace("&f", ChatColor.WHITE + "")
				.replace("&7", ChatColor.GRAY + "")
				.replace("&8", ChatColor.DARK_GRAY+ "")
				.replace("&0", ChatColor.BLACK + "");
		else
			return "";
	}
}
