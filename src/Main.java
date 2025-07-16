import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) throws Exception {
        int rowCount = 21;
        int columnCount = 19;
        int titlesize = 32;
        int boardWidth = columnCount * titlesize;
        int boardHeight= rowCount * titlesize;

        JFrame frame = new JFrame("Pac Man");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Pac pacmanGame = new Pac();
        frame.add(pacmanGame);
        frame.pack();

    }
}
