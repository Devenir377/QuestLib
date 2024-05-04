package com.scape05.game.content.dialogue;

import com.scape05.game.entity.mob.Actor;
import com.scape05.game.entity.player.Player;

public abstract class Dialogue {

    protected int stage;

    protected Player player;

    protected Actor actor;

    /**
     * Sets the player instance. For back-end use only.
     * @param player the player
     */
    @Deprecated
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Sends or re-sends the current stage the dialogue is in.
     * Can be used in clickButton in combination with next(); or goTo(stage);
     */
    public abstract void handleStaging();

    /**
     * Handles interface buttons in the current dialogue.
     * @param id the button id
     * @return return true if your condition meets for a button. Should make it return false by default!
     */
    public abstract boolean clickButton(int id);

    /**
     * Goes to the next stage in dialogue
     */
    protected void next() {
        stage++;
    }

    /**
     * Goes to the previous stage in the dialogue
     */
    protected void previous() {
        stage--;
    }

    /**
     * Instead of next(); you could use goTo(stage); to go to a different stage instead of just the next one.
     * @param stage the stage to go to
     */
    public void goTo(int stage) {
        this.stage = stage;
    }

    /**
     * Instead of next(); you could use goTo(stage); to go to a different stage instead of just the next one.
     * @param stage the stage to go to
     */
    public void next(int stage) {
        this.stage = stage;
    }

    /**
     * Ends the dialogue
     */
    protected void end() {
        stage = -1;
    }

    /**
     * Ends and force close any dialogue or interface that is open
     */
    protected void closeDialogue() {
        stage = -1;
    }

    /**
     * Gets the current stage the dialogue is in.
     * @return current stage
     */
    public int currentStage() {
        return stage;
    }

    protected void npc(Actor actor, Mesanim mesanim, String message) {

    }

    /**
     * New way of sending npc dialogue using a different actor from the constructor that doesn't auto-wrap.
     * @param actor the actor
     * @param mesanim the emotion
     * @param message the message
     */
    protected void npcNoWrap(Actor actor, Mesanim mesanim, String... message) {

    }

    /**
     * New way of sending npc dialogue using the actor from the constructor.
     * @param mesanim the emotion
     * @param message the message
     */
    protected void npc(Mesanim mesanim, String message) {

    }

    /**
     * New way of sending npc dialogue that doesn't auto wrap, using the actor from the constructor.
     * @param mesanim the emotion
     * @param message the message
     */
    protected void npcNoWrap(Mesanim mesanim, String... message) {

    }

    /**
     * New way of sending player dialogue
     * @param mesanim the emotion
     * @param message the message
     */
    protected void player(Mesanim mesanim, String message) {

    }

    /**
     * New way of sending player dialogue that doesn't auto-wrap.
     * @param mesanim the emotion
     * @param message the message
     */
    protected void playerNoWrap(Mesanim mesanim, String... message) {

    }


    /**
     * Sends dialogue that auto wraps
     * @param mesanim
     * @param message
     */
    @Deprecated
    protected void sendWrap(Mesanim mesanim, String message) {

    }

    /**
     * Sends dialogue for an acor
     * @param actor the actor
     * @param mesanim the emotion
     * @param message the message
     */
    @Deprecated
    protected void sendWrap(Actor actor, Mesanim mesanim, String message) {

    }

    @Deprecated
    protected void send(Actor actor, Mesanim mesanim, String... lines) {

    }
    @Deprecated
    protected void send(Mesanim mesanim, String... lines) {

    }

    private boolean opButtons;
    private int op1;
    private int op2;
    private int op3;
    private int op4;
    private int op5;

    /**
     * Sends an option message with built-in goTo()
     * @param goto1 the stage the dialogue has to go if option 1 is clicked
     * @param goto2 the stage the dialogue has to go if option 2 is clicked
     * @param mes1 option 1
     * @param mes2 option 2
     */
    protected void op(int goto1, int goto2, String mes1, String mes2) {

    }

    /**
     * Sends an option message with built-in goTo()
     * @param goto1 the stage the dialogue has to go if option 1 is clicked
     * @param goto2 the stage the dialogue has to go if option 2 is clicked
     * @param goto3 the stage the dialogue has to go if option 3 is clicked
     * @param mes1 option 1
     * @param mes2 option 2
     * @param mes3 option 3
     */
    protected void op(int goto1, int goto2, int goto3, String mes1, String mes2, String mes3) {

    }

    /**
     * Sends an option message with built-in goTo()
     * @param goto1 the stage the dialogue has to go if option 1 is clicked
     * @param goto2 the stage the dialogue has to go if option 2 is clicked
     * @param goto3 the stage the dialogue has to go if option 3 is clicked
     * @param goto4 the stage the dialogue has to go if option 4 is clicked
     * @param mes1 option 1
     * @param mes2 option 2
     * @param mes3 option 3
     * @param mes4 option 4
     */
    protected void op(int goto1, int goto2, int goto3, int goto4, String mes1, String mes2, String mes3, String mes4) {

    }

    /**
     * Sends an option message with built-in goTo()
     * @param goto1 the stage the dialogue has to go if option 1 is clicked
     * @param goto2 the stage the dialogue has to go if option 2 is clicked
     * @param goto3 the stage the dialogue has to go if option 3 is clicked
     * @param goto4 the stage the dialogue has to go if option 4 is clicked
     * @param goto5 the stage the dialogue has to go if option 5 is clicked
     * @param mes1 option 1
     * @param mes2 option 2
     * @param mes3 option 3
     * @param mes4 option 4
     * @param mes5 option 5
     */
    protected void op(int goto1, int goto2, int goto3, int goto4, int goto5, String mes1, String mes2, String mes3, String mes4, String mes5) {

    }

    /**
     * Internal function
     */
    @Deprecated
    public void optionButtons(int button) {

    }


    /**
     * Sends the select option dialogue.
     * You can have up to 5 options
     * @param options The options to display
     */
    protected void op(String... options) {

    }

    @Deprecated
    protected void sendOption(String... options) {

    }

    @Deprecated
    protected void sendOptionTitle(String title, String... options) {

    }

    /**
     * Sends a message/statement without any dialogue heads
     * @param message the message
     */
    protected void mes(String message) {

    }

    /**
     * Sends a message/statement that doesn't auto wrap.
     * @param message the message displayed
     */
    protected void mesNoWrap(String... message) {

    }

    /**
     * Sends a book interface
     * @param title The title of the book
     * @param hasPreviousPage if the current two pages has a previous button
     * @param hasNextPage if the current two pages has a next button
     * @param text the text on the current two pages
     */
    protected void book(String title, boolean hasPreviousPage, boolean hasNextPage, String text) {

    }

    /**
     * Sends a big book interface
     * @param title The title of the book
     * @param hasPreviousPage If the current two pages has a previous button
     * @param hasNextPage If the current two pages has a next button
     * @param pageNumLeft Current page number on the left side
     * @param pageNumRight Current page number on the right side
     * @param text the text on the current two pages
     */
    protected void bigBook(String title, boolean hasPreviousPage, boolean hasNextPage, int pageNumLeft, int pageNumRight, String text) {

    }

    @Deprecated
    protected void sendStatementWrap(String message) {

    }

    @Deprecated
    protected void sendStatement(String... lines) {

    }

    /**
     * Sends an information box like the one on tutorial island
     * @param title The title text
     */
    protected void sendInformationBox(String title, String line1, String line2, String line3, String line4) {

    }

    /**
     * Sends a statement/message with an item displayed on the left.
     * @param item the item id
     * @param lines the message to display
     */
    protected void mesItem(int item, String lines) {

    }

    /**
     * Moves the item on message/statement up or down
     * @param x X-axis (left/right)
     * @param y Y-axis (up/down)
     */
    protected void moveMesItem(int x, int y) {

    }

    /**
     * Moves the item on message/statement up or down
     * @param x1 X-axis (left/right) for the first item
     * @param y1 Y-axis (up/down) for the first item
     * @param x2 X-axis (left/right) for the second item
     * @param y2 Y-axis (up/down) for the second item
     */
    protected void moveMesItem(int x1, int y1, int x2, int y2) {

    }

    /**
     * Sends a statement/message that doesn't auto-wrap with an item displayed on the left.
     * @param item the item id
     * @param lines the message to display
     */
    protected void mesItemNoWrap(int item, String... lines) {
        sendItemStatement(item, lines);
    }

    private int componentId;
    private int componentId2;
    private int displayedItem;
    private int displayedItem2;
    @Deprecated
    protected void sendItemStatementWrap(int item, String message) {

    }

    @Deprecated
    protected void sendItemStatement(int item, String... line) {

    }

    /**
     * Message/Statement that displays two items on the left side.
     * @param item item 1
     * @param item2 item 2
     * @param message the displayed message
     */
    protected void mesItemTwo(int item, int item2, String message) {

    }

    /**
     * Message/Statement that doesn't auto-wrap and displays two items on the left side.
     * @param item item 1
     * @param item2 item 2
     * @param message the displayed message
     */
    protected void mesItemTwoNoWrap(int item, int item2, String... message) {

    }

    @Deprecated
    protected void sendTwoItemsStatementWrap(int item, int item2, String message) {

    }

    @Deprecated
    protected void sendTwoItemsStatement(int item, int item2, String... line) {

    }

    /**
     * Sends two pages on the book interface
     * @param hasNext if it has a next page or not
     * @param hasPrevious if it has a previous page or not
     * @param title the title of the book
     * @param lines the lines on the pages
     */
    protected void sendBook(boolean hasNext, boolean hasPrevious, String title, String... lines) {

    }

    /**
     * Sends two pages in a bigger book interface.
     * @param hasNext if the book has a next page
     * @param hasPrevious if the book has a previous page
     * @param title the title of the book
     * @param leftPageNum the page number on the left side of the book
     * @param rightPageNum the page number on the right side of the book
     * @param lines the lines on the two pages
     */
    protected void sendBigBook(boolean hasNext, boolean hasPrevious, String title, String leftPageNum, String rightPageNum, String... lines) {

    }

}
