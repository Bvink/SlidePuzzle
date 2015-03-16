package tornado.org.slider.settings;

import tornado.org.slider.constants.Constants;

public class Settings {

    private int[] tileSize = new int[2];
    private int[] screenSize = new int[2];
    private String winState;

    public void setTileSize(int... tileSize) {
        this.tileSize = tileSize;
    }

    public int[] getTileSize() {
        return tileSize;
    }

    public void setScreenSize(int... screenSize) {
        this.screenSize = screenSize;
    }

    public int[] getScreenSize() {
        return screenSize;
    }

    public void setWinState() {
        StringBuilder win = new StringBuilder();
        System.out.println();

        for (int i = 1; i < tileSize[0] * tileSize[1]; i++) {
            win.append(i).append(Constants.SPACE);
        }
        win.append(0).append(Constants.SPACE);
        winState = win.toString();
        System.out.println(winState);
    }

    public String getWinState() {
        return winState;
    }
}
