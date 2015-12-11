package Jeu;

public class CarreauArgent extends CarreauAction {

	private int montant;

        public CarreauArgent(Monopoly m,int num,String nom,int mt){
            super(m,num,nom);
            this.setMontant(mt);
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
    private void setMontant(int montant) {
        this.montant = montant;
    }
}