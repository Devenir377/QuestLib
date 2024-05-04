package com.scape05.game.entity.player;
import com.scape05.game.content.quests.QuestHandler;
import com.scape05.game.entity.Entity;


public class Player extends Entity {
    private QuestHandler questHandler;

    public Player() {
        questHandler = new QuestHandler();
    }

    public QuestHandler getQuestHandler() {
        return questHandler;
    }
}