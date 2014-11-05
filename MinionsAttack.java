/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zanflango.minionsattack;

import org.bukkit.plugin.java.JavaPlugin;

public class MinionsAttack extends JavaPlugin{
   @Override
   public void onEnable(){
       getCommand("minionsattack").setExecutor(new MinionsAttackCommand());
   }
}
