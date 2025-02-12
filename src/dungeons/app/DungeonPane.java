package dungeons.app;
import snap.geom.Pos;
import snap.gfx.Color;
import snap.view.*;

/**
 * This class is the main UI controller for the game.
 */
public class DungeonPane extends ViewOwner {

    // The DungeonView
    private DungeonView _dungeonView;

    @Override
    protected View createUI()
    {
        Label label = new Label("Dungeons Builder");
        label.setPropsString("Font:Times Bold 70; TextColor:WHITE; Margin:14,0,25,0; LeanX:CENTER");
        _dungeonView = new DungeonView();
        _dungeonView.setMargin(4, 4,4, 4);

        BoxView dungeonViewBox = new BoxView(_dungeonView);
        dungeonViewBox.setBorder(Color.get("#550055"), 12);
        dungeonViewBox.setMargin(20, 20, 20, 20);

        ColView colView = new ColView();
        colView.setFill(Color.get("#440044"));
        colView.setAlign(Pos.TOP_CENTER);
        colView.setChildren(label, dungeonViewBox);
        return colView;
    }

    @Override
    protected void initUI()
    {
        setFirstFocus(_dungeonView);
    }
}
