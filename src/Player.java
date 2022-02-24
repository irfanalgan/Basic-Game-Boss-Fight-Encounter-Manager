package com.irfankaanalgan;

/**
 * player class
 */
abstract class Player implements PotencyCalculator{
    protected String role;
    protected int entityID;
    protected int healthPoints;
    protected int baseDamage;
    protected int maxHealth;

    /**
     * default constructor of Player
     */
    public Player() {
    }

    /**
     * constructor of Player
     * @param role
     * @param entityID
     * @param healthPoints
     * @param baseDamage
     */
    public Player(String role, int entityID, int healthPoints, int baseDamage) {
        this.role = role;
        this.entityID = entityID;
        this.healthPoints = healthPoints;
        this.baseDamage = baseDamage;
        this.maxHealth = healthPoints;
    }

    /**
     * getter role of player
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * getter entity ID of player
     * @return
     */
    public int getEntityID() {
        return entityID;
    }

    /**
     * getter max health of player
     * @return
     */
    public int getMaxHealth(){return maxHealth;}

    /**
     * setter max health of player
     * @param health
     */
    public void setMaxHealth(int health){this.maxHealth = health; }

    /**
     * setter role of player
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * getter health poinst of player
     * @return
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * setter health points of player
     * @param healthPoints
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * getter base damaage of player
     * @return
     */
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * setter base damage of player
     * @param baseDamage
     */
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}

/**
 * tank class
 */
class Tank extends Player {
    private int defense;

    /**
     * constructor of tank
     * @param role
     * @param entityID
     * @param healthPoints
     * @param baseDamage
     * @param defense
     */
    public Tank(String role, int entityID, int healthPoints, int baseDamage, int defense){
        super(role,entityID,healthPoints,baseDamage);
        this.defense = defense;
    }

    /**
     *
     * @return
     */
    @Override
    public int dealDamage() {
        return baseDamage;
    }

    /**
     *
     * @param damage
     */
    @Override
    public void takeDamage(int damage) {
        this.healthPoints = this.healthPoints- (damage - defense);
    }

    /**
     * getter defence of tank
     * @return
     */
    public int getDefense() {
        return defense;
    }

    /**
     * setter defence of tank
     * @param defense
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
}

/**
 * damage Dealer class
 */
class DamageDealer extends Player {
    private int intelligence;

    /**
     * constructor of damage dealer
     * @param role
     * @param entityID
     * @param healthPoints
     * @param baseDamage
     * @param intelligence
     */
    public DamageDealer(String role, int entityID, int healthPoints, int baseDamage,int intelligence){
        super(role,entityID,healthPoints,baseDamage);
        this.intelligence = intelligence;
    }
    @Override
    public int dealDamage() {
        return baseDamage + intelligence;
    }

    @Override
    public void takeDamage(int damage) {
        this.healthPoints = this.healthPoints - damage;
    }

    /**
     * getter intelligence of damage dealer
     * @return
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * setter intelligence of damage dealer
     * @param intelligence
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

/**
 * healer class
 */
class Healer extends Player {
    private int mind;

    /**
     * constructor of healer
     * @param role
     * @param entityID
     * @param healthPoints
     * @param baseDamage
     * @param mind
     */
    public Healer(String role, int entityID, int healthPoints, int baseDamage,int mind){
        super(role,entityID,healthPoints,baseDamage);
        this.mind = mind;
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
     * heal other player
     * @return
     */
    public int heal(int health,int healthMax){
        if((health+ mind + 10) > healthMax){
            return healthMax - health;
        }
        else{
            return mind + 10;
        }
    }

    /**
     * getter mind of healer
     * @return
     */
    public int getMind() {
        return mind;
    }

    /**
     * setter mind of healer
     * @param mind
     */
    public void setMind(int mind) {
        this.mind = mind;
    }
}
