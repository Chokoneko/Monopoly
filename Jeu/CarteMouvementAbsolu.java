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
public class CarteMouvementAbsolu extends CarteMouvement {
    private Carreau destination ;
    private boolean marcheAvant ; 

    public CarteMouvementAbsolu(Monopoly monopoly, String texte, int numero,Carreau destination, boolean marcheAvant) {
        super(monopoly, texte, numero);
        this.setDestination(destination);
        this.setMarcheAvant(marcheAvant);
    }

    

    @Override
    public void actionCarte() {
        if (this.isMarcheAvant()&&this.PasseParDepart(this.getMonopoly().getJoueurCourant().getPositionCourante().getNumero(), this.getDestination().getNumero())){
            this.getMonopoly().passerParDepart();
        }
        this.getMonopoly().getJoueurCourant().setPositionCourante(destination);
    }

    /**
     * @return the destination
     */
    public Carreau getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Carreau destination) {
        this.destination = destination;
    }

    /**
     * @return the marcheAvant
     */
    public boolean isMarcheAvant() {
        return marcheAvant;
    }

    /**
     * @param marcheAvant the marcheAvant to set
     */
    public void setMarcheAvant(boolean marcheAvant) {
        this.marcheAvant = marcheAvant;
    }
    
}
