package mvc.view;
import mvc.controller.Controller;
import mvc.model.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import static mvc.controller.Controller.p1;
import static mvc.controller.Controller.p2;
import static mvc.model.Board.gamePieces;
public class View extends JFrame {
    private boolean iconSelected,start;
    static int l1=0,l2=0,c1=0,c2=0;
    private JButton selectedButton;
    JPanel panel;
    public static JButton[] pi = new JButton[80];
    public static String[] Blue = {"trap1B", "trap2B", "trap3B", "beastRider1B", "scout1B", "trap4B", "sorceress1B", "beastRider2B", "elf1B", "scout2B", "trap5B", "dwarf1B", "knight1B", "yeti1B", "scout3B", "dwarf2B", "beastRider3B", "sorceress2B", "trap6B", "scout4B", "dwarf3B", "elf2B", "slayerB.png", "yeti2B", "dragonB.png", "flagB.png", "mageB.png", "dwarf4B", "knight2B", "dwarf5B"};
    public static String[] Red = {"trap1R", "scout1R", "dwarf1R", "elf1R", "slayerR.png", "lavaBeast1R", "dragonR.png", "flagR.png", "mageR.png", "dwarf2R", "knight1R", "dwarf3R", "trap2R", "trap3R", "beastRider1R", "elf2R", "scout2R", "trap4R", "dwarf4R", "knight2R", "lavaBeast2R", "trap5R", "beastRider2R", "scout3R", "trap6R", "sorceress1R", "scout4R", "dwarf5R", "beastRider3R", "sorceress2R"};
    public static String[] WhiteYellow={"white1","white2","yellow1","yellow2","white3","white4","yellow3","yellow4","white5","white6","white7","white8","yellow5","yellow6","white9","white10","yellow7","yellow8","white11","white12"};


    /**
     * Constructor
     * In this method we create the visual representation of the board using JButtons
     * @throws IOException
     */
    public View() throws IOException {
        this.setTitle("Stratego");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PListener cl = new PListener();
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 12));
        for (int i = 0; i < 80; i++) {
            pi[i] = new JButton();
            if (i >= 50) {
                pi[i].setIcon(getImageRed(i));
                pi[i].setName(Red[i-50]);
            } else if (i >= 30) {
                if (i == 30 || i == 31 || i == 34 || i == 35 || i == 38 || i == 39 || i == 40 || i == 41 || i == 44 || i == 45 || i == 48 || i == 49) {
                    pi[i].setIcon(getImageWhite());
                    pi[i].setName(WhiteYellow[i-30]);
                } else {
                    pi[i].setIcon(getImageYellow());
                    pi[i].setName(WhiteYellow[i-30]);
                }
            } else {
                pi[i].setIcon(getImageBlue(i));
                pi[i].setName(Blue[i]);
            }
            pi[i].setBorder(BorderFactory.createLineBorder(Color.black));
            pi[i].addMouseListener(cl);
            panel.add(pi[i]);
        }
        iconSelected = false;
        start=false;
        p1.setLimit(0);
        p2.setLimit(0);
        p1.saveCount(0);
        p2.saveCount(0);
        add(panel);
    }

    /***
     * Accessor
     * PreCondition:
     * @param i the num of the red image
     * PostCondition:
     * @return the image to be placed on board
     */
    public ImageIcon getImageRed(int i) { // image for card
        String imgR=null;
        try {
                if ((Objects.equals(Red[i - 50], "trap1R")) ||(Objects.equals(Red[i - 50], "trap2R"))||(Objects.equals(Red[i - 50], "trap3R"))||(Objects.equals(Red[i - 50], "trap4R")) ||(Objects.equals(Red[i - 50], "trap5R"))||(Objects.equals(Red[i - 50], "trap6R"))){
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/trapR.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else if ((Objects.equals(Red[i - 50], "lavaBeast1R")) ||(Objects.equals(Red[i - 50], "lavaBeast2R"))){
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/lavaBeast.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else if((Objects.equals(Red[i - 50], "sorceress1R")) ||(Objects.equals(Red[i - 50], "sorceress2R"))){
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/sorceressR.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else if((Objects.equals(Red[i - 50], "elf1R")) ||(Objects.equals(Red[i - 50], "elf2R"))) {
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/elfR.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else  if ((Objects.equals(Red[i - 50], "scout1R")) ||((Objects.equals(Red[i - 50], "scout2R")) ||(Objects.equals(Red[i - 50], "scout3R")) || (Objects.equals(Red[i - 50], "scout4R")))) {
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/scoutB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else  if ((Objects.equals(Red[i - 50], "dwarf1R")) ||((Objects.equals(Red[i - 50], "dwarf2R")) ||(Objects.equals(Red[i - 50], "dwarf3R")) || (Objects.equals(Red[i - 50], "dwarf4R")) || (Objects.equals(Red[i - 50], "dwarf5R")))) {
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/dwarfR.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else if ((Objects.equals(Red[i - 50], "beastRider1R")) || (Objects.equals(Red[i - 50], "beastRider2R")) || (Objects.equals(Red[i - 50], "beastRider3R"))) {
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/beastRiderR.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else if ((Objects.equals(Red[i - 50], "knight1R")) || (Objects.equals(Red[i - 50], "knight2R"))) {
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/knightR.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
                else if(Objects.equals(Red[i - 50], "slayerR.png") || Objects.equals(Red[i - 50], "dragonR.png") || Objects.equals(Red[i - 50], "flagR.png") || Objects.equals(Red[i - 50], "mageR.png")) {
                    return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/RedPieces/" + Red[i-50]))).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
                }
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    /***
     * Accessor
     * PostCondition:
     * @return the image to be placed on board
     */
    public ImageIcon getImageWhite() { // image for card
        try {
            return new ImageIcon(ImageIO.read(Objects.requireNonNull(View.class.getResource("./images/white.png")))
                    .getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /***
     * Accessor
     * PreCondition:
     * @param i the num of the blue image
     * PostCondition:
     * @return the image to be placed on board
     */
    public  ImageIcon getImageBlue(int i) {
        try {
            if ((Objects.equals(Blue[i], "trap1B")) || (Objects.equals(Blue[i], "trap2B")) || (Objects.equals(Blue[i], "trap3B")) || (Objects.equals(Blue[i], "trap4B")) || (Objects.equals(Blue[i], "trap5B")) || (Objects.equals(Blue[i], "trap6B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/trapB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if ((Objects.equals(Blue[i], "yeti1B")) || (Objects.equals(Blue[i], "yeti2B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/yeti.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if ((Objects.equals(Blue[i], "sorceress1B")) || (Objects.equals(Blue[i], "sorceress2B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/sorceressB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if ((Objects.equals(Blue[i], "elf1B")) || (Objects.equals(Blue[i], "elf2B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/elfB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if ((Objects.equals(Blue[i], "scout1B")) || (Objects.equals(Blue[i], "scout2B")) || (Objects.equals(Blue[i], "scout3B")) || (Objects.equals(Blue[i], "scout4B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/scoutB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if ((Objects.equals(Blue[i], "dwarf1B")) || (Objects.equals(Blue[i], "dwarf2B")) || (Objects.equals(Blue[i], "dwarf3B")) || (Objects.equals(Blue[i], "dwarf4B")) || (Objects.equals(Blue[i], "dwarf5B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/dwarfB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if ((Objects.equals(Blue[i], "beastRider1B")) || (Objects.equals(Blue[i], "beastRider2B")) || (Objects.equals(Blue[i], "beastRider3B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/beastRiderB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if ((Objects.equals(Blue[i], "knight1B")) || (Objects.equals(Blue[i], "knight2B"))) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/knightB.png"))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            } else if (Objects.equals(Blue[i], "slayerB.png") || Objects.equals(Blue[i], "dragonB.png") || Objects.equals(Blue[i], "flagB.png") || Objects.equals(Blue[i], "mageB.png")) {
                return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/bluePieces/"+Blue[i]))).getScaledInstance(100, 80, Image.SCALE_SMOOTH));
            }
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    /***
     * Accessor
     * PostCondition:
     * @return the yellow image to be placed on board
     */
    private ImageIcon getImageYellow() {
        try {
            return new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("./images/yellow.png")))
                    .getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /***
     * Accessor
     * PostCondition:
     * @return the white image to be placed on board
     */
    public ImageIcon getImageBack() { // image for background
        try {
            return new ImageIcon(ImageIO.read(Objects.requireNonNull(View.class.getResource("./images/white.png")))); // image
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * PreCondition: In this class we want to implement some moves and attacks.
     * PostCondition: The Controller class updates the board whenever we need to update it after a mouse click
     * */
    private class PListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int k = 0, l = 0;
            JButton but = ((JButton) e.getSource());
            if (iconSelected && !but.equals(selectedButton)) {
                if (!start) {
                    if (Objects.equals(gamePieces.get(k).getColor(), "blue")) {
                        p1.setStart(true);
                    }
                    if (Objects.equals(gamePieces.get(k).getColor(), "red")) {
                        p2.setStart(true);
                    }
                    start=true;
                }
                for (int i = 0; i < gamePieces.size(); i++) {
                        gamePieces.get(i).setLimit(0);
                }
                    for (int i = 0; i < gamePieces.size(); i++) {
                    if (Objects.equals(selectedButton.getName(), gamePieces.get(i).getName())) {
                        k = i;              //vriskoume to index sto arraylist me ola ta pionia pou anhkei sto koumpi pou epileksame
                        break;
                    }
                }
                for (int i = 0; i < gamePieces.size(); i++) {
                    if (Objects.equals(but.getName(), gamePieces.get(i).getName())) {
                        l = i;                //vriskoume to index sto arraylist me ola ta pionia pou anhkei sto koumpi sto opoio epileksame na metakinhthoume
                        break;
                    }
                }
                //SEIRA THS MPLE OMADAS-ELEGXOS GIA SWSTH KINHSH MESW TOU CONTROLLER
                if (p1.getStart() && Move.movePiece(gamePieces.get(k), gamePieces.get(l)) && Objects.equals(gamePieces.get(k).getColor(), "blue")) {
                    Controller.movePlayer(selectedButton,but,p1,p2,k,l,0,30);
                }
                //SEIRA THS KOKKINHS OMADAS-ELEGXOS GIA SWSTH KINHSH MESW TOU CONTROLLER
                if (p2.getStart() && Move.movePiece(gamePieces.get(k), gamePieces.get(l)) && Objects.equals(gamePieces.get(k).getColor(), "red")) {
                    Controller.movePlayer(selectedButton,but,p2,p1,k,l,50,80);
                }
                //SEIRA THS MPLE OMADAS-ELEGXOS GIA SWSTH EPITHESH MESW TOU CONTROLLER
                if (p1.getStart() && Attack.attackPiece(gamePieces.get(k), gamePieces.get(l))&& Objects.equals(gamePieces.get(k).getColor(), "blue")  && Move.numOfMoves(gamePieces.get(k), gamePieces.get(l)) && Move.illegalMoves(gamePieces.get(k), gamePieces.get(l)) && Move.forbiddenZones(gamePieces.get(l))) {
                    try {
                        Controller.attackPlayer(selectedButton,but,p1,p2,k,l,"BLUE TEAM WON","slayerB.png","dragonR.png","slayerR.png","dragonB.png","flagR.png");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                //SEIRA THS KOKKNHS OMADAS-ELEGXOS GIA SWSTH EPITHESH MESW TOU CONTROLLER
                if(p2.getStart() && Attack.attackPiece(gamePieces.get(k), gamePieces.get(l))&& Objects.equals(gamePieces.get(k).getColor(), "red") && Move.numOfMoves(gamePieces.get(k), gamePieces.get(l)) && Move.illegalMoves(gamePieces.get(k), gamePieces.get(l)) && Move.forbiddenZones(gamePieces.get(l))) {
                    try {
                        Controller.attackPlayer(selectedButton,but,p2,p1,k,l,"RED TEAM WON","slayerR.png","dragonB.png","slayerB.png","dragonR.png","flagB.png");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                iconSelected = false;
            }
            else if (!iconSelected && but.getName() != null) {
                if (Move.immovablePieces(but)) {                //kathorizoume thn akinhsia twn immovable pieces(flag,trap)
                    iconSelected = true;
                    selectedButton = but;
                }
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

