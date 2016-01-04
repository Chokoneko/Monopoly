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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}