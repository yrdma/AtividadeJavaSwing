import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//colocar peso e altura no Jtext
//fazer com que o botao pegue e faça o calculo
//apresentar a situação no Jlabel


public class CalculadoraDeImc {
    private JPanel mainPanel;
    private JButton btnCalcularImc;
    private JTextField txtPeso;;
    private JLabel lblImc;
    private JTextField txtAltura;
    private JLabel lblCategoria;

    double guardarImc = 0;

    public void calculoImc(double peso, double altura) {

        peso = Double.valueOf(txtPeso.getText());
        altura = Double.valueOf(txtAltura.getText());
        guardarImc = peso / (altura * altura);
    }

    public CalculadoraDeImc() {
        btnCalcularImc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculoImc(Double.valueOf(txtPeso.getText()), Double.valueOf(txtAltura.getText()));
                lblImc.setText(String.format("%.2f", guardarImc));
                if (guardarImc < 18.5) {
                    lblCategoria.setText("Abaixo do peso");
                } else if (guardarImc > 18.6 && guardarImc <= 24.9) {
                    lblCategoria.setText("Peso normal");
                } else if (guardarImc > 24.9 && guardarImc <= 29.9) {
                    lblCategoria.setText("Acima do peso");
                } else if (guardarImc > 29.9 && guardarImc <= 34.9) {
                    lblCategoria.setText("Obesidade Grau 1");
                } else if (guardarImc > 34.9 && guardarImc <= 39.9) {
                    lblCategoria.setText("Obesidade Grau 2");
                } else if (guardarImc > 39.9) {
                    lblCategoria.setText("Obesidade Grau 3");


                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setContentPane(new CalculadoraDeImc().mainPanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
