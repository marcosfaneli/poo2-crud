/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02.controllers;

import aula02.models.Aluno;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class CadastroAlunoController {
    
    public boolean incluir(String nome, String curso, String RA) throws SQLException{
        Aluno aluno = new Aluno();
        aluno.setCurso(curso);
        aluno.setNome(nome);
        aluno.setRA(RA);
        
        return aluno.incluir();
    }
    
    public boolean atualizar(){
        return true;
    }
    
    public boolean excluir(){
        return true;
    }
}
