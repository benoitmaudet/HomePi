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

public class InfraRedController extends Controller {

    private final GpioController gpio = GpioFactory.getInstance();
    private final GpioPinDigitalOutput pin0;
    private final GpioPinDigitalOutput pin1;

    public InfraRedController() {
        pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Out_IR");
        pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "In_IR");
    }

    public void sendMessage(){

    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) {

    }
}
