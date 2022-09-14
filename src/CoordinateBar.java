import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CoordinateBar extends JToolBar {
    private JLabel coordinateText, sizeText;
    private Separator separator;

    CoordinateBar() {

        separator = new Separator();
        add(separator);

        ImageIcon coordinateIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/icons/coordinate.png")));
        Image reSizedCoordinateimg = coordinateIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        coordinateIcon = new ImageIcon(reSizedCoordinateimg);
        JLabel coordinatePic = new JLabel(coordinateIcon);
        add(coordinatePic);

        separator = new Separator();
        add(separator);

        coordinateText = new JLabel(" 0 , 0 px");
        add(coordinateText);

        separator = new Separator();
        add(separator);


        ImageIcon sizeIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/icons/size.png")));
        JLabel sizePic = new JLabel(sizeIcon);
        add(sizePic);

        separator = new Separator();
        add(separator);

        sizeText = new JLabel(" 0 x 0 ");
        add(sizeText);

        setFloatable(false);
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
    }

    public JLabel getCoordinateText() {
        return coordinateText;
    }

    public JLabel getSizeText(){
        return  this.sizeText;
    }
}
