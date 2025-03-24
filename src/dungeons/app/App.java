package dungeons.app;
import snap.util.SnapEnv;

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
        dungeonPane.getWindow().setMaximized(SnapEnv.isWebVM);
        dungeonPane.setWindowVisible(true);
    }
}
