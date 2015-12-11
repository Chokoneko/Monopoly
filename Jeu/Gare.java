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
		// TODO - implement Gare.CalculLoyerEffectif
		throw new UnsupportedOperationException();
	}

	public int getCashRestant() {
		// TODO - implement Gare.getCashRestant
		throw new UnsupportedOperationException();
	}

	public int getPrix() {
		// TODO - implement Gare.getPrix
		throw new UnsupportedOperationException();
	}

}