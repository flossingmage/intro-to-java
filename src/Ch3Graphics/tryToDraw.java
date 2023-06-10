package Ch3Graphics;

import javax.swing.*;
import java.awt.*;

public class tryToDraw{
    public static void main(String[] args) {
        DrawingPanel drawingPanel = new DrawingPanel(300,300);
        Graphics pen = drawingPanel.getGraphics();
        pen.drawImage(new ImageIcon("G:\\My Drive\\ijp\\workspace\\src\\Ch3Graphics\\Mercury.png").getImage(),10,10,100,100,null);
    }

}
