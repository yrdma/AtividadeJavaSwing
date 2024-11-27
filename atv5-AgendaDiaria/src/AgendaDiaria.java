import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

//iserir os compromissos em uma variavel e mandar para o Jtable
//enviar data e hora com o Jspinner
//usar o botão para excluir o compromisso

public class AgendaDiaria {

    private JPanel mainPanel;
    private JTextField txtCompromisso;
    private JSpinner spnHora;
    private JButton btnAddCompromisso;
    private JTable tableCompromissos;
    private JButton btnRemoverCompromisso;
    private JSpinner spnData;
    private JLabel lblAviso;

    DefaultTableModel model = (DefaultTableModel) tableCompromissos.getModel();


    private void configSpinners() {
        spnData.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorData = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editorData);


        spnHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spnHora, "HH:mm");
        spnHora.setEditor(editorHora);
    }


    public AgendaDiaria() {
        configSpinners();
        DefaultTableModel modeloTable = new DefaultTableModel(
                new String[]{"Compromisso", "Data", "Hora"}, 0
        );
        tableCompromissos.setModel(modeloTable);


        btnAddCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atividade = txtCompromisso.getText();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(spnData.getValue());
                String hora = new SimpleDateFormat("HH:mm").format(spnHora.getValue());
                if (atividade.isBlank()) {
                    lblAviso.setText("Favor declare o nome da atividade");


                } else {

                    modeloTable.addRow(new Object[]{atividade, data, hora});


                    txtCompromisso.setText("");
                    lblAviso.setText("");
                }
            }
        });
        btnRemoverCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tableCompromissos.getSelectedRow();

                if(linhaSelecionada != -1) {
                    modeloTable.removeRow(linhaSelecionada);
                    lblAviso.setText("");
                }else {
                    lblAviso.setText("Selecione um compromisso para remover");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        frame.setContentPane(new AgendaDiaria().mainPanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
