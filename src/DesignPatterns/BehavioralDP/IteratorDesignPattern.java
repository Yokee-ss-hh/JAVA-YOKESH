package DesignPatterns.BehavioralDP;

// Provides a way to access elements of a collection sequentially without exposing its underlying structure
// Iterator: A interface defining iterator methods like hasNext(), next()
// Concrete Iterator: A class implementing Iterator interface
// Aggregate: A interface to create an Iterator
// Concrete Aggregate: A class with core logic and a method to return iterator

// Iterator
interface VideoIterator {
    boolean hasNext();
    String next();
}

// Aggregate
interface Playlist {
    VideoIterator createIterator();
}

// Concrete Aggregate
class YouTubePlaylist implements Playlist {
    private String[] videos;
    public YouTubePlaylist(String[] videos) {
        this.videos = videos;
    }
    public String[] getVideos() {
        return videos;
    }
    @Override
    public VideoIterator createIterator() {
        return new PlaylistIterator(this);
    }
}

// Concrete Iterator
class PlaylistIterator implements VideoIterator {
    private YouTubePlaylist playlist;
    private int position = 0;
    public PlaylistIterator(YouTubePlaylist playlist) {
        this.playlist = playlist;
    }
    @Override
    public boolean hasNext() {
        return position < playlist.getVideos().length;
    }
    @Override
    public String next() {
        return playlist.getVideos()[position++];
    }
}
public class IteratorDesignPattern {
    public static void main(String[] args) {
        String[] videos = {"Video1", "Video2", "Video3"};
        YouTubePlaylist playlist = new YouTubePlaylist(videos);
        VideoIterator iterator = playlist.createIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
