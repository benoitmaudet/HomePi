import homepi.HomePi;
import homepi.Notification;

import java.util.Date;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 13/09/13
 * Time: 21:52
 */

public class Playground {

    public Playground() {

    }

    public static void main(String[] args) {
        System.out.println("Hello world !");
        HomePi homePi = new HomePi();
        Notification notification = new Notification(1,"Nouvelle notification", new Date(),1);
        homePi.getNotificationSystem().addNotification(notification);
    }
}
