package Jeu;


import Jeu.Monopoly;
import Jeu.Carreau;

public abstract class CarreauPropriete extends Carreau {

	private Joueur proprietaire;
	private int prixAchat;
	private int loyer;

        public CarreauPropriete(Monopoly m,int num, String nom, int pA){
            super(m,num,nom);
            this.setPrixAchat(pA);
            this.setLoyer(0);
            this.setProprietaire(null);
            
        }
	public void acheterPropriete() {
		// TODO - implement CarreauPropriete.acheterPropriete
		throw new UnsupportedOperationException();
	}

	public int getPrixAchat() {
		return this.prixAchat;
	}

	public Monopoly getMonopoly() {
		// TODO - implement CarreauPropriete.getMonopoly
		throw new UnsupportedOperationException();
	}

	public String getNom() {
		// TODO - implement CarreauPropriete.getNom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	public void setProprietaire(Joueur j) {
		this.proprietaire = j;
	}

	public Joueur getProprietaire() {
		return this.proprietaire;
	}

	public void construire() {
		// TODO - implement CarreauPropriete.construire
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	public void action(Joueur j) {
		// TODO - implement CarreauPropriete.action
		throw new UnsupportedOperationException();
	}

	public void calculLoyer() {
		// TODO - implement CarreauPropriete.calculLoyer
		throw new UnsupportedOperationException();
	}

    /**
     * @param prixAchat the prixAchat to set
     */
    private void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    /**
     * @return the loyer
     */
    private int getLoyer() {
        return loyer;
    }

    /**
     * @param loyer the loyer to set
     */
    private void setLoyer(int loyer) {
        this.loyer = loyer;
    }

}