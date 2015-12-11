package Jeu;


import Jeu.CarreauPropriete;
import Jeu.Monopoly;

public class ProprieteAConstruire extends CarreauPropriete {

	private Groupe groupePropriete;
	private int nbMaisons;
	private int[] loyerMaison;

        public ProprieteAConstruire (Monopoly m,int num, String nom, int pA,int[] tabL,Groupe g){
            super(m,num,nom,pA);
            this.setNbMaisons(0);
            this.setLoyerMaison(tabL);
            this.setGroupePropriete(g);
           
            
        }
	public int getNbMaison() {
		// TODO - implement ProprieteAConstruire.getNbMaison
		throw new UnsupportedOperationException();
	}

	public int getNbHotel() {
		// TODO - implement ProprieteAConstruire.getNbHotel
		throw new UnsupportedOperationException();
	}

	public Groupe getGroupe() {
		// TODO - implement ProprieteAConstruire.getGroupe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nbM
	 */
	public int caculLoyerEffectif(int nbM) {
		// TODO - implement ProprieteAConstruire.caculLoyerEffectif
		throw new UnsupportedOperationException();
	}

    /**
     * @return the groupePropriete
     */
    private Groupe getGroupePropriete() {
        return groupePropriete;
    }

    /**
     * @param groupePropriete the groupePropriete to set
     */
    private void setGroupePropriete(Groupe groupePropriete) {
        this.groupePropriete = groupePropriete;
    }

    /**
     * @return the nbMaisons
     */
    private int getNbMaisons() {
        return nbMaisons;
    }

    /**
     * @param nbMaisons the nbMaisons to set
     */
    private void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    /**
     * @return the loyerMaison
     */
    private int[] getLoyerMaison() {
        return loyerMaison;
    }

    /**
     * @param loyerMaison the loyerMaison to set
     */
    private void setLoyerMaison(int[] loyerMaison) {
        this.loyerMaison = loyerMaison;
    }

}