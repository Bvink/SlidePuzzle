package tornado.org.slider;

import tornado.org.slider.constants.Constants;
import tornado.org.slider.settings.Settings;

public class Main {

    public static void main(String[] args) {
        if (args.length == 4) {
            if (Integer.parseInt(args[1]) < 3 || Integer.parseInt(args[1]) < 3) {
                System.out.println(Constants.GENERATE_ERROR);
            }
            Settings settings = new Settings();
            settings.setTileSize(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            settings.setScreenSize(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            settings.setWinState();
            Puzzle puzzle = new Puzzle();
            puzzle.start(settings);
        } else {
            for (String s : Constants.STARTUP_ERROR) {
                System.out.println(s);
            }
        }
    }
}
