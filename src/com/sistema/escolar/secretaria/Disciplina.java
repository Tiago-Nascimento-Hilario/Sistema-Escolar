package com.sistema.escolar.secretaria;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private List<String> disciplinas = new ArrayList<>();

    // metodos geters e set
    public List<String> getDisciplinas() {
        return disciplinas;}
    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;}


     //método mostrar menu
    public void mostrarMenu(){
        String escolhaDoUsuario = JOptionPane.showInputDialog(null,"MENU-GERENCIAMENTO-DISCIPLINAS\n1-Adicionar\n2-Excluir\n3-Consultar");
        if (Integer.parseInt(escolhaDoUsuario) == 1){
            adicionarDisciplina();
        } else if (Integer.parseInt(escolhaDoUsuario)==2) {
            excluirDiscplina();
        } else if (Integer.parseInt(escolhaDoUsuario)==3) {
            if (disciplinas.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não há disciplina cadastrada");
                mostrarMenu();
                }else {
                consultar();
                }
            }

        }
        //método para adicionar disciplina
    public void adicionarDisciplina(){

        String disciplina = (JOptionPane.showInputDialog(null,"Adicione o nome da disciplina"));
        if (disciplinas.contains(disciplina)){
            JOptionPane.showMessageDialog(null, disciplina + " Já esta cadastrada");
        }else {
            disciplinas.add(disciplina);
        }
    int escolhaDoUsuarioAdicionarOutraDisciplina=JOptionPane.showConfirmDialog(null, "Deseja adicionar outra disciplina?");
        if (escolhaDoUsuarioAdicionarOutraDisciplina == 0){
            adicionarDisciplina();
        } else if (escolhaDoUsuarioAdicionarOutraDisciplina == 1) {
            listarDisciplinas();
            JOptionPane.showMessageDialog(null,"SECRETARIA E CONTROLE\nselecione OK para finalizar");
            mostrarMenu();
        }
    }
    // metodo para listar disciplinas
    public void listarDisciplinas(){
        int confimarAdicaoDeDisciplina = JOptionPane.showConfirmDialog(null, "As disciplinas listadas estão corretas?\n" + disciplinas.toString());
        if (confimarAdicaoDeDisciplina == 0){
            JOptionPane.showMessageDialog(null, "Disciplinas adicionadas com secesso!");
        }else {
            mostrarMenu();
        }
    }
    // metodo para excluir disciplina
    public void excluirDiscplina(){
        if (disciplinas.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não ha discplina cadastrada!");
        }else {
        String escolhaDoUsuarioExluir = JOptionPane.showInputDialog(null,"Informe o nome da disciplina para excluir");
        disciplinas.remove(escolhaDoUsuarioExluir);
        }
        mostrarMenu();
    }
    public void consultar(){
        JOptionPane.showMessageDialog(null,"" + disciplinas.toString());
        mostrarMenu();
    }

    @Override
    public String toString() {
        return "\nDisciplina{" +
                "\ndisciplinas=" + disciplinas +
                '}';
    }
}

