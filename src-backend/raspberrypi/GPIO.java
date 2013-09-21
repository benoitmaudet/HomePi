package raspberrypi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 14:04
 */



public class GPIO {

    private final Pin gpio_00 = RaspiPin.GPIO_00;
    private final Pin gpio_01 = RaspiPin.GPIO_01;
    private final Pin gpio_02 = RaspiPin.GPIO_02;
    private final Pin gpio_03 = RaspiPin.GPIO_03;
    private final Pin gpio_04 = RaspiPin.GPIO_04;
    private final Pin gpio_05 = RaspiPin.GPIO_05;
    private final Pin gpio_06 = RaspiPin.GPIO_06;
    private final Pin gpio_07 = RaspiPin.GPIO_07;
    private final Pin gpio_08 = RaspiPin.GPIO_08;
    private final Pin gpio_09 = RaspiPin.GPIO_09;
    private final Pin gpio_10 = RaspiPin.GPIO_10;
    private final Pin gpio_11 = RaspiPin.GPIO_11;
    private final Pin gpio_12 = RaspiPin.GPIO_12;
    private final Pin gpio_13 = RaspiPin.GPIO_13;
    private final Pin gpio_14 = RaspiPin.GPIO_14;
    private final Pin gpio_15 = RaspiPin.GPIO_15;
    private final Pin gpio_16 = RaspiPin.GPIO_16;
    private final Pin gpio_17 = RaspiPin.GPIO_17;
    private final Pin gpio_18 = RaspiPin.GPIO_18;
    private final Pin gpio_19 = RaspiPin.GPIO_19;
    private final Pin gpio_20 = RaspiPin.GPIO_20;

    private final GpioController gpio = GpioFactory.getInstance();

    public GPIO() {

    }

    public static void main(String[] args) {

    }
}
