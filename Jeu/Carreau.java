package Jeu;

public abstract class Carreau {

	private Monopoly monopoly;
	private int numero;
	private String nomCarreau;

        public Carreau (Monopoly m,int num,String nom){
            this.setMonopoly(m);
            this.setNumero(num);
            this.setNomCarreau(nom);
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
    private void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }

    /**
     * @param numero the numero to set
     */
    private void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @param nomCarreau the nomCarreau to set
     */
    private void setNomCarreau(String nomCarreau) {
        this.nomCarreau = nomCarreau;
    }

}