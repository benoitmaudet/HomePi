package homepi;

import java.util.Collection;
import java.util.HashSet;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:05
 */

public class NotificationSystem extends System {

    private Collection<Notification> notifications;
    private Boolean ledIsActive;


    public NotificationSystem() {
       notifications = new HashSet<Notification>();
       ledIsActive = true;
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

    public static void main(String[] args) {

    }
}
