package Jeu;


import Jeu.Monopoly;
import static java.util.Collections.shuffle;


public class Main {

    
    
	public static void main(String[] args) {          
		Monopoly m = new Monopoly("data.txt","CartesCaisseCommunaute.txt","CartesChance.txt");            
                shuffle(m.getCartesCaisseCommunaute());
                shuffle(m.getCartesChance());
                m.inscrireJoueurs();
                
                m.JouerJeu();

	}
        

}
