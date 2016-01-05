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
public class CarteAllerPrison extends CarteMouvementAbsolu{

    public CarteAllerPrison(Monopoly monopoly, String texte, int numero, Carreau destination) {
        super(monopoly, texte, numero, destination,true);
    }
    
    @Override
    public void actionCarte() {
       
    }
    
}
