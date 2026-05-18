/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//LINK PARA ACESSO AO CHAT DA IA QUE AUXILIOU NOS COMENTÁRIOS --> https://claude.ai/share/c0bc6468-829c-4b2e-a593-9edc6895650e


package com.mycompany.urnadigital;


import javax.swing.JOptionPane; // Importar a classe swing para interface gráfica
import java.util.List; // Importar a classe de listas que forma um "contrato" que vai possuir os métodos
import java.util.ArrayList; // Importar a classe de ArrayList para armazenamento dos dados e implementação dos métodos da classe list
/**
 *
 * @author joaofranco
 */
public class UrnaDigital {

        public static List<Object> cadastrarCandidatos() {
        // Método que retorna uma List<Object>, ou seja, uma lista que pode
        // armazenar qualquer tipo de objeto, pois Object é a superclasse de
       // todas as classes em Java.
                
        boolean continuar = true;
        //Criação de uma variável para auxiliar no loop.
        List<Object> listaDosCandidatos = new ArrayList<>();
        //Criação da ArrayList para armazenar os candidatos.
                
        do {   //Inicialização do loop
            String candidato = JOptionPane.showInputDialog(null, "Informe o nome do candidato:", "Cadastro de candidato", JOptionPane.PLAIN_MESSAGE);
                //Com a interface gráfica "showInputDialog" o usuário pode escrever o nome de um candidato que será cadastrado.
                //O "PLAIN_MESSAGE" é utilizado para que não haja simbolos gráficos
                
            listaDosCandidatos.add(candidato);
              // Quando um candidato for implementado, ele ira ser adcionado à lista.
                
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar novo candidato?") == JOptionPane.YES_OPTION ? true : false;
        //Após o cadastro, será aberta uma aba de confirmação (showConfirmDialog) que questionará ao usuário se deseja implementar outro candidato ou não;
        //Há a utilização do operador ternário substituindo o IF...ELSE
                
        } while (continuar);
        //Há o loop enquanto a condição for verdadeira (continuar = true)
        return listaDosCandidatos;
        // Retorna a lista de candidatos após a quebra de condição do loop (continuar = false)
    }
    
    public static Object votar(List<Object> candidatos) {
        return JOptionPane.showInputDialog(
            null, // componente pai que se encontra nulo por não haver parâmetros que o completem (Não tem JFrame).
            "Informe o nome ou número do(a) candidato(a):", // pergunta
            "Voto", // título da caixa de diálogo
            JOptionPane.QUESTION_MESSAGE, // tipo de mensagem
            null, // ícone alternativo
            candidatos.toArray(), // vetor de opções predefinidas
            candidatos.toArray()[0] // opção selecionada por padrão                 
        );
    }
    
    public static Object elegerVencedor(List<Object> candidatos, int[] numeroDeVotos) { 
            //Método estático para eleger vencedor onde os parâmetros necessários são 
            //a lista com os candidatos e o numero de votos que corresponde a cada um deles.
            
        int maiorNumeroDeVotos = Integer.MIN_VALUE;
            //A análise de votos deve se iniciar no menor valor possivel, sendo necessário o uso do Integer.MIN_VALUE (Menor número possivel em java) para evitar problemas.
        int posicao = -1;
           // "Guarda" o lugar do vencedor, pois as outras posições do vetor pertencem a um candidato, funcionando como uma posição "fantasma".
        for (int i = 0; i < candidatos.size(); i++) {
                //Percorre todos os candidatos da lista
            if (numeroDeVotos[i] > maiorNumeroDeVotos) { 
               // Verifica se o candidato atual tem mais votos
               // do que o maior número de votos registrado até o momento.
                maiorNumeroDeVotos = numeroDeVotos[i];
                posicao = i;
                //Atualiza o número de votos e guarda a posição.
            }
        }
        
        return candidatos.get(posicao);
            //Ao fim da análise, retorna o candidato vencedor.
    }
    
    public static void main(String[] args) { 
            
        boolean continuar = true;
            //Variável de controle do loop
        List<Object> nomesDosCandidatos = cadastrarCandidatos();
            //Chama o método cadastrarCandidatos() e guarda o resultado — a lista de nomes — na variável nomesDosCandidatos. 
        int[] numeroDeVotos = new int[nomesDosCandidatos.size()];
            //Cria um array com o o mesmo tamanho da lista de candidatos.
        do {
            Object voto = votar(nomesDosCandidatos);
            // Aqui o programa abre a caixa de diálogo para o usuário escolher um candidato, passando a lista nomesDosCandidatos como parâmetro
           // e armazena na variável voto.
                
            for (int i = 0; i < nomesDosCandidatos.size(); i++) { 
                    //Percorre toda a lista de candidatos pelo índice i, de 0 até o último. O objetivo é achar qual candidato o usuário votou.
                if (nomesDosCandidatos.get(i).equals(voto)) { 
                   // Compara o conteúdo da posição.
                    numeroDeVotos[i]++;    
                   // Incrementa 1 no candidato que recebeu o voto.
                }                
            }            

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja registrar um novo voto?"); // Variável para armazenar a resposta da pergunta sobre novo voto.
            if (resposta != JOptionPane.YES_OPTION) { // Verifica se a resposta foi DIFERENTE de "sim".
                continuar = false; // Finaliza a interface caso a verificação for verdadeira.
            }
        } while (continuar); //Loop enquanto continuar = true.
        
        for (int i = 0; i < nomesDosCandidatos.size(); i++) { // Percorre o ArrayList.
            System.out.println(nomesDosCandidatos.get(i) + " : " + numeroDeVotos[i] + " votos"); // Mostra o candidato com seu respectivo número de votos.
        }
    }
}
