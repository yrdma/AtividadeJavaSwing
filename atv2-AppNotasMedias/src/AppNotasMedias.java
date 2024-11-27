import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Pegar notas Calcular medias e falar situação do aluno
//fazer um array para pegar as notas
//fazer um botão para jogar as notas para o text area
//atribuir ao botão uma função onde calculo a media usando as notas existentes no textArea
//jogo o resultado para o Jlabel


public class AppNotasMedias {

    private JPanel mainPanel;
    private JTextField txtNotas;
    private JButton btnAddNotas;
    private JTextArea txtAreaNotas;
    private JButton btnMedia;
    private JLabel lblMedia;
    private JLabel lblSituacao;

    double[] notas = new double[10];
    int indice = 0;

    public AppNotasMedias() {
        btnAddNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double guardarNota = Double.valueOf(txtNotas.getText());

                String amazenarNotas = "";
                if (indice < notas.length) {
                    notas[indice] = guardarNota;
                    indice++;

                    for (int i = 0; i < indice; i++) {


                        amazenarNotas += notas[i] + "\n";

                    }
                    txtAreaNotas.setText(amazenarNotas);
                    txtNotas.setText("");

                }





            }
        });
        btnMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double somaTotal = 0;

                for (int i = 0; i < notas.length; i++) {
                    somaTotal += notas[i];
                }
                somaTotal = somaTotal / indice;
                if (somaTotal >= 7) {
                    lblSituacao.setText("Aprovado");
                    lblMedia.setText("Media: " + somaTotal );
                }else {
                    lblSituacao.setText("Reprovado");
                    lblMedia.setText("Media: " + somaTotal);
                }

            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setContentPane(new AppNotasMedias().mainPanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
