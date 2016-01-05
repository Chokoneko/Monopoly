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
public class CarteMouvementAbsolu extends CarteMouvement {
    private Carreau destination ;
    private boolean marcheAvant ; 

    public CarteMouvementAbsolu(Monopoly monopoly, String texte, int numero,Carreau destination, boolean marcheAvant) {
        super(monopoly, texte, numero);
        this.setDestination(destination);
    }

    @Override
    public void deplacer(Joueur joueur) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    @Override
    public void actionCarte() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    /**
     * @return the destination
     */
    public Carreau getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Carreau destination) {
        this.destination = destination;
    }
    
}
