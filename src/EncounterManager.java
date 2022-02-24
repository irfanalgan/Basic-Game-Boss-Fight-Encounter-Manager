package com.irfankaanalgan;

import java.util.Scanner;

/**
 * main class
 */
public class EncounterManager {
    /**
     * main program
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("WELCOME !");
        EncounterManager initialise = new EncounterManager();
        initialise.menu();
    }
    // we created player objects at the beginning
    Scanner inputScanner = new Scanner(System.in);
    Tank tank = new Tank("Tank",1,100,10,6);
    DamageDealer damageDealer = new DamageDealer("Damage Dealer",1,100,10,7);
    Healer healer = new Healer("Healer",1,100,10,8);
    EnemyEntity enemy = new EnemyEntity(1,100,10);


    /**
     * main menu of the program
     */
    public void menu () {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1) Register entities");
            System.out.println("2) Start encounter");
            System.out.println("3) Exit");
            char choice = sc.next().charAt(0);
            char selection = 'f';
            switch(choice){
                case '1' -> {
                    System.out.println("Select an entity to register: ");
                    System.out.println("\na) Tank");
                    System.out.println("b) Damage Dealer");
                    System.out.println("c) Healer");
                    System.out.println("d) Enemy");
                    char entity = sc.next().charAt(0);
                    int healthPoints;
                    int baseDamage;
                    int characterTrait;
                    switch (entity) {
                        case 'a' -> {
                            System.out.println("Please Enter Tank Health Point: ");
                            healthPoints = inputScanner.nextInt();
                            System.out.println("Please Enter Tank Base Damage: ");
                            baseDamage = inputScanner.nextInt();
                            System.out.println("Please Enter Tank Defence Point: ");
                            characterTrait = inputScanner.nextInt();
                            register(entity,healthPoints,baseDamage,characterTrait);
                        }
                        case 'b' -> {
                            System.out.println("Please Enter Damage Dealer Health Point: ");
                            healthPoints = inputScanner.nextInt();
                            System.out.println("Please Enter Damage Dealer Base Damage: ");
                            baseDamage = inputScanner.nextInt();
                            System.out.println("Please Enter Damage Dealer Intelligence Point: ");
                            characterTrait = inputScanner.nextInt();
                            register(entity,healthPoints,baseDamage,characterTrait);

                        }
                        case 'c' -> {
                            System.out.println("Please Enter Healer Health Point: ");
                            healthPoints = inputScanner.nextInt();
                            System.out.println("Please Enter Healer Base Damage: ");
                            baseDamage = inputScanner.nextInt();
                            System.out.println("Please Enter Healer Mind Point: ");
                            characterTrait = inputScanner.nextInt();
                            register(entity,healthPoints,baseDamage,characterTrait);

                        }
                        case 'd' -> {
                            System.out.println("Please Enter Enemy Health Point: ");
                            healthPoints = inputScanner.nextInt();
                            System.out.println("Please Enter Enemy Base Damage: ");
                            baseDamage = inputScanner.nextInt();
                            spawnEnemy(healthPoints,baseDamage);

                        }
                        default -> System.out.println("Please enter Valid Option");
                    }
                }
                case '2' ->{
                    while(selection != 'e') {
                        if (playersAreAlive()){ // it checks the all players are alive or not if it is false then program will be terminated
                            System.out.println("==========================================");
                            System.out.println("Entities' HP");
                            System.out.println("Tank: " + tank.getHealthPoints());
                            System.out.println("Damage Dealer: " + damageDealer.getHealthPoints());
                            System.out.println("Healer: " + healer.getHealthPoints());
                            System.out.println("Enemy: " + enemy.getHealthPoints());
                            System.out.println("==========================================\n");
                            if (enemyIsAlive()) {
                                Scanner sl = new Scanner(System.in);
                                System.out.println("a) Player attack");
                                System.out.println("b) Player heal");
                                System.out.println("c) Enemy attack");
                                System.out.println("d) Enemy group-wide attack");
                                System.out.println("e) Stop the encounter");
                                selection = sl.next().charAt(0);
                                Scanner ac = new Scanner(System.in);
                                switch (selection) {
                                    case 'a' -> {
                                        System.out.println("Select which player will attack: (t)ank, (d)amage dealer, (h)ealer");
                                        char attackChoice = ac.next().charAt(0);
                                        if (playerIsAlive(attackChoice)) { // it checks the specific player is alive or not if it is false then program will be terminated
                                            playerAttack(attackChoice);
                                        } else {
                                            break;
                                        }
                                    }
                                    case 'b' -> {
                                        System.out.println("Select who will receive the heal: (t)ank, (d)amage dealer, (h)ealer");
                                        char healChoice = ac.next().charAt(0);
                                        if (playerIsAlive(healChoice)) { // it checks the specific player is alive or not if it is false then program will be terminated
                                            if(playerIsAlive('h')){
                                                healPlayer(healChoice);
                                            }
                                            else{
                                                System.out.println("Healer is dead you cannot heal any player!");
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    case 'c' -> {
                                        System.out.println("Select which player you want to attack: (t)ank, (d)amage dealer, (h)ealer");
                                        char enemyAttackChoice = ac.next().charAt(0);
                                        if (playerIsAlive(enemyAttackChoice)) { // it checks the specific player is alive or not if it is false then program will be terminated
                                            enemyAttack(enemyAttackChoice);
                                        } else {
                                            break;
                                        }
                                    }
                                    case 'd' -> {
                                        groupWideAttack();
                                    }
                                    case 'e' -> {

                                    }
                                    default -> System.out.println("Please enter Valid Option");
                                }
                            } else {
                                System.out.println("The enemy is dead. The encounter has ended.");
                                break;
                            }
                        }
                        else{
                            System.out.println("Players are dead");
                            break;
                        }
                    }
                }
                case '3' ->{
                }
                default -> System.out.println("Please enter Valid Option");
            }
            if(choice == '3'){
                break;
            }
        }

    }

    /**
     *
     * @param entity
     * @param healthPoints
     * @param baseDamage
     * @param characterTrait
     */

    public void register(char entity,int healthPoints,int baseDamage,int characterTrait){
        if(entity == 'a'){
            tank.setDefense(characterTrait);
            tank.setRole("Tank");
            tank.setHealthPoints(healthPoints);
            tank.setBaseDamage(baseDamage);
            tank.setMaxHealth(healthPoints);
            System.out.println("Player registered as Tank");

        }
        if(entity == 'b'){
            damageDealer.setIntelligence(characterTrait);
            damageDealer.setRole("Damage Dealer");
            damageDealer.setHealthPoints(healthPoints);
            damageDealer.setBaseDamage(baseDamage);
            damageDealer.setMaxHealth(healthPoints);
            System.out.println("Player registered as Damage Dealer");

        }
        if(entity  == 'c') {
            healer.setMind(characterTrait);
            healer.setRole("Healer");
            healer.setHealthPoints(healthPoints);
            healer.setBaseDamage(baseDamage);
            healer.setMaxHealth(healthPoints);
            System.out.println("Player registered as Healer");
        }
    }

    /**
     * it spawns enemy
     * @param healthPoints
     * @param baseDamage
     */
    public void spawnEnemy(int healthPoints,int baseDamage){
        enemy.setHealthPoints(healthPoints);
        enemy.setBaseDamage(baseDamage);
        System.out.println("Enemy spawned!!");
    }

    /**
     * it checks enemy is alive
     * @return
     */
    boolean enemyIsAlive(){
        if(enemy.getHealthPoints() == 0 || enemy.getHealthPoints() < 0){
            return false;
        }else{
            return true;
        }
    }

    /**
     * it allows to check specific player is alive or not
     * @param Choice
     * @return
     */
    boolean playerIsAlive(char Choice){
        if(Choice == 't' && (tank.getHealthPoints() == 0 || tank.getHealthPoints() < 0)){
            System.out.println("Tank is dead please choose another player");
            return false;
        }
        if(Choice == 'd' && (damageDealer.getHealthPoints() == 0 || damageDealer.getHealthPoints() < 0)){
            System.out.println("Damage Dealer is dead please choose another player");
            return false;
        }
        if(Choice == 'h' && (healer.getHealthPoints() == 0 || healer.getHealthPoints() < 0)){
            System.out.println("Healer is dead please choose another player");
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * it allows to check all player is alive or not
     * @return
     */
    boolean playersAreAlive(){
        if((tank.getHealthPoints() == 0 || tank.getHealthPoints() < 0) && (damageDealer.getHealthPoints() == 0 || damageDealer.getHealthPoints() < 0) && (healer.getHealthPoints() == 0 || healer.getHealthPoints() < 0)){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * it allows player to attack
     * @param attackChoice
     */
    public void playerAttack(char attackChoice){
        if(attackChoice == 't'){
            enemy.takeDamage(tank.dealDamage());
            System.out.println("Tank attacked the enemy ("+ tank.dealDamage() +" damage attack)");
        }else if(attackChoice == 'd'){
            enemy.takeDamage(damageDealer.dealDamage());
            System.out.println("Damage dealer attacked the enemy ("+ damageDealer.dealDamage() +" damage attack)");
        }else if(attackChoice == 'h'){
            enemy.takeDamage(healer.dealDamage());
            System.out.println("Healer attacked the enemy ("+ healer.dealDamage() +" damage attack)");
        }else{
            System.out.println("Please enter Valid Option");
        }
    }

    /**
     * it allows the player to regenerate health
     * @param healChoice
     */
    public void healPlayer(char healChoice){
        int healing = 0;
        if(healChoice == 't'){
            healing = healer.heal(tank.getHealthPoints(),tank.getMaxHealth());//calls the healer heal method with player health points and max health points
            tank.setHealthPoints(tank.getHealthPoints() + healing);
            System.out.println("The tank was healed by " + healing + "HP");
        }else if(healChoice == 'd'){
            healing = healer.heal(damageDealer.getHealthPoints(),damageDealer.getMaxHealth());
            damageDealer.setHealthPoints(damageDealer.getHealthPoints() + healing);
            System.out.println("The damage dealer was healed by " + healing + "HP");
        }else if(healChoice == 'h'){
            healing = healer.heal(healer.getHealthPoints(),healer.getMaxHealth());
            healer.setHealthPoints(healer.getHealthPoints() +healing);
            System.out.println("The healer was healed by " + healing + "HP");
        }else{
            System.out.println("Please enter Valid Option");
        }
    }

    /**
     * it allows to enemy attack
     * @param enemyAttackChoice
     */
    public void enemyAttack(char enemyAttackChoice){
        if(enemyAttackChoice == 't'){
            tank.takeDamage(enemy.dealDamage());
            System.out.println("Tank was attacked by the enemy ("+ enemy.dealDamage() +" damage attack)");
        }else if(enemyAttackChoice == 'd'){
            damageDealer.takeDamage(enemy.dealDamage());
            System.out.println("Damage dealer was attacked by the enemy ("+ enemy.dealDamage() +" damage attack)");
        }else if(enemyAttackChoice == 'h'){
            healer.takeDamage(enemy.dealDamage());
            System.out.println("Healer was attacked by the enemy ("+ enemy.dealDamage() +" damage attack)");
        }else{
            System.out.println("Please enter Valid Option");
        }
    }

    /**
     * it allows to enemy attack to all players
     */
    public void groupWideAttack(){
        tank.takeDamage(enemy.dealDamage());
        damageDealer.takeDamage(enemy.dealDamage());
        healer.takeDamage(enemy.dealDamage());
        System.out.println("Enemy attacked all players ("+ enemy.dealDamage()+" damage attack)");
    }
}
