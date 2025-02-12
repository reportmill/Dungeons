package dungeons.app;

import snap.util.SnapUtils;

/**
 * The main class.
 */
public class App {

    /**
     * Standard main implementation.
     */
    public static void main(String[] args)
    {
        DungeonPane dungeonPane = new DungeonPane();
        dungeonPane.getWindow().setMaximized(SnapUtils.isWebVM);
        dungeonPane.setWindowVisible(true);
    }
}
