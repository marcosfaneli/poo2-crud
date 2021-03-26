package aula02.views;

import javax.swing.JDialog;
import javax.swing.JFrame;

public abstract class AbstractView extends JDialog {
    
    public void abrir(int altura, int largura, String titulo){
        setSize(largura,altura);
        setLocationRelativeTo(null);
        setTitle(titulo);
        setLayout(null);
        
        criarComponentesDaTela();
        
        setVisible(true);
    }
    
    public abstract void criarComponentesDaTela();
    
}
