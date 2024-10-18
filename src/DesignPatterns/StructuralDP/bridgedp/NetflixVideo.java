package org.dsa.structuraldp.bridgedp;

public class NetflixVideo extends Video{
    public NetflixVideo(VideoProcessor videoProcessor){
        super(videoProcessor);
    }
    @Override
    public void play(String videoFile) {
        videoProcessor.process("Netflix video "+videoFile+" processing");
    }
}
