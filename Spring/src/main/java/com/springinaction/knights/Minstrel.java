package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @author Hanz
 * @date 2020/6/1
 */
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public Minstrel(String s) {
    }

    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave!");
    }

    public void singAfterQuest() {
        stream.println("Tee hee, the brave knight" + "did embark on a quest!");
    }
}
