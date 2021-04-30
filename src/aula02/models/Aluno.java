/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02.models;

import aula02.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Aluno {
    
    private int id;
    private String nome;
    private String curso;
    private String RA;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public boolean incluir() throws SQLException{
        String sql = "insert into alunos(nome, curso, ra) values (?,?,?)";
        
        PreparedStatement prepare = Conexao.getConexao().prepareStatement(sql);
        prepare.setString(1, nome);
        prepare.setString(2, curso);
        prepare.setString(3, RA);
        
        return prepare.execute();
    }
    
    public List<Aluno> listar() throws SQLException{
        
        List<Aluno> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM cadastro.alunos";
        
        ResultSet result = Conexao.getConexao().createStatement().executeQuery(sql);
        
        while(result.next()){
            Aluno aluno = new Aluno();
            aluno.setCurso(result.getString("curso"));
            aluno.setId(result.getInt("id"));
            aluno.setNome(result.getString("nome"));
            aluno.setRA(result.getString("ra"));
            
            lista.add(aluno);
        }
        
        return lista;
    }
    
    public boolean excluir(int id) throws SQLException{
        String sql = "DELETE FROM alunos WHERE id = ?";
        
        PreparedStatement pst = Conexao.getConexao().prepareStatement(sql);
        pst.setInt(1, id);
        
        return pst.execute();
    }
    
    public boolean atualizar(int id) throws SQLException{
        String sql = "UPDATE alunos SET nome = ?, curso = ?, ra = ? WHERE id = ?";
        
        PreparedStatement pst = Conexao.getConexao().prepareStatement(sql);
        
        pst.setString(1, nome);
        pst.setString(2, curso);
        pst.setString(3, RA);
        pst.setInt(4, id);
        
        return pst.execute();
    }
}
