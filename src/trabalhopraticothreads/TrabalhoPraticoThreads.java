/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopraticothreads;

import java.util.Scanner;

/**
 *
 * @author WilmarVitorFonseca
 */
public class TrabalhoPraticoThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner primeiroLutador = new Scanner(System.in);
        Scanner segundoLutador = new Scanner(System.in);

        System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=");
        System.out.println("Bem Vindo ao Clube da Luta!");
        System.out.println("");
        System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=");

        System.out.println("Por Favor insira o nome do primeiro lutador da luta!");
        String nomePrimeiroLutador = primeiroLutador.nextLine();

        System.out.println("Qual sera seu fator de foçar para o calculo de dano de cada golpe");
        double fatorForcaPrimeiroLutador = primeiroLutador.nextDouble();

        System.out.println("Qual é o valor de vigor deste lutador?");
        double vigorPrimeiroLutador = primeiroLutador.nextDouble();

        System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=");
        
        System.out.println("Por Favor insira o nome do segundo lutador da luta!");
        
        String nomeSegundoLutador = segundoLutador.nextLine();

        System.out.println("Qual sera seu fator de foçar para o calculo de dano de cada golpe");
        double fatorSegundoLutador = segundoLutador.nextDouble();

        System.out.println("Qual é o valor de vigor deste lutador?");
        double vigorSegundoLutador = segundoLutador.nextDouble();

        System.out.println("=-=-=-=-=-==-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=");

        System.out.println("Aguarde que a Luta já ira começar em instantes!");

        Lutador lutador1 = new Lutador(nomePrimeiroLutador, fatorForcaPrimeiroLutador, vigorPrimeiroLutador);
        Lutador lutador2 = new Lutador(nomeSegundoLutador, fatorSegundoLutador, vigorSegundoLutador);

        lutador1.setInimigo(lutador2);
        lutador2.setInimigo(lutador1);

        lutador1.start();
        lutador2.start();
    }

}
