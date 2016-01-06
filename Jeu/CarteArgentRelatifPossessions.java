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
        this.getMonopoly().getIhm().messageAfficherCarte(this);
        int montantTotal=0 ;
        for (ProprieteAConstruire pAC : this.getMonopoly().getJoueurCourant().getProprietesAConstruire()){
            montantTotal=montantTotal+(pAC.getNbHotel()*this.getMontantHotel())+(pAC.getNbMaisons()*this.getMontantMaison());
        }        
        this.getMonopoly().getJoueurCourant().setCash(this.getMonopoly().getJoueurCourant().getCash()-montantTotal);
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
