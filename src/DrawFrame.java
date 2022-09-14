import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {
    private JPanel contentPanel;
    private JToolBar toolBar, paintControl;
    private CoordinateBar coordinateBar;
    private PaintPanel paintPanel;
    private JScrollPane scrollPane;

    private int paintPanelWidth = 1100;
    private int paintPanelHeight = 600;

    DrawFrame() {
        // content panel
        contentPanel = new JPanel();
        contentPanel.setLayout(null);

        // toolbar
        toolBar = new ToolBar(this).getToolBar();


        // create bottom coordinator bar
        coordinateBar = new CoordinateBar();


        // create a panel for painting
        paintPanel = new PaintPanel(this, paintPanelWidth, paintPanelHeight);

        paintControl = new PaintControl(this);

        // set a scroll bar
        scrollPane = new JScrollPane();
        scrollPane.setLocation(5, 5);
        scrollPane.setViewportView(paintPanel);
        scrollPane.setSize(paintPanelWidth, paintPanelHeight);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // scroll panel in content panel
        contentPanel.add(scrollPane);
        contentPanel.setBackground(new Color(145, 179, 203));

        add(toolBar, BorderLayout.NORTH);
        add(coordinateBar, BorderLayout.SOUTH);
        add(paintControl, BorderLayout.EAST);
        add(contentPanel);

        // set a default closer of window
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public CoordinateBar getCoordinateBar() {
        return this.coordinateBar;
    }

    public JToolBar getPaintControl() {
        return this.paintControl;
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }
}
