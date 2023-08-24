package DesignPatterns.StructuralDP;
// Bridge Design Pattern says "Decouple an abstraction from its implementation so that the
// two can vary independently"
interface Video{
    void play(String file);
}
interface VideoProcessor{
    void process(String file);
}
interface HdVideoProcessor extends VideoProcessor{
    void hdProcess();
}
interface UltraHdVideoProcessor extends VideoProcessor{
    void ultraHdProcess();
}
class YoutubeVideo implements Video{
    @Override
    public void play(String file) {
        System.out.println(String.format("Playing youtube video from file %s",file));
    }
}
class YoutubeVideoHD extends YoutubeVideo implements HdVideoProcessor{
    @Override
    public void play(String file) {
        process(file);
        System.out.println(String.format("Playing youtube video in HD from file %s",file));
    }

    @Override
    public void process(String file) {
        hdProcess();
    }

    @Override
    public void hdProcess() {
        System.out.println("processing HD video");
    }
}
class YoutubeVideoUltraHd extends YoutubeVideo implements UltraHdVideoProcessor{
    @Override
    public void play(String file) {
        process(file);
        System.out.println(String.format("Playing youtube video in ultra HD from file %s",file));
    }

    @Override
    public void process(String file) {
        ultraHdProcess();
    }

    @Override
    public void ultraHdProcess() {
        System.out.println("processing ultra hd video");
    }
}

// --------------------------------------------------------------------------------
// The problem from above implementation is interfaces and their implementation codes are tightly coupled
// YoutubeVideoHD class is tightly coupled with HdVideoProcessor interface and YoutubeVideoUltraHd class
// is tightly coupled with UltraHdVideoProcessor.
// Instead, we can decouple them as below
interface Video1{
    void play(String file);
}
interface VideoProcessor1{
    void process(String file);
}
interface HdVideoProcessor1 extends VideoProcessor1{
    void hdProcess();
}
interface UltraHdVideoProcessor1 extends VideoProcessor1{
    void ultraHdProcess();
}
class HdVideoProcessor1Impl implements HdVideoProcessor1{
    @Override
    public void process(String file) {
        hdProcess();
    }
    @Override
    public void hdProcess() {
        System.out.println("processing Hd video");
    }
}
class UltraHdVideoProcessor1Impl implements UltraHdVideoProcessor1 {
    @Override
    public void process(String file) {
        ultraHdProcess();
    }
    @Override
    public void ultraHdProcess() {
        System.out.println("processing ultra hd video");
    }
}
class YoutubeVideo1 implements Video1{
    VideoProcessor1 videoProcessor1;
    public YoutubeVideo1(VideoProcessor1 videoProcessor1) {
        this.videoProcessor1 = videoProcessor1;
    }
    @Override
    public void play(String file) {
        videoProcessor1.process(file);
        System.out.println(String.format("Playing youtube video from file %s",file));
    }
}
public class BridgeDesignPattern {
    public static void main(String[] args) {
        System.out.println("------------With Bridge Design Pattern--------------");

        YoutubeVideo y1 = new YoutubeVideoHD();
        y1.play("osaho.mp4");
        YoutubeVideo y2 = new YoutubeVideoUltraHd();
        y2.play("rambo.mp4");

        // Tight coupling between YouTube class and video processor classes

        System.out.println("------------With Bridge Design Pattern--------------");

        YoutubeVideo1 y3 = new YoutubeVideo1(new HdVideoProcessor1Impl());
        y3.play("osaho.mp4");
        YoutubeVideo1 y4 = new YoutubeVideo1(new UltraHdVideoProcessor1Impl());
        y4.play("Bracks.mp4");
        // Loose coupling between YouTube class and video processor classes
    }
}
