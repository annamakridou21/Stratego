package mvc.model;
import java.util.Objects;

public class Attack {
    /**
     * Observer
     * In this method we implement the second energy, attacking. The Piece with the highest rank wins.
     * PreCondition:
     * @param p1 is the piece that will attack
     * @param p2 is the piece that is being attacked
     * Firstly we call checkIfIsEnemy to ensure that the Piece attacks to an opponent's Piece.
     * Then we need to ensure that the attack can be done. 2 things must be checked.
     *                i)A piece cannot attack if it's a Flag or a Bomb.
     *                ii)A piece cannot attack if the other piece is more than one block away but not diagonally.
     * To check i) we call checkIfFlagOrBomb
     * To check ii) we call checkIfClose
     * If everything is ok then we can move to attacking.
     * 1) If the attacker wins, the method removeAndReplace of the Controller class is called, because we need to change the graphics in the board.
     * To check this we call attackerWins
     * 2) If the player that is being attacked wins, he stays in the same position.
     * To check this we call attackedWins
     * 3) If someone,exception:Dwarf, attacks the Bomb, he loses the fight.
     * To check this we call bombAttack
     * 4) If a Slayer attacks a Dragon he wins, despite his lower rank. We call the method removeAndReplace.
     * To check this we call checkIfSlayerAttacksDragon
     * 5) If both pieces have the same rank, then we remove them from the board. We call removeAndReplace method
     * (we replace their buttons with an empty space in the board)
     * To check this we call sameRank
     * PostCondition:
     * Be able to attack based on the rules above
     * */
    public static boolean attackPiece(Piece p1, Piece p2){
        if(!Objects.equals(p1.getColor(), "white") && !Objects.equals(p2.getColor(), "white")) {
            if (checkIfIsEnemy(p1, p2) && checkIfClose(p1, p2) && checkIfFlagOrTrap(p1)) return true;
            else return false;
        }
        return true;
    }

    /**
     * Observer
     * PreCondition:
     * @param p1 is the piece that will attack
     * @param p2 is the piece that is being attacked
     * We need to ensure that Pieces do not attack their teammates
     * PostCondition:
     * @return true if p1 and p2 are enemies, false otherwise.
     * */
    public static boolean checkIfIsEnemy(Piece p1, Piece p2){
        if (Objects.equals(p1.getColor(), p2.getColor())) return false;
        return true;
    }

    /**
     * Observer
     * PreCondition:
     * @param p1 is the piece that will attack
     * We need to ensure that the pieces flag, trap cannot attack
     * PostCondition:
     * @return true if p1 isn't a flag or a trap, false otherwise.
     * */
    public static boolean checkIfFlagOrTrap(Piece p1){
        if (Objects.equals(p1.getName(), "flagB.png") || Objects.equals(p1.getName(), "flagR.png") ||Objects.equals(p1.getName(), "trap1") || Objects.equals(p1.getName(), "trap2") || Objects.equals(p1.getName(), "trap3") || Objects.equals(p1.getName(), "trap4") || Objects.equals(p1.getName(), "trap5") || Objects.equals(p1.getName(), "trap6") ) return false;
        else return true;
    }

    /**
     * Observer
     * PreCondition:
     * We need to ensure that p2 is one block away from p1.
     * PostCondition:
     * @return true if p2 is one block away and not diagonally from p1 and false otherwise.
     * */
    public static boolean checkIfClose(Piece p1, Piece p2){
        if( (p1.getPositionX()==p2.getPositionX() && p1.getPositionY()==p2.getPositionY()+1) || (p1.getPositionX()==p2.getPositionX() && p1.getPositionY()==p2.getPositionY()-1)
            || (p1.getPositionY()==p2.getPositionY() && p1.getPositionX()==p2.getPositionX()+1) || (p1.getPositionY()==p2.getPositionY() && p1.getPositionX()==p2.getPositionX()-1))
        return true;
        else return false;
    }

    /**
     * Observer
     * PreCondition:
     * @param p1 is the piece that will attack
     * @param p2 is the piece that is being attacked
     * In this method we implement the step 1,3,4
     * PostCondition:
     * @return true if the attacker wins
     * */
    public static boolean attackerWins(Piece p1, Piece p2) {
        if (p1.getRank() > p2.getRank()) {
            return true;
        }
        return false;
    }
    /**
     * Observer
     * PreCondition:
     * @param p1 is the piece that will attack
     * @param p2 is the piece that is being attacked
     * In this method we implement the step 2
     * PostCondition:
     * @return true if the attacked wins
     * If the attacked piece is the Flag then the game is ***FINISHED***. In this case we call the method checkIfGameFinished from the Controller.
     * */
    public static boolean attackedWins(Piece p1, Piece p2) {
        if (p2.getRank() > p1.getRank()) {
            return true;
           // if (Objects.equals(p2.getName(), "flagR.png") || Objects.equals(p2.getName(), "flagB.png")) return true;
        }
        else return false;
    }

    /**
     * Observer
     * PreCondition:
     * @param p1 is the piece that will attack
     * @param p2 is the piece that is being attacked
     * In this method we implement the step 5
     * PostCondition:
     * @return true if both pieces p1,p2 have the same rank.
     * */
    public static boolean sameRank(Piece p1, Piece p2) {
        if (p1.getRank() == p2.getRank()) {
            return true;
        } else return false;
    }
}
