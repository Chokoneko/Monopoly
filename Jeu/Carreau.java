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
    
    public boolean construire(Joueur joueur){
        
        boolean continueConstruire = true;
        int nbMaisonDispo, nbHotelDispo;
        nbMaisonDispo = this.getMonopoly().getNbMaisonsRestant();
        nbHotelDispo = this.getMonopoly().getNbHotelsRestant();
         HashSet<Groupe> listeGroupeConstructible = new HashSet<Groupe>();
        if (nbMaisonDispo + nbHotelDispo > 0){
            HashSet<Groupe> collecGroupeEntier;
            collecGroupeEntier = this.getMonopoly().getJoueurCourant().groupesPossedesEntiers();
            
            if (!collecGroupeEntier.isEmpty()){
                
                for (Groupe g: collecGroupeEntier){
                    
                    boolean groupeCons;
                    groupeCons = joueur.groupeConstructible(g);
                    
                   
                    
                    if (groupeCons){
                        listeGroupeConstructible.add(g);
                    }
                }
                
                if (!listeGroupeConstructible.isEmpty()){
                    
                    boolean veuxAcheter = this.getMonopoly().messageDemandeVouloirAcheter();
                    
                    if (veuxAcheter){
                    
                        for (Groupe g: listeGroupeConstructible){
                            this.getMonopoly().messageAfficherGroupe(g);
                        }
                        
                        boolean surAcheter = this.getMonopoly().messageDemandeContinuerAcheter();
                        
                        if (surAcheter){

                            HashSet<Groupe> liste = new HashSet<Groupe>();
                            for (ProprieteAConstruire prop: joueur.getProprietesAConstruire()){
                                if (!liste.contains(prop.getGroupe())){
                                    liste.add(prop.getGroupe());
                                }
                            }                  

                            Groupe groupe;
                            groupe = this.getMonopoly().messageDemandeChoixGroupe(liste);

                            HashSet<ProprieteAConstruire> collecProp = new HashSet<ProprieteAConstruire>();
                            collecProp = joueur.getCasesConstructibles(groupe);



                            for (ProprieteAConstruire prop : collecProp){
                                this.getMonopoly().messageAfficherProp(prop);                          
                            }
                            
                            surAcheter = this.getMonopoly().messageDemandeContinuerAcheter();

                            if (surAcheter){
                                

                                ProprieteAConstruire prop;
                                prop = this.getMonopoly().messageDemandeChoixProp(joueur);

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

                                continueConstruire = this.getMonopoly().messageDemandeReconstruire();
                            }
                        }                        
                        else {
                            continueConstruire = this.getMonopoly().messageDemandeReconstruire();
                        }
                    }
                    else {
                        continueConstruire = this.getMonopoly().messageDemandeReconstruire();
                    }
                       
                            
                    
                }
                else {
                    this.getMonopoly().messagePlusImmobilier();
                    continueConstruire = false;
                }
                
                
            }
            else {
                this.getMonopoly().messagePasConstruction();
                continueConstruire = false;
            }
            
        }
        else {
            this.getMonopoly().messagePlusImmobilier(); 
            continueConstruire = false;
        }
        
        return continueConstruire;     
        
        
    }
    

}