package homepi;

import general.Activable;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:31
 */

public abstract class System implements Activable {

    protected Boolean isActivate;

    public System() {
        //TODO : write homepi.System constructor
    }

    public void activate(){
        isActivate = true;
    }

    public void deactivate(){
        isActivate = false;
    }

    public abstract String toString();
}
