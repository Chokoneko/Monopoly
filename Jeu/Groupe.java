package Jeu;


import Jeu.ProprieteAConstruire;
import java.util.ArrayList;

public class Groupe {

	private ArrayList <ProprieteAConstruire> proprietes;
	private CouleurPropriete couleur;
	private int prixAchatMaison;
	private int prixAchatHotel;
        
        public Groupe(CouleurPropriete c,int pAM,int pAH){
            proprietes = new ArrayList();
            this.setCouleur(c);
            this.setPrixAchatHotel(pAH);
            this.setPrixAchatMaison(pAM);
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
    private void addPropriete(ProprieteAConstruire p) {     
        this.getProprietes().add(p);
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
    private void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
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
    private void setPrixAchatMaison(int prixAchatMaison) {
        this.prixAchatMaison = prixAchatMaison;
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
    private void setPrixAchatHotel(int prixAchatHotel) {
        this.prixAchatHotel = prixAchatHotel;
    }

}