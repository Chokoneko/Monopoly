package Jeu;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Joueur {
	private Monopoly monopoly;
	private HashSet <Compagnie> compagnies;
	private HashSet<Gare> gares;
	private Carreau positionCourante;
	private HashSet <ProprieteAConstruire> proprietesAConstruire;
	private String nomJoueur;
	private int cash;
	private int nbDouble;
	private int nbTourPrison;
        private ArrayList<CarteLiberePrison> cartesLiberePrison ;

        public Joueur(Monopoly newMonopoly,String newNomJoueur){
            this.setMonopoly(newMonopoly);
            compagnies = new HashSet<>();
            gares = new HashSet<>();
            cartesLiberePrison = new ArrayList<>();
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
	public void setCash(int newCash){
                if (newCash <= 0){
                    this.getMonopoly().faillite(this);
                }else{
                    this.cash = newCash;
                }
        }
        public void reinitStats(){
            
                for (Compagnie comp : this.getCompagnies()){
                        comp.setProprietaire(null);
                }compagnies.clear();
            
                for (Gare gare : this.getGares()){
                        gare.setProprietaire(null);
                }gares.clear();
                
                for (ProprieteAConstruire pac : this.getProprietesAConstruire()){
                        pac.setProprietaire(null);
                }proprietesAConstruire.clear();                             
                for (CarteLiberePrison clp : this.getCartesLiberePrison()){
                        clp.setProprietaire(null);
                }cartesLiberePrison.clear();
        } 
	/**
	 * 
	 * @param g
	 */
	public void addGare(Gare newGare) {
                this.getGares().add(newGare);
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
		return this.proprietesAConstruire;
	}

        public HashSet<Groupe> groupesPossedesEntiers(){
            HashSet<Groupe> gPE = new HashSet(); 
            HashMap<Groupe,Integer> liste = new HashMap () ;
            for (ProprieteAConstruire pAC : this.getProprietesAConstruire()){
                if(!liste.containsKey(pAC.getGroupe())){
                    liste.put(pAC.getGroupe(),1);
                    System.out.println("j'ajoute à la liste provisoire le groupe "+pAC.getGroupe().getCouleur().name());
                }
                else {
                    int nb = liste.get(pAC.getGroupe());
                    liste.remove(pAC.getGroupe());
                    liste.put(pAC.getGroupe(), nb+1);
                    System.out.println("il y a actuellement "+Integer.valueOf(nb+1).toString()+" prop dans le groupe "+pAC.getGroupe().getCouleur().name());
                }
            }
            for (Groupe groupe : liste.keySet()){
                System.out.println(" pour le groupe "+groupe.getCouleur().name()+" il doit y avoir "+Integer.valueOf(groupe.getProprietes().size()).toString());
                                if (liste.get(groupe)==groupe.getProprietes().size()){                    
                    gPE.add(groupe);
                }
            }
            
            return gPE;
           }
        
//        précondition groupepossedeentier
        public boolean groupeConstructible (Groupe groupe) {
            int mini=5 ;
            for (ProprieteAConstruire pAC : groupe.getProprietes()){
                if(pAC.getAttributNbMaison()<mini){
                    mini = pAC.getAttributNbMaison();
                }
            }
            
            return (mini<5 && ((mini<4 && this.getMonopoly().getNbMaisonsRestant()>0)||(mini==4 && this.getMonopoly().getNbHotelsRestant()>0))) ; 
                       
        }
        
        // precondition il y a au moins une case constructible
        public HashSet<ProprieteAConstruire> getCasesConstructibles(Groupe groupe) {
            HashSet<ProprieteAConstruire> casesConstructibles = new HashSet ();
            int mini=5 ;
            for (ProprieteAConstruire pAC : groupe.getProprietes()){
                if(pAC.getAttributNbMaison()<mini){
                    mini = pAC.getAttributNbMaison();
                }
            }
            for (ProprieteAConstruire pAC : groupe.getProprietes()){
                if(pAC.getAttributNbMaison()==mini){
                    casesConstructibles.add(pAC);
                }
            }
            return casesConstructibles ;
        }
               
        
	/**
	 * 
	 * @param c
	 */
	public void addCompagnie(Compagnie newCompagnie) {
		this.getCompagnies().add(newCompagnie);
	}
        
        
      
	/**
	 * 
	 * @param pAC
	 */
	public void addProprieteAConstruire(ProprieteAConstruire newProprieteAConstruire) {
		this.getProprietesAConstruire().add(newProprieteAConstruire);
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
    public HashSet<Compagnie> getCompagnies() {
        return compagnies;
    }

    /**
     * @return the gares
     */
    public HashSet<Gare> getGares() {
        return gares;
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
    public int getNbTourPrison() {
        return nbTourPrison;
    }

    /**
     * @param nbTourPrison the nbTourPrison to set
     */
    public void setNbTourPrison(int newNbTourPrison) {
        this.nbTourPrison = newNbTourPrison;
    }   

    /**
     * @return the CartesLiberePrison
     */
    public ArrayList<CarteLiberePrison> getCartesLiberePrison() {
        return cartesLiberePrison;
    }

    /**
     * @param CartesLiberePrison the CartesLiberePrison to set
     */
    public void addCartesLiberePrison(CarteLiberePrison CarteLiberePrison) {
        this.getCartesLiberePrison().add(CarteLiberePrison);
    }
    
    public void utiliserCartePrison(){
        
        if(this.getCartesLiberePrison().get(0).getNumero()==0){
            this.getMonopoly().getCartesChance().push(this.getCartesLiberePrison().get(0));
        }
        else{
            this.getMonopoly().getCartesCaisseCommunaute().push(this.getCartesLiberePrison().get(0));
        }
        this.getCartesLiberePrison().remove(0);
        this.setNbTourPrison(0);
    }
    
}
