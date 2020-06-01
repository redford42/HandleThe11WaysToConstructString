package com.springinaction.knights;

/**
 * @author Hanz
 * @date 2020/5/29
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest(){
        quest.embark();
    }
}
