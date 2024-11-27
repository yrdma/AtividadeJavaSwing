import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraLenda {
    private JPanel mainPanel;
    private JTextField txtResultado;
    private JPanel panelBtn;
    private JButton btnSoma;
    private JButton btnSubtrair;
    private JButton btnDivisao;
    private JButton btnMultiplicar;
    private JButton btn1;
    private JButton btn4;
    private JButton btn7;
    private JButton btn2;
    private JButton btn3;
    private JButton btnLimpar;
    private JButton btn5;
    private JButton btn6;
    private JButton btn0;
    private JButton btn9;
    private JButton btn8;
    private JButton btnIgual;

    private CalcularOperacao calcularOperacao = new CalcularOperacao();

    public  void exibir(String texto){
        if(txtResultado.getText().equals("0")){
            txtResultado.setText(texto);
        } else {
            txtResultado.setText(txtResultado.getText().concat(texto));
        }
    }

    public void limpar(){
        txtResultado.setText("");
    }



    public static class CalcularOperacao{

        public String operacao;
        public Double total;


        public void escolherConta(String operacao, double valor) {
            this.operacao = operacao;
            this.total = valor;
        }

        public double fazerOperacao(double valor){
            if(operacao.equals("SOMA")){
                total+=valor;
            }else if(operacao.equals("SUBTRAIR")){
                total -= valor;
            }else if(operacao.equals("DIVIDIR")){
                total /= valor;
            }else if(operacao.equals("MULTIPLICAR")){
                total *= valor;
            }
            return total;
        }

        public Double pegarTotal(){
            return this.total;
        }

    }



    public CalculadoraLenda(){

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        btnSoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double primeiroValor = Double.parseDouble(txtResultado.getText());
                calcularOperacao.escolherConta("SOMA", primeiroValor);
                txtResultado.setText("");

            }
        });

        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double primeiroValor = Double.parseDouble(txtResultado.getText());
                calcularOperacao.escolherConta("SUBTRAIR", primeiroValor);
                txtResultado.setText("");

            }
        });

        btnDivisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double primeiroValor = Double.parseDouble(txtResultado.getText());
                calcularOperacao.escolherConta("DIVIDIR", primeiroValor);
                txtResultado.setText("");

            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double primeiroValor = Double.parseDouble(txtResultado.getText());
                calcularOperacao.escolherConta("MULTIPLICAR", primeiroValor);
                txtResultado.setText("");
            }
        });

        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double primeiroValor = Double.parseDouble(txtResultado.getText());
                double resultado = calcularOperacao.fazerOperacao(primeiroValor);

                txtResultado.setText("" + resultado);

            }
        });



        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("0");
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("1");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("2");
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("3");
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("4");
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("5");
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("6");
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("7");
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("8");
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir("9");
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Lenda");
        frame.setContentPane(new CalculadoraLenda().mainPanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}