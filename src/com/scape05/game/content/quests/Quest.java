package com.scape05.game.content.quests;


import com.scape05.engine.maploading.RSObject;
import com.scape05.game.content.dialogue.Dialogue;
import com.scape05.game.entity.Entity;
import com.scape05.game.entity.Location;
import com.scape05.game.entity.item.Item;
import com.scape05.game.entity.mob.Actor;
import com.scape05.game.entity.object.GeneratedObject;
import com.scape05.game.entity.player.Player;
import com.scape05.game.entity.storage.Storage;

/**
 * A class containing all functions/API calls.
 * @author Devenir
 */
public abstract class Quest {

	/*
	 *  does not actually mean deprecated in this class. It's just so when auto-generating JavaDoc it ignores .
	 */

	/**
	 * The player doing the quest
	 */
	protected final Player player;

	/**
	 * The constructor of the Quest class
	 * @param player the player doing the quest.
	 */

	protected Quest(Player player) {
		this.player = player;
	}

	/**
	 * Method, which starts the quest, sets the quest stage,
	 * does whatever else needs to be done to start off the quest.
	 */

	public abstract void startQuest();

	/**
	 * Finishes the quest(set stage to 100) add the rewards etc
	 */

	public abstract void finishQuest();

	/**
	 * Contains the number of quest points the quest
	 * gives upon completion.
	 */
	private int questPointsReward;

	/**
	 * Contains the number of the quest id in order from 0 (Black knights fortress)
	 */
	private int identifier;

	/**
	 * The stage the player is up to in a quest.
	 * Ranges from 0-100
	 * (0 being unstarted, 100 being finished)
	 */
	protected int stage;

	/**
	 * Buttons clicked in interfaces
	 * @param button the button ID
	 * @return true if a defined button is clicked.
	 */

	public abstract boolean clickedButton(int button);

	/**
	 * Handles the items on npcs related to the quest
	 */

	public abstract boolean itemOnNPC(Item item, Actor actor, int itemSlot);

	/**
	 * Handles the item on item related to the quest
	 */

	public abstract boolean itemOnItem(Item item1, Item item2);

	/**
	 * Handles the items on npcs related to the quest
	 */

	public abstract boolean itemOnLongDistanceNPC(Item item, Actor actor, int itemSlot);

	/**
	 * Handles the first clicking of npcs related to the quest
	 */

	public abstract boolean handleNpcFirstClick(Actor actor);

	/**
	 * Handles the first clicking of npcs related to the quest at a long/unreachable distance
	 */

	public abstract boolean handleNpcClickLongDistance(Actor actor, int option);

	/**
	 * Handles the second clicking of npcs related to the quest
	 */

	public abstract boolean handleNpcSecondClick(Actor actor);

	/**
	 * Handles the third clicking of npcs related to the quest
	 */

	public abstract boolean handleNpcThirdClick(Actor actor);

	/**
	 * Handles the fourth clicking of npcs related to the quest
	 */

	public abstract boolean handleNpcFourthClick(Actor actor);

	/**
	 * Handles the first clicking of objects related to the quest
	 */

	public abstract boolean firstClickObject(RSObject object);

	/**
	 * Handles the second clicking of objects related to the quest
	 */

	public abstract boolean secondClickObject(RSObject object);

	/**
	 * Handles the third clicking of objects related to the quest
	 */

	public abstract boolean thirdClickObject(RSObject object);

	/**
	 * Handles the fourth clicking of objects related to the quest
	 */

	public abstract boolean fourthClickObject(RSObject object);

	/**
	 * Handles the items on objects related to the quest
	 */

	public abstract boolean itemOnObject(Item item, RSObject object);

	/**
	 * Handles the first clicking of objects that are long distance related to the quest
	 */

	public abstract boolean longDistanceClickObject(RSObject object, int option);

	/**
	 * Handles the items on objects related to the quest
	 */

	public abstract boolean itemOnLongDistanceObject(Item item, RSObject object);

	/**
	 * Handles the items clicked
	 */

	public abstract boolean itemInteraction(Item item, int option, int slot);

	/**
	 * Handles the items clicked
	 */

	public boolean itemOnGeneratedObject(Item item, GeneratedObject object) {
		return false;
	}

	/**
	 * The title of the quest, this appears in the quest
	 * tab of the player client.
	 */
	private String title;

	/**
	 * String array containing the lines in the journal and the quest stage at which they should be revealed.
	 */
	private String[][] journalLines;

	/**
	 * String array containing the lines in the journal in their past tense.
	 */
	private String[][] journalLinesPastTense;

	/**
	 * String array containing the lines in the journal showing the requirements for the quest
	 */
	private String[] requirementsText;

	/**
	 * String array containing locations. Those will need to be highlighted dark red.
	 */
	private String[] keywords;

	/**
	 * The button id pressed to bring up the journal
	 */
	private int journalButtonId;

	/**
	 * The button id pressed to bring up the journal
	 */
	private int journalStringId;

	/**
	 * The quest journal for this quest
	 */
	private QuestJournal journal;

	/**
	 * Gives a reward to the player
	 */

	public abstract void giveReward();

	/**
	 * Void which sets the journal information. This must be
	 * declared if the quest has a journal.
	 *
	 * @param journalStringId   - The journal string id (in quest tab)
	 * @param journalButtonId   - The journal button id
	 * @param requirements  - The requirements text lines
	 * @param journal   - the journal lines
	 * @param journal_past  - the journal lines in past tense
	 * @param keywords  - the highlighted keywords that appear red in the journal
	 */

	public void setJournalInfo(int journalStringId, int journalButtonId, String[] requirements, String[][] journal, String[][] journal_past, String[] keywords) {
		this.journalStringId = journalStringId;
		this.journalButtonId = journalButtonId;
		this.requirementsText = requirements;
		this.journalLines = journal;
		this.journalLinesPastTense = journal_past;
		this.keywords = keywords;
		this.journal = new QuestJournal(player, this, this.title, this.journalLines, this.journalLinesPastTense, this.requirementsText, this.keywords);
	}

	/**
	 * The quest points the quest will give on completion.
	 * @return The number of given quest points.
	 */

	public int getQuestPointsReward() {
		return questPointsReward;
	}

	/**
	 * Used to define the number of quest points given on completion.
	 * @param questPoints The defined number of quest points given.
	 */

	public void setQuestPointsReward(int questPoints) {
		this.questPointsReward = questPoints;
	}

	/**
	 * Every quest is numbered with an identifier. You don't have to worry about this as it is handled by Devenir.
	 * @return the quest identifier
	 */

	public int getIdentifier() {
		return identifier;
	}

	/**
	 * Every quest is numbered with an identifier. You don't have to worry about this as it is handled by Devenir.
	 * @param identifier the quest identifier
	 */

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	/**
	 * Used to get the current quest stage
	 * @return the quest stage the Player is on
	 */
	public int getQuestStage() {
		return stage;
	}

	/**
	 * Sets the quest stage the player is on.
	 * @param stage the quest stage currently on.
	 */
	public void setQuestStage(int stage) {
		this.stage = stage;
	}

	/**
	 * Gets the title of the quest
	 * @return The quest title
	 */

	String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the quest as shown in the quest journal and quest completion interface.
	 * @param title the quest title
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The button that opens the quest journal
	 * @return the defined button to open the journal
	 */

	public int getJournalButtonId() {
		return journalButtonId;
	}

	/**
	 * The button that opens the quest journal
	 * @return the defined button to open the journal
	 */

	public int getJournalStringId() {
		return journalStringId;
	}

	/**
	 * Used to reference to the quest journal. Often used with getJournal().showJournal("journal text") for dynamic journals.
	 * Don't use if you don't know what you're doing.
	 * @return the journal code
	 */

	public QuestJournal getJournal() {
		return journal;
	}

	/**
	 * Gets the dynamic level of a skill. This is the value of a skill that is, for example, effected by potions.
	 * @param skill The skill you're checking. For example, "runecrafting"
	 * @return the dynamic level of the skill
	 */
	public int getDynamicLevel(String skill) {
		return 0;
	}

	/**
	 * Gets the main level of a skill that is not affected by debuffs or buffs.
	 * @param skill The skill you're checking. For example, "woodcutting"
	 * @return The level of the skill
	 */
	public int getStaticLevel(String skill) {
		return 0;
	}

	/**
	 * Plays a sound
	 * @param soundID the sound
	 */
	public void playSound(int soundID) {

	}

	/**
	 * Plays a sound with a delay
	 * @param soundID the sound
	 * @param msDelay the delay in milliseconds
	 */
	public void playSound(int soundID, int msDelay) {

	}

	/**
	 * Plays a sound with a delay and special loop effect.
	 * Some sounds have a "looping" effect like the Ancient teleport spell.
	 * @param soundID the sound
	 * @param msDelay the delay in milliseconds
	 * @param loopEffect the number of "loops"
	 */
	public void playSound(int soundID, int msDelay, int loopEffect) {

	}

	/**
	 * Makes an entity perform an animation.
	 * @param entity The entity (player or actor/npc)
	 * @param animationId the animation ID to play
	 */
	public void animation(Entity entity, int animationId) {

	}

	/**
	 * Makes an entity perform an animation.
	 * @param entity The entity (player or actor/npc)
	 * @param animationId the animation ID to play
	 * @param msDelay the delay in milliseconds before the animation plays
	 */
	public void animation(Entity entity, int animationId, int msDelay) {

	}

	/**
	 * Makes the entity display a graphic like a fire spell or something
	 * @param entity The entity (player or actor/npc)
	 * @param gfxId the graphic id to play
	 */
	public void gfx(Entity entity, int gfxId) {

	}

	/**
	 * Makes the entity display a graphic that has a millisecond delay and a height offset
	 * @param entity the entity (player or actor/npc)
	 * @param gfxId the graphic id to play
	 * @param msDelay the time in milliseconds to wait for graphic to play
	 * @param height the height of the grapic ranging from 0-255
	 */
	public void gfx(Entity entity, int gfxId, int msDelay, int height) {

	}

	/**
	 * Adds experience to a skill
	 * @param xp experience amount
	 * @param skill the skill to recieve xp in
	 */
	public void addXP(double xp, String skill) {

	}

	/**
	 * Checks if the player has an item in their inventory
	 * @param itemID the item id
	 * @return true if player has item
	 */
	public boolean hasItem(int itemID) {
		return true;
	}

	/**
	 * Checks if the player has an item with specified amount in their inventory
	 * @param itemID the item id
	 * @param itemAmount the amount
	 * @return true if player has specified amount of item
	 */
	public boolean hasItemAmount(int itemID, int itemAmount) {
		return true;
	}

	/**
	 * Checks if player has an item in their bank
	 * @param itemID the item id
	 * @return true if player has item
	 */
	public boolean hasItemInBank(int itemID) {
		return true;
	}

	/**
	 * Checks if the player has an item with specified amount in their bank
	 * @param itemID the item id
	 * @param itemAmount the amount
	 * @return true if player has specified amount of item
	 */
	public boolean hasItemAmountInBank(int itemID, int itemAmount) {
		return true;
	}

	/**
	 * Checks if the player is wearing an item
	 * @param itemID the item id
	 * @return true if the player is wearing the specified item
	 */
	public boolean wearingItem(int itemID) {
        return false;
    }

	/**
	 * An action performed when an actor dies
	 * @param actor the actor performing action
	 */

	public abstract void onActorDeath(Actor actor);

	/**
	 * Creates a ground item
	 * @param itemID the item id
	 * @param itemAmount the item amount
	 * @param locationX the x coordinate where the item has to appear
	 * @param locationY the y coordinate where the item has to appear
	 * @param heightLevel the heightlevel where the item has to appear
	 */
	public void createGroundItem(int itemID, int itemAmount, int locationX, int locationY, int heightLevel) {

	}

	/**
	 * Creates a grounditem on the location of an entity (player or actor/npc)
	 * @param entity the entity the item has to spawn under
	 * @param itemID the item id to spawn
	 * @param itemAmount the item amount
	 */
	public void createGroundItem(Entity entity, int itemID, int itemAmount) {

	}

	/**
	 * Checks if the player has inventory space for the item you want to give.
	 * @param itemID the item to give
	 * @param itemAmount the item amount
	 * @return true if player has space for the item.
	 */
	public boolean hasInventorySpaceForItem(int itemID, int itemAmount) {
		return false;
	}

	/**
	 * Gives an item to the player. THIS DOESN'T TAKE FULL INVENTORY INTO CONSIDERATION!!!
	 * To check if the player has space first, you can use the hasInventorySpaceForItem(int itemID, int itemAmount) function.
	 * Or alternatively you could use forceGiveItem(int itemID, int itemAmount)
	 * @param itemID the item id to give
	 */
	public void giveItem(int itemID) {

	}

	/**
	 * Gives an item with specific amount to the player. THIS DOESN'T TAKE FULL INVENTORY INTO CONSIDERATION!!!
	 * To check if the player has space first, you can use the hasInventorySpaceForItem(int itemID, int itemAmount) function.
	 * Or alternatively you could use forceGiveItem(int itemID, int itemAmount)
	 * @param itemID the item id to give
	 */
	public void giveItem(int itemID, int itemAmount) {

	}

	/**
	 * Force gives an item to the player. If the inventory is full, item is dropped to the floor.
	 * @param itemID the item id to add
	 * @param itemAmount the amount
	 */
	public void forceGiveItem(int itemID, int itemAmount) {

	}

	/**
	 * Removes an item from inventory
	 * @param itemID the item id to remove
	 */
	public void removeItem(int itemID) {

	}

	/**
	 * Removes an item with a specific amount from inventory.
	 * @param itemID the item id to remove
	 * @param itemAmount the amount to remove
	 */
	public void removeItem(int itemID, int itemAmount) {

	}

	/**
	 * Sends a message in the chatbox
	 * @param chatboxMessage the message
	 */
	public void print(String chatboxMessage) {

	}

	/**
	 * Sends a message in the chatbox with a gamecycle delay.
	 *
	 * For example, tickDelay 4 means the message will be printed 4 600ms game ticks later.
	 * @param chatboxMessage The message
	 * @param tickDelay the delay of ticks
	 */
	public void printDelayed(String chatboxMessage, int tickDelay) {

	}

	/**
	 * Teleports an entity to a new location.
	 * @param entity the entity (player or actor/npc)
	 * @param destination the destination location
	 */
	public void teleport(Entity entity, Location destination) {

	}

	/**
	 * Teleports an entity to a new location.
	 * @param entity the entity (player or actor/npc)
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param height the height level 0-3
	 */
	public void teleport(Entity entity, int x, int y, int height) {

	}

	/**
	 * Teleports the player to different coordinates
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param heightLevel The height level 0-3
	 */
	public void teleport(int x, int y, int heightLevel) {

	}

	/**
	 * Teleports the player to different coordinates after specified tick delay
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param heightLevel The height level 0-3
	 * @param tickDelay The wait in ticks
	 */
	public void teleportDelayed(int x, int y, int heightLevel, int tickDelay) {

	}

	/**
	 * Sends the quest complete interface
	 * @param title The title of the quest to appear on the interface
	 * @param itemOnInterface The item shown on the interface
	 * @param jingle The ID of the jingle to play when the interface is displayed.
	 *               <a href="https://oldschool.runescape.wiki/w/File:Quest_complete_1.ogg">238</a>
	 *               <a href="https://oldschool.runescape.wiki/w/File:Quest_complete_2.ogg">239</a>
	 *               <a href="https://oldschool.runescape.wiki/w/File:Quest_complete_3.ogg">240</a>
	 * @param rewards text that tells you what you've been awarded.
	 */
	public void sendQuestCompleteInterface(String title, int itemOnInterface, int jingle, String... rewards) {

	}

	/**
	 * Sends the "new" quest complete interface, displaying the given title, rewards, and item on the interface.
	 * @param title The title of the quest that has been completed.
	 * @param itemOnInterface The ID of the item to display on the interface.
	 * @param jingle The ID of the jingle to play when the interface is displayed.
	 *               <a href="https://oldschool.runescape.wiki/w/File:Quest_complete_1.ogg">238</a>
	 *               <a href="https://oldschool.runescape.wiki/w/File:Quest_complete_2.ogg">239</a>
	 *               <a href="https://oldschool.runescape.wiki/w/File:Quest_complete_3.ogg">240</a>
	 * @param rewards The rewards to display on the interface. If no rewards are provided, all reward slots will be left blank.
	 */
	public void sendQuestCompleteInterfaceV2(String title, int itemOnInterface, int jingle, String... rewards) {

	}


	/**
	 * Sends a dialogue. You need to construct it.
	 * Example: sendDialogue(new DemonSlayerDialogues(player, actor))
	 * @param dialogue the dialogue you want to send.
	 */
	public void sendDialogue(Dialogue dialogue) {

	}

	/**
	 * Sends a dialogue with a starting offset.
	 * @param dialogue the dialogue you want to send
	 * @param startOffset the stage you want it to start on
	 */
	public void sendDialogue(Dialogue dialogue, int startOffset) {

	}

	/**
	 * Gets a var from ServerVars class
	 * @param var the var
	 * @return the value of that var
	 */
	public int getVarInt(Storage.Permanent.Var var) {

        return 0;
    }

	/**
	 * Gets a var from the ServerVars class
	 * @param var the var
	 * @return the condition of the var
	 */
	public boolean getVarBoolean(Storage.Permanent.Var var) {

        return false;
    }

	/**
	 * Sets a value on a var from the ServerVars class
	 * @param var the var
	 * @param value the value you want it to be
	 */
	public void setVar(Storage.Permanent.Var var, int value) {

	}

	/**
	 * Sets a condition of a var from the ServerVars class
	 * @param var the var
	 * @param condition the condition true or false
	 */
	public void setVar(Storage.Permanent.Var var, boolean condition) {

	}

	/**
	 * Adjust the value of a var relative to the var's current amount.
	 * @param var the var adjusted
	 * @param amount the amount added or subtracted
	 */
	public void adjustVarValue(Storage.Permanent.Var var, int amount) {

	}

	/**
	 * Makes an entity chat using overhead text
	 * @param chatter the chatting entity. Can be a player or an actor.
	 * @param message the message to chat
	 */
	public void chat(Entity chatter, String message) {

	}

	/**
	 * Gets the distance between two entities
	 * @param a entity a
	 * @param b entity b
	 */
	public int getDistance(Entity a, Entity b) {
		return 0;
	}

	/**
	 * Gets the distance between an entity and object
	 * @param entity entity
	 * @param object object
	 */
	public int getDistance(Entity entity, RSObject object) {
		return 0;
	}

	/**
	 * Gets the distance between two locations
	 * @param x1 the x coordinate for location a
	 * @param y1 the y coordinate for location a
	 * @param x2 the x coordinate for location b
	 * @param y2 the y coordinate for location b
	 * @return
	 */
	public int getDistance(int x1, int y1, int x2, int y2) {
		return 0;
	}

	/**
	 * Checks to see if an entity has vison over the other entity
	 * @param a entity A
	 * @param b entity B
	 * @return true if entity A has vision over entity B
	 */
	public boolean hasVision(Entity a, Entity b) {
		return false;
	}

	/**
	 * Swings the door open and closes automatically.
	 * @param door The door swinging open and closing
	 */
	public void swingDoor(RSObject door) {

	}

	/**
	 * Swings the door open and closes automatically.
	 * This method replaces the door with a different ID when opened.
	 * @param door The door swinging open and closing
	 * @param tempReplacementId The temporary replacement of the door
	 */
	public void swingDoor(RSObject door, int tempReplacementId) {

	}


	public void moveThroughDoor(RSObject door, Location dest, boolean horizontal) {

	}

	/**
	 * Moves you through the door. This does not swing the door open. That is handled separately.
	 * @param door the door object
	 * @param horizontal If you move horizontal. Otherwise, it moves you vertically.
	 */
	public void moveThroughDoor(RSObject door, boolean horizontal) {

	}

	/**
	 * Gets the players current quest points
	 * @return player's current quest points
	 */
	public int getCurrentQuestPoints() {
		return 0;
	}

	/**
	 * Pops up an interface on the game screen.
	 * @param interfaceId the interface id to display.
	 */
	public void showInterface(int interfaceId) {

	}

	/**
	 * Displays an interface in the chat area.
	 * @param chatInterfaceId the interface id to display.
	 */
	public void showChatInterface(int chatInterfaceId) {

	}

	/**
	 * Displays an interface in the tab area.
	 * @param tabInterface the interface id to display.
	 */
	public void showTabInterface(int tabInterface) {

	}

	/**
	 * Overrides text on a child ID of an interface
	 * @param text The text to override with
	 * @param childId the child ID of the overridden text
	 */
	public void adjustInterfaceText(String text, int childId) {

	}

	/**
	 * Wraps journal interface text
	 * @param text The text to wrap
	 * @return the auto-wrapped text
	 */
	public String[] wrapJournalText(String text) {
		return null;
	}

	/**
	 * Executes code at delay
	 *
	 * @param onExecute    code to execute
	 * @param executeDelay the delay (in 600ms ticks) to execute the code
	 */
	public void tick(int executeDelay, Runnable onExecute) {

	}

	/**
	 * Makes/Spawns a new Actor.
	 *
	 * @param npcId         the npc Id the actor should adopt
	 * @param walks         if the actor walks or just stands in one spot
	 * @param respawns      should actor respawn on death?
	 * @param spawnLocation the location the actor spawns
	 * @return The actor instance
	 */
	public Actor spawnActor(int npcId, boolean walks, boolean respawns, Location spawnLocation) {
		return new Actor(npcId, walks, respawns, spawnLocation);
	}

	/**
	 * Makes/Spawns a new Actor with an owner Entity.
	 *
	 * @param owner         The owner entity of an Actor. This could be a player or another actor.
	 * @param npcId         the npc Id the actor should adopt
	 * @param walks         if the actor walks or just stands in one spot
	 * @param respawns      should actor respawn on death?
	 * @param spawnLocation the location the actor spawns
	 * @return The actor instance
	 */
	public Actor spawnActor(Entity owner, int npcId, boolean walks, boolean respawns, Location spawnLocation) {
		return new Actor(owner, npcId, walks, respawns, spawnLocation);
	}

}
