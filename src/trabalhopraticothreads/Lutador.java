/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopraticothreads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WilmarVitorFonseca
 */
public class Lutador extends Thread {

    private String nomeLutador;
    private double fatorForça;
    private double vigor;
    private Lutador inimigo;

    public Lutador(String nomeLutador, double fatorForça, double vigor) {
        this.nomeLutador = nomeLutador;
        this.fatorForça = fatorForça;
        this.vigor = vigor;
    }

    public String getNomeLutador() {
        return nomeLutador;
    }

    public double getVigor() {
        return vigor;
    }

    public void setVigor(double vigor) {
        this.vigor = vigor;
    }

    public Lutador getInimigo() {
        return inimigo;
    }

    public void setInimigo(Lutador inimigo) {
        this.inimigo = inimigo;
    }

    @Override
    public void run() {
        Random geradorMovimentos = new Random();
        int proximoGolpe;
        double danoCausado;
        int tempoReacao;
        do {
            try {
                tempoReacao = (geradorMovimentos.nextInt(6)+3) * 1000;
                Thread.sleep(tempoReacao);
            } catch (InterruptedException ex) {
            }
            if (this.vigor > 0) {
                proximoGolpe = geradorMovimentos.nextInt(4);
                switch (proximoGolpe) {
                    case 0:
                        System.out.println("O Lutador " + this.nomeLutador + " acertou um Direto");
                        danoCausado = geradorMovimentos.nextInt(3) * this.fatorForça * -1;
                        break;
                    case 1:
                        System.out.println("O Lutador " + this.nomeLutador + " acertou um Jab");
                        danoCausado = (geradorMovimentos.nextInt(3) + 2) * this.fatorForça * -1;
                        break;
                    case 3:
                        System.out.println("O Lutador " + this.nomeLutador + " acertou um Uppercut");
                        danoCausado = (geradorMovimentos.nextInt(3) + 4) * this.fatorForça * -1;
                        break;
                    default:
                        System.out.println("O Lutador " + this.nomeLutador + " esta imovel");
                        danoCausado = 0;
                        break;
                }
                danoCausado += this.inimigo.getVigor();
                this.inimigo.setVigor(danoCausado);
            }
        } while (this.inimigo.getVigor() > 0 && this.vigor > 0);
        if (this.vigor <= 0) {
            System.out.println("-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=");
            System.out.println("E " + this.nomeLutador + " foi nocauteado!!!");
            System.out.println("E o novo campeão é o lutador " + this.inimigo.getNomeLutador());
        }
    }
}
