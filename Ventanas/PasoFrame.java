import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PasoFrame extends Frame {
    Frame vent1, vent2;
    Button bUno, bDos, bSalir1, bSalir2;

    public PasoFrame() {
        WindowAdapter cerrarVentana = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        bSalir1 = new Button("Salir");
        bSalir1.setBounds(150, 105, 100, 25);
        bSalir1.setBackground(Color.red);
        bSalir1.setForeground(Color.white);
        bSalir1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vent1 = new Frame("Esta es la ventana 1");
        vent1.setBounds((1024 / 2), (750 / 2), 400, 200);
        vent1.setBackground(Color.blue);
        vent1.setLayout(null);
        vent1.addWindowListener(cerrarVentana);
        vent1.setVisible(true);

        bUno = new Button("Ventana 2");
        bUno.setBounds(150, 75, 100, 25);
        bUno.setBackground(Color.yellow);
        bUno.setForeground(Color.black);
        vent1.add(bUno);
        vent1.add(bSalir1);

        bUno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vent2.setVisible(true);
                vent1.setVisible(false);
            }
        });

        bSalir2 = new Button("Salir");
        bSalir2.setBounds(150, 105, 100, 25);
        bSalir2.setBackground(Color.red);
        bSalir2.setForeground(Color.white);
        bSalir2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        vent2 = new Frame("Esta es la Ventana 2");
        vent2.setBounds((1024 / 2), (750 / 2), 400, 200);
        vent2.setBackground(Color.yellow);
        vent2.setLayout(null);
        vent2.addWindowListener(cerrarVentana);
        vent2.setVisible(false);

        bDos = new Button("Ventana 1");
        bDos.setBounds(150, 75, 100, 25);
        bDos.setBackground(Color.blue);
        bDos.setForeground(Color.white);
        vent2.add(bDos);
        vent2.add(bSalir2);

        bDos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vent1.setVisible(true);
                vent2.setVisible(false);
            }
        });
    }

    public static void main(String a[]) {
        PasoFrame ventana = new PasoFrame();
        ventana.validate();
    }
}