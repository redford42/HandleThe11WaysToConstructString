package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @author Hanz
 * @date 2020/5/29
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public SlayDragonQuest(String s) {
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
