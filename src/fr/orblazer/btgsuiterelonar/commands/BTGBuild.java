package fr.orblazer.btgsuiterelonar.commands;

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
  			BuildManager.getInstance().Build(p.getWorld(), p.getLocation(), )
			return true;
  		}
  		return false;
	}
}
