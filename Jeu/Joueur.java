package Jeu;


import Jeu.Gare;
import Jeu.ProprieteAConstruire;
import Jeu.Compagnie;
import Jeu.Monopoly;
import Jeu.Carreau;

public class Joueur {

	private Monopoly monopoly;
	private Compagnie[] compagnies;
	private Gare[] gares;
	private Carreau positionCourante;
	private ProprieteAConstruire[] proprietesAConstruire;
	private String nomJoueur;
	private int cash;
	private int nbDouble;
	private int nbTourPrison;

        public Joueur(Monopoly newMonopoly,String newNomJoueur){
            this.setMonopoly(newMonopoly);
            compagnies = new Compagnie[2];
            gares = new Gare[4];
            positionCourante = newMonopoly.getCarreau(1);
            proprietesAConstruire = new ProprieteAConstruire[22];
            this.setNomJoueur(newNomJoueur);
            this.setCash(1500);
            this.setNbDouble(0);
            this.setNbTourPrison(0);
            
        }
	/**
	 * 
	 * @param l
	 */
	public void payerLoyer(int newLoyer) {
		// TODO - implement Joueur.payerLoyer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 */
	public void recevoirLoyer(int newLoyer) {
		// TODO - implement Joueur.recevoirLoyer
		throw new UnsupportedOperationException();
	}

	public int incrementerNbDouble() {
		// TODO - implement Joueur.incr�menterNbDouble
		throw new UnsupportedOperationException();
	}

	public int reinitialiserNbDouble() {
		// TODO - implement Joueur.reinitialiserNbDouble
		throw new UnsupportedOperationException();
	}

	public int getCash() {
		return this.cash;
	}

	/**
	 * 
	 * @param g
	 */
	public void addGare(Gare newGare) {
		// TODO - implement Joueur.addGare
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newCash
	 */
	public void setCash(int newCash) {
		this.cash = newCash;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPositionCourante(Carreau position) {
		this.positionCourante = position;
	}

	public void incrementerNbTourPrison() {
		// TODO - implement Joueur.incrementerNbTourPrison
		throw new UnsupportedOperationException();
	}

	public int getNumeroPositionCourante() {
		// TODO - implement Joueur.getNum�roPositionCourante
		throw new UnsupportedOperationException();
	}

	public String getNomJoueur() {
		return this.nomJoueur;
	}

	public String getNomPositionCourante() {
		// TODO - implement Joueur.getNomPositionCourante
		throw new UnsupportedOperationException();
	}

//	public Collection<ProprieteAConstruire> getProprietesAConstruire() {
//		// TODO - implement Joueur.getProprietesAConstruire
//		throw new UnsupportedOperationException();
//	}

	/**
	 * 
	 * @param c
	 */
	public void addCompagnie(Compagnie newCompagnie) {
		// TODO - implement Joueur.addCompagnie
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pAC
	 */
	public void addProprieteAConstruire(ProprieteAConstruire newProprieteAConstruire) {
		// TODO - implement Joueur.addPropri�t�AConstruire
		throw new UnsupportedOperationException();
	}

	public int getNbGare() {
		// TODO - implement Joueur.getNbGare
		throw new UnsupportedOperationException();
	}

	public int getNbCompagnie() {
		// TODO - implement Joueur.getNbCompagnie
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argentDepart
	 * @param argentSoustrait
	 */
	public int calculCashRestant(int argentDepart, int argentSoustrait) {
		// TODO - implement Joueur.calculCashRestant
		throw new UnsupportedOperationException();
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
     * @return the compagnies
     */
    private Compagnie[] getCompagnies() {
        return compagnies;
    }

    /**
     * @param compagnies the compagnies to set
     */
    private void setCompagnies(Compagnie[] newCompagnies) {
        this.compagnies = newCompagnies;
    }

    /**
     * @return the gares
     */
    private Gare[] getGares() {
        return gares;
    }

    /**
     * @param gares the gares to set
     */
    private void setGares(Gare[] newGares) {
        this.gares = newGares;
    }

    /**
     * @return the positionCourante
     */
    private Carreau getPositionCourante() {
        return positionCourante;
    }

    /**
     * @param proprietesAConstruire the proprietesAConstruire to set
     */
    private void setProprietesAConstruire(ProprieteAConstruire[] newProprietesAConstruire) {
        this.proprietesAConstruire = newProprietesAConstruire;
    }

    /**
     * @param nomJoueur the nomJoueur to set
     */
    private void setNomJoueur(String newNomJoueur) {
        this.nomJoueur = newNomJoueur;
    }

    /**
     * @return the nbDouble
     */
    private int getNbDouble() {
        return nbDouble;
    }

    /**
     * @param nbDouble the nbDouble to set
     */
    private void setNbDouble(int newNbDouble) {
        this.nbDouble = newNbDouble;
    }

    /**
     * @return the nbTourPrison
     */
    private int getNbTourPrison() {
        return nbTourPrison;
    }

    /**
     * @param nbTourPrison the nbTourPrison to set
     */
    private void setNbTourPrison(int newNbTourPrison) {
        this.nbTourPrison = newNbTourPrison;
    }

}
