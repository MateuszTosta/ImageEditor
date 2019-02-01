import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class ImageEditor {
    private Logger logger = LogManager.getLogger(ImageEditor.class);
    private BufferedImage imageTemp;
    private Stack<OperationDone> operationsDone;

    public void LoadImage(String fileName) throws URISyntaxException {
        try {
            if (fileName == null || fileName.isEmpty()) {
                logger.warn("FileName is empty");
            } else {
                Path path = Paths.get(getClass().getResource(fileName).toURI());
                imageTemp = ImageIO.read(new File(path.toUri()));
                operationsDone = new Stack<>();
                logger.info("Successfuly loaded image" + fileName);
            }
        } catch (URISyntaxException | IOException e) {
            logger.error("Image no found");
            e.printStackTrace();
        }
    }

    public void saveImage() {
        try {
            if (imageTemp == null) {
                logger.warn("There's no image to save");
            } else {
                ImageIO.write(imageTemp, "jpg", new File("E:\\Kurs Java\\ImageEditor\\src\\main\\resources"));
                logger.info("Successfuly saved omage");
            }
        } catch (IOException e) {
            logger.error("Error saving image.");
            e.printStackTrace();
        }
    }

    public void perform(ImageOperation imageOperation){
        ColorModel cm = imageTemp.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = imageTemp.copyData(null);
        BufferedImage stateBefore = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        operationsDone.push(new OperationDone(stateBefore, imageOperation));
        imageOperation.execute(imageTemp);
    }
    public void undo(){
        if(operationsDone.empty()){
            logger.warn("No oerations to undo");
        }else{
            OperationDone undone = operationsDone.pop();
            imageTemp = undone.getImageBefore();
            logger.info("Operation" + undone.getImageOperation() + "undone");
        }
    }
}