package ar.edu.unlam.t1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion {
    private JPanel root;
    private JPanel cabecera;
    private JPanel botonera;
    private JButton btnReset;
    private JButton a7button;
    private JButton a4button;
    private JButton a1Button;
    private JButton btnPunto;
    private JButton a8Button;
    private JButton a9Button;
    private JButton btnDivision;
    private JButton a5Button;
    private JButton a6Button;
    private JButton btnProducto;
    private JButton a2Button;
    private JButton a3Button;
    private JButton btnResta;
    private JButton a0Button;
    private JButton btnIgual;
    private JButton btnSuma;
    private JLabel label;

    public Aplicacion() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             label.setText("");
            }
        });
        ActionListener listenerDigitos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = label.getText() + ((JButton) e.getSource()).getText();
                label.setText(texto);
            }
        };
        a7button.addActionListener(listenerDigitos);
        a4button.addActionListener(listenerDigitos);
        a1Button.addActionListener(listenerDigitos);
        btnPunto.addActionListener(listenerDigitos);
        a8Button.addActionListener(listenerDigitos);
        a9Button.addActionListener(listenerDigitos);
        a5Button.addActionListener(listenerDigitos);
        a6Button.addActionListener(listenerDigitos);
        a2Button.addActionListener(listenerDigitos);
        a3Button.addActionListener(listenerDigitos);
        a0Button.addActionListener(listenerDigitos);

        ActionListener listenerOperaciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = calcular(label.getText());
                label.setText(resultado);
                if( e.getSource() != btnIgual) {
                String texto = label.getText() + ((JButton) e.getSource()).getText();
                label.setText(texto);
               }
            }
        };
        btnDivision.addActionListener(listenerOperaciones);
        btnProducto.addActionListener(listenerOperaciones);
        btnResta.addActionListener(listenerOperaciones);
        btnIgual.addActionListener(listenerOperaciones);
        btnSuma.addActionListener(listenerOperaciones);

    }

    public String calcular (String operacion ){
        String resultado;
        String[] ops = operacion.split("[\\+\\-X\\/]");
        if (ops.length == 1) {
            resultado = ops[0];
        } else {
            float v1 = Float.parseFloat(ops[0]);
            float v2 = Float.parseFloat(ops[1]);
            float r;
            if (operacion.contains("+")) {
                r = v1 + v2;
            } else if (operacion.contains("-")) {
                r = v1 - v2;
            } else if (operacion.contains("X")) {
                r = v1 * v2;
            } else {
                r = v1 / v2;
            }
            resultado = String.valueOf(r);
        }
        return resultado;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
