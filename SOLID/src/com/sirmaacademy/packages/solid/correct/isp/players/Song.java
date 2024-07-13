package com.sirmaacademy.packages.solid.correct.isp.players;

public class Song {
    private String title;
    private String artist;
    private int lengthInSeconds;

    public Song(String title, String artist, int lengthInSeconds) {
        this.title = title;
        this.artist = artist;
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
}
