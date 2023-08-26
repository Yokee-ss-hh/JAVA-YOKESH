package DesignPatterns.BehavioralDP;
// Observer pattern is used when there is one-to-many relationship between objects
// such as if one object is modified, its dependent objects are to be notified automatically.
// In observer pattern, there are many observers (subscriber objects) that are observing a particular
// subject (publisher object). Observers register themselves to a subject to get a notification when
// there is a change made inside that subject.
// A observer object can register or unregister from subject at any point of time.
// It helps is making the objects loosely coupled.

import java.util.ArrayList;
import java.util.List;
/*
Subject: interface or abstract class defining the operations for attaching and de-attaching observers to the subject.
ConcreteSubject: concrete Subject class. It maintains the state of the object and when a change in the state occurs it notifies the attached Observers.
Observer: interface or abstract class defining the operations to be used to notify this object.
ConcreteObserver: concrete Observer implementations.
 */
interface MessageSubject{
     void attach(MessageObserver o);
     void detach(MessageObserver o);
     void notifyUpdate(Message m);
}
class MessagePublisher implements MessageSubject{
    List<MessageObserver> observers = new ArrayList<>();
    @Override
    public void attach(MessageObserver o) {
        observers.add(o);
    }
    @Override
    public void detach(MessageObserver o) {
        observers.remove(o);
    }
    @Override
    public void notifyUpdate(Message m) {
        for(MessageObserver observer: observers){
            observer.update(m);
        }
    }
}
interface MessageObserver
{
    public void update(Message m);
}
class Message
{
    final String messageContent;

    public Message (String m) {
        this.messageContent = m;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
class MessageSubscriberOne implements MessageObserver
{
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
    }
}
class MessageSubscriberTwo implements MessageObserver
{
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());
    }
}class MessageSubscriberThree implements MessageObserver
{
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberThree :: " + m.getMessageContent());
    }
}
public class ObserverDesignPattern {
    public static void main(String[] args) {
        MessageObserver messageSubscriberOne = new MessageSubscriberOne();
        MessageObserver messageSubscriberTwo = new MessageSubscriberTwo();
        MessageObserver messageSubscriberThree = new MessageSubscriberThree();

        MessageSubject messagePublisher = new MessagePublisher();

        messagePublisher.attach(messageSubscriberOne);
        messagePublisher.attach(messageSubscriberTwo);
        messagePublisher.notifyUpdate(new Message("I am yokesh"));

        messagePublisher.detach(messageSubscriberOne);
        messagePublisher.attach(messageSubscriberThree);
        messagePublisher.notifyUpdate(new Message("I am Yokee"));
    }
}
