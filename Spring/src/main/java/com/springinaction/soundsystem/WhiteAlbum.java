package com.springinaction.soundsystem;

/**
 * @author Hanz
 * @date 2020/6/2
 */
public class WhiteAlbum implements CompactDisc{
    private String title = "WhiteAlbum";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
