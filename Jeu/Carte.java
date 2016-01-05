/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

/**
 *
 * @author couillec
 */
public abstract class Carte {
    
    protected Monopoly monopoly; 
    protected String texte ;
    protected int numero;
    
    public Carte (Monopoly monopoly, String texte,int numero){
        this.setMonopoly(monopoly);
        this.setNumero(numero);
        this.setTexte(texte);
    }
    
    public abstract void actionCarte() ;

    /**
     * @return the monopoly
     */
    protected Monopoly getMonopoly() {
        return monopoly;
    }

    /**
     * @param monopoly the monopoly to set
     */
    protected void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }

    /**
     * @return the texte
     */
    protected String getTexte() {
        return texte;
    }

    /**
     * @param texte the texte to set
     */
    protected void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * @return the numero
     */
    protected int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    protected void setNumero(int numero) {
        this.numero = numero;
    }
    
}
