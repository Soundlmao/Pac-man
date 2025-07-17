import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

public class Pac extends JPanel {
    class Block{
        int x;
        int y;
        int width;
        int height;
        Image image;

        int startX;
        int startY;
        Block(Image image, int x, int y, int width, int height ){
            this.image = image;
            this.x = x;
            this. y = y;
            this.width = width;
            this.startY = y;
            this.startX = x;
        }

    }
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

    //X = wall, O = skip, P = pac man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
    private String[] tileMap = {
            "XXXXXXXXXXXXXXXXXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X                 X",
            "X XX X XXXXX X XX X",
            "X    X       X    X",
            "XXXX XXXX XXXX XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXrXX X XXXX",
            "O       bpo       O",
            "XXXX X XXXXX X XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXXXX X XXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X  X     P     X  X",
            "XX X X XXXXX X X XX",
            "X    X   X   X    X",
            "X XXXXXX X XXXXXX X",
            "X                 X",
            "XXXXXXXXXXXXXXXXXXX"
    };

    HashSet<Block> walls;
    HashSet<Block> foods;
    HashSet<Block> ghosts;
    Block pacman;



    Pac(){        //Loading images
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.black);
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
    public void LoadMap() {
        walls = new HashSet<Block>();
        foods = new HashSet<Block>();
        ghosts = new HashSet<Block>();

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                String row = tileMap[r];
                char tileMapChar = row.charAt(c);
                // Do something with tileMapChar (like draw a block or check collision)
                int x= c * titlesize;
                int y = r * titlesize;
                switch (tileMapChar){

                    case 'X':
                        walls.add(new Block(wallImage, x, y, titlesize, titlesize));
                        break;

                    case ' ':
                        foods.add(new Block(null, x, y, titlesize, titlesize));
                        break;

                    case 'P':
                        pacman = new Block(pacmanRightImage, x, y, titlesize, titlesize);
                        break;

                    case 'b':
                        ghosts.add(new Block(blueGhostImage, x, y, titlesize, titlesize));
                        break;

                    case 'o':
                        ghosts.add(new Block(orangeghostImage, x, y, titlesize, titlesize));
                        break;

                    case 'p':
                        ghosts.add(new Block(pinkghostImage, x, y, titlesize, titlesize));
                        break;

                    case 'r':
                        ghosts.add(new Block(redghostImage, x, y, titlesize, titlesize));
                        break;

                    case 'O': // 'Skip' tile – do nothing
                        break;

                    default:
                        // Optional: handle unknown characters
                        break;
                }
            }
        }

    }
    public void draw(Graphics g) {
         g.drawImage(pacman.image, pacman.x, pacman.y, pacman.width, pacman.height, null);
         for(Block ghost : ghosts){
             g.drawImage(ghost.image,ghost.x, ghost.y, ghost.width, ghost.height, null);
         }
    }

}
