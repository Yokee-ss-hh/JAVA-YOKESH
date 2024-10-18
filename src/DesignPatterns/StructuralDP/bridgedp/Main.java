package org.dsa.structuraldp.bridgedp;

public class Main {
    public static void main(String[] args) {
        Video youtubeVideo = new YoutubeVideo(new HdProcessor());
        youtubeVideo.play("hello.mp4");

        Video netflixVideo = new NetflixVideo(new UltraHDProcessor());
        netflixVideo.play("elephant.mp4");
    }
}
