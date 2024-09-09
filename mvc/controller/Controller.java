package mvc.controller;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import mvc.model.*;
import mvc.view.View;
import javax.swing.*;

import static mvc.model.Board.gamePieces;
import static mvc.model.Player.player1Pieces;
import static mvc.model.Player.player2Pieces;
import static mvc.view.View.*;

public class Controller {
    public static Player p1;
    public static Player p2;
    static Board board;
    static View view;

    public static void main(String[] args) throws IOException {
        Controller c = new Controller();
        c.initialize();
        view.pack();
    }
    /**
     * Transformer
     * Invariants: Players=2, Board=1
     * PreCondition:
     * We need 2 players and 30 pieces in order to start the game with the classic rules.
     * PostCondition:
     * Initializes the game with 2 players, 30 pieces for each player.
     */
    public void initialize() throws IOException {
        board = new Board();
        p1 = new Player();
        p2 = new Player();
        p1.init("blue");
        p2.init("red");
        board.initPieces();
        view = new View();
        view.setVisible(true);
    }
    /**
     * Transformer
     * PreCondition:
     * @param selectedButton is the attacker
     * @param but is the piece that is being attacked
     * @param p1 is the first player with the blue pieces
     * @param p2 is the second player with the red pieces
     * @param k index of attacker
     * @param l index of the piece that is being attacked
     * @param a index
     * @param b index
     * PostCondition:
     * The aim of this method is to portray the result of a move in the board(view)
     * */
    public static void movePlayer(JButton selectedButton, JButton but, Player p1, Player p2,int k, int l,int a,int b){
        String s = selectedButton.getName();
        Icon i = selectedButton.getIcon();
        selectedButton.setName(but.getName());
        selectedButton.setIcon(view.getImageBack());                    //gia na metakinhthei o paixths an to but einai aspro tote metakineitai sto aspro koumpi kai vazoume thn eikona tou selectedbutton sth thesh tou but
        selectedButton.setBorder(BorderFactory.createLineBorder(Color.black));
        but.setIcon(i);
        but.setName(s);
        int x = gamePieces.get(k).getPositionX();
        int y = gamePieces.get(k).getPositionY();               //ananewnoume to position tou paikth epeidh metakinhthike se neo shmeio
        gamePieces.get(k).setPosition(gamePieces.get(l).getPositionX(), gamePieces.get(l).getPositionY());
        gamePieces.get(l).setPosition(x, y);
        p1.setStart(false);                 //allagh seiras paiktwn
        p2.setStart(true);

        //DIASWSH MPLE OMADAS

        if (gamePieces.get(k).getPositionX() == 7) {                //an exei ftasei sth prwth seira tou antipalou ksekinaei h diaswsh
            if (Save.savePiece(gamePieces.get(k))) {
                gamePieces.get(k).setSave(gamePieces.get(k).getSave()+1);               //count tis diaswseis
                for (int o = a; o < b; o++) {
                    if (Objects.equals(gamePieces.get(o).getColor(), "white")) {            //topothetw to pioni pou tha swthei se mia white thesh dhladh adeia
                        int newX=gamePieces.get(o).getPositionX();                          //ananewnw to position tou pioniou pou epestrepse
                        int newY=gamePieces.get(o).getPositionX();
                        if(a==0) {
                            for (int j = a; j < b; j++) {
                                if (gamePieces.get(j).getAvailability() == -1 && gamePieces.get(j).getRank() == -1) {
                                    if(!Objects.equals(gamePieces.get(j).getName(), "trap1B") || !Objects.equals(gamePieces.get(j).getName(), "trap2B") || !Objects.equals(gamePieces.get(j).getName(), "trap3B") || !Objects.equals(gamePieces.get(j).getName(), "trap4B") || !Objects.equals(gamePieces.get(j).getName(), "trap5B") || !Objects.equals(gamePieces.get(j).getName(), "trap6B")) {
                                        pi[o].setName(Blue[j]);                     //an den einai pagida tote to vazw sto tamplo.auto giati h pagida den epitrepetai na diaswthei
                                        pi[o].setIcon(view.getImageBlue(j));
                                        gamePieces.get(j).setPosition(newX, newY);                  //thetw to position
                                        gamePieces.get(j).setColor("blue");
                                        gamePieces.get(j).setName(Blue[j]);
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                        else {                                      //omoia diadikasia me th parapanw alla gia th kokkinh omada
                            for (int j = a; j < b; j++) {
                                if (gamePieces.get(j).getAvailability() == -1 && gamePieces.get(j).getRank() == -1) {
                                    if(!Objects.equals(gamePieces.get(j).getName(), "trap1R") || !Objects.equals(gamePieces.get(j).getName(), "trap2R") || !Objects.equals(gamePieces.get(j).getName(), "trap3R") || !Objects.equals(gamePieces.get(j).getName(), "trap4R") || !Objects.equals(gamePieces.get(j).getName(), "trap5R") || !Objects.equals(gamePieces.get(j).getName(), "trap6R")) {
                                        pi[o].setName(Red[j - 50]);
                                        pi[o].setIcon(view.getImageRed(j));
                                        gamePieces.get(j).setPosition(newX, newY);
                                        gamePieces.get(j).setColor("red");
                                        gamePieces.get(j).setName(Red[j-50]);
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    /**
     * Transformer
     * PreCondition:
     * @param selectedButton is the attacker
     * @param but is the piece that is being attacked
     * @param p1 is the first player with the blue pieces
     * @param p2 is the second player with the red pieces
     * @param k index of attacker
     * @param l index of the piece that is being attacked
     * @param message is the message that shows the winner
     * @param slayer1 is the image of the slayer in order to code the restrictions
     * @param slayer2 is the image of the slayer
     * @param dragon1 is the image of the dragon
     * @param dragon2 is the image of the dragon
     * @param flag is the image of the flag
     * PostCondition:
     * The aim of this method is to portray the result of an attack in the board(view)
      * */

    public static void attackPlayer(JButton selectedButton, JButton but, Player p1, Player p2,int k, int l,String message,String slayer1, String dragon1, String slayer2,String dragon2,String flag) throws IOException {
        //EKSOUDETERWSH MPLE PAGIDAS APO KOKKINO NANO
        if(Objects.equals(gamePieces.get(k).getColor(), "blue")) {
            if(Objects.equals(gamePieces.get(l).getName(), "trap1R") ||Objects.equals(gamePieces.get(l).getName(), "trap2R") ||Objects.equals(gamePieces.get(l).getName(), "trap3R") ||Objects.equals(gamePieces.get(l).getName(), "trap4R") ||Objects.equals(gamePieces.get(l).getName(), "trap5R") || Objects.equals(gamePieces.get(l).getName(), "trap6R")){
                if(Objects.equals(gamePieces.get(k).getName(), "dwarf1B") ||Objects.equals(gamePieces.get(k).getName(), "dwarf2B") ||Objects.equals(gamePieces.get(k).getName(), "dwarf3B") ||Objects.equals(gamePieces.get(k).getName(), "dwarf4B") ||Objects.equals(gamePieces.get(k).getName(), "dwarf5B")) {
                    but.setIcon(selectedButton.getIcon());
                    but.setName(selectedButton.getName());              //o nanos eksoudeterwnei th pagida dhladh pairnei th thesh ths sto tamplo
                    int x = gamePieces.get(k).getPositionX();
                    int y = gamePieces.get(k).getPositionY();
                    gamePieces.get(k).setPosition(gamePieces.get(l).getPositionX(), gamePieces.get(l).getPositionY());
                    gamePieces.get(l).setPosition(x, y);
                    for(int i=0;i<player1Pieces.size();i++) {
                        if(Objects.equals(player1Pieces.get(i), gamePieces.get(l).getName())) {
                            player1Pieces.remove(i);
                            break;
                        }
                    }
                }
                else {                                                  //an opoiodhpote pioni epitethei sth pagida tote feugei apo to tamplo kai h pagida paramenei sth thesh ths
                    selectedButton.setIcon(view.getImageBack());
                    gamePieces.get(k).setColor("white");
                    gamePieces.get(k).setRank(-1);
                    gamePieces.get(k).setAvailability(-1);
                    for(int i=0;i<player1Pieces.size();i++) {
                        if(Objects.equals(player1Pieces.get(i), gamePieces.get(k).getName())) {
                            player1Pieces.remove(i);
                            break;
                        }
                    }
                }
            }
        }
        //EKSOUDETERWSH KOKKINHS PAGIDAS APO MPLE NANO
        if(Objects.equals(gamePieces.get(k).getColor(), "red")) {
            if(Objects.equals(gamePieces.get(l).getName(), "trap1B") ||Objects.equals(gamePieces.get(l).getName(), "trap2B") ||Objects.equals(gamePieces.get(l).getName(), "trap3B") ||Objects.equals(gamePieces.get(l).getName(), "trap4B") ||Objects.equals(gamePieces.get(l).getName(), "trap5B") || Objects.equals(gamePieces.get(l).getName(), "trap6B")){
                if(Objects.equals(gamePieces.get(k).getName(), "dwarf1R") ||Objects.equals(gamePieces.get(k).getName(), "dwarf2R") ||Objects.equals(gamePieces.get(k).getName(), "dwarf3R") ||Objects.equals(gamePieces.get(k).getName(), "dwarf4R") ||Objects.equals(gamePieces.get(k).getName(), "dwarf5R")) {
                    but.setIcon(selectedButton.getIcon());
                    but.setName(selectedButton.getName());
                    int x = gamePieces.get(k).getPositionX();
                    int y = gamePieces.get(k).getPositionY();
                    gamePieces.get(k).setPosition(gamePieces.get(l).getPositionX(), gamePieces.get(l).getPositionY());
                    gamePieces.get(l).setPosition(x, y);
                    for(int i=0;i<player2Pieces.size();i++) {
                        if(Objects.equals(player2Pieces.get(i), gamePieces.get(l).getName())) {
                            player2Pieces.remove(i);
                            break;
                        }
                    }
                }
                else {
                    selectedButton.setIcon(view.getImageBack());
                    gamePieces.get(k).setColor("white");
                    gamePieces.get(k).setRank(-1);
                    gamePieces.get(k).setAvailability(-1);
                    for(int i=0;i<player2Pieces.size();i++) {
                        if(Objects.equals(player2Pieces.get(i), gamePieces.get(k).getName())) {
                            player2Pieces.remove(i);
                            break;
                        }
                    }
                }
            }
        }
        //EPITHESH PERIPTWSH 1: IDIA KATATAKSH
            if (Attack.sameRank(gamePieces.get(k), gamePieces.get(l))) {
                selectedButton.setIcon(view.getImageBack());            //afaireitai kai to selected kai to but apo to tamplo, epeidh exoun idia katataksh
                but.setIcon(view.getImageBack());
                selectedButton = but;
                if(Objects.equals(gamePieces.get(k).getColor(), "blue")){
                    for(int i=0;i<player1Pieces.size();i++) {
                        if(Objects.equals(player1Pieces.get(i), gamePieces.get(k).getName())) {
                            player1Pieces.remove(i);                //afairountai ta pionia apo to arraylist kathe paikth
                            break;
                        }
                    }
                    for(int i=0;i<player2Pieces.size();i++) {
                        if(Objects.equals(player2Pieces.get(i), gamePieces.get(l).getName())) {
                            player2Pieces.remove(i);
                            break;
                        }
                    }
                }
                else if(Objects.equals(gamePieces.get(k).getColor(), "red")) {
                    for(int i = 0; i<player2Pieces.size(); i++) {
                        if(Objects.equals(player2Pieces.get(i), gamePieces.get(k).getName())) {
                            player2Pieces.remove(i);
                            break;
                        }
                    }
                    for(int i = 0; i<player1Pieces.size(); i++) {
                        if(Objects.equals(player1Pieces.get(i), gamePieces.get(l).getName())) {
                            player1Pieces.remove(i);
                            break;
                        }
                    }
                }
                gamePieces.get(k).setColor("white");
                gamePieces.get(k).setRank(-1);
                gamePieces.get(k).setAvailability(-1);              //thetw to availability -1 etsi wste na gnwrizw poia pionia exoun xathei gia na ta diaswsw ustera
                gamePieces.get(l).setColor("white");
                gamePieces.get(l).setRank(-1);
                gamePieces.get(l).setAvailability(-1);
            }
            //EPITHESH PERIPTWSH 2: O AMUNOMENOS KERDIZEI
            if (Attack.attackedWins(gamePieces.get(k), gamePieces.get(l))) {
                if ((Objects.equals(gamePieces.get(k).getName(), slayer1) && Objects.equals(gamePieces.get(l).getName(), dragon1))) {
                    but.setIcon(selectedButton.getIcon());                  //eksairesh: an o slayer epithethei se drako ton kerdizei kai pairnei th thesh tou
                    but.setName(selectedButton.getName());              //se kathe allh periptwsh otan o amunomenos kerdizei paramenei sthn idia thesh kai to pioni pou ekane thn epithesh apoxwrei apo to tamplo
                    selectedButton.setIcon(view.getImageBack());
                    selectedButton = but;
                    int x = gamePieces.get(k).getPositionX();
                    int y = gamePieces.get(k).getPositionY();
                    gamePieces.get(k).setPosition(gamePieces.get(l).getPositionX(), gamePieces.get(l).getPositionY());
                    gamePieces.get(l).setPosition(x, y);
                    if(Objects.equals(gamePieces.get(k).getColor(), "blue")){
                        for(int i=0;i<player1Pieces.size();i++) {
                            if(Objects.equals(player1Pieces.get(i), gamePieces.get(l).getName())) {
                                player1Pieces.remove(i);
                                break;
                            }
                        }
                    }
                    else if(Objects.equals(gamePieces.get(k).getColor(), "red")) {
                        for(int i = 0; i<player2Pieces.size(); i++) {
                            if(Objects.equals(player2Pieces.get(i), gamePieces.get(l).getName())) {
                                player2Pieces.remove(i);
                                break;
                            }
                        }
                    }
            }
            else {
                    if(Objects.equals(gamePieces.get(k).getColor(), "blue")){
                        for(int i=0;i<player1Pieces.size();i++) {
                            if(Objects.equals(player1Pieces.get(i), gamePieces.get(k).getName())) {
                                player1Pieces.remove(i);
                                break;
                            }
                        }
                    }
                    else if(Objects.equals(gamePieces.get(k).getColor(), "red")) {
                        for(int i = 0; i<player2Pieces.size(); i++) {
                            if(Objects.equals(player2Pieces.get(i), gamePieces.get(k).getName())) {
                                player2Pieces.remove(i);
                                break;
                            }
                        }
                    }
                selectedButton.setIcon(view.getImageBack());
                selectedButton = but;
                gamePieces.get(k).setColor("white");
                gamePieces.get(k).setRank(-1);
                gamePieces.get(k).setAvailability(-1);
            }
        }
        //EPITHESH PERIPTWSH 3: O EPITITHEMENOS KERDIZEI
        if (Attack.attackerWins(gamePieces.get(k), gamePieces.get(l))) {
            if(checkIfGameFinished(l,flag)){
                System.out.println(message);        //ama h epithesh ginetai se shmaia tote exoume katakthsh shmaias pou sunepagetai lhksh tou paixnidiou
                System.exit(0);
            }
            if(Objects.equals(gamePieces.get(k).getName(), dragon2) && Objects.equals(gamePieces.get(l).getName(), slayer2)) {
                but.setIcon(selectedButton.getIcon());
                but.setName(selectedButton.getName());                  //ama o drakos epitithetai se slayer kerdizei. h antitheth periptwsh apotelei mia eksairesh kai fainetai parakatw
                selectedButton.setIcon(view.getImageBack());
                int x = gamePieces.get(k).getPositionX();
                int y = gamePieces.get(k).getPositionY();
                gamePieces.get(k).setPosition(gamePieces.get(l).getPositionX(), gamePieces.get(l).getPositionY());
                gamePieces.get(l).setPosition(x, y);
            }
            else {
                but.setIcon(selectedButton.getIcon());
                but.setName(selectedButton.getName());
                selectedButton.setIcon(view.getImageBack());
                int x = gamePieces.get(k).getPositionX();
                int y = gamePieces.get(k).getPositionY();
                gamePieces.get(k).setPosition(gamePieces.get(l).getPositionX(), gamePieces.get(l).getPositionY());
                gamePieces.get(l).setPosition(x, y);
            }
            if(Objects.equals(gamePieces.get(k).getColor(), "blue")){
                for(int i=0;i<player1Pieces.size();i++) {
                    if(Objects.equals(player1Pieces.get(i), gamePieces.get(l).getName())) {
                        player1Pieces.remove(i);
                        break;
                    }
                }
            }
            else if(Objects.equals(gamePieces.get(k).getColor(), "red")) {
                for(int i = 0; i<player2Pieces.size(); i++) {
                    if(Objects.equals(player2Pieces.get(i), gamePieces.get(l).getName())) {
                        player2Pieces.remove(i);
                        break;
                    }
                }
            }
        }
        p1.setStart(false);
        p2.setStart(true);
    }
    /**
     * Observer
     * PreCondition:
     * In this method we check if the game is finished.
     * The game is finished if:
     * 1) Only immovable pieces are left.(We call getMovables method to check this.)
     * 2) The flag has been captured.
     * 3) Bombs are blocking the movable pieces left.
     * PostCondition:
     * @return true if the game is finished, false if the game is not finished yet.
     * */
    public static boolean checkIfGameFinished(int l,String flag) {
        boolean checkR=false,checkB=false;
        if(Objects.equals(gamePieces.get(l).getName(), flag)) {         //an h shmaia katakththike to paixnidi elhkse
           return true;
        }
        for(int i=0;i<30;i++) {
            if(Objects.equals(player1Pieces.get(i), "trap1B") || Objects.equals(player1Pieces.get(i), "trap2B") || Objects.equals(player1Pieces.get(i), "trap3B") || Objects.equals(player1Pieces.get(i), "trap4B") || Objects.equals(player1Pieces.get(i), "trap5B") || Objects.equals(player1Pieces.get(i), "trap6B") || Objects.equals(player1Pieces.get(i), "flagB.png")){
                checkB=true;                //elegxoume an exoun meinei mono pagides kai shmaies sto arraylist
            }
            else {
                checkB=false;
                break;
            }
        }
        for(int i=0;i<30;i++) {
            if(Objects.equals(player1Pieces.get(i), "trap1B") || Objects.equals(player1Pieces.get(i), "trap2B") || Objects.equals(player1Pieces.get(i), "trap3B") || Objects.equals(player1Pieces.get(i), "trap4B") || Objects.equals(player1Pieces.get(i), "trap5B") || Objects.equals(player1Pieces.get(i), "trap6B") || Objects.equals(player1Pieces.get(i), "flagB.png")){
                checkR=true;
            }
            else {
                checkR=false;
                break;
            }
        }
        if(checkR)return true;              //an exoun meinei mono pagides h shmaies tote o paikths de mporei na sunexisei na paizei ara teleiwnei to paixnidi
        if(checkB)return true;
        return false;
    }
    /**
     * PreCondition:
     * We also need a method that flips the image of the Piece everytime
     * that it's the Player's turn and hides the Pieces of the opponent
     * PostCondition:
     * The Players cannot see each other's Pieces.
     */
    public void flipPiece() {
    }

    /**
     * Observer
     * In this method we have a pop-up that asks the user if he wants alternative rules.
     *
     * @return true if he wants alternative rules,false if he doesn't.
     */
    public boolean askTheUser() {
        return false;
    }

    /**
     * Observer
     * If the method askTheUser returns true.
     * let the user choose between Μειωμένος Στρατός, Καμία Υποχώρηση.
     *
     * @return true if the answer is Μειωμένος Στρατός, false if it is Καμία Υποχώρηση
     */
    public boolean chooseRules() {
        return true;
    }

    /**
     * Controller collects each player's data and sends them to view package
     */
    public void gatherInfo() {
    }

}