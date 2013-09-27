package controlabledevice;

import controller.RadioController;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:42
 */

public class RadioDevice extends ControlableDevice  {

    private String name;
    private String onCode;
    private String offCode;

    public RadioDevice(String name, String onCode, String offCode) {
        this.name = name;
        this.onCode = onCode;
        this.offCode = offCode;
    }

    public String toString() {
        //TODO : write RadioDevice toString method 
        return null;
    }

    public void switchOn(){
        RadioController.sendMessage(onCode);
    }

    public void switchOff(){
        RadioController.sendMessage(offCode);
    }

    public static void main(String[] args) {

    }
}
