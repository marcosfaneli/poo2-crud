/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02.models;

import aula02.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
