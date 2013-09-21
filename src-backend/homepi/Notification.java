package homepi;

import java.util.Date;

/**
 * HomePi
 * Author: Benoît Maudet
 * Date: 14/09/13
 * Time: 15:04
 */

public class Notification {

    private int priority;
    private String message;
    private Date creationDate;
    private int duration;

    public Notification(int priority, String message, Date creationDate, int duration) {
        this.priority = priority;
        this.message = message;
        this.creationDate = creationDate;
        this.duration = duration;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static void main(String[] args) {

    }
}
