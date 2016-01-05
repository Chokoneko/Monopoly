package Jeu;


import java.util.HashMap;
import java.util.HashSet;

public class Joueur {
//TODO choisir type collec (hashSet par default - corps des methode a modifier)
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
        private HashSet<CarteLiberePrison> CartesLiberePrison ;

        public Joueur(Monopoly newMonopoly,String newNomJoueur){
            this.setMonopoly(newMonopoly);
            compagnies = new HashSet<>();
            gares = new HashSet<>();
            positionCourante = newMonopoly.getCarreau(1);
            proprietesAConstruire = new HashSet<>();
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
		this.cash = newCash; // TODO  verifier l'argent du joueur et le mettre en game over
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

	/*public int getNumeroPositionCourante() {
		return positionCourante.getNumero();
        }*/
        
        public Carreau getPositionCourante() {
		return positionCourante;
	}
        
	public String getNomJoueur() {
		return this.nomJoueur;
	}

	public HashSet<ProprieteAConstruire> getProprietesAConstruire() {
		// TODO - implement Joueur.getProprietesAConstruire / modifier "collection"
		throw new UnsupportedOperationException();
	}

        public HashSet<Groupe> groupesPossedesEntiers(){
            HashSet<Groupe> gPE = new HashSet(); 
            HashMap<Groupe,Integer> liste = new HashMap () ;
            for (ProprieteAConstruire pAC : this.getProprietesAConstruire()){
                if(!liste.containsKey(pAC.getGroupe())){
                    liste.put(pAC.getGroupe(), 1);
                }
                else {
                    int nb = liste.get(pAC.getGroupe());
                    liste.remove(pAC.getGroupe());
                    liste.put(pAC.getGroupe(), nb+1);
                }
            }
            for (Groupe groupe : liste.keySet()){
                if (liste.get(groupe)==groupe.getProprietes().size()){
                    gPE.add(groupe);
                }
            }
            
            return gPE;
           }
        
        //précondition groupepossedeentier
//        public boolean groupeConstructible (Groupe groupe) {
//    
//        }
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
            return this.gares.size();
	}

	public int getNbCompagnie() {
            return this.compagnies.size();
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
    private HashSet<Compagnie> getCompagnies() {
        return compagnies;
    }

    /**
     * @param compagnies the compagnies to set
     */
    private void setCompagnies(Compagnie newCompagnies) {
        this.compagnies.add(newCompagnies);
    }

    /**
     * @return the gares
     */
    private HashSet<Gare> getGares() {
        return gares;
    }

    /**
     * @param gares the gares to set
     */
    private void setGares(Gare newGares) {
        this.gares.add(newGares);
    }

    /**
     * @param proprietesAConstruire the proprietesAConstruire to set
     */
    private void setProprietesAConstruire(ProprieteAConstruire newProprietesAConstruire) {
        this.proprietesAConstruire.add(newProprietesAConstruire);
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
    public HashSet<CarreauPropriete> getProprietes() {
        return proprietes;
    }

    /**
     * @return the CartesLiberePrison
     */
    public HashSet<CarteLiberePrison> getCartesLiberePrison() {
        return CartesLiberePrison;
    }

    /**
     * @param CartesLiberePrison the CartesLiberePrison to set
     */
    public void addCartesLiberePrison(CarteLiberePrison CarteLiberePrison) {
        this.getCartesLiberePrison().add(CarteLiberePrison);
    }
}
