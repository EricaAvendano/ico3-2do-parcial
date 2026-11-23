import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ventana extends JFrame implements ActionListener, ChangeListener {
    private Color color;
    private Main parent;
    private JPanel pnlLeft;
    private JPanel pnlSliderNames;
    private JLabel lblRed;
    private JLabel lblGreen;
    private JLabel lblBlue;
    private JPanel pnlSliders;
    private JSlider sldRed;
    private JSlider sldGreen;
    private JSlider sldBlue;
    private JPanel pnlLabels;
    private JLabel lblBefore;
    private JLabel lblAfter;
    private JButton btnOk;

    /**
     * Crea una nueva instancia de dialogo tomando la ventana Main pasada como
     * parametro como el padre.
     *
     * @param parent La ventana Main que va a ser utilizada como padre de este dialogo
     */
    public Ventana(Main parent) {
        /*
         * Necesito guardar una referencia al padre para poder utilizar sus
         * metodos e interactuar con la otra ventana
         */
        this.parent = parent;

        /* La interfaz la creo de la misma manera que siempre */
        getContentPane().setLayout(new BorderLayout());

        pnlLeft = new JPanel(new BorderLayout());
        pnlSliderNames = new JPanel(new GridLayout(3, 1));
        pnlSliders = new JPanel(new GridLayout(3, 1));
        pnlLabels = new JPanel(new GridLayout(2, 1));

        Color back = parent.getButtonBackground();
        color = back;

        lblRed = new JLabel("Rojo");
        pnlSliderNames.add(lblRed);
        lblGreen = new JLabel("Verde");
        pnlSliderNames.add(lblGreen);
        lblBlue = new JLabel("Azul");
        pnlSliderNames.add(lblBlue);
        pnlLeft.add(pnlSliderNames, BorderLayout.WEST);

        sldRed = new JSlider(0, 255, back.getRed());
        sldRed.addChangeListener(this);
        pnlSliders.add(sldRed);

        sldGreen = new JSlider(0, 255, back.getGreen());
        sldGreen.addChangeListener(this);
        pnlSliders.add(sldGreen);

        sldBlue = new JSlider(0, 255, back.getBlue());
        sldBlue.addChangeListener(this);
        pnlSliders.add(sldBlue);

        pnlLeft.add(pnlSliders, BorderLayout.CENTER);
        getContentPane().add(pnlLeft, BorderLayout.CENTER);

        lblBefore = new JLabel("Antes");
        lblBefore.setOpaque(true);
        lblBefore.setBackground(back);
        pnlLabels.add(lblBefore);

        lblAfter = new JLabel("Despues");
        lblAfter.setOpaque(true);
        lblAfter.setBackground(back);
        pnlLabels.add(lblAfter);

        getContentPane().add(pnlLabels, BorderLayout.EAST);

        btnOk = new JButton("Ok");
        btnOk.addActionListener(this);
        getContentPane().add(btnOk, BorderLayout.SOUTH);

        this.setSize(400, 200);
        this.setTitle("Cambiar color de la letra");
    }

    /**
     * Maneja el evento en que se cierra el JFrame
     *
     * @param e El evento que ocurrio
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    /**
     * Maneja el evento en que cambia el valor de los JSlider
     *
     * @param e El evento que ocurrio
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        color = new Color(sldRed.getValue(),
                sldGreen.getValue(),
                sldBlue.getValue());
        lblAfter.setBackground(color);

        /*
         * Esta clase debe modificar la ventana que la invoco. El control entre
         * ventanas esta dividido entre las dos clases. Como podremos ver en al
         * correr la aplicacion esta ventana va a modificar la ventana que la
         * invoco en tiempo real
         */
        parent.setButtonBackground(color);
    }
}