package DesignPatterns.CreationalDP;
// Define an interface for creating an object, but let the sub classes that implement
// the interface decide which class to instantiate.
// The Factory method lets a class defer instantiation to subclasses.
// There will be only 1 factory in this pattern

// -----------------Factory Design Pattern using Abstract classes------------------
interface Notification{
    String sendNotification(String message);
}
class SmsNotification implements Notification{
    @Override
    public String sendNotification(String message) {
        return String.format("%s sent successfully",message);
    }
}
class PushNotification implements Notification{
    @Override
    public String sendNotification(String message) {
        return String.format("%s sent successfully",message);
    }
}
enum NotificationEnum{
    PUSH, SMS
}
class NotificationFactory{
    public static Notification notificationType(NotificationEnum notificationEnum){
        if(notificationEnum == NotificationEnum.PUSH){
            return new PushNotification();
        }
        else{
            return new SmsNotification();
        }
    }
}
public class FactoryDesignPattern {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.notificationType(NotificationEnum.PUSH);
        System.out.println(notification1.getClass());
        System.out.println(notification1.sendNotification("This is test notification via push notification"));

        Notification notification2 = NotificationFactory.notificationType(NotificationEnum.SMS);
        System.out.println(notification2.getClass());
        System.out.println(notification2.sendNotification("This is test notification via sms notification"));
    }
}
