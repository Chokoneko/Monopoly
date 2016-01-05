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
	 * @param mod c'est quoi ça déjà ? TODO le rennomer comme il faut 
         *          --> c'est le modulo qui dépend du nombre de compagnie que le joueur possède. (1 compagnie -> mod=4 / 2 compagnies -> mod=10)
	 */
	public int calculPrixLoyerCompagnie(int d1, int d2, int mod) {
		// TODO - implement Compagnie.calculPrixLoyerCompagnie
            return (d1 +d2) * mod;
		//throw new UnsupportedOperationException();
	}

    @Override //TODO  faire la fonction
    public void acheterPropriété(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}