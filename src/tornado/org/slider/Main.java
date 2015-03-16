package tornado.org.slider;

import tornado.org.slider.settings.Settings;

public class Main {

    public static void main(String[] args) {
        if (args.length == 4) {
            Settings settings = new Settings();
            settings.setTileSize(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            settings.setScreenSize(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            settings.setWinState();
            Puzzle puzzle = new Puzzle();
            puzzle.start(settings);
        } else {
            System.out.println("Not enough arguments!");
            System.out.println("Please give;");
            System.out.println("Amount of vertical squares");
            System.out.println("Amount of horizontal squares");
            System.out.println("Screen Height");
            System.out.println("Screen width");
        }
    }
}
