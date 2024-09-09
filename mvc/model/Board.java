package mvc.model;
import java.util.ArrayList;
import static mvc.view.View.Red;
import static mvc.view.View.Blue;

public class Board {
    public static ArrayList<Piece> gamePieces = new ArrayList<>();

    public void initPieces() {
        gamePieces.add(new ImmovablePiece(0, 0, "blue", 6, 0, Blue[0],0));
        gamePieces.add(new ImmovablePiece(0, 1, "blue", 6, 0, Blue[1],0));
        gamePieces.add(new ImmovablePiece(0, 2, "blue", 6, 0, Blue[2],0));
        gamePieces.add(new MovablePiece(0, 3, "blue", 3, 7, Blue[3],0));
        gamePieces.add(new MovablePiece(0, 4, "blue", 4, 2, Blue[4],0));
        gamePieces.add(new ImmovablePiece(0, 5, "blue", 6, 0, Blue[5],0));
        gamePieces.add(new MovablePiece(0, 6, "blue", 2, 6, Blue[6],0));
        gamePieces.add(new MovablePiece(0, 7, "blue", 3, 7, Blue[7],0));
        gamePieces.add(new MovablePiece(0, 8, "blue", 2, 4, Blue[8],0));
        gamePieces.add(new MovablePiece(0, 9, "blue", 4, 2, Blue[9],0));
        gamePieces.add(new ImmovablePiece(1, 0, "blue", 6, 0, Blue[10],0));
        gamePieces.add(new MovablePiece(1, 1, "blue", 5, 3, Blue[11],0));
        gamePieces.add(new MovablePiece(1, 2, "blue", 2, 8, Blue[12],0));
        gamePieces.add(new MovablePiece(1, 3, "blue", 2, 5, Blue[13],0));
        gamePieces.add(new MovablePiece(1, 4, "blue", 4, 2, Blue[14],0));
        gamePieces.add(new MovablePiece(1, 5, "blue", 5, 3, Blue[15],0));
        gamePieces.add(new MovablePiece(1, 6, "blue", 3, 7, Blue[16],0));
        gamePieces.add(new MovablePiece(1, 7, "blue", 2, 6, Blue[17],0));
        gamePieces.add(new ImmovablePiece(1, 8, "blue", 6, 0, Blue[18],0));
        gamePieces.add(new MovablePiece(1, 9, "blue", 4, 2, Blue[19],0));
        gamePieces.add(new MovablePiece(2, 0, "blue", 5, 3, Blue[20],0));
        gamePieces.add(new MovablePiece(2, 1, "blue", 2, 4, Blue[21],0));
        gamePieces.add(new MovablePiece(2, 2, "blue", 1, 1, Blue[22],0));
        gamePieces.add(new MovablePiece(2, 3, "blue", 2, 5, Blue[23],0));
        gamePieces.add(new MovablePiece(2, 4, "blue", 1, 10, Blue[24],0));
        gamePieces.add(new ImmovablePiece(2, 5, "blue", 1, 0, Blue[25],0));
        gamePieces.add(new MovablePiece(2, 6, "blue", 1, 9, Blue[26],0));
        gamePieces.add(new MovablePiece(2, 7, "blue", 5, 3, Blue[27],0));
        gamePieces.add(new MovablePiece(2, 8, "blue", 2, 8, Blue[28],0));
        gamePieces.add(new MovablePiece(2, 9, "blue", 5, 3, Blue[29],0));

        gamePieces.add(new MovablePiece(3, 0, "white", -1, -1, "white1",0));
        gamePieces.add(new MovablePiece(3, 1, "white", -1, -1, "white2",0));
        gamePieces.add(new MovablePiece(3, 2, "yellow", -1, -1, "yellow1",0));
        gamePieces.add(new MovablePiece(3, 3, "yellow", -1, -1, "yellow2",0));
        gamePieces.add(new MovablePiece(3, 4, "white", -1, -1, "white3",0));
        gamePieces.add(new MovablePiece(3, 5, "white", -1, -1, "white4",0));
        gamePieces.add(new MovablePiece(3, 6, "yellow", -1, -1, "yellow3",0));
        gamePieces.add(new MovablePiece(3, 7, "yellow", -1, -1, "yellow4",0));
        gamePieces.add(new MovablePiece(3, 8, "white", -1, -1, "white5",0));
        gamePieces.add(new MovablePiece(3, 9, "white", -1, -1, "white6",0));
        gamePieces.add(new MovablePiece(4, 0, "white", -1, -1, "white7",0));
        gamePieces.add(new MovablePiece(4, 1, "white", -1, -1, "white8",0));
        gamePieces.add(new MovablePiece(4, 2, "yellow", -1, -1, "yellow5",0));
        gamePieces.add(new MovablePiece(4, 3, "yellow", -1, -1, "yellow6",0));
        gamePieces.add(new MovablePiece(4, 4, "white", -1, -1, "white9",0));
        gamePieces.add(new MovablePiece(4, 5, "white", -1, -1, "white10",0));
        gamePieces.add(new MovablePiece(4, 6, "yellow", -1, -1,"yellow7",0));
        gamePieces.add(new MovablePiece(4, 7, "yellow", -1, -1, "yellow8",0));
        gamePieces.add(new MovablePiece(4, 8, "white", -1, -1, "white11",0));
        gamePieces.add(new MovablePiece(4, 9, "white", -1, -1, "white12",0));

        gamePieces.add(new ImmovablePiece(5, 0, "red", 6, 0, Red[0],0));
        gamePieces.add(new ImmovablePiece(5, 1, "red", 4, 2, Red[1],0));
        gamePieces.add(new ImmovablePiece(5, 2, "red", 5, 3, Red[2],0));
        gamePieces.add(new MovablePiece(5, 3, "red", 2, 4, Red[3],0));
        gamePieces.add(new MovablePiece(5, 4, "red", 1, 1, Red[4],0));
        gamePieces.add(new ImmovablePiece(5, 5, "red", 2, 5, Red[5],0));
        gamePieces.add(new MovablePiece(5, 6, "red", 1,10, Red[6],0));
        gamePieces.add(new MovablePiece(5, 7, "red", 1, 1, Red[7],0));
        gamePieces.add(new MovablePiece(5, 8, "red", 1, 9, Red[8],0));
        gamePieces.add(new MovablePiece(5, 9, "red", 5, 3, Red[9],0));
        gamePieces.add(new ImmovablePiece(6, 0, "red", 2, 8, Red[10],0));
        gamePieces.add(new MovablePiece(6, 1, "red", 5, 3, Red[11],0));
        gamePieces.add(new MovablePiece(6, 2, "red", 6, 0, Red[12],0));
        gamePieces.add(new MovablePiece(6, 3, "red", 6, 0, Red[13],0));
        gamePieces.add(new MovablePiece(6, 4, "red", 3, 7, Red[14],0));
        gamePieces.add(new MovablePiece(6, 5, "red", 2, 4, Red[15],0));
        gamePieces.add(new MovablePiece(6, 6, "red", 4, 2, Red[16],0));
        gamePieces.add(new MovablePiece(6, 7, "red", 6, 0, Red[17],0));
        gamePieces.add(new ImmovablePiece(6, 8, "red", 5, 3, Red[18],0));
        gamePieces.add(new MovablePiece(6, 9, "red", 2, 8, Red[19],0));
        gamePieces.add(new MovablePiece(7, 0, "red", 2, 5, Red[20],0));
        gamePieces.add(new MovablePiece(7, 1, "red", 6, 0, Red[21],0));
        gamePieces.add(new MovablePiece(7, 2, "red", 3, 7, Red[22],0));
        gamePieces.add(new MovablePiece(7, 3, "red", 4, 2, Red[23],0));
        gamePieces.add(new MovablePiece(7, 4, "red", 6, 0, Red[24],0));
        gamePieces.add(new ImmovablePiece(7, 5, "red", 2, 6, Red[25],0));
        gamePieces.add(new MovablePiece(7, 6, "red", 4,2, Red[26],0));
        gamePieces.add(new MovablePiece(7, 7, "red", 5, 3, Red[27],0));
        gamePieces.add(new MovablePiece(7, 8, "red", 3, 7, Red[28],0));
        gamePieces.add(new MovablePiece(7, 9, "red", 2, 6, Red[29],0));

    }


}