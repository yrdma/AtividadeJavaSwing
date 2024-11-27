import javax.swing.*;

public class AgendaDiaria {

    private JPanel mainPanel;
    private JTextField txtCompromisso;
    private JSpinner spinDataHora;
    private JButton btnAddCompromisso;
    private JTable tableCompromissos;
    private JButton btnRemoverCompromisso;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        frame.setContentPane(new AgendaDiaria().mainPanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
