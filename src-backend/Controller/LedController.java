package controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:04
 */

public class LedController extends Controller{

    private static String color;
    private static final GpioController gpio = GpioFactory.getInstance();
    private static final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Red_LED");;
    private static final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Blue_LED");;
    private static final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Green_LED");;

    public LedController() {

    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        LedController.color = color;
    }

    public static void flash(){
        pin3.pulse(1000, true); // set second argument to 'true' use a blocking call
        pin4.pulse(1000, true); // set second argument to 'true' use a blocking call
        pin5.pulse(1000, true); // set second argument to 'true' use a blocking call
    }

    public static void switchOn() throws Exception {
//        if(isActivate){
            if(color.equals("red")){
                pin3.high();
            } else if (color.equals("blue")) {
                pin4.high();
            } else if (color.equals("green")) {
                pin5.high();
            }
            else
            {
                throw new Exception("Couleur non comprise en compte");
            }
            //TODO : add others colors
//        }
    }

    public static void switchOff(){
        pin3.low();
        pin4.low();
        pin5.low();
    }

//    public void switchOnForInterval() throws Exception {
//        if(isActivate){
//            if(color.equals("red")){
//                pin3.pulse(interval, true);
//            } else if (color.equals("blue")) {
//                pin4.pulse(interval, true);
//            } else if (color.equals("green")) {
//                pin5.pulse(interval, true);
//            }
//            else
//            {
//                throw new Exception("Couleur non comprise en compte");
//            }
//            //TODO : add others colors
//        }
//    }
//
//    public void switchOff(){
//        pin3.low();
//        pin4.low();
//        pin5.low();
//    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) {
        // stop all raspberrypi.GPIO activity/threads by shutting down the raspberrypi.GPIO controller
        // (this method will forcefully shutdown all raspberrypi.GPIO monitoring threads and scheduled tasks)
       // gpio.shutdown();
    }
}
