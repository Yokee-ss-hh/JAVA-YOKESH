package org.dsa.structuraldp.bridgedp;

public abstract class Video {
    VideoProcessor videoProcessor;
    public Video(VideoProcessor videoProcessor){
        this.videoProcessor = videoProcessor;
    }
    public abstract void play(String videoFile);
}
