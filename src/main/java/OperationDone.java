import java.awt.image.BufferedImage;

public class OperationDone{
    private BufferedImage imageBefore;
    private ImageOperation imageOperation;

    public OperationDone(BufferedImage imageBefore, ImageOperation imageOperation) {
        this.imageBefore = imageBefore;
        this.imageOperation = imageOperation;
    }

    public BufferedImage getImageBefore() {
        return imageBefore;
    }

    public void setImageBefore(BufferedImage imageBefore) {
        this.imageBefore = imageBefore;
    }

    public ImageOperation getImageOperation() {
        return imageOperation;
    }

    public void setImageOperation(ImageOperation imageOperation) {
        this.imageOperation = imageOperation;
    }
}