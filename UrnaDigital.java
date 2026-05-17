/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.urnadigital;


import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class UrnaDigital {

        public static List<Object> cadastrarCandidatos() {
        boolean continuar = true;
        List<Object> listaDosCandidatos = new ArrayList<>();
        
        do {
            String candidato = JOptionPane.showInputDialog(null, "Informe o nome do candidato:", "Cadastro de candidato", JOptionPane.PLAIN_MESSAGE);
            listaDosCandidatos.add(candidato);
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar novo candidato?") == JOptionPane.YES_OPTION ? true : false;
        } while (continuar);
        
        return listaDosCandidatos;
    }
    
    public static Object votar(List<Object> candidatos) {
        return JOptionPane.showInputDialog(
            null, // componente pai
            "Informe o nome ou número do(a) candidato(a):", // pergunta
            "Voto", // título da caixa de diálogo
            JOptionPane.QUESTION_MESSAGE, // tipo de mensagem
            null, // ícone alternativo
            candidatos.toArray(), // vetor de opções predefinidas
            candidatos.toArray()[0] // opção selecionada por padrão                    
        );
    }
    
    public static Object elegerVencedor(List<Object> candidatos, int[] numeroDeVotos) {
        int maiorNumeroDeVotos = Integer.MIN_VALUE;
        int posicao = -1;
        
        for (int i = 0; i < candidatos.size(); i++) {
            if (numeroDeVotos[i] > maiorNumeroDeVotos) {
                maiorNumeroDeVotos = numeroDeVotos[i];   
                posicao = i;
            }
        }
        
        return candidatos.get(posicao);
    }
    
    public static void main(String[] args) {
        boolean continuar = true;
        List<Object> nomesDosCandidatos = cadastrarCandidatos();
        
        int[] numeroDeVotos = new int[nomesDosCandidatos.size()];
        
        do {
            Object voto = votar(nomesDosCandidatos);
            
            for (int i = 0; i < nomesDosCandidatos.size(); i++) {
                if (nomesDosCandidatos.get(i).equals(voto)) {
                    numeroDeVotos[i]++;                    
                }                
            }            

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja registrar um novo voto?");
            if (resposta != JOptionPane.YES_OPTION) {
                continuar = false;
            }
        } while (continuar);
        
        for (int i = 0; i < nomesDosCandidatos.size(); i++) {
            System.out.println(nomesDosCandidatos.get(i) + " : " + numeroDeVotos[i] + " votos");
        }
    }
}


