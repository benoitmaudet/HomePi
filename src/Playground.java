import controlabledevice.RadioDevice;
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
            RadioDevice electricSocket1 = new RadioDevice("Prise1","5510485","5510484");
            RadioDevice electricSocket2 = new RadioDevice("Prise2","5522775","5522772");
            electricSocket2.switchOn();
            Thread.sleep(5000);
            electricSocket2.switchOff();
            System.out.println("Start capture");
            System.out.println(RadioController.captureMessage());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
