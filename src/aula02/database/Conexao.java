package aula02.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private final String usuario = "root";
    private final String senha = "";
    private final String url = "jdbc:mysql://127.0.0.1:3306/cadastro";
    
    private static Connection connection;
    
    public static Connection getConexao(){
        return connection;
    }
    
    public boolean conectar(){
        try{
            connection = DriverManager.getConnection(url,usuario, senha);
            return true;
        }catch(SQLException erro){
            erro.printStackTrace();
        }
        return false;
    }
}
