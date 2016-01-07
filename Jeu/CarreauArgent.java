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
    public int getMontant() {
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
        
        if (position == 5 || position == 39){
            this.getMonopoly().messageCaseArgentPaie(this);
            cash = j.getCash();
            j.setCash(cash + montant);
        }
        else{
            this.getMonopoly().messageCaseArgentRien();
        }
        
        boolean continueConstruire = true;
        while (continueConstruire){
            continueConstruire = this.construire(j);
        }
    }
}