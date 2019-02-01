import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AddCanteredText implements ImageOperation {
    private Logger logger = LogManager.getLogger(AddCanteredText.class);
    private Color color;
    private String text;

    public AddCanteredText(Color color, String text){
        this.color=color;
        this.text=text;
    }

    @Override
    public void execute(BufferedImage image){
        Graphics2D g = image.createGraphics();
        Font font = new Font("TimesRoman", Font.PLAIN, 40);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        int stringWidth = fontMetrics.stringWidth(text);
        int stringHeight = fontMetrics.getAscent();
        g.setPaint(color);
        g.drawString(text, (image.getWidth() - stringWidth)/2, image.getHeight() / 2 + stringHeight / 4);
        g.dispose();
        logger.info("Added Text");
    }

    @Override
    public String toString() {
        return "AddCenteredText";
    }
}
