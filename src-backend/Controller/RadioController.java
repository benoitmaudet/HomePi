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
        Process p = Runtime.getRuntime().exec("sudo rf_utils/send " + message);
        p.waitFor();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
        String line = reader.readLine();
        while (line != null) {
            line = reader.readLine();
        }
    }

    public static void main(String[] args) {

    }
}
