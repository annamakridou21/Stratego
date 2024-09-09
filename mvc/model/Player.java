package mvc.model;

import java.util.ArrayList;
import java.util.Objects;

import static mvc.controller.Controller.p1;
import static mvc.controller.Controller.p2;
import static mvc.view.View.Blue;
import static mvc.view.View.Red;

public class Player {
    private boolean start;
    private int limit,count;
    public static ArrayList<String> player1Pieces = new ArrayList<>();
    public static ArrayList<String> player2Pieces = new ArrayList<>();

    public Player(){}

    public void init(String col) {
        for(int i=0;i<30;i++) {
            if(Objects.equals(col, "blue")) player1Pieces.add(Blue[i]);
            if(Objects.equals(col, "red")) player2Pieces.add(Red[i]);
        }
    }

        /**
         * Transformer
         * @param l the limits of each Player
         */
    public void setLimit(int l){
        this.limit=l;
    }

    /**
     * Accessor
     * @return the limit of each Player
     */
    public int getLimit(){return this.limit;}

    /**
     * Transformer
     * @param st sets the turn of the player.
     */
    public void setStart(boolean st) {
        this.start=st;
    }
    /**
     * Accessor
     * @return which player's turn is now
     */
    public boolean getStart(){
        return this.start;
    }

    /**
     * Transformer
     * PreCondition:
     * We need to have a counter of the player's saves in order to display them in the Info Menu
     * PostCondition:
     * count how many saves each Player made in total
     * */
    public void saveCount(int count){
        this.count=count;
    }

    /**
     * Transformer
     * PreCondition:
     * We need to have a counter of the player's successful attacks in order to display the percentage in the Info Menu
     * PostCondition:
     * @return how many successful attacks each Player made
     * */
    private void successfulAttacksCount(){}

    /**
     * Transformer
     * PreCondition:
     * We need to have a counter of the player's total attacks in order to display the percentage in the Info Menu
     * PostCondition:
     * @return how many attacks each Player made
     * */
    private void totalAttacksCount(){}

    /**
     * Transformer
     * PreCondition:
     * We need to have a counter of the player's captivities in order to display it in the Info Menu
     * PostCondition:
     * @return how many pieces in captivity each Player has
     * */
    private void captivitiesCount(){}

    /**
     * Accessor
     * @return the saves of each Player
     */
    public int getSaveCount(){return 0;}

    /**
     * Accessor
     * @return the successful attacks of each Player
     */

    public int getSuccessfulAttacks(){return 0;}

    /**
     * Accessor
     * @return the total attacks of each Player
     */
    public int getTotalAttacks(){return 0;}

    /**
     * Accessor
     * @return the captivities of each Player
     */
    public int getCaptivities(){return 0;}
}
