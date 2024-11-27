import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//criar um votor para coletar dados do contato
//fazer com que o botão pegue esses dados e envie para p Jlist
//fazer com que o Jlist exiba os contatos
//fazer com que o botão exclua contato selecionado

public class CadastroDeContatos {
    private JPanel mainPanel;
    private JTextField txtNome;
    private JButton btnAddContato;
    private JList<String> listContatos;
    private JButton btnRemoverContato;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JLabel lblAviso;


    DefaultListModel<String> armazenamento = new DefaultListModel<>();

    public String informacaoContato = "";


    public CadastroDeContatos() {

        listContatos.setModel(armazenamento);

        btnAddContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = "";
                String telefone = "";
                String email = "";
                nome = txtNome.getText();
                telefone = txtTelefone.getText();
                email = txtEmail.getText();

                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    lblAviso.setText("Deve Preencher todos os campos");
                    return;
                }

                lblAviso.setText("");

                informacaoContato = nome + " /" + telefone + " /" + email;

                armazenamento.addElement(informacaoContato);

                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");
            }
        });
        btnRemoverContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int elementoSelecionado = listContatos.getSelectedIndex();
                if(elementoSelecionado != -1){
                    armazenamento.remove(elementoSelecionado);
                } else {
                    lblAviso.setText("Não há contatos para remover");
                }


            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new CadastroDeContatos().mainPanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
