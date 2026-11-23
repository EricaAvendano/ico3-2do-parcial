package eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventosMouseRueda extends JFrame {

    public EventosMouseRueda() {
        // SEGUNDA EJECUCIÓN: etiquetas que muestran las coordenadas del puntero del mouse
        JLabel lblMovedX = new JLabel("Moved x: ");
        lblMovedX.setBounds(25, 10, 100, 30);

        JLabel lblMovedY = new JLabel("y: ");
        lblMovedY.setBounds(230, 10, 100, 30);

        JLabel lblDraggedX = new JLabel("Dragged x: ");
        lblDraggedX.setBounds(25, 40, 110, 30);

        JLabel lblDraggedY = new JLabel("y: ");
        lblDraggedY.setBounds(230, 40, 100, 30);

        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 80, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Listener de tipo Mouse
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isAltDown()) {
                    lblSaludo.setText("clic + alt");
                    System.out.println("clic + alt");
                } else if (e.isControlDown()) {
                    lblSaludo.setText("clic + Control");
                    System.out.println("clic + Control");
                } else if (e.isShiftDown()) {
                    lblSaludo.setText("clic + Shift");
                    System.out.println("clic + Shift");
                } else if (e.isMetaDown()) {
                    lblSaludo.setText("clic derecho");
                    System.out.println("clic derecho");
                } else {
                    lblSaludo.setText("clic izquierdo");
                    System.out.println("clic izquierdo");
                }

                // Validar doble clic
                if (e.getClickCount() == 2) {
                    lblSaludo.setText("doble clic");
                    System.out.println("doble clic");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        // Listener para eventos de la rueda del mouse
        MouseWheelListener wheel = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("mouse wheel");
                if (e.getPreciseWheelRotation() == -1) {
                    System.out.println("rueda hacia arriba");
                }
                if (e.getPreciseWheelRotation() == 1) {
                    System.out.println("rueda hacia abajo");
                }
            }
        };

        // Listener para eventos de movimiento del puntero del mouse
        MouseMotionListener motionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("dragged");
                // SEGUNDA EJECUCIÓN: mostrar coordenadas al arrastrar
                lblDraggedX.setText("Dragged x: " + e.getX());
                lblDraggedY.setText("y: " + e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("moved");
                // SEGUNDA EJECUCIÓN: mostrar coordenadas al mover
                lblMovedX.setText("Moved x: " + e.getX());
                lblMovedY.setText("y: " + e.getY());
            }
        };

        // Agregar listeners a los componentes
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);
        campoSaludo.addMouseWheelListener(wheel);
        this.addMouseMotionListener(motionListener);

        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);

        // SEGUNDA EJECUCIÓN: agregar etiquetas de coordenadas al frame
        add(lblMovedX);
        add(lblMovedY);
        add(lblDraggedX);
        add(lblDraggedY);

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        EventosMouseRueda objEventoMouse = new EventosMouseRueda();
    }
}