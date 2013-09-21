import com.pi4j.io.gpio.*;

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
//        HomePi homePi = new HomePi();
//        Notification notification = new Notification(1,"Nouvelle notification", new Date(),1);
//        homePi.getNotificationSystem().addNotification(notification);

        System.out.println("<--Pi4J--> raspberrypi.GPIO Control Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #04 as an output pin and turn on
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.HIGH);
        System.out.println("--> raspberrypi.GPIO state should be: ON");

        Thread.sleep(15000);

        // turn off gpio pin #04
        pin3.low();
        pin4.low();
        pin5.low();
        System.out.println("--> raspberrypi.GPIO state should be: OFF");

        Thread.sleep(15000);

        // toggle the current state of gpio pin #04 (should turn on)
        pin5.toggle();
        pin4.toggle();
        pin3.toggle();
        System.out.println("--> raspberrypi.GPIO state should be: ON");

        Thread.sleep(15000);

        // toggle the current state of gpio pin #04  (should turn off)
        pin5.toggle();
        pin4.toggle();
        pin3.toggle();
        System.out.println("--> raspberrypi.GPIO state should be: OFF");

        Thread.sleep(15000);

        // turn on gpio pin #04 for 1 second and then off
        System.out.println("--> raspberrypi.GPIO state should be: ON for only 1 second");
        pin3.pulse(1000, true); // set second argument to 'true' use a blocking call
        pin4.pulse(1000, true); // set second argument to 'true' use a blocking call
        pin5.pulse(1000, true); // set second argument to 'true' use a blocking call

        // stop all raspberrypi.GPIO activity/threads by shutting down the raspberrypi.GPIO controller
        // (this method will forcefully shutdown all raspberrypi.GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();
    }
}
