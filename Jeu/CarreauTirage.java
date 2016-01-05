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
                System.out.println("Vous êtes tombé sur la case Caisse Communautaire ! Vous tirez une carte communautaire !");
                this.getMonopoly().tirerUneCarte(carteCaisseCommunautaire);
                 
        }else{
                System.out.println("Vous êtes tombé sur la case Chance ! Vous tirez une carte Chance !");
                this.getMonopoly().tirerUneCarte(carteChance);
        }


        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}