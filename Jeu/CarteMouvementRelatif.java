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
    public void actionCarte() {
        this.getMonopoly().getIhm().messageAfficherCarte(this);
        this.getMonopoly().getJoueurCourant().setPositionCourante(this.getMonopoly().getCarreau(this.getMonopoly().getJoueurCourant().getPositionCourante().getNumero() + this.getNombre())); 
        this.getMonopoly().messageNouvellePosition(this.getMonopoly().getJoueurCourant().getPositionCourante());
        this.getMonopoly().getJoueurCourant().getPositionCourante().action(this.getMonopoly().getJoueurCourant());
        

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
