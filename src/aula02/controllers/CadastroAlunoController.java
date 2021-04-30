/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02.controllers;

import aula02.models.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class CadastroAlunoController {
    
    public List<Object[]> carregarDados(){
        List<Object[]> lista = new ArrayList<>();
        
        Aluno model = new Aluno();
        try{
            List<Aluno> alunos = model.listar();
            
            for(Aluno aluno : alunos){
                Object[] obj = new Object[]{
                    aluno.getId(), aluno.getNome(), aluno.getCurso(), aluno.getRA()
                };
                lista.add(obj);
            }
        }catch(Exception erro){
            System.out.println(erro.getMessage());
        }
        return lista;
    }
    
    public boolean incluir(String nome, String curso, String RA) throws SQLException{
        Aluno aluno = new Aluno();
        aluno.setCurso(curso);
        aluno.setNome(nome);
        aluno.setRA(RA);
        
        return aluno.incluir();
    }
    
    public boolean atualizar(String nome, String curso, String RA, int id) throws SQLException{
        Aluno aluno = new Aluno();
        
        aluno.setNome(nome);
        aluno.setCurso(curso);
        aluno.setRA(RA);
        aluno.setId(id);
        
        return aluno.atualizar(id);
    }
    
    public boolean excluir(int id) throws SQLException {
        return new Aluno().excluir(id);
    }
}
