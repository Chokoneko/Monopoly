package Jeu;

public abstract class Carreau {

	private Monopoly monopoly;
	private int numero;
	private String nomCarreau;

        public Carreau (Monopoly newMonopoly,int newNumero, String newNomCarreau){
            this.setMonopoly(newMonopoly);
            this.setNumero(newNumero);
            this.setNomCarreau(newNomCarreau);
        }
	public int getNumero() {
		return this.numero;
	}

	public String getNomCarreau() {
		return this.nomCarreau;
	}

    /**
     * @return the monopoly
     */
    private Monopoly getMonopoly() {
        return monopoly;
    }

    /**
     * @param monopoly the monopoly to set
     */
    private void setMonopoly(Monopoly newMonopoly) {
        this.monopoly = newMonopoly;
    }

    /**
     * @param numero the numero to set
     */
    private void setNumero(int newNumero) {
        this.numero = newNumero;
    }

    /**
     * @param nomCarreau the nomCarreau to set
     */
    private void setNomCarreau(String newNomCarreau) {
        this.nomCarreau = newNomCarreau;
    }
    
    public abstract void action(Joueur j);
    
    public void construire(){
        int nbMaisonDispo, nbHotelDispo;
        nbMaisonDispo = this.getMonopoly().getNbMaisonsRestant();
        nbHotelDispo = this.getMonopoly().getNbHotelsRestant();
        
        if (nbMaisonDispo + nbHotelDispo > 0){
            
        }
        else {
            this.getMonopoly().messagePlusImmobilier();
                    
        }
        
        
    }

}