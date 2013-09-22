package homepi;

import controller.LedController;

import java.util.Collection;
import java.util.HashSet;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:05
 */

public class NotificationSystem extends System implements Runnable {

    private static Collection<Notification> notifications = new HashSet<Notification>();
    private static Boolean ledIsActive = true;

    public NotificationSystem() {
    }

    public void addNotification(Notification notification){
        notifications.add(notification);
    }

    public void removeNotification(Notification notification){
        notifications.remove(notification);
    }

    public void removeAllNotification(){
        notifications = new HashSet<Notification>();;
    }

    public int getNumberOfNotification(){
        return notifications.size();
    }

    public void deleteAllNotifications(){
        for(Notification notification : notifications){
            notifications.remove(notification);
        }
    }

    public void activateLedNotification(){
        ledIsActive = true;
    }

    public void deactivateLedNotification(){
        ledIsActive = false;
    }

    public Boolean ledNotificationIsActive(){
         return ledIsActive;
    }

    @Override
    public String toString() {
        return "homepi.NotificationSystem{" +
                "notifications=" + notifications +
                ", ledIsActive=" + ledIsActive +
                '}';
    }

    @Override
    public void run() {
        while (isActivate){
            if(notifications.size() > 0 ){
                int priority = 0;
                for(Notification notification : notifications){
                    if(notification.getPriority()>priority){
                        priority = notification.getPriority();
                    }
                }
                switch (priority){
                    case 0 : LedController.flashGreen();
                        break;
                    case 1 : LedController.flashBlue();
                        break;
                    case 2 : LedController.flashRed();
                        break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public static void main(String[] args) {

    }


}
