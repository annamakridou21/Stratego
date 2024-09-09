package mvc.view;

public class Statistics {
    /**
     * PreCondition:
     * We check which player's turn it is. Then we call all the methods below.
     * When the turn changes we display the stats of the other player etc.
     * PostCondition:
     * Show the statistics of each player on his turn.
     * */
    public void showPlayerStats(){}
    /**
     * Accessor
     * @param successfulAttacks is the number of successful attacks of each player
     * @param total the total amount of attacks
     * @return percentage of successful attacks , succefulAttacks/total
     */
    private double showSuccessfulAttacks(int successfulAttacks,int total) {return 0;}

    /**
     * Accessor
     * @param saves is number of saves for each player
     * @return number of saves
     */
    private int showSaves(int saves){return 0;}

    /**
     * Accessor
     * @param rounds is number of rounds for each player
     * @return number of rounds
     */
    private int showRounds(int rounds){return 0;}
}