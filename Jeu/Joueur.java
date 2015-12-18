package Jeu;


import Jeu.Carreau;
import Jeu.Compagnie;
import Jeu.Gare;
import Jeu.Monopoly;
import Jeu.ProprieteAConstruire;
import java.util.HashSet;

public class Joueur {
//TODO choisir type collec (hashSet par default)
	private Monopoly monopoly;
	private HashSet <Compagnie> compagnies;
	private HashSet<Gare> gares;
	private Carreau positionCourante;
	private HashSet <ProprieteAConstruire> proprietesAConstruire;
        private HashSet <CarreauPropriete> proprietes;
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

	public void incrementerNbDouble() {
            this.setNbDouble(this.getNbDouble()+1);
	}

	public void reinitialiserNbDouble() {
		this.setNbDouble(0);
	}

	public int getCash() {
		return this.cash;
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
	 * @param g
	 */
	public void addGare(Gare newGare) {
		// TODO - implement Joueur.addGare
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param position
	 */
	public void setPositionCourante(Carreau position) {
		this.positionCourante = position;
	}

	public void incrementerNbTourPrison() {
            nbTourPrison = nbTourPrison + 1;
	}

	public int getNumeroPositionCourante() {
		return positionCourante.getNumero();
        }
        
        public String getNomPositionCourante() {
		return positionCourante.getNomCarreau();
	}
        
	public String getNomJoueur() {
		return this.nomJoueur;
	}

//	public Collection<ProprieteAConstruire> getProprietesAConstruire() {
//		// TODO - implement Joueur.getProprietesAConstruire / modifier "collection"
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
        
        public void addPropriete(CarreauPropriete newCarreauPropriete){
                //TODO - implement Joueur.addPropriete
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
            return gares.length;
	}

	public int getNbCompagnie() {
            return compagnies.length;
	}

	/**
	 * 
	 * @param argentDepart
	 * @param argentSoustrait
	 */
	public int calculCashRestant(int argentDepart, int argentSoustrait) {
		return argentDepart - argentSoustrait;
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
    public int getNbDouble() {
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
    
    /* TODO
    public groupePossédéEntier(){
    }
    
    public addCarteLibereDePrison(){
    }
    */

    /**
     * @return the proprietes
     */
    public CarreauPropriete[] getProprietes() {
        return proprietes;
    }
}
