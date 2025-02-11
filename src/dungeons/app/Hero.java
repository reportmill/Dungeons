package dungeons.app;
import dungeons.app.pkg.images.ImageUtils;
import snap.gfx.Image;
import snap.gfx.Painter;
import snap.view.View;

/**
 * This class represents the hero.
 */
public class Hero extends View {

    // The image state
    private int _imageState;

    // The hero tile location
    private double _tileX, _tileY;

    private static final Image HeroRight = Image.getImageForClassResource(DungeonView.class, "pkg.images/Hero.png");
    private static final Image HeroLeft = ImageUtils.flipImageX(HeroRight);

    /**
     * Constructor.
     */
    public Hero()
    {
        setSize(100, 100);
    }

    public void moveRight()
    {
        getAnim(0).clear().getAnim(500).setX(getX() + 100).needsFinish().play();
        _imageState = 0;
    }

    public void moveLeft()
    {
        getAnim(500).clear().setX(getX() - 100).needsFinish().play();
        _imageState = 1;
    }

    public void moveUp()
    {
        getAnim(500).clear().setY(getY() - 100).needsFinish().play();
    }

    public void moveDown()
    {
        getAnim(500).clear().setY(getY() + 100).needsFinish().play();
    }

    /**
     * Returns the tile image for tile id.
     */
    public Image getImageForState(int anId)
    {
        switch(anId) {
            case 0: return HeroRight;
            case 1: return HeroLeft;
            default: return null;
        }
    }

    @Override
    protected void paintFront(Painter aPntr)
    {
        Image hero = getImageForState(_imageState);
        aPntr.drawImage(hero, 0, 0, 100, 100);
    }
}
