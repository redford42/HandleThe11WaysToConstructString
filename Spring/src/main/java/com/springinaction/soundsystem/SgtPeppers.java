package com.springinaction.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author Hanz
 * @date 2020/6/2
 */
@Component("lonelyHeartClub")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
