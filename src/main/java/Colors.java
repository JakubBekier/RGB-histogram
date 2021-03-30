import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class Colors {
    private HashMap<Integer, Integer> red;
    private HashMap<Integer, Integer> green;
    private HashMap<Integer, Integer> blue;

    public Colors(){
    }

    public void convert(String path){
        try {
            File file = new File(path);
            BufferedImage img = ImageIO.read(file);
            int width = img.getWidth();
            int height = img.getHeight();
            HashMap<Integer, Integer> red = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> green = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> blue = new HashMap<Integer, Integer>();

            for (int i = 0; i < 256; i++){
                red.put(i, 0);
                green.put(i, 0);
                blue.put(i, 0);
            }

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int pixel = img.getRGB(x, y);
                    Color color = new Color(pixel, true);
                    red.put(color.getRed(), red.get(color.getRed()) + 1);
                    green.put(color.getGreen(), green.get(color.getGreen()) + 1);
                    blue.put(color.getBlue(), blue.get(color.getBlue()) + 1);
                }
            }

            this.red = red;
            this.blue = blue;
            this.green = green;
        } catch (Exception e){

        }
    }

    public HashMap<Integer, Integer> getRed(){
        return this.red;
    }

    public HashMap<Integer, Integer> getBlue(){
        return this.blue;
    }

    public HashMap<Integer, Integer> getGreen(){
        return this.green;
    }
}
