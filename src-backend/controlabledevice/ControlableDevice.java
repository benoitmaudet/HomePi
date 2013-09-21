package controlabledevice;

import java.util.Collection;
import java.util.Map;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:38
 */

public abstract class ControlableDevice {

    protected String name;
    protected boolean isActivate;
    protected Map<String,String> commands;

    public ControlableDevice() {
        //TODO : write ControlableDevice constructor  
    }

    public void activate(){
        isActivate = true;
    }

    public void deactivate(){
        isActivate = false;
    }

    public void addCommand(String commandName, String action){
        commands.put(commandName,action);
    }

    public void removeCommand(String commandName){
        commands.remove(commandName);
    }

    public Collection<String> getCommandsCollection(){
        return commands.keySet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
