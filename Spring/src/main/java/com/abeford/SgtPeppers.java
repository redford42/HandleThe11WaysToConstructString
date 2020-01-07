package com.abeford;

import com.abeford.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Author: HANZ
 * Date: 2020/1/6
 * Time: 22:20
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Black And Red";
    private String artist = "AbeFord";
    public void play() {
        System.out.print("Playing" + title + "by" +artist);
    }
}
