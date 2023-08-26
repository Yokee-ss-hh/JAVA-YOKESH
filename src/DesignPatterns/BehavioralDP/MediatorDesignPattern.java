package DesignPatterns.BehavioralDP;

import java.util.ArrayList;
import java.util.List;

// Mediator helps in establishing loosely coupled communication between objects and helps in reducing the direct references to each other.
// Mediator design pattern is very helpful in an enterprise application where multiple objects are
// interacting with each other. If the objects interact with each other directly, the system components
// are tightly-coupled with each other that makes higher maintainability cost and not hard to extend.
// Mediator pattern focuses on provide a mediator between objects for communication and help in
// implementing lose-coupling between objects.
interface ChatServer{
    void addUser(Participant participant);
    void sendMessage(Participant participant, String message);
}
class OnlineChatServer implements ChatServer{
    List<Participant> participants;
    OnlineChatServer(){
        this.participants = new ArrayList<>();
    }
    @Override
    public void addUser(Participant participant) {
        participants.add(participant);
    }
    @Override
    public void sendMessage(Participant participant, String message) {
        for(Participant p: participants){
            if(participant != p){
                p.receiveMessage(message,participant);
            }
        }
    }
}
class Participant{
    private String userName;
    private ChatServer chatServer;
    Participant(String userName){
        this.userName = userName;
    }
    public void joinGroup(ChatServer chatServer){
        this.chatServer = chatServer;
        chatServer.addUser(this);
    }
    public void sendMessage(String message){
        System.out.println("You are sending message :"+message);
        chatServer.sendMessage(this,message);
    }
    public void receiveMessage(String message, Participant user){
        System.out.println("Received message from "+user.userName+": "+message);
    }
}
public class MediatorDesignPattern {
    public static void main(String[] args) {
        ChatServer chatServer = new OnlineChatServer();
        Participant user1 = new Participant("yokesh");
        Participant user2 = new Participant("kusuma");
        Participant user3 = new Participant("yoki yokee");
        user1.joinGroup(chatServer);
        user2.joinGroup(chatServer);
        user3.joinGroup(chatServer);

        user1.sendMessage("Hi guys, I am yokesh");

        user2.sendMessage("Hey Yokesh How are you");

        user1.sendMessage("I am fine");

        user3.sendMessage("em andaru tinnara");
    }
}
