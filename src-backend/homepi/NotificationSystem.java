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

    private static Collection<Notification> notifications;
    private Boolean ledIsActive;
    private LedController ledController;


    public NotificationSystem() {
       notifications = new HashSet<Notification>();
       ledIsActive = true;
       ledController = new LedController();
    }

    public void addNotification(Notification notification){
        notifications.add(notification);
    }

    public void removeNotification(Notification notification){
        notifications.remove(notification);
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
                    case 0 : ledController.setColor("green");
                        break;
                    case 1 : ledController.setColor("blue");
                        break;
                    case 2 : ledController.setColor("red");
                        break;
                }
                try {
                    ledController.switchOnForInterval();
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) {

    }


}
