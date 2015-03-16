package tornado.org.slider.objects;

import tornado.org.slider.constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    private int tileNumber;

    public Tile(int number) {
        super();
        this.setBackground(number == 0 ? Color.WHITE : Color.DARK_GRAY);
        this.tileNumber = number;
    }

    public void paint(Graphics g) {
        super.paint(g);
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.white);
        Font font = new Font(Constants.TREBUCHET_MS, Font.BOLD, Constants.FONT_SIZE);
        g2d.setFont(font);
        FontMetrics a = g.getFontMetrics();
        String num = Integer.toString(tileNumber);
        int height = a.getHeight();
        int width = a.stringWidth(num);
        g2d.drawString(num, (getWidth() - width) / 2, (getHeight() / 2 + height / 2));
        this.setBorder(BorderFactory.createLineBorder(Color.white));
    }

    public int getNumber() {
        return this.tileNumber;
    }

    public void setNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

}