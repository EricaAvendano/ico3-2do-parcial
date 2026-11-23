import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Estas son un grupo de ventanas que nos van a servir para aprender a manejar
 * muchas ventanas en nuestras aplicaciones.
 */
public class Main extends JFrame implements ActionListener {
    private JButton btnVentana1;
    private JButton btnVentana2;
    private JButton btnVentana3;
    private JButton btnVentana4;
    private JButton btnVentana5;

    /** Creates a new instance of Main */
    public Main() {
        setLayout(new GridLayout(2, 3));

        btnVentana1 = new JButton("Abrir una ventana");
        btnVentana1.addActionListener(this);
        getContentPane().add(btnVentana1);

        btnVentana2 = new JButton("Abrir un dialogo");
        btnVentana2.addActionListener(this);
        getContentPane().add(btnVentana2);

        btnVentana3 = new JButton("Abrir MessageDialog");
        btnVentana3.addActionListener(this);
        getContentPane().add(btnVentana3);

        btnVentana4 = new JButton("Abrir InputDialog");
        btnVentana4.addActionListener(this);
        getContentPane().add(btnVentana4);

        btnVentana5 = new JButton("Abrir InputDialog con opciones");
        btnVentana5.addActionListener(this);
        getContentPane().add(btnVentana5);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventanas!");
        setSize(700, 150);
        setVisible(true);
    }

    public Color getButtonBackground() {
        return btnVentana1.getBackground();
    }

    public Color getButtonForeground() {
        return btnVentana1.getForeground();
    }

    public void setButtonBackground(Color c) {
        if (c != null) {
            btnVentana1.setBackground(c);
            btnVentana2.setBackground(c);
            btnVentana3.setBackground(c);
            btnVentana4.setBackground(c);
            btnVentana5.setBackground(c);
        }
    }

    public void setButtonForeground(Color c) {
        if (c != null) {
            btnVentana1.setForeground(c);
            btnVentana2.setForeground(c);
            btnVentana3.setForeground(c);
            btnVentana4.setForeground(c);
            btnVentana5.setForeground(c);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main app = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVentana1) {
            /*
             * Como puedes ver mostrar otra ventana es muy sencillo, lo unico
             * que tienes que hacer es crear una clase que implemente JFrame
             * como ya sabemos hacerlo y mandarla llamar desde otra forma
             * creando un nuevo objeto de esa clase.
             */
            Ventana v = new Ventana(this);
            /*
             * Este metodo nos permite establecer la localizacion de la ventana
             * al crearse, queremos que este cerca de la ventana principal
             * entonces mandamos el parametro this, pero podriamos ponerlo sobre
             * de cualquier componente.
             */
            v.setLocationRelativeTo(this);
            v.setVisible(true);
        } else if (e.getSource() == btnVentana2) {
            /*
             * Un dialogo es una ventana que no te permite continuar
             * interactuando con la ventana que la manda llamar, ademas esto
             * detiene el codigo en la primera ventana por lo que podemos
             * recibir informacion de la ventana de manera directa.
             */
            Dialogo d = new Dialogo(this);
            d.setLocationRelativeTo(this);
            d.setVisible(true);
            setButtonForeground(d.getColor());
            d.dispose();
        } else if (e.getSource() == btnVentana3) {
            /*
             * JOptionPane es un control que me permite mostrar una dialogo con
             * informacion. El metodo que usamos a continuacion se llama
             * showMessageDialog y nos muestra una ventana con un mensaje
             * informativo. Puede recibir varios parametros aunque solamente los
             * primeros dos son indispensables. El primero es el componente
             * padre, para efectos de este proyecto siempre va a ser this, que
             * quiere decir que el padre de la ventana es esta misma ventana y
             * por lo tanto no me permite modificarla mientras el dialogo se
             * este mostrando; el segundo es el mensaje a desplegar, como
             * podemos ver abajo el mensaje puede estar entre comillas o tambien
             * podriamos utilizar una variable tipo String, el tercer parametro
             * es el titulo que queremos que aparezca en la ventana y el cuarto
             * parametro es el tipo de mensaje que queremos que sea, los tipos
             * de mensaje valido son: JOptionPane.ERROR_MESSAGE,
             * JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE y
             * JOptionPane.WARNING_MESSAGE
             */
            JOptionPane.showMessageDialog(this,
                    "MessageDialog muestra un mensaje!", "MessageDialog",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnVentana4) {
            /*
             * Otro dialogo muy similar al MessageDialog que mostramos arriba es
             * el InputDialog. Para construirlo utilizamos el componente padre
             * al que seguiremos mandando this para que la ventana actual sea el
             * padre, despues tenemos que poner el mensaje a desplegar, despues
             * el titulo de la ventana y por ultimo el tipo de mensaje que es
             * (ve los tipos posibles arriba). La diferencia mas importante es
             * que el metodo showInputDialog() devuelve un Object que podemos
             * convertir a String mediante un cast para saber que fue lo que
             * selecciono el usuario.
             */
            String nombre = (String) JOptionPane.showInputDialog(this,
                    "Cual es tu nombre?", "Log in",
                    JOptionPane.QUESTION_MESSAGE);
            if (nombre != null) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + nombre);
            }
        } else if (e.getSource() == btnVentana5) {
            String[] edades = { "0-14", "15-20", "21-30", "31-60", "61+" };
            /*
             * Como podemos ver aqui, otra opcion para mandar llamar el
             * InputDialog es utilizando un constructor que ademas de lo que
             * usamos arriba tambien pide un ImageIcon (ve el trial de imagenes
             * para saber como utilizarlo), un arreglo con los valores posibles
             * a seleccionar y por ultimo el indice que debe aparecer
             * seleccionado al mostrar el dialogo. Al igual que el InputDialog
             * que vimos arriba este nos devuelve un objeto que debemos
             * convertir a String mediante un cast.
             */
            String edad = (String) JOptionPane.showInputDialog(this,
                    "Cual es tu edad?", "Edades",
                    JOptionPane.QUESTION_MESSAGE, null, edades, 0);

            if (edad != null) {
                if (edad.equals(edades[0])) {
                    JOptionPane.showMessageDialog(this, "Todavia eres joven");
                } else if (edad.equals(edades[1])) {
                    JOptionPane.showMessageDialog(this, "Eres un adolescente");
                } else if (edad.equals(edades[2])) {
                    JOptionPane.showMessageDialog(this, "Eres un adulto joven");
                } else if (edad.equals(edades[3])) {
                    JOptionPane.showMessageDialog(this, "Eres un adulto");
                } else if (edad.equals(edades[4])) {
                    JOptionPane.showMessageDialog(this, "Eres un adulto mayor");
                }
            }
        }
    }
}