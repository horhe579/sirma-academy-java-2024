package com.sirmaacademy.packages.solid.correct.isp.players;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CompletePlayer implements Pausable, Playable, Shuffleable, Skippable {
    private String make;
    private HashMap<String, ArrayList<Song>> songs = new HashMap();

    public CompletePlayer(String make) {
        this.make = make;
    }

    public CompletePlayer(String make, HashMap<String, ArrayList<Song>> songs) {
        this.make = make;
        this.songs = songs;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void addSongToList(Song song)
    {
        String artist = song.getArtist();
        String title = song.getTitle();

        songs.putIfAbsent(artist, new ArrayList<>());
        if(songs.get(artist).stream().filter(s -> title.equals(s.getTitle())).count() == 0)
        {
            songs.get(artist).add(song);
        }
    }

    @Override
    public void pause() {
        if(isEmptyPlaylist())
        {
            System.out.println("Nothing to pause.");
            return;
        }
        System.out.println("Pausing song.");
    }

    @Override
    public void play() {
        if(isEmptyPlaylist())
        {
            System.out.println("Nothing to play.");
            return;
        }
        System.out.println("Playing song.");
    }

    @Override
    public void shuffle() {
        if(isEmptyPlaylist())
        {
            System.out.println("Nothing to shuffle.");
            return;
        }
        System.out.println("Shuffling songs.");
    }

    @Override
    public void next() {
        if(isEmptyPlaylist())
        {
            System.out.println("Nothing to play.");
            return;
        }
        System.out.println("Playing next song.");
    }

    @Override
    public void previous() {
        if(isEmptyPlaylist())
        {
            System.out.println("Nothing to play.");
            return;
        }
        System.out.println("Playing previous song.");
    }

    private boolean isEmptyPlaylist()
    {
        return songs.isEmpty();
    }
}
