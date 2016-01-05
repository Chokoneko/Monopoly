package Jeu;

import java.util.HashSet;

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
    protected Monopoly getMonopoly() {
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
    
    public void construire(Joueur joueur){
        int nbMaisonDispo, nbHotelDispo;
        nbMaisonDispo = this.getMonopoly().getNbMaisonsRestant();
        nbHotelDispo = this.getMonopoly().getNbHotelsRestant();
        
        if (nbMaisonDispo + nbHotelDispo > 0){
            HashSet<Groupe> collecGroupeEntié;
            collecGroupeEntié = this.getMonopoly().getNumeroJoueurCourant().groupePossedeEntie();
            
            if (collecGroupeEntié != null){
                
                for (Groupe g: collecGroupeEntié){
                    
                    boolean groupeCons;
                    groupeCons = g.groupeConstructible();
                    
                    HashSet<Groupe> listeGroupeConstructible = new HashSet<Groupe>();
                    
                    if (groupeCons){
                        listeGroupeConstructible.add(g);
                    }
                }
                
                if (listeGroupeConstructible != null){
                    
                    for (Groupe g: listeGroupeConstructible){
                        this.getMonopoly().messageAfficherGroupe(g);
                    }
                    
                    Groupe groupe;
                    groupe = this.getMonopoly().messageDemandeChoixGroupe;
                    
                    HashSet<ProprieteAConstruire> collecProp = new HashSet<ProprieteAConstruire>();
                    collecProp = groupe.getCasesConstructibles;
                    
                    if (collecProp != null){
                        
                        for (ProprieteAConstruire prop : collecProp){
                            this.getMonopoly().messageAfficherProp(prop);                          
                        }
                        
                        ProprieteAConstruire prop;
                        prop = this.getMonopoly().messageDemandeChoixProp;
                        
                        int nbMaison, prix;
                        nbMaison = prop.getNbMaisons();
                        
                        Groupe gr;
                        gr = prop.getGroupe();
                                
                        if (nbMaison == 4){
                            prop.incrementerNbMaison();
                            this.getMonopoly().setNbMaisonsRestant(this.getMonopoly().getNbMaisonsRestant()+4);
                            this.getMonopoly().setNbHotelsRestant(this.getMonopoly().getNbHotelsRestant()-1);
                            prix = gr.getPrixAchatHotel();
                        }
                        else {
                            prop.incrementerNbMaison();
                            this.getMonopoly().setNbMaisonsRestant(this.getMonopoly().getNbMaisonsRestant()-1); 
                            prix = gr.getPrixAchatMaison();
                        }
                  
                        joueur.setCash(joueur.getCash()-prix);
                       
                    }
                    else {
                        this.getMonopoly().messagePasPropConstructible();
                    }
                            
                    
                }
                else {
                    this.getMonopoly().messagePasGroupeConstructible();
                }
                
                
            }
            else {
                this.getMonopoly().messagePasDeGroupeEntier();
            }
            
        }
        else {
            this.getMonopoly().messagePlusImmobilier();                   
        }
        
        
    }

}