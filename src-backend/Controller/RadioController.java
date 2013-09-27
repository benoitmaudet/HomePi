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

    public static void sendMessage(String message) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("chmod +x /var/www/HomePi/rf_utils/codesend");
            p.waitFor();
            p = Runtime.getRuntime().exec("/var/www/HomePi/rf_utils/codesend " + message);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
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
            String code = line.replace("Received ","");
            if(result.containsKey(code)){
                result.put(code,result.get(code)+1);
            }
            else
            {
                result.put(code, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
