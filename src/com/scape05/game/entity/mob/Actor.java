package com.scape05.game.entity.mob;

import com.scape05.game.entity.Entity;
import com.scape05.game.entity.Location;

public class Actor extends Entity {

    private int id;

    /**
     * Constructs a new Actor
     *
     * @param npcId         The id of the mob
     * @param walks         The mob can walk or not
     * @param shouldRespawn The mob should respawn after dying
     * @param location      The location of the mob
     */
    public Actor(int npcId, boolean walks, boolean shouldRespawn, Location location) {
        this.id = npcId;
    }

    public Actor(Entity owner, int npcId, boolean walks, boolean shouldRespawn, Location location) {
        this.id = npcId;
    }


    public int getId() {
        return id;
    }

}
