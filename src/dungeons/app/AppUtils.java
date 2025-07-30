package dungeons.app;
import snap.gfx.Image;
import snap.gfx.Painter;

/**
 * Image utilities.
 */
public class AppUtils {

    /**
     * Flips an image along X axis.
     */
    public static Image flipImageX(Image anImage)
    {
        if (!anImage.isLoaded())
            anImage.waitForImageLoad();
        double imageWidth = anImage.getWidth();
        double imageHeight = anImage.getHeight();
        Image image = Image.getImageForSize(imageWidth, imageHeight, true);
        Painter pntr = image.getPainter();
        pntr.translate(imageWidth / 2, imageHeight / 2);
        pntr.scale(-1, 1);
        pntr.translate(-imageWidth / 2, -imageHeight / 2);
        pntr.drawImage(anImage, 0, 0);
        return image;
    }
}
