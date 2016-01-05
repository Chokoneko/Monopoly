package Jeu;


import Jeu.CarreauPropriete;
import Jeu.Monopoly;

public class ProprieteAConstruire extends CarreauPropriete {

	private Groupe groupePropriete;
	private int nbMaisons;
	private int[] loyerMaison = new int[5];

        public ProprieteAConstruire (Monopoly newMonopoly,int newNumero, String newNomCarreau, int newPrixAchat,int[] tableLoyer,Groupe newGroupe){
            super(newMonopoly,newNumero,newNomCarreau,newPrixAchat);
            this.setNbMaisons(0);
            this.setLoyerMaison(tableLoyer);
            this.setGroupePropriete(newGroupe);
           
            
        }

	public int getNbHotel() {
	if (nbMaisons==5){
            return 1;
        }
        else {
            return 0;
        }
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
        if (nbMaisons<5){
            return nbMaisons;
        }
        else {
            return 0;
        }
        
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
    public void acheterPropriété(Joueur joueur) {
        
        int cashJoueur;
        int prixProp;
        
        cashJoueur = joueur.getCash();
        prixProp = this.getPrixAchat();
        
        if (cashJoueur > prixProp){
            boolean rep;
            rep = this.getMonopoly().messageDemandeAchat(this);
            
            if (rep) {
                this.setProprietaire(joueur);
                joueur.addProprieteAConstruire(this);
                
                int cashRestant;
                cashRestant = joueur.calculCashRestant(cashJoueur, prixProp);
                joueur.setCash(cashRestant);
                        
            }
        }
        else {
            this.getMonopoly().messageRefusAchat(joueur, this); 
        }
        

    }

    @Override
    public int calculLoyer() {
        int nombreMaison;
        nombreMaison = this.getNbMaisons();
        
        int loyerEffectif;
        loyerEffectif = this.getLoyerMaison()[nombreMaison-1];
        
        int cashJoueurCourant;
        cashJoueurCourant = this.getMonopoly().getJoueurCourant().getCash();
        
        int cashRestant;
        cashRestant = cashJoueurCourant - loyerEffectif;
        
        Joueur proprio;
        proprio = this.getProprietaire();
        
        this.getMonopoly().messageApresLoyer(proprio, loyerEffectif, cashRestant);
        return loyerEffectif;
    }
    
    public int calculLoyerEffectif(int nombreMaison){
        return (this.getLoyerMaison()[nombreMaison-1]);
    }

}