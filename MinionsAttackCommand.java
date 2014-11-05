/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zanflango.minionsattack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

/**
 *
 * @author Tim
 */
public class MinionsAttackCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(!(cs instanceof Player)){
            return false;
        }
        Player player = (Player) cs;
           //locate nearest player
        Player closest = getNearestPlayer(player);
        // loop through all zombies, if within 20 blocks set target to that player.
        // as long as they don't already have a target.
        if (closest==null){
          Bukkit.broadcastMessage("Nobody here?");    
        }else{
             Bukkit.broadcastMessage("Minions Attack!!"); 
         for(Entity e : player.getWorld().getEntities()) {
            if(e instanceof Zombie) {
                if(e.getLocation().distance(player.getLocation()) < 21)
                {
                    Zombie z = (Zombie) e;
                    z.setTarget(closest);
                    
                }
            }
         }
        }
     return true;
        
    }
    
     public Player getNearestPlayer(Player player) {
         Player closest = null;
         for(Player e : player.getWorld().getPlayers()) {
                 if(closest == null || e.getLocation().distance(player.getLocation()) < closest.getLocation().distance(player.getLocation())) {
                     if(!e.equals(player)){
                     closest =  e;
                     }
             }
         }
         return closest;
     }    
    
}



