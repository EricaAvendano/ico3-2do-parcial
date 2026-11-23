package eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventosMouse extends JFrame {

    public EventosMouse() {
        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Añadir un listener de tipo Mouse mediante una clase anónima
        MouseListener listener = new MouseListener() {
            // PRIMERA EJECUCIÓN:
            // @Override
            // public void mouseClicked(MouseEvent e) {
            //     lblSaludo.setText("mouseClicked");
            // }

            @Override
            public void mousePressed(MouseEvent e) {
                // SEGUNDA EJECUCIÓN
                lblSaludo.setText("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TERCERA EJECUCIÓN
                lblSaludo.setText("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // CUARTA EJECUCIÓN
                lblSaludo.setText("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // QUINTA EJECUCIÓN
                lblSaludo.setText("mouseExited");
            }

            // SÉPTIMA EJECUCIÓN:
            // Usar el método getSource() del objeto MouseEvent para identificar la fuente del evento
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == campoSaludo) {
                    lblSaludo.setText("MouseClicked dentro de campo saludo");
                }
                if (e.getSource() == boton) {
                    lblSaludo.setText("MouseClicked dentro de boton");
                }
            }
        };

        // Agregar el listener al botón mediante el método addMouseListener()
        boton.addMouseListener(listener);

        // SEXTA EJECUCIÓN: agregar al campo de texto el mismo listener
        campoSaludo.addMouseListener(listener);

        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        EventosMouse objEventoMouse = new EventosMouse();
    }
}