package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import model.ChessPiece;

/**
 * This is an invisible button which has the same functionality as a button
 * but does not appear to the viewer
 * @author lianhanloh
 *
 */

@SuppressWarnings("serial")
public class InvisibleButton extends JButton {

    /** class fields */
    private int thickness = 3;
    private Color highlight_color = Color.blue;
    private Color img_border = Color.red;
    private boolean visible = false;
    private BufferedImage img;
    private int width;
    private int height;

    public InvisibleButton () {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        // displays chess piece if visible
        if (visible) {
//            setBorderPainted(true);
//            setBorder(BorderFactory.createLineBorder(img_border, thickness));
            width = getWidth() - 5;
            height = getHeight() - 5;
            g.drawImage(img, 5, 5, width, height, null);
        }
        // paints border if selected
        if (isSelected()) {
            setBorderPainted(true);
            setBorder(BorderFactory.createLineBorder(highlight_color, 
                    thickness));
            paintBorder(g);
        }
        // does not paint anything otherwise
    }

    /** displays image of chess piece */
    public void showPiece(ChessPiece p) {
        img = p.getImage();
        visible = true;
    }

}