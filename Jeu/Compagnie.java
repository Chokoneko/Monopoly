package Jeu;


import Jeu.CarreauPropriete;
import Jeu.Monopoly;

public class Compagnie extends CarreauPropriete {

        public Compagnie (Monopoly newMonopoly,int newNumero, String newNomCarreau, int newPrixAchat){
            super(newMonopoly,newNumero,newNomCarreau,newPrixAchat);
            
        }
        
	/**
	 * (d1 + d2) * mod
	 * @param d1
	 * @param d2
	 * @param mod         
	 */
	public int calculPrixLoyerCompagnie(int de1, int de2, int mod) {
            return (de1 +de2) * mod;
	}
        
    /**
     *
     * @param joueur
     */
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
                joueur.addCompagnie(this);
                
                int cashRestant;
                cashRestant = joueur.calculCashRestant(cashJoueur, prixProp);
                joueur.setCash(cashRestant);
                this.getMonopoly().messageConfirmeAchat(joueur);
                        
            }
        }
        else {
            this.getMonopoly().messageRefusAchat(joueur, this); 
        }
    }

    @Override
    public int calculLoyer() {
        Joueur jProprio;
        Joueur jCourant;
        Monopoly monopoly;
        int d1;
        int d2;
        int nbComp;
        int loyer;
        int ca;
        int caRe;
        
        jProprio = this.getProprietaire();
        monopoly = this.getMonopoly();
        jCourant = monopoly.getJoueurCourant();
        
        d1 = monopoly.getDe1();
        d2 = monopoly.getDe2();
        nbComp = jProprio.getNbCompagnie();
        ca = jCourant.getCash();
        
        if (nbComp > 1){
            loyer = this.calculPrixLoyerCompagnie(d1, d2, 10);
        }else{
            loyer = this.calculPrixLoyerCompagnie(d1, d2, 4);
        }
        caRe = jCourant.calculCashRestant(ca, loyer);
        
        monopoly.messageApresLoyer(jProprio, loyer, caRe);
        
        return loyer ;
    }

    @Override //le caste ne fonctionnant pas, obligé de faire sa pour gerer l'affichage des groupe quand on tombe sur une propriété
    public Groupe getGroupe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}