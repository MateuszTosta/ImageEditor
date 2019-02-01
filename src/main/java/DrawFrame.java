import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.*;
import java.awt.image.BufferedImage;


public class DrawFrame implements ImageOperation{
    private Logger logger = (Logger) LogManager.getLogger(DrawFrame.class);
    private Color color;

    @Override
    public void execute(BufferedImage image) {
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(50f));
        g.drawRect(0, 0, image.getWidth(), image.getHeight());
        g.dispose();
        logger.info("Drew Frame.");
    }

    @Override
    public String toString() {
        return "DrawFrame";
    }
}