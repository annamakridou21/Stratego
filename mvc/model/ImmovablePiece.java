package mvc.model;

public class ImmovablePiece extends Piece {
    private final int x=0,y=0;

    /**
     * The construction of the piece depends on the rules that the user chooses. If he chooses Μειωμένος Στρατός we create
     * only 15 pieces for each player.
     * PreCondition:
     * 1) Color should be blue or red.
     * 2) Availability and rank are positive numbers.
     * PostCondition:
     * A piece that meets the requirements above is created.
     * @param x
     * @param y
     * @param color
     * @param availability
     * @param rank
     * @param name
     * @param save
     */
    ImmovablePiece(int x, int y, String color, int availability, int rank, String name, int save) {
        super(x, y, color, availability, rank, name, save);
    }
}

