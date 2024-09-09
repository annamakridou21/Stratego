package mvc.model;

import java.util.Objects;

public class Save {
    /**
     * Transformer
     * In this method we implement the last energy, saving.
     * Let's suppose that Piece p1 tries to save p2
     * PreCondition:
     * @param p1 is the piece that will save
     * 1) If p1 is a Scout or if p2 is a Flag, the save cannot be done.
     * To implement the above, we call another method checkSave.
     * 2) Each player can save only 2 of its pieces.
     * To check this we call each checkPlayerLimit.
     * 3) Each piece can save only 1 other piece.
     * To check this we call checkPieceLimit
     * PostCondition:
     * The result of this method must either be a save of a piece or the rejection of the save.
     * */
    public static boolean savePiece(Piece p1){
        if(checkSave(p1)) return true;
        else return false;
    }

    /**
     * Observer
     * PreCondition:
     * @param p1 is the piece that will save
     * In this method we implement the step 1
     * PostCondition:
     * @return true if p1 isn't a scout and p2 isn't a flag.
     * */
    private static boolean checkSave(Piece p1){
        if(Objects.equals(p1.getName(), "scout1") || Objects.equals(p1.getName(), "scout2") ||Objects.equals(p1.getName(), "scout3") ||Objects.equals(p1.getName(), "scout4")) return false;
        else return true;
    }

    /**
     * Observer
     * PreCondition:
     * In this method we implement the step 2
     * Invariant: Limit=2
     * PostCondition:
     * @return true if the player can make one more save
     * */
    private boolean checkPlayerLimit(Player p){
        if (p.getLimit()<=2)return true;
        else return false;
    }

    /**
     * Observer
     * PreCondition:
     * In this method we implement the step 3
     * Invariant: Limit=1
     * @return true if the piece hasn't saved any other piece
     * PostCondition:
     * */
    private boolean checkPieceLimit(Piece p){
        if (p.getLimit()<1)return true;
        else return false;
    }
}
