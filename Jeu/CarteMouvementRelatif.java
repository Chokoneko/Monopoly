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
public class CarteMouvementRelatif extends CarteMouvement{

    private int nombre ;

    public CarteMouvementRelatif(Monopoly monopoly, String texte, int numero,int nombre) {
        super(monopoly, texte, numero);
        this.setNombre(nombre);
    }
    
    @Override
    public void deplacer(Joueur joueur) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    @Override
    public void actionCarte() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
}
