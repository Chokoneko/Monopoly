/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

/**
 *
 * @author couillec
 */
public abstract class CarteMouvement extends Carte {

    public CarteMouvement(Monopoly monopoly, String texte, int numero) {
        super(monopoly, texte, numero);
    }
    
    public abstract void  deplacer (Joueur joueur);
    
}
