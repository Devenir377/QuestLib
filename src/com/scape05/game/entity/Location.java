package com.scape05.game.entity;

import com.scape05.game.entity.storage.Storage;

public class Location {

    public int x;
    public int y;
    public int z;

    public Location(Location other) {
        this(other.x, other.y, other.z);
    }

    public Location(Location other, int z) {
        this(other.x, other.y, z);
    }

    public Location() {
    }

    public Location(int x, int y) {
        this(x, y, 0);
    }

    public Location(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("location=[%d,%d,%d]", x, y, z);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Location p) {
            return x == p.x && y == p.y && z == p.z;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (z << 30) | (y << 15) | x;
    }

    public void set(Location other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    /**
     * Gets the distance between this position and another position. Only X and
     * Y are considered (i.e. 2 dimensions).
     *
     * @param other The other position.
     * @return The distance.
     */
    public int getDistance(Location other) {
        int deltaX = x - other.x;
        int deltaY = y - other.y;
        return (int) Math.ceil(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    }

    /**
     * Gets the region id
     *
     * @return regionId
     */
    public int getRegionId() {
        int regionX = x >> 3;
        int regionY = y >> 3;
        int regionId = (regionX / 8 << 8) + regionY / 8;
        return regionId;
    }

    public Location getRegion() {
        return new Location(this.getBaseSectorX(), this.getBaseSectorY(), z);
    }

    /**
     * This method should only EVER be used to get the new base sector of the players current region **while** Loading - please wait...
     *
     * @return
     */
    public int getBaseSectorX() {
        return (x >> 3) - 6;
    }

    /**
     * This method should only EVER be used to get the new base sector of the players current region **while** Loading - please wait...
     *
     * @return
     */
    public int getBaseSectorY() {
        return (y >> 3) - 6;
    }

    /**
     * Gets the location x for the provided location
     *
     * @param base The location to get the local x for
     * @return
     */
    public int getLocalX(Location base) {
        return x - 8 * base.getBaseSectorX();
    }

    /**
     * Gets the location y for the provided location
     *
     * @param base The location to get the local y for
     * @return
     */
    public int getLocalY(Location base) {
        return y - 8 * base.getBaseSectorY();
    }

    /**
     * Gets the location x for this location
     *
     * @return
     */
    public int getLocalX() {
        return getLocalX(this);
    }

    /**
     * Gets the local y for this location
     *
     * @return
     */
    public int getLocalY() {
        return getLocalY(this);
    }

    /**
     * This location is viewable from the other location
     *
     * @param other The other location
     * @return The location is viewable from this location
     */
    public boolean isViewableFrom(Location other) {
        Location p = delta(this, other);
        return (other.z == z) && (p.x <= 14) && (p.x >= -15) && (p.y <= 14) && (p.y >= -15);
    }

    /**
     * This location is viewable from the other location
     *
     * @param other The other location
     * @return The location is viewable from this location
     */
    public boolean isObjectViewableFrom(Location other) {
        Location p = delta(this, other);
        return (other.z == z) && (p.x <= 64) && (p.x >= -64) && (p.y <= 64) && (p.y >= -64);
    }

    /**
     * This location is viewable from the other location
     *
     * @param other The other location
     * @return The location is viewable from this location
     */
    public boolean isItemViewableFrom(Location other) {
        Location p = delta(this, other);
        return (other.z == z) && (p.x <= 64) && (p.x >= -64) && (p.y <= 64) && (p.y >= -64);
    }

    /**
     * Moves the coordinate by the provided values
     *
     * @param x The amount of x coordinates to move
     * @param y The amount of y coordinates to move
     */
    public void translate(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    /**
     * Gets a new location incremented by the given coordinates.
     *
     * @param x The x-difference.
     * @param y The y-difference.
     * @param z The height difference.
     * @return The location.
     */
    public Location getTranslated(int x, int y, int z) {
        return new Location(this.x + x, this.y + y, this.z + z);
    }

    private Location delta(Location a, Location b) {
        return new Location(b.x - a.x, b.y - a.y);
    }

}
