package Jeu;


import Jeu.ProprieteAConstruire;
import java.util.ArrayList;

public class Groupe {

	private ArrayList <ProprieteAConstruire> proprietes;
	private CouleurPropriete couleur;
	private int prixAchatMaison;
	private int prixAchatHotel;
        
        public Groupe(CouleurPropriete couleur,int prixAchatMaison,int prixAchatHotel){
            proprietes = new ArrayList();
            this.setCouleur(couleur);
            this.setPrixAchatHotel(prixAchatHotel);
            this.setPrixAchatMaison(prixAchatMaison);
        }

    /**
     * @return the proprietes
     */
    private ArrayList <ProprieteAConstruire> getProprietes() {
        return proprietes;
    }

    /**
     * @param proprietes the proprietes to set
     */
    private void addPropriete(ProprieteAConstruire newProprieteAConstruire) {     
        this.getProprietes().add(newProprieteAConstruire);
    }

    /**
     * @return the couleur
     */
    private CouleurPropriete getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    private void setCouleur(CouleurPropriete newCouleur) {
        this.couleur = newCouleur;
    }

    /**
     * @return the prixAchatMaison
     */
    private int getPrixAchatMaison() {
        return prixAchatMaison;
    }

    /**
     * @param prixAchatMaison the prixAchatMaison to set
     */
    private void setPrixAchatMaison(int newPrixAchatMaison) {
        this.prixAchatMaison = newPrixAchatMaison;
    }

    /**
     * @return the prixAchatHotel
     */
    private int getPrixAchatHotel() {
        return prixAchatHotel;
    }

    /**
     * @param prixAchatHotel the prixAchatHotel to set
     */
    private void setPrixAchatHotel(int newPrixAchatHotel) {
        this.prixAchatHotel = newPrixAchatHotel;
    }

}