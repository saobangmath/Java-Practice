package ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class HelloWorld extends JPanel {
    private int _x, _y;
    public HelloWorld(){
        this._x = Constant.x;
        this._y = Constant.y;
    }
    public void paint(Graphics g){
        BufferedImage img = createImageWithText();
        g.drawImage(img,_x ,_y,this);
        if (_x >= 200){
            _x = 0;
        }
        else{
            _x++;
        }

        repaint();
    }

    private BufferedImage createImageWithText() {
        BufferedImage bufferedImage = new BufferedImage(2000,2000, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.RED);
        g.drawString(Constant.secret, Constant.x, Constant.y);

        return bufferedImage;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new HelloWorld());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
