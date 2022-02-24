public class PlayerScore {	
    private String playerName;          // Name of the player
    private String role;                // Role of player
    private Integer damageDealt;        // Amount of damage dealt
    private Integer damageReceived;     // Amount of damage received
    private Integer healingDone;        // Amount of healing dealt
    private Integer healingReceived;    // Amount of healing received
    private Integer attacks;            // Number of attacks performed
    PlayerScore(String name, String playerRole, int dmgDealt, int dmgReceived, int healDone, int healReceived, int numOfAttacks) {
        playerName = name;
        role = playerRole;
        damageDealt = dmgDealt;
        damageReceived = dmgReceived;
        healingDone = healDone;
        healingReceived = healReceived;
        attacks = numOfAttacks;
    }



    //Getters

    /**
     *  return damage per attack
     * @return
     */
    public Double  getDamagePerAttack(){
        return (double) damageDealt/damageReceived;
    }

    /**
     * return player name
     * @return
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * return player role
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * return damage dealt
     * @return
     */
    public Integer getDamageDealt() {
        return damageDealt;
    }

    /**
     * return damage received
     * @return
     */
    public Integer getDamageReceived() {
        return damageReceived;
    }

    /**
     * return healing done
     * @return
     */
    public Integer getHealingDone() {
        return healingDone;
    }

    /**
     * return healing received
     * @return
     */
    public Integer getHealingReceived() {
        return healingReceived;
    }

    /**
     * return attacks
     * @return
     */
    public Integer getAttacks() {
        return attacks;
    }
}
