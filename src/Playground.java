import controller.RadioController;

import java.io.IOException;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 13/09/13
 * Time: 21:52
 */

public class Playground {

    public Playground() {

    }

    public static void main(String[] args) throws InterruptedException{

        System.out.println("Hello world !");
        try {
            RadioController.sendMessage("5510485");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
