import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class PaintControl extends JToolBar {
    private JLabel strokeLabel;

    private final DrawFrame frame;

    PaintControl(DrawFrame frame) {
        this.frame = frame;

        // create a color chooser
        ColorChooser colorChooser = new ColorChooser(frame);
        DrawingTools drawingTools = new DrawingTools();
        DrawingShapes drawingShapes = new DrawingShapes();
        UndoRedo undoRedo = new UndoRedo();


//        add(new Separator());
        add(undoRedo);
        add(drawingTools);
        add(new ManageStroke());
        add(drawingShapes);
        add(colorChooser);
        add(new Separator());

        setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 1));
        setFloatable(false);
    }


    class DrawingTools extends JPanel {
        DrawingTools() {

            JButton pencil = new JButton("");
            ImageIcon pencilPic = new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/pencil.png")));
            pencil.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 0;
                }
            });
            pencil.setIcon(pencilPic);

            JButton eraser = new JButton("");
            ImageIcon eraserPic = new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/eraser.png")));
            eraser.setIcon(eraserPic);
            eraser.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 4;
                }
            });

            add(pencil);
            add(eraser);

            setBorder(new TitledBorder("Tools"));

        }
    }

    class DrawingShapes extends JPanel {
        DrawingShapes() {
            JButton circleBtn = new JButton("");
            circleBtn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/circle.png"))));
            circleBtn.setPreferredSize(new Dimension(30, 30));
            circleBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 3;
                }
            });
            add(circleBtn);

            JButton rectangleBtn = new JButton("");
            rectangleBtn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/rectangle.png"))));
            rectangleBtn.setPreferredSize(new Dimension(30, 30));
            rectangleBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 2;
                }
            });
            add(rectangleBtn);

            JButton lineBtn = new JButton("");
            lineBtn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/line.png"))));
            lineBtn.setPreferredSize(new Dimension(30, 30));
            lineBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().active_tool = 1;
                }
            });
            add(lineBtn);


            setBorder(new TitledBorder("Shapes"));

        }

    }

    class ManageStroke extends JPanel {
        ManageStroke() {
            JSlider chooseLineStroke = new JSlider(HORIZONTAL, 1, 15, 2);

            strokeLabel = new JLabel("Size: " + chooseLineStroke.getValue(), SwingConstants.CENTER);
            frame.getPaintPanel().stroke = new BasicStroke((float) chooseLineStroke.getValue());
            chooseLineStroke.addChangeListener(e -> {
                strokeLabel.setText("Size: " + chooseLineStroke.getValue());
                frame.getPaintPanel().stroke = new BasicStroke((float) chooseLineStroke.getValue());

            });

            add(new Separator());
            add(chooseLineStroke);
            add(strokeLabel);
            add(new Separator());
            setLayout(new GridLayout(4, 1));

        }

    }

    class UndoRedo extends JPanel {
        UndoRedo() {
            JPanel panel = new JPanel();

            JButton undoBtn = new JButton("Undo", new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/undo.png"))));
            undoBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().undo();
                }
            });

            JButton redoBtn = new JButton("Redo", new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/redo.png"))));
//            redoBtn.setPreferredSize(new Dimension(70 , 25));
            redoBtn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().redo();
                }
            });
            panel.add(undoBtn);
            panel.add(redoBtn);


            JPanel panelClear = new JPanel();
            JButton clear = new JButton("Clear", new ImageIcon(Objects.requireNonNull(getClass().getResource("assets/icons/delete.png"))));
            clear.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getPaintPanel().clear();
                }
            });
            panelClear.add(clear);

            add(panel);
            add(panelClear);
            setLayout(new GridLayout(2, 1));
        }
    }

}
