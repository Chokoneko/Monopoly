package Jeu;


import Jeu.CarreauPropriete;
import Jeu.Monopoly;

public class Gare extends CarreauPropriete {

    
    public Gare (Monopoly newMonopoly,int newNumero, String newNomCarreau, int newPrixAchat){
             super(newMonopoly,newNumero,newNomCarreau,newPrixAchat);
            
    }
    /**
     * m�thode/ retourne 25 * n
     * @param n
     */
    public int CalculLoyerEffectif(int nombreGarePossedees) {
		return 25 * nombreGarePossedees;
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
                joueur.addGare(this);
                
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
        Joueur jProprio;
        Joueur jCourant;
        Monopoly monopoly;
        int nbGare;
        int ca;
        int caRe;
        int loyer;
        
        monopoly = this.getMonopoly();
        jProprio = this.getProprietaire();
        jCourant = monopoly.getJoueurCourant();
        nbGare = jProprio.getNbGare();
        
        loyer = this.CalculLoyerEffectif(nbGare);
        ca = jCourant.getCash();
        caRe = jCourant.calculCashRestant(ca, loyer);
        
        monopoly.messageApresLoyer(jProprio, loyer, caRe);
        
        return loyer;
    }

}