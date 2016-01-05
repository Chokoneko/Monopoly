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
    
    public void setProprietaire(Joueur joueur){
        proprietaire=joueur;
    }

    @Override
    public void actionCarte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
