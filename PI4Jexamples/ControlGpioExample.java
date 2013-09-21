// START SNIPPET: control-gpio-snippet

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  ControlGpioExample.java  
 * 
 * This file is part of the Pi4J project. More information about 
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2013 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import homepi.System;

/**
 * This example code demonstrates how to perform simple state
 * control of a raspberrypi.GPIO pin on the Raspberry Pi.
 * 
 * @author Robert Savage
 */
public class ControlGpioExample {
    
    public static void main(String[] args) throws InterruptedException {
        
        homepi.System.out.println("<--Pi4J--> raspberrypi.GPIO Control Example ... started.");
        
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();
        
        // provision gpio pin #04 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.HIGH);
        System.out.println("--> raspberrypi.GPIO state should be: ON");
        
        Thread.sleep(5000);
        
        // turn off gpio pin #04
        pin.low();
        System.out.println("--> raspberrypi.GPIO state should be: OFF");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #04 (should turn on)
        pin.toggle();
        System.out.println("--> raspberrypi.GPIO state should be: ON");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #04  (should turn off)
        pin.toggle();
        System.out.println("--> raspberrypi.GPIO state should be: OFF");
        
        Thread.sleep(5000);

        // turn on gpio pin #04 for 1 second and then off
        System.out.println("--> raspberrypi.GPIO state should be: ON for only 1 second");
        pin.pulse(1000, true); // set second argument to 'true' use a blocking call
        
        // stop all raspberrypi.GPIO activity/threads by shutting down the raspberrypi.GPIO controller
        // (this method will forcefully shutdown all raspberrypi.GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();
    }
}
//END SNIPPET: control-gpio-snippet