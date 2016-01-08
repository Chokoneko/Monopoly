package Jeu;


import Jeu.Monopoly;
import static java.util.Collections.shuffle;
import java.awt.Color;
import java.util.Scanner;

public class Main {

    
    
	public static void main(String[] args) {          
		Monopoly m = new Monopoly("data.txt","CartesCaisseCommunaute.txt","CartesChance.txt");
                
                System.out.println("Voulez vous jouer en mode démo ?(y/n)");
                Scanner sc = new Scanner(System.in);
                String rep= sc.nextLine();
                while (!rep.equals("y") && !rep.equals("n")){
                    System.out.println("Mauvaise saisie (y/n)");
                    rep= sc.nextLine();
                }
                if (rep == ("n")){
                    m.setModeDemo(false);
                    shuffle(m.getCartesCaisseCommunaute());
                    shuffle(m.getCartesChance());
                }else{
                    m.setModeDemo(true);
                }
                
                m.inscrireJoueurs();
                
                m.JouerJeu();
        
        
	}
        

}
