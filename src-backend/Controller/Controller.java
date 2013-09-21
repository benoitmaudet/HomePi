package controller;

import general.Activable;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:22
 */

public abstract class Controller implements Activable {

    protected Boolean isActivate;

    public Controller() {
        isActivate = true;
    }

    public void activate(){
        isActivate = true;
    }

    public void deactivate(){
        isActivate = false;
    }

    public abstract String toString();
}
