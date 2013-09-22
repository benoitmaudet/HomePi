package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

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
        Process p = Runtime.getRuntime().exec("chmod +x /var/www/HomePi/rf_utils/codesend");
        p.waitFor();
        p = Runtime.getRuntime().exec("/var/www/HomePi/rf_utils/codesend " + message);
        p.waitFor();
    }

    public static HashMap<String, Integer> captureMessage() throws IOException, InterruptedException {
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        Process p = Runtime.getRuntime().exec("chmod +x /var/www/HomePi/rf_utils/RFSniffer");
        p.waitFor();
        p = Runtime.getRuntime().exec("/var/www/HomePi/rf_utils/RFSniffer");
        p.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ( (line = buf.readLine() ) != null )
        {
            if(result.containsKey(line)){
                result.put(line,result.get(line)+1);
            }
            else
            {
                result.put(line, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
