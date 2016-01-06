package Jeu;

public class CarreauArgent extends CarreauAction {

	private int montant;

        public CarreauArgent(Monopoly newMonopoly,int newNumero, String newNomCarreau,int newMontant){
            super(newMonopoly,newNumero,newNomCarreau);
            this.setMontant(newMontant);
        }

    /**
     * @return the montant
     */
    private int getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    private void setMontant(int newMontant) {
        this.montant = newMontant;
    }

    @Override
    public void action(Joueur j) {
        int cash;
        int position;
        
        position = this.getNumero();
        
        if (position == 5){
            System.out.println("Vous êtes tombé sur la case Impôts sur le revenu ! Vous devez payer "+ this.getMontant() +" gils.");
            cash = j.getCash();
            j.setCash(cash + montant);
        }else{
            System.out.println("Vous êtes tombé sur la case Taxes de Luxe ! Vous devez payer "+ this.getMontant() +" gils.");
            cash = j.getCash();
            j.setCash(cash + montant);
        }
    }
}