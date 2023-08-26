package SolidPrinciples.WithSolid;
interface AudioMediaPlayer{
    void playAudio();
}
interface VideoMediaPlayer{
    void playVideo();
}
class VlcMediaPlayer implements AudioMediaPlayer, VideoMediaPlayer{
    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");
    }
    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");
    }
}
class DivMediaPlayer implements VideoMediaPlayer{
    @Override
    public void playVideo() {
        System.out.println(" Playing video ..........");
    }
}
class MaxMediaPlayer implements AudioMediaPlayer{
    @Override
    public void playAudio() {
        System.out.println(" Playing audio ..........");
    }
}
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        // We divided MediaPlayer interface into 2 small interfaces to fix ISP violation issue
    }
}
