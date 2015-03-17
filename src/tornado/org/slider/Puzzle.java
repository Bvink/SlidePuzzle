package tornado.org.slider;

import tornado.org.slider.constants.Constants;
import tornado.org.slider.objects.Tile;
import tornado.org.slider.settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

class Puzzle implements MouseListener {
    private JFrame frame;
    private final List<Tile> list = new ArrayList<>();
    private Settings settings;
    private Tile[] square;
    private int[] tileSize;
    private int[] screenSize;
    private int fieldSize;

    public void start(Settings settings) {
        this.settings = settings;
        this.tileSize = settings.getTileSize();
        this.screenSize = settings.getScreenSize();
        this.fieldSize = tileSize[0] * tileSize[1];
        frame = new JFrame(Constants.TITLE);
        square = new Tile[fieldSize];
        frame.setLayout(new GridLayout(tileSize[0], tileSize[1]));
        frame.setResizable(false);
        for (int i = 0; i < square.length; i++) {
            Tile tile = new Tile(i);
            list.add(tile);
        }
        for (int i = 0; i < square.length; i++) {
            int index = (int) (Math.random() * list.size() - 1);
            square[i] = list.get(index);
            square[i].addMouseListener(this);
            frame.getContentPane().add(square[i]);
            list.remove(index);
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(screenSize[1], screenSize[0]);
        frame.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getComponent().getBackground() != Color.WHITE) {
            e.getComponent().setBackground(Color.GRAY);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getComponent().getBackground() != Color.WHITE) {
            e.getComponent().setBackground(Color.darkGray);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getComponent().getX();
        int y = e.getComponent().getY();
        int num = 0;
        int[] state = new int[fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            if (square[i].getBackground() == Color.WHITE) {
                num = i;
            }
        }
        int x2 = square[num].getX();
        int y2 = square[num].getY();
        if ((Math.abs(x - x2) < screenSize[0] / tileSize[0] && Math.abs(x - x2) > 1 && y == y2) || (Math.abs(y - y2) < screenSize[1] / tileSize[1] && Math.abs(y - y2) > 1 && x == x2)) {
            e.getComponent().setBackground(Color.WHITE);
            square[num].setNumber(((Tile) e.getComponent()).getNumber());
            ((Tile) e.getComponent()).setNumber(0);
            square[num].setBackground(Color.darkGray);
        }

        for (int i = 0; i < fieldSize; i++) {
            state[i] = square[i].getNumber();
        }

        checkWin(gameState(state));
    }

    private String gameState(int[] state) {
        StringBuilder sb = new StringBuilder();
        for (int i : state) {
            sb.append(i).append(Constants.SPACE);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void checkWin(String s) {
        if (s.equals(settings.getWinState())) {
            int choice = JOptionPane.showConfirmDialog(null, Constants.WIN_MESSAGE, Constants.WIN_TITLE, JOptionPane.YES_NO_OPTION);
            switch (choice) {
                case JOptionPane.YES_OPTION:
                    frame.setVisible(false);
                    Puzzle puzzle = new Puzzle();
                    puzzle.start(settings);
                    break;
                case JOptionPane.NO_OPTION:
                    System.exit(0);
                    break;
                default:
                    System.out.println(Constants.ERROR_MESSAGE);
                    System.exit(0);
                    break;
            }
        }
    }
}