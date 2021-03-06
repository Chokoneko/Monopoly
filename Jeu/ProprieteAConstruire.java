package Jeu;


import Jeu.CarreauPropriete;
import Jeu.Monopoly;
import java.util.HashSet;

public class ProprieteAConstruire extends CarreauPropriete {

	private Groupe groupePropriete;
	private int nbMaisons;
	private int[] loyerMaison = new int[6];

        public ProprieteAConstruire (Monopoly newMonopoly,int newNumero, String newNomCarreau, int newPrixAchat,int[] tableLoyer,Groupe newGroupe){
            super(newMonopoly,newNumero,newNomCarreau,newPrixAchat);
            this.setNbMaisons(0);
            this.setLoyerMaison(tableLoyer);
            this.setGroupePropriete(newGroupe);
            this.getGroupe().addPropriete(this);
           
            
        }

        public int getAttributNbMaison (){
            return nbMaisons ;
        }
        
	public int getNbHotel() {
	if (nbMaisons==5){
            return 1;
        }
        else {
            return 0;
        }
	}

        @Override
	public Groupe getGroupe() {
		return (this.groupePropriete);
	}
        

	/**
	 * 
	 * @param nbM
         * 
     * @return 
	 */
	public int caculLoyerEffectif() {
            
            int loyer;
            boolean possedeToutGroupe = false;
            
            HashSet<ProprieteAConstruire> prop;
            int c = 0;
            for (ProprieteAConstruire  pAC : this.getProprietaire().getProprietesAConstruire()){
                if (pAC.getGroupe() == this.getGroupe()){
                    c = c+1;
                }
            }
            
            if (c == this.getGroupe().getProprietes().size()){
               possedeToutGroupe = true;
            }
            
            if ( (this.getNbMaisons() + this.getNbHotel() == 0) && possedeToutGroupe){
                return (this.getLoyerMaison()[0] * 2);
            }
            else {
                return (this.getLoyerMaison()[this.getNbMaisons()]);
            }
        
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
    public int getNbMaisons() {
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
            rep = this.getMonopoly().messageDemandeAchat(this, joueur);
            
            if (rep) {
                this.setProprietaire(joueur);
                joueur.addProprieteAConstruire(this);
                
                int cashRestant;
                cashRestant = joueur.calculCashRestant(cashJoueur, prixProp);
                joueur.setCash(cashRestant);
                this.getMonopoly().getIhm().messageConfirmeAchat(joueur);
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
        loyerEffectif = this.caculLoyerEffectif();
        
        int cashJoueurCourant;
        cashJoueurCourant = this.getMonopoly().getJoueurCourant().getCash();
        
        int cashRestant;
        cashRestant = cashJoueurCourant - loyerEffectif;
        
        Joueur proprio;
        proprio = this.getProprietaire();
        
        this.getMonopoly().messageApresLoyer(proprio, loyerEffectif, cashRestant);
        return loyerEffectif;
    }
    
    public void incrementerNbMaison(){
        this.nbMaisons = this.nbMaisons+1;
    }

}