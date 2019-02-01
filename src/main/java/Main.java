import java.awt.*;

 public class Main {
    public static void main(String[] args) {
       ImageEditor ie = new ImageEditor(){
            ie.loadImage("indeks.jpg");
            ie.perform(new DrawFrame(Color.WHITE));
            ie.undo();
            ie.prform(new DistributeStripes(20, new Color(197, 179, 200)));
            ie.perform(new AddCanteredText(new Color(111,67,119), "Sample Text"));
            ie.saveImage();
        };
    }
}
