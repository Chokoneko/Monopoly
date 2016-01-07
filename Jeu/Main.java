package Jeu;


import Jeu.Monopoly;
import static java.util.Collections.shuffle;
import java.awt.Color;

public class Main {

    
    
	public static void main(String[] args) {          
		Monopoly m = new Monopoly("data.txt","CartesCaisseCommunaute.txt","CartesChance.txt");
                m.setModeDemo(true);
//                shuffle(m.getCartesCaisseCommunaute());
//                shuffle(m.getCartesChance());
//                    System.out.println("\033[41m"+"This text is red.");
                m.inscrireJoueurs();
                
                 
        
        
	}
        

}
