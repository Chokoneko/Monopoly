package Jeu;

public class CarreauMouvement extends CarreauAction {
     public CarreauMouvement(Monopoly newMonopoly,int newNumero, String newNomCarreau){
        super(newMonopoly,newNumero,newNomCarreau);

    
    }

    @Override
    public void action(Joueur j) {
        
        System.out.println("Vous allez en prison !");
        j.incrementerNbTourPrison();
        j.setPositionCourante(this.getMonopoly().getCarreau(11));
        
        

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}