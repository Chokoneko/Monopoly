package Jeu;


import Jeu.Monopoly;
import Jeu.Carreau;

public abstract class CarreauPropriete extends Carreau {

	private Joueur proprietaire;
	private int prixAchat;
	private int loyer;

        public CarreauPropriete(Monopoly newMonopoly,int newNumero, String newNomCarreau, int newPrixAchat){
            super(newMonopoly,newNumero,newNomCarreau);
            this.setPrixAchat(newPrixAchat);
            this.setLoyer(0);
            this.setProprietaire(null);
            
        }

	public int getPrixAchat() {
		return this.prixAchat;
	}

	public Monopoly getMonopoly() {
		return super.getMonopoly();
	}

	public String getNom() {
		return super.getNomCarreau();
	}

	/**
	 * 
	 * @param j
	 */
	public void setProprietaire(Joueur newJoueur) {
		this.proprietaire = newJoueur;
	}

	public Joueur getProprietaire() {
		return this.proprietaire;
	}

	/**
	 * 
	 * @param j
	 */
	public void action(Joueur joueur) {
		Joueur proprietaire = this.getProprietaire();
                
                if (proprietaire != null){
                    int loyer;
                    loyer = this.calculLoyer();
                    
                    proprietaire.setCash(proprietaire.getCash()+loyer);
                    joueur.setCash(joueur.getCash()-loyer);
                                      
                }
                else {
                    this.acheterPropriété(joueur);
                    
                }
                boolean continueConstruire = true;
                while (continueConstruire){
                    continueConstruire = this.construire(joueur);
                }
	}

	public abstract int calculLoyer();

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
    private void setLoyer(int newLoyer) {
        this.loyer = newLoyer;
    }
    
    public abstract void acheterPropriété(Joueur j);
    
    public abstract Groupe getGroupe();

}