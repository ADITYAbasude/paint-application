import java.awt.*;

public class Paint {
    public static void main(String[] args) {
        DrawFrame frame = new DrawFrame();
        frame.setTitle("Paint");
        frame.pack();


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
