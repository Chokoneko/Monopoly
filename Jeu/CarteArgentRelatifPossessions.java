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

    public CarteArgentRelatifPossessions(Monopoly monopoly, String texte, int numero, int montantMaison, int montantHotel) {
        super(monopoly, texte, numero);
        this.setMontantHotel(montantHotel);
        this.setMontantMaison(montantMaison);
    }

    @Override
    public void payerMontant(Joueur joueur) {
        int montantTotal=0 ;
        montantTotal=joueur.getProprietesAConstruire().
        joueur.setCash(joueur.getCash()-montantTotal);
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

    /**
     * @param montantMaison the montantMaison to set
     */
    private void setMontantMaison(int montantMaison) {
        this.montantMaison = montantMaison;
    }

    /**
     * @param montantHotel the montantHotel to set
     */
    private void setMontantHotel(int montantHotel) {
        this.montantHotel = montantHotel;
    }

}
