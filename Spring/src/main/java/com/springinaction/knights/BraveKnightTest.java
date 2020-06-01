package com.springinaction.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;

/**
 * @author Hanz
 * @date 2020/5/29
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
