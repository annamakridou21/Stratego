package mvc.model;

import javax.swing.*;
import java.util.Objects;

import static java.lang.Math.abs;
import static mvc.model.Board.gamePieces;
import static mvc.view.View.Blue;
import static mvc.view.View.Red;

public class Move {
    /**
     * Observer
     * In this method we implement the first energy, moving.
     * In this method we check if the move that the Player wants to make is acceptable.
     * PreCondition:
     * 1) The position mustn't be diagonally to the position
     * To check this we call method illegalMoves.
     * 2) Only one move can be done in a round, exception:Scout
     * To check this we call method numOfMoves
     * 3) A Piece cannot move in the position of another Piece
     * To check this we call method isFreePosition
     * 4) If the position is one of the forbidden zones, the move cannot be done.
     * To check this we call forbiddenZones
     * 5) We check if traps are blocking our way. If they are, then the game is ***FINISHED*** and we call the method checkIfGameFinished from the controller.
     * To check this we call trapsBlock
     * After checking everything, we call the method moveInBoard from the controller class to change the appearance of the board after moving
     * PostCondition:
     * The Piece implement do all the above.
     */

    public static boolean movePiece(Piece p1,Piece p2){
        return illegalMoves(p1,p2) && numOfMoves(p1,p2)
                && isFreePosition(p2) && forbiddenZones(p2);
    }

    /**
     * Observer
     * PreCondition:
     * In this method we implement the step 1
     * PostCondition:
     * @return true if the piece can move, false if it cannot move
     * */
    public static boolean illegalMoves(Piece p1, Piece p2){
        if (p1.getPositionX()==(p2.getPositionX()+1) && (p1.getPositionY()==(p2.getPositionY()+1))) return false;
        if (p1.getPositionX()==(p2.getPositionX()+1) && (p1.getPositionY()==Math.abs(p2.getPositionY()-1))) return false;
        if (p1.getPositionX()==Math.abs(p2.getPositionX()-1) && (p1.getPositionY()==Math.abs(p2.getPositionY()-1))) return false;
        if (p1.getPositionX()==Math.abs(p2.getPositionX()-1) && (p1.getPositionY()==(p2.getPositionY()+1))) return false;
        return true;
    }

    /**
     * Observer
     * PreCondition:
     * In this method we implement the step 2
     * PostCondition:
     * @return the number of moves.
     * If positionNow-position>1 block away and p1 is a Scout then it can move. Return true.
     * If positionNow-position>1 block away and p1 isn't a Scout then it cannot move. Return false.
     * */
    public static boolean numOfMoves(Piece p1, Piece p2){
        int posX= p1.getPositionX();
        int posY= p1.getPositionY();
        int newX= p2.getPositionX();
        int newY= p2.getPositionY();
            if ((abs(newX-posX)>1) || (abs(newY-posY)>1)) {
                if(Objects.equals(p1.getName(), "scout1R") || Objects.equals(p1.getName(), "scout2R") || Objects.equals(p1.getName(), "scout3R") || Objects.equals(p1.getName(), "scout4R") || Objects.equals(p1.getName(), "scout1B") || Objects.equals(p1.getName(), "scout2B") || Objects.equals(p1.getName(), "scout3B") || Objects.equals(p1.getName(), "scout4B" )) {
                     if(((abs(newX-posX)>1) && newY==posY) || ((abs(newY-posY)>1) && newX==posX)) return true;
                }
                 return false;
            }
        return true;
    }

    /**
     * Observer
     * PreCondition:
     * In this method we implement step 3
     * @param p2 is the place that the piece wants to step into
     * PostCondition:
     * @return true if nobody is currently at this position
     * */
    public static boolean isFreePosition(Piece p2){
        if(Objects.equals(p2.getColor(), "white")) return true;
        return false;
    }

    /**
     * Observer
     * PreCondition:
     * In this method we implement the step 4
     * PostCondition:
     * @return true if the piece isn't trying to step into a forbidden zone
     * */

    public static boolean forbiddenZones(Piece p2) {
        if (Objects.equals(p2.getColor(), "yellow")) return false;
        return true;
    }

    /**
     * Observer
     * PreCondition:
     * @param p1 is the piece that we need to check if it's being blocked.
     * In this method we implement the step 5
     * PostCondition:
     * @return true if the piece isn't being blocked by bombs by front,right,left,behind, returns false if it is blocked
     * from everywhere and the game ***FINISHES***.
     * */
    public static boolean trapsBlock(Piece p1) {
        int front=0,back=0,left=0,right=0;
        for(int i=0; i<gamePieces.size();i++) {
            if(gamePieces.get(i).getPositionX()==(p1.getPositionX()+1) && gamePieces.get(i).getPositionY()==p1.getPositionY()){
                back=i;
            }
            if(gamePieces.get(i).getPositionX()==(p1.getPositionX()-1) && gamePieces.get(i).getPositionY()==p1.getPositionY()){
                front=i;
            }
            if(gamePieces.get(i).getPositionX()==p1.getPositionX() && gamePieces.get(i).getPositionY()==(p1.getPositionY()+1)){
                right=i;
            }
            if(gamePieces.get(i).getPositionX()==p1.getPositionX() && gamePieces.get(i).getPositionY()==(p1.getPositionY()-1)){
                left=i;
            }
        }
        if( (Objects.equals(gamePieces.get(back).getName(), "trap1") || Objects.equals(gamePieces.get(back).getName(), "trap2") || Objects.equals(gamePieces.get(back).getName(), "trap3") || Objects.equals(gamePieces.get(back).getName(), "trap4") || Objects.equals(gamePieces.get(back).getName(), "trap5") || Objects.equals(gamePieces.get(back).getName(), "trap6")) &&
                (Objects.equals(gamePieces.get(front).getName(), "trap1") || Objects.equals(gamePieces.get(front).getName(), "trap2") || Objects.equals(gamePieces.get(front).getName(), "trap3") || Objects.equals(gamePieces.get(front).getName(), "trap4") || Objects.equals(gamePieces.get(front).getName(), "trap5") || Objects.equals(gamePieces.get(front).getName(), "trap6")) &&
                (Objects.equals(gamePieces.get(right).getName(), "trap1") || Objects.equals(gamePieces.get(right).getName(), "trap2") || Objects.equals(gamePieces.get(right).getName(), "trap3") || Objects.equals(gamePieces.get(right).getName(), "trap4") || Objects.equals(gamePieces.get(right).getName(), "trap5") || Objects.equals(gamePieces.get(right).getName(), "trap6")) &&
                (Objects.equals(gamePieces.get(left).getName(), "trap1") || Objects.equals(gamePieces.get(left).getName(), "trap2") || Objects.equals(gamePieces.get(left).getName(), "trap3") || Objects.equals(gamePieces.get(left).getName(), "trap4") || Objects.equals(gamePieces.get(left).getName(), "trap5") || Objects.equals(gamePieces.get(left).getName(), "trap6"))) return false;
        return true;
    }

    /**
     *
     * @param p1
     * @return
     */
    public static boolean immovablePieces(JButton p1) {
        if (Objects.equals(p1.getName(), "white1") || Objects.equals(p1.getName(), "white2") || Objects.equals(p1.getName(), "white3") || Objects.equals(p1.getName(), "white4") || Objects.equals(p1.getName(), "white5") || Objects.equals(p1.getName(), "white6") || Objects.equals(p1.getName(), "white7") || Objects.equals(p1.getName(), "white8") || Objects.equals(p1.getName(), "white9") || Objects.equals(p1.getName(), "white10") || Objects.equals(p1.getName(), "white11") || Objects.equals(p1.getName(), "white12") || Objects.equals(p1.getName(), "yellow1") || Objects.equals(p1.getName(), "yellow2") || Objects.equals(p1.getName(), "yellow3") || Objects.equals(p1.getName(), "yellow4") || Objects.equals(p1.getName(), "yellow5") || Objects.equals(p1.getName(), "yellow6") || Objects.equals(p1.getName(), "yellow7") || Objects.equals(p1.getName(), "yellow8") || Objects.equals(p1.getName(), "trap1B") || Objects.equals(p1.getName(), "trap2B") ||Objects.equals(p1.getName(), "trap3B") ||Objects.equals(p1.getName(), "trap4B") ||Objects.equals(p1.getName(), "trap5B") ||Objects.equals(p1.getName(), "trap6B") ||Objects.equals(p1.getName(), "trap1R") || Objects.equals(p1.getName(), "trap2R") ||Objects.equals(p1.getName(), "trap3R") ||Objects.equals(p1.getName(), "trap4R") ||Objects.equals(p1.getName(), "trap5R") ||Objects.equals(p1.getName(), "trap6R") || Objects.equals(p1.getName(), "flagB.png") ||Objects.equals(p1.getName(), "flagR.png")) return false;
        return true;
    }
}
