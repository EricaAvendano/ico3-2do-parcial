import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OperacionesAritmeticas {
    // objetos
    private Frame fr_Ventana;
    private JLabel lblInstruccion, lblNum1, lblNum2, lblResultado;
    private JTextField jtfNum1, jtfNum2, jtfResultado;
    private JButton bCalcular, bCerrar;
    private JRadioButton rbSuma, rbResta, rbMultiplicacion, rbDivision;
    private ButtonGroup grupoOperaciones;
    private Panel pnlSuperior, pnlCentral, pnlOperaciones, pnlInferior;

    // constructor
    public OperacionesAritmeticas() {
        fr_Ventana = new Frame("Operaciones Aritmeticas");
        pnlSuperior = new Panel();
        pnlCentral = new Panel();
        pnlOperaciones = new Panel();
        pnlInferior = new Panel();

        lblInstruccion = new JLabel("<html> Ingresa dos numeros, elige una operacion y da click en CALCULAR: </html>");
        lblNum1 = new JLabel("Numero A: ");
        lblNum2 = new JLabel("Numero B: ");
        lblResultado = new JLabel("Resultado: ");

        jtfNum1 = new JTextField(5);
        jtfNum2 = new JTextField(5);
        jtfResultado = new JTextField(10);
        jtfResultado.setEditable(false); // el resultado no se puede escribir

        // radio buttons
        rbSuma = new JRadioButton("Suma", true); // seleccionado por defecto
        rbResta = new JRadioButton("Resta");
        rbMultiplicacion = new JRadioButton("Multiplicacion");
        rbDivision = new JRadioButton("Division");

        // el ButtonGroup hace que solo se pueda seleccionar uno a la vez
        grupoOperaciones = new ButtonGroup();
        grupoOperaciones.add(rbSuma);
        grupoOperaciones.add(rbResta);
        grupoOperaciones.add(rbMultiplicacion);
        grupoOperaciones.add(rbDivision);

        bCalcular = new JButton("Calcular");
        bCerrar = new JButton("Cerrar");
    }

    public void acomodarEnVentana() {
        // event listeners
        bCalcular.addActionListener(new ManejadorBotonCalcular());
        bCerrar.addActionListener(new ManejadorBotonCerrar());

        fr_Ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(-1);
            }
        });

        pnlSuperior.add(lblInstruccion);
        fr_Ventana.add(pnlSuperior, BorderLayout.NORTH);

        // panel central: numeros y resultado
        pnlCentral.setLayout(new GridLayout(4, 2));
        pnlCentral.add(lblNum1);
        pnlCentral.add(jtfNum1);
        pnlCentral.add(lblNum2);
        pnlCentral.add(jtfNum2);
        pnlCentral.add(new Label("Operacion: "));
        pnlCentral.add(pnlOperaciones);
        pnlCentral.add(lblResultado);
        pnlCentral.add(jtfResultado);

        // panel con los radio buttons
        pnlOperaciones.setLayout(new GridLayout(2, 2));
        pnlOperaciones.add(rbSuma);
        pnlOperaciones.add(rbResta);
        pnlOperaciones.add(rbMultiplicacion);
        pnlOperaciones.add(rbDivision);

        fr_Ventana.add(pnlCentral, BorderLayout.CENTER);

        pnlInferior.add(bCalcular);
        pnlInferior.add(bCerrar);
        fr_Ventana.add(pnlInferior, BorderLayout.SOUTH);

        fr_Ventana.setSize(500, 350);
        fr_Ventana.setVisible(true);
    }

    class ManejadorBotonCalcular implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            double num1, num2, resultado = 0;
            String operacion;

            // validar que los datos sean numeros
            try {
                num1 = Double.parseDouble(jtfNum1.getText());
                num2 = Double.parseDouble(jtfNum2.getText());
            } catch (NumberFormatException ex) {
                jtfResultado.setText("Dato invalido");
                return;
            }

            // detectar que radio button esta seleccionado
            if (rbSuma.isSelected()) {
                operacion = "suma";
            } else if (rbResta.isSelected()) {
                operacion = "resta";
            } else if (rbMultiplicacion.isSelected()) {
                operacion = "multiplicacion";
            } else {
                operacion = "division";
            }

            // ejecutar SOLO la operacion seleccionada
            switch (operacion) {
                case "suma":
                    resultado = num1 + num2;
                    break;
                case "resta":
                    resultado = num1 - num2;
                    break;
                case "multiplicacion":
                    resultado = num1 * num2;
                    break;
                case "division":
                    if (num2 == 0) {
                        jtfResultado.setText("No se divide entre 0");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
            }

            jtfResultado.setText(String.valueOf(resultado));
        }
    }

    class ManejadorBotonCerrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        OperacionesAritmeticas iguOperaciones = new OperacionesAritmeticas();
        iguOperaciones.acomodarEnVentana();
    }
}