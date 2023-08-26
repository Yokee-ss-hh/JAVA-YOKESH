package SolidPrinciples.WithoutSolid;
// The Interface Segregation Principle states that clients should not be forced to implement interfaces
// they don't use. ISP splits interfaces that are very large into smaller and more specific ones so that
// clients will only have to know about the methods that are of interest to them.
interface MediaPlayer{
    void playAudio();
    void playVideo();
}
class VlcMediaPlayer implements MediaPlayer {
    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");
    }

    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");
    }
}
class DivMediaPlayer implements MediaPlayer{
    @Override
    public void playAudio() {
        throw new UnsupportedOperationException("DivMediaPlayer don't support playing audio files");
    }

    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");
    }
}
class MaxMediaPlayer implements MediaPlayer{
    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");
    }
    @Override
    public void playVideo() {
        throw new UnsupportedOperationException("MaxMediaPlayer don't support playing video files");
    }
}
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        // The above code violates interface segregation principle
        // VlcMediaPlayer is not violating ISP because VLC supports all methods from MediaPlayer interface
        // DivMediaPlayer and MaxMediaPlayer are violating ISP as 1 does not support audio files
        // and another does not support video files.
        // Even though DivMediaPlayer and MaxMediaPlayer classes not supporting 1 method each, we are
        // forcing them to implement respective methods by implementing MediaPlayer interface which
        // violates ISP
    }
}
