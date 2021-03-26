package aula02;

import aula02.database.Conexao;
import aula02.views.PrincipalView;

public class Aula02 {

    public static void main(String[] args) {
        Conexao con = new Conexao();
        boolean conectado = con.conectar();
        
        if(conectado == true){
            PrincipalView tela = new PrincipalView();
            tela.abrir();
        }else {
            System.out.println("Não foi possível conectar ao banco");
        }
    }
}
