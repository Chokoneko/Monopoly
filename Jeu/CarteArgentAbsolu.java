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
public class CarteArgentAbsolu extends CarteArgent {
    private int montant;

    public CarteArgentAbsolu(Monopoly monopoly, String texte, int numero,int montant) {
        super(monopoly, texte, numero);
        this.setMontant(montant);
    }

    
    @Override
    public void payerMontant(Joueur joueur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionCarte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
