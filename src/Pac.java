import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

public class Pac extends JPanel {
    private int rowCount = 21;
    private int columnCount = 19;
    private int titlesize = 32;
    private int boardWidth = columnCount * titlesize;
    private int boardHeight= rowCount * titlesize;

    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;

    private Image wallImage;
    private Image blueGhostImage;
    private Image orangeghostImage;
    private Image pinkghostImage;
    private Image redghostImage;





    Pac(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLUE);
        wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
        orangeghostImage = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
        pinkghostImage = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
        redghostImage = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();

    }
        //Loading images
}
