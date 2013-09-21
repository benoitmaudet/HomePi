package homepi;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:00
 */

public class HomePi {

    private NotificationSystem notificationSystem;
    private LightSystem lightSystem;

    public HomePi() {
        notificationSystem= new NotificationSystem();
        lightSystem = new LightSystem();

    }

    public NotificationSystem getNotificationSystem() {
        return notificationSystem;
    }

    public LightSystem getLightSystem() {
        return lightSystem;
    }

    public static void main(String[] args) {

    }
}
