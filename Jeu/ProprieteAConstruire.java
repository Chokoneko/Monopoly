package Jeu;


import Jeu.CarreauPropriete;
import Jeu.Monopoly;

public class ProprieteAConstruire extends CarreauPropriete {

	private Groupe groupePropriete;
	private int nbMaisons;
	private int[] loyerMaison;

        public ProprieteAConstruire (Monopoly newMonopoly,int newNumero, String newNomCarreau, int newPrixAchat,int[] tableLoyer,Groupe newGroupe){
            super(newMonopoly,newNumero,newNomCarreau,newPrixAchat);
            this.setNbMaisons(0);
            this.setLoyerMaison(tableLoyer);
            this.setGroupePropriete(newGroupe);
           
            
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
	public int caculLoyerEffectif(int nbMaisons) {
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
    private void setGroupePropriete(Groupe newGroupePropriete) {
        this.groupePropriete = newGroupePropriete;
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
    private void setNbMaisons(int newNbMaisons) {
        this.nbMaisons = newNbMaisons;
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
    private void setLoyerMaison(int[] newLoyerMaison) {
        this.loyerMaison = newLoyerMaison;
    }

    @Override 
    public void acheterPropriété() {
        this.setProprietaire(this.getMonopoly().getJoueurCourant());
        this.getMonopoly().getJoueurCourant().addProprieteAConstruire(this);
    }

    @Override
    public int calculLoyer() {
        int nombreMaison;
        nombreMaison = this.getNbMaisons();
        
    }

}