package mvc.model;

public class MovablePiece extends Piece {

    /**
     * The construction of the piece depends on the rules that the user chooses. If he chooses Μειωμένος Στρατός we create
     * only 15 pieces for each player.
     * PreCondition:
     * 1) Color should be blue or red.
     * 2) Availability and rank are positive numbers.
     * PostCondition:
     * A piece that meets the requirements above is created.
     *
     * @param x
     * @param y
     * @param color
     * @param availability
     * @param rank
     * @param name
     * @param save
     */
    MovablePiece(int x, int y, String color, int availability, int rank, String name, int save) {
        super(x, y, color, availability, rank, name, save);
    }

    /**
     * Accessor
     * PreCondition:
     * This method should return how many movable pieces have left on the board.
     * PostCondition:
     * @return available movable pieces.
     * If the number that will be returned is 0, then the game is finished.
     * */
    public int getMovables(){return 0;}

}
