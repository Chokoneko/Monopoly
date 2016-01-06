package Jeu;

public class CarreauTirage extends CarreauAction {
     public CarreauTirage(Monopoly newMonopoly,int newNumero, String newNomCarreau){
        super(newMonopoly,newNumero,newNomCarreau);
    
    }

    @Override
    public void action(Joueur j) {
        int position;
        
        position = this.getNumero();
        if (this.getNumero() == 3 || this.getNumero() == 18 || this.getNumero() == 34){
                this.getMonopoly().getIhm().messageCarteCommunautaire();
                this.getMonopoly().tirerUneCarte(this.getMonopoly().getCartesCaisseCommunaute());
                 
        }else{
                this.getMonopoly().getIhm().messageCarteChance();
                this.getMonopoly().tirerUneCarte(this.getMonopoly().getCartesChance());
        }
    }
}