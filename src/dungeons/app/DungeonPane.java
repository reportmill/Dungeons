package dungeons.app;
import snap.view.View;
import snap.view.ViewOwner;

/**
 * This class is the main UI controller for the game.
 */
public class DungeonPane extends ViewOwner {

    @Override
    protected View createUI()
    {
        return new DungeonView();
    }
}
