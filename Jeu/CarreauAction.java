package Jeu;


public abstract class CarreauAction extends Carreau {
    
    public CarreauAction(Monopoly newMonopoly,int newNumero, String newNomCarreau){
        super(newMonopoly,newNumero,newNomCarreau);
        
    
    }
    
    public abstract void action(Joueur j);
    
}