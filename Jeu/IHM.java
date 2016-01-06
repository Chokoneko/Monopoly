package Jeu;


import Jeu.Monopoly;
import java.util.HashSet;
import java.util.Scanner;

public class IHM {

	private Monopoly monopoly;

        
	/**
	 * 
	 * @param proprietaire
	 * @param prix
	 * @param cashRestant
	 */
	public void messageApresLoyer(Joueur proprietaire, Integer prix, Integer cashRestant) {
		System.out.println("Vous devez payer "+prix.toString()+" gils au joueur "+ proprietaire.getNomJoueur()+". Il vous restera "+cashRestant.toString()+" gils." );
	}

	public String saisieRep() {
		Scanner sc = new Scanner(System.in);
                return sc.nextLine();
	}

        public String messageDemanderNom (){
            System.out.print("Nom Joueur : ");
            Scanner sc = new Scanner(System.in);            
            return sc.nextLine() ;
            
        }
         public boolean messageAjouterJoueur (){
            String rep ;
            rep = "default";
            while (!rep.equals("y") && !rep.equals("n")){
                System.out.println("Voulez vous ajouter un autre joueur ? (y/n)");
                Scanner sc = new Scanner(System.in);
                rep = sc.nextLine();
                if (!rep.equals("y") && !rep.equals("n")){
                    System.out.println("Mauvaise saisie, veuiller recommencer..");
                }
            }
            //rep = sc.toString();
            return rep.equals("y");
            
        }
        
         public void messageFaillite(){
             System.out.println("Game Over "+this.getMonopoly().getJoueurCourant().getNomJoueur());            
         }
        
         
        public void messageTropDeJoueurs(){
            System.out.println("Vous ne pouvez pas ajouter plus de 6 joueurs");                        
        }
         
        public void messageAfficherLancerDesJoueur(Joueur joueur, Integer score){
            System.out.println("Le joueur "+joueur.getNomJoueur()+" à fait un score de "+ score.toString() );                        
        }
        
        public void messageRefusAchat(Joueur joueur, CarreauPropriete carreau){
            System.out.println("Vous avez essayer d'acheter le carreau " +carreau.getNomCarreau() + " cependant il vous manque " + String.valueOf(carreau.getPrixAchat()-joueur.getCash()) +" pour réaliser cet achat");
        }
         
        public void messageAfficherInfoLancerDes(Joueur joueurCourant,Carreau carreauCourant,Integer score){
            this.messageAfficherLancerDesJoueur(joueurCourant, score);
            System.out.println("Il est maintenant sur la case "+ carreauCourant.getNomCarreau());                       
        }
	/**
	 * 
	 * @param nom
	 * @param prixAchat
	 */
	public boolean messageDemandeAchat(CarreauPropriete carreauP) { 
            System.out.print("La propriété s'appelle "+carreauP.getNom());
             if (carreauP instanceof ProprieteAConstruire){
                 System.out.println(" et appartient au groupe " + (ProprieteAConstruire)carreauP.getGroupe() + " ."); //ERREUR NORMAL NE PAS TOUCHER 
             }
             else {
                 System.out.println(".");
             }
                      
            System.out.println("Elle vaut"+ String.valueOf(carreauP.getPrixAchat())+"gils.");//TODO Integer ou int ?
            System.out.println("Voulez vous l'acheter ?");
            
            boolean rep;
            Scanner sc = new Scanner(System.in);
            rep = sc.nextBoolean();
            
            return rep;

	}
        public void messageInfosJoueurs(Joueur joueur,Carreau carreau){
            
            System.out.println("Le joueur "+joueur.getNomJoueur()+" est sur la case "+ carreau.getNomCarreau()+" il possède "+Integer.valueOf(joueur.getCash())+" gils");
            if (joueur.getProprietes()==null){
                System.out.println("Ce joueur ne possède aucunes terres");
            }
            else{
                System.out.println("Ce joueur ne possède les terres suivantes :");
                for (CarreauPropriete carreauPropriete : joueur.getProprietes()){
                    System.out.println(carreauPropriete.getNom());
                }                    
            }            
        }


        
        
      public ProprieteAConstruire messageDemandeChoixProp(){
//             System.out.println("Sur quel propriété voulez vous construire ?");
//             //this.saisieRep()
//            
          return null;
      }// TODO benj je pige pas comment tu veux faire
        
        
    /**
     * 
     * @return the monopoly
     */
    private Monopoly getMonopoly() {
        return monopoly;
    }
    
    public void messagePlusImmobilier(){
        System.out.println(" Aucune possibilitée de construction ce tour-ci car il ne reste ni hotel ni maison à la banque.");
    }
    
    public void messageAfficherGroupe(Groupe g){
        System.out.println(" Groupe: " + g.getCouleur().toString() + "   Nombre de propriété: " + g.getProprietes().size());
    }
    
    
    public Groupe messageDemandeChoixGroupe(HashSet<Groupe> liste){
        System.out.println(" Saississez le nom du groupe voulu (la couleur).");
        String groupe;
        Scanner sc = new Scanner(System.in);
        groupe = sc.nextLine(); 
        
        CouleurPropriete coul;
        coul = CouleurPropriete.valueOf(groupe);
        
        Groupe rep = null;
        for (Groupe g: liste){
            if (g.getCouleur() == coul){
                rep = g;
            }            
        }
        
        return rep;
        
    }
    
    
    public void messageAfficherProp(ProprieteAConstruire prop){
        System.out.println("Propriété: " + prop.getNom() + "    Numéro: " +prop.getNumero()) ;
        System.out.println("Nombre de maison: " + prop.getNbMaisons() + "    Nombre d'hotel " +prop.getNbHotel());
    }
    
    public void messagePasDeGroupeEntier(){
        System.out.println(" Vous ne possédez pas de groupe de terrain complet vous ne pouvez donc pas construire.");
    }
    
    public void messagePasGroupeConstructible(){
        System.out.println(" Vous ne possédez pas de groupe constructible et vous ne pouvez donc pas construire.");
    }

    void messagePassageDepart() {
        System.out.println(this.getMonopoly().getJoueurCourant().getNomJoueur() + "passe par la case départ et gagne 200 gils");
    }

}