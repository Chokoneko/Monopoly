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
	 */
	public int calculPrixLoyerCompagnie(int d1, int d2, int mod) {
		// TODO - implement Compagnie.calculPrixLoyerCompagnie
		throw new UnsupportedOperationException();
	}

}