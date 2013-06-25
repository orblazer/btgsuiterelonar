package fr.orblazer.btgsuiterelonar.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.orblazer.btgsuiterelonar.Main;
import fr.orblazer.btgsuiterelonar.manager.BuildManager;

public class BTGBuild {
	private Main pl;

  	public BTGBuild(Main pl) {
	  this.pl = pl;
  	}

	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
  		if ((command.getName().equalsIgnoreCase("btgbuild")) || (command.getName().equalsIgnoreCase("btbuild")) || 
  				(command.getName().equalsIgnoreCase("bgbuild"))) {

  			Player p = (Player)sender;
  			System.out.println(pl.plName + BuildManager.getInstance().listFile());
  			try {
  				File f = new File("test.schematic");
  			
				BuildManager.getInstance().Build(p.getWorld(), p.getLocation(), BuildManager.getInstance().loadSchematic(f));
			}
  			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
  		}
  		return false;
	}
}
