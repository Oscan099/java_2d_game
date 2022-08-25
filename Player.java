import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player {


    private BufferedImage image;

    private Point pos;

    private int score;

    public Player() {

        loadImage();

        pos = new Point(10, 4);
        score = 0;
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/player.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {

        g.drawImage(
            image, 
            pos.x * Board.TILE_SIZE, 
            pos.y * Board.TILE_SIZE, 
            observer
        );
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            pos.translate(0, -1);
        }

        if (key == KeyEvent.VK_E) {
            pos.translate(1, -1);
        }

        if (key == KeyEvent.VK_Q) {
            pos.translate(-1, -1);
        }

        if (key == KeyEvent.VK_C) {
            pos.translate(1, 1);
        }

        if (key == KeyEvent.VK_Z) {
            pos.translate(-1, 1);
        }

        if (key == KeyEvent.VK_X) {
            pos.translate(0, 1);
        }
        if (key == KeyEvent.VK_D) {
            pos.translate(1, 0);
        }
        if (key == KeyEvent.VK_S) {
            pos.translate(0, 1);
        }
        if (key == KeyEvent.VK_A) {
            pos.translate(-1, 0);
        }
        if (key == KeyEvent.VK_SHIFT) {

            pos.translate(0, -3);
        }


    }

    public void tick() {

        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= Board.COLUMNS) {
            pos.x = Board.COLUMNS - 1;
        }

        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= Board.ROWS) {
            pos.y = Board.ROWS - 1;
        }
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public void addScore(int amount) {
        score += amount;
    }

    public Point getPos() {
        return pos;
    }


}

