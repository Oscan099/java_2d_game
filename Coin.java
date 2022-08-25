import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Coin {

    private BufferedImage image;

    private Point pos;

    public Coin(int x, int y) {
        // load the assets
        loadImage();

        pos = new Point(x, y);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/thicc.png"));

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
    public void flip() {

    }
    public Point getPos() {
        return pos;
    }

    public void setPos(int x, int y) {
        pos = new Point(x, y);
    }
    private class ML implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            System.out.println("Click!");
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
    private class MML implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            System.out.println("Mouse: " + mouseEvent.getX() + " , " + mouseEvent.getY());
        }
    }
}
