package Ch3Graphics;

//RVv2
/**
 * This program uses DrawingPanel to create simple graphics. This version randomizes the color of the RV
 * @author : First Last
 * @since : May 22nd, 2023
 * @version : 2.0
 */

import java.awt.*;

public class RVv2 {
   public static final DrawingPanel canvas = new DrawingPanel(300, 300);
   public static Graphics pen = canvas.getGraphics();
   public static final Font font = new Font("Arial", Font.BOLD, 20);
    public static void main(String[] args) {
        var move = 0;
        canvas.setBackground(Color.CYAN);
        pen.setFont(font);
        do{
            canvas.clear();
            drawBus(move);
            move+=2;
            if (move > 300){
                move = -100;
            }


        }while (true);


    }

    public static void drawBus(int move) {
        pen.setColor(Color.black);
        pen.drawString("HELLO", 10 + move, 20);
        // draw the bus body
        pen.setColor(busColor());
        pen.fillRect(10 + move, 30, 100, 50);
        pen.setColor(busColor());
        pen.fillOval(20 + move, 70, 20, 20);
        pen.fillOval(80 + move, 70, 20, 20);

        // draw the windshield
        pen.setColor(busColor());
        pen.fillRect(80 + move, 40, 30, 20);
        canvas.sleep(50);




    }
    /**
     * this method returns a random color
     * @return a random color
     */
    public static Color busColor(){
        return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }
}
