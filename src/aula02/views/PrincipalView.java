package aula02.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PrincipalView extends JFrame {
    
    public void abrir(){
        setSize(800,600);
        setDefaultCloseOperation(3);
        setTitle("Cadastro de Alunos");
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
        criarMenu();
        
        setVisible(true);
    }
    
    private void criarMenu(){
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        
        JMenu cadastroMenu = new JMenu("Cadastro");
        menu.add(cadastroMenu);
        
        JMenu sobreMenu = new JMenu("Sobre");
        menu.add(sobreMenu);
        
        JMenuItem cadastroAlunoItem = new JMenuItem("Alunos");
        cadastroAlunoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroAlunoView cadastroAluno = new CadastroAlunoView();
                cadastroAluno.abrir(600, 800, "Cadastro de Alunos");
            }
        });
        cadastroMenu.add(cadastroAlunoItem);
        
        JMenuItem autorItem = new JMenuItem("Autor");
        //
        autorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AutorView tela = new AutorView();
                tela.abrir(400,400,"Autor do Projeto");
            }
        });
        //
        sobreMenu.add(autorItem);
        
        JMenuItem sairItem = new JMenuItem("Sair");
        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(rootPane, "Você quer sair do sistema?","Confirmação", JOptionPane.YES_NO_OPTION);
                
                if(resposta == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        sobreMenu.add(sairItem);
    }
    
}
