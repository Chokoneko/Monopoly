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
public class CarteArgentRelatifPossessions extends CarteArgent {
    
    private int montantMaison ;
    private int montantHotel ;

    @Override
    public void payerMontant(Joueur joueur) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO.
    }

    /**
     * @return the montantMaison
     */
    public int getMontantMaison() {
        return montantMaison;
    }

    /**
     * @return the montantHotel
     */
    public int getMontantHotel() {
        return montantHotel;
    }

    @Override
    public void actionCarte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
