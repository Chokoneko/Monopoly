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
public class CarteArgentAnniversaire extends CarteArgent {
    private int montant ; 

    public CarteArgentAnniversaire(Monopoly monopoly, String texte, int numero, int montant) {
        super(monopoly, texte, numero);
        this.setMontant(montant);
    }

   

    @Override
    public void actionCarte() {
        this.getMonopoly().getJoueurCourant().setCash(this.getMonopoly().getJoueurCourant().getCash()+this.getMonopoly().getJoueurs().size()*10);
        for(Joueur joueur : this.getMonopoly().getJoueurs()){
            joueur.setCash(joueur.getCash()-10);
        }
       
         
    }

    /**
     * @return the montant
     */
    public int getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(int montant) {
        this.montant = montant;
    }
    
}
