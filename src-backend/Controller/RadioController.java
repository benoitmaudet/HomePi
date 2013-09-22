package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:02
 */

public class RadioController extends Controller{

    public RadioController() {

    }

    @Override
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void sendMessage(String message) throws IOException, InterruptedException {
        System.out.println("In");
        Process p = Runtime.getRuntime().exec("chmod +x /var/www/HomePi/rf_utils/codesend");
        p.waitFor();
        p = Runtime.getRuntime().exec("/var/www/HomePi/rf_utils/codesend " + message);
        p.waitFor();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
        String line = reader.readLine();
        System.out.println(line);
        while (line != null) {
            line = reader.readLine();
            System.out.println(line);
        }
    }

    public static void main(String[] args) {

    }
}
