import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DistributeStripes implements ImageOperation{
   private Logger logger = LogManager.getLogger(DistributeStripes.class);
   private int stripeCount;
   private Color color;

    public DistributeStripes(int stripeCount, Color color) {
        this.stripeCount = stripeCount;
        this.color = color;
    }

    @Override
    public void execute(BufferedImage image) {
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(2f));
        int gap = image.getWidth()/stripeCount;
        for(int i = gap; i < image.getWidth(); i += gap){
            g.drawLine(i, 0, i, image.getHeight());
        }
        g.dispose();
        logger.info("DistributedStrikes.");
    }

    @Override
    public String toString() {
        return "DistributedStrikes.";
    }
}
