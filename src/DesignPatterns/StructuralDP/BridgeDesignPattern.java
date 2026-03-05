package DesignPatterns.StructuralDP;

interface Platform{
    void uploadVideo(String videoName);
}
class YouTube implements Platform{
    @Override
    public void uploadVideo(String videoName){
        System.out.println("Uploading "+videoName+" to YouTube!!");
    }
}
class Netflix implements Platform{
    @Override
    public void uploadVideo(String videoName){
        System.out.println("Uploading "+videoName+" to Netflix!!");
    }
}
abstract class Video{
    protected Platform platform; // Any children of Video can set the platform
    Video(Platform platform){
        this.platform=platform;
    }
    abstract void processVideo(String videoFile);
}
class HdVideo extends Video{
    HdVideo(Platform platform) {
        super(platform);
    }
    @Override
    void processVideo(String videoFile) {
        System.out.println("Converting "+videoFile+" to HD");
        platform.uploadVideo(videoFile);
    }
}
class FourKVideo extends Video{
    FourKVideo(Platform platform) {
        super(platform);
    }
    @Override
    void processVideo(String videoFile) {
        System.out.println("Converting "+videoFile+" to 4K");
        platform.uploadVideo(videoFile);
    }
}
public class BridgeDesignPattern {
    // Decouple the abstraction from implementation so that two can vary independently
    // Split "what it is" from "How it works"
    // I make videos in 4K and HD, and I want to stream the same on netflix and YouTube
    // Instead of creating 2 separate videos for 2 platforms, I create 1 video and plug into various platforms
    // Don't create YoutubeVideo class and NetflixVideo class, just create Video class and make a bridge to connect to
    // Netflix and YouTube
    // Implementor: A interface to decide what to do like Platform -> uploadVideo()
    // Concrete Implementor: A class that implements above Implementor
    // Abstraction: A abstract class [middle man(Bridge)] which holds a reference to Implementor
    // Refined Abstraction: Classes extending Abstraction
    public static void main(String[] args) {
        Video youTubeHdVideo = new HdVideo(new YouTube());
        youTubeHdVideo.processVideo("Hello.mp4");

        Video youTube4KVideo = new FourKVideo(new YouTube());
        youTube4KVideo.processVideo("Hello.mp4");

        Video netflixHdVideo = new HdVideo(new Netflix());
        netflixHdVideo.processVideo("Hello.mp4");

        Video netflix4KVideo = new FourKVideo(new Netflix());
        netflix4KVideo.processVideo("Hello.mp4");

        // NOTE: I haven't created 4 classes YouTubeHDVideo, YouTube4KVideo, NetflixHDVideo, Netflix4KVideo
        // Instead, we created YouTube, Netflix, HDVideo and FourKVideo
        // We are decoupling abstraction from implementation, and we are forming a bridge b/w 2 entities, Video & Platform
    }
}
