package com.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Hanz
 * @date 2020/6/2
 */
public class CDPlayer implements MediaPlayer{
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
