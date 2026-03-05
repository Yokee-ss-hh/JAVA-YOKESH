package DesignPatterns.BehavioralDP;

// One object (Subject) maintains a list of dependents (Observers) and automatically notifies them when its state changes.
// Example: YouTube channel notifying its customers
// Subject: YouTube channel
// Observer: Subscribers
// State Change: Uploads new video
// notifyObservers(): push notification to observers

import java.util.ArrayList;
import java.util.List;

interface Subscriber{
    void update(String videoName);
}

interface Channel{
    void subscribeChannel(Subscriber subscriber);
    void unSubscribeChannel(Subscriber subscriber);
    void notifySubscribers();
}

class YouTubeUser implements Subscriber{
    private String name;
    public YouTubeUser(String name) {
        this.name = name;
    }
    @Override
    public void update(String videoTitle) {
        System.out.println(name + " got notification: New video -> " + videoTitle);
    }
}

class YouTubeChannel implements Channel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String channelName;
    private String latestVideo;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribeChannel(Subscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void unSubscribeChannel(Subscriber sub) {
        subscribers.remove(sub);
    }

    public void uploadVideo(String title) {
        this.latestVideo = title;
        System.out.println(channelName + " uploaded: " + title);
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber sub : subscribers) {
            sub.update(latestVideo);
        }
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("CodeWithYokesh");
        Subscriber user1 = new YouTubeUser("Ravi");
        Subscriber user2 = new YouTubeUser("Anjali");
        channel.subscribeChannel(user1);
        channel.subscribeChannel(user2);
        channel.uploadVideo("Observer Pattern Explained");
    }
}
