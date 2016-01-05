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
public class CarteLiberePrison extends Carte {
    
    private Joueur proprietaire;

    public CarteLiberePrison(Monopoly monopoly, String texte, int numero) {
        super(monopoly, texte, numero);
    }
    
    public void setProprietaire(Joueur joueur){
        proprietaire=joueur;
    }

    @Override
    public void actionCarte() {
        this.setProprietaire(this.getMonopoly().getJoueurCourant());
        this.getMonopoly().getJoueurCourant().addCartesLiberePrison(this);
    }
    
}
