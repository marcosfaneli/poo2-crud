package aula02.views;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AutorView extends AbstractView{

    @Override
    public void criarComponentesDaTela() {
        JLabel lblNomeAutor = new JLabel("Autor do Projeto: Marcos Faneli");
        lblNomeAutor.setBounds(10, 20, 300, 20);
        add(lblNomeAutor);
        
        BufferedImage image;
        
        try{
            File file = new File("images/metallica.jpg");
            image = ImageIO.read(file);
            
            ImageIcon icon = new ImageIcon(image);
            
            JLabel lblImagem = new JLabel(icon);
            lblImagem.setBounds(10, 50, 360, 300);
            add(lblImagem);
            
        }catch(Exception e){
            System.out.println("Ocorreu um erro ao ler a imagem: "+ e.getMessage());
        }
    }
    
}
