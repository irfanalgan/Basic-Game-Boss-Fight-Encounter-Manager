package com.irfankaanalgan;

/**
 * enemy class
 */
class EnemyEntity implements PotencyCalculator{
    private int entityID;
    private int healthPoints;
    private int baseDamage;

    /**
     * default constructor of enemy
     */
    public EnemyEntity() {
    }

    /**
     * constructor of enemy
     * @param entityID
     * @param healthPoints
     * @param baseDamage
     */
    public EnemyEntity(int entityID, int healthPoints, int baseDamage) {
        this.entityID = entityID;
        this.healthPoints = healthPoints;
        this.baseDamage = baseDamage;
    }

    @Override
    public int dealDamage() {
        return baseDamage;
    }

    @Override
    public void takeDamage(int damage) {
        this.healthPoints = this.healthPoints - damage;
    }

    /**
     * getter health points of enemy
     * @return
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * setter health points of enemy
     * @param healthPoints
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * setter base damage of enemy
     * @param baseDamage
     */
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}
