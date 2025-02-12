package dungeons.app;
import dungeons.app.pkg.images.ImageUtils;
import snap.gfx.Image;
import snap.gfx.Painter;
import snap.view.ParentView;
import snap.view.View;
import snap.view.ViewEvent;

/**
 * This view class displays a dungeon.
 */
public class DungeonView extends ParentView {

    // The dungeon width / height in tiles
    private int _tileWidth, _tileHeight;

    // The cell size
    private int _tileSize;

    // The tile images
    private Image[][] _tiles;

    // The hero
    private Hero _hero;

    // Tile images
    private static final Image StoneTile1 = Image.getImageForClassResource(DungeonView.class, "pkg.images/StoneTile1.png");
    private static final Image WallCornerFrontLeft = Image.getImageForClassResource(DungeonView.class, "pkg.images/WallCornerFront.png");
    private static final Image WallCornerFrontRight = ImageUtils.flipImageX(WallCornerFrontLeft);
    private static final Image WallCornerBackLeft = Image.getImageForClassResource(DungeonView.class, "pkg.images/WallCornerBack.png");
    private static final Image WallCornerBackRight = ImageUtils.flipImageX(WallCornerBackLeft);
    private static final Image PlateTile1 = Image.getImageForClassResource(DungeonView.class, "pkg.images/PlateTile1.png");

    /**
     * Constructor.
     */
    public DungeonView()
    {
        super();
        _tileWidth = 8;
        _tileHeight = 7;
        _tileSize = 100;

        loadMap();

        Key key = new Key();
        key.setXY(300, 400);
        addChild(key);

        _hero = new Hero();
        addChild(_hero);

        enableEvents(KeyPress);
        setFocusable(true);
        setFocusWhenPressed(true);
    }

    /**
     * Returns the number of tiles wide.
     */
    public int getTileWidth()  { return _tileWidth; }

    /**
     * Returns the number of tiles high.
     */
    public int getTileHeight()  { return _tileHeight; }

    /**
     * Returns the tile image for tile id.
     */
    public Image getTileImageForId(int anId)
    {
        switch(anId) {
            case 0: return StoneTile1;
            case 1: return WallCornerFrontLeft;
            case 2: return WallCornerFrontRight;
            case 3: return WallCornerBackLeft;
            case 4: return WallCornerBackRight;
            case 5: return PlateTile1;
            default: return null;
        }
    }

    /**
     * Paint method.
     */
    @Override
    protected void paintFront(Painter aPntr)
    {
        for (int i = 0; i < _tileWidth; i++) {
            for (int j = 0; j < _tileHeight; j++) {
                double tileX = i * _tileSize;
                double tileY = j * _tileSize;
                aPntr.drawImage(_tiles[i][j], tileX, tileY, _tileSize, _tileSize);
            }
        }
    }

    @Override
    protected double getPrefWidthImpl(double aH)  { return _tileWidth * _tileSize; }

    @Override
    protected double getPrefHeightImpl(double aW)  { return _tileHeight * _tileSize; }

    @Override
    protected void processEvent(ViewEvent anEvent)
    {
        if (anEvent.isRightArrow())
            _hero.moveRight();
        else if (anEvent.isLeftArrow())
            _hero.moveLeft();
        else if (anEvent.isUpArrow())
            _hero.moveUp();
        else if (anEvent.isDownArrow())
            _hero.moveDown();
    }

    /**
     * Loads the map.
     */
    private void loadMap()
    {
        _tiles = new Image[_tileWidth][_tileHeight];

        for (int i = 0; i < _tileWidth; i++) {
            for (int j = 0; j < _tileHeight; j++) {
                int tileId = Map1[j][i];
                _tiles[i][j] = getTileImageForId(tileId);
            }
        }
    }

    private static int[][] Map1 = {
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 4, 0, 0, 5, 0 },
            { 0, 0, 1, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 3, 4, 0 },
            { 0, 5, 0, 0, 0, 1, 2, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }
    };
}
