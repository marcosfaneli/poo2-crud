package aula02.views;

import aula02.controllers.CadastroAlunoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroAlunoView extends AbstractView {
    
    private JLabel lblNome;
    private JTextField txtNome;
    
    private JLabel lblCurso;
    private JTextField txtCurso;
    
    private JLabel lblRA;
    private JTextField txtRA;
    
    private JButton btnIncluir;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    
    private CadastroAlunoController controller = new CadastroAlunoController();

    @Override
    public void criarComponentesDaTela() {
        criarCampoTexto();
        criarBotoes();
    }
    
    private void criarBotoes(){
        btnIncluir = new JButton("Incluir");
        btnIncluir.setBounds(10,100,100,30);
        btnIncluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.incluir(txtNome.getText(), txtCurso.getText(), txtRA.getText());
                    JOptionPane.showMessageDialog(rootPane, "Usuário salvo com sucesso");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao salvar o aluno.");
                }
            }
        });
        add(btnIncluir);
        
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(120, 100, 100, 30);
        add(btnAtualizar);
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(230, 100, 100, 30);
        add(btnExcluir);
    }
    
    private void criarCampoTexto(){
        lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 10, 50, 20);
        add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(60, 10, 600, 20);
        add(txtNome);
        
        lblCurso = new JLabel("Curso");
        lblCurso.setBounds(10, 40, 50, 20);
        add(lblCurso);
        
        txtCurso = new JTextField();
        txtCurso.setBounds(60, 40, 250, 20);
        add(txtCurso);
        
        lblRA = new JLabel("RA");
        lblRA.setBounds(10, 70, 50, 20);
        add(lblRA);
        
        txtRA = new JTextField();
        txtRA.setBounds(60, 70, 100, 20);
        add(txtRA);
    }
        
}
