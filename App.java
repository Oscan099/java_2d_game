import javax.swing.*;

class App {

    private static void initWindow() {

        JFrame window = new JFrame("Try-kuri");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Board board = new Board();

        window.add(board);

        window.addKeyListener(board);

        window.setResizable(false);

        window.pack();

        window.setLocationRelativeTo(null);

        window.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(App::initWindow);
    }
}