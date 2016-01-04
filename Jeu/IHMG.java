
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author couillec
 */
public class IHMG {
    
    public static JFrame fenetrePrincipale;               // Une fenêtre dans laquelle on va afficher l'IHM du jeu
    private JPanel       panPlateau;                      // pannel pour afficher le plateau  
    
    public void CreationPlateau() {
        // Instanciation de la fenêtre 
        fenetrePrincipale = new JFrame("Test IHM Contact");
        // Indique de sortir du programme lorsque la fenêtre est fermée par l'utilisateur
        fenetrePrincipale.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        fenetrePrincipale.setSize(900, 800);
        
        fenetrePrincipale.getContentPane().setLayout(new BorderLayout());
        fenetrePrincipale.getContentPane().add(panPlateau, BorderLayout.CENTER);
        panPlateau.setLayout(new GridLayout(13,13)); // découpage des cases, les angles sont des carré de deux carreau, les autres des rectagles de 1 par 2
    }
    
    public void CreationCases() {
//        panPlateau.add(pan1);
    }
}
