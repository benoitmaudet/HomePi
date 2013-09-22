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
            Thread.sleep(5000);
            RadioController.sendMessage("5510484");
            System.out.println("Start capture");
            System.out.println(RadioController.captureMessage());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
