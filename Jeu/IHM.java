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
             System.out.println("Vous n'avez plus d'argent "+this.getMonopoly().getJoueurCourant().getNomJoueur() +". Vous êtes éliminé . ");
             System.out.println("Tout vos bien ont été saisi et sont de nouveau disponible à l'achat.");
             System.out.println("Il ne reste plus que "+ this.getMonopoly().getJoueurs().size() + " joueur dans la partie !");
         }
        
         
        public void messageTropDeJoueurs(){
            System.out.println("Vous ne pouvez pas ajouter plus de 6 joueurs");                        
        }
         
        public void messageAfficherLancerDesJoueur(Joueur joueur, Integer score){
            System.out.println("Le joueur "+joueur.getNomJoueur()+" à fait un score de "+ score.toString() +"." );                        
        }
        
        public void messageRefusAchat(Joueur joueur, CarreauPropriete carreau){
            System.out.println("Vous avez essayer d'acheter le carreau " +carreau.getNomCarreau() + " cependant il vous manque " + String.valueOf(carreau.getPrixAchat()-joueur.getCash()) +" pour réaliser cet achat");
        }
         
        public void messageAfficherInfoLancerDes(Joueur joueurCourant,Carreau carreauCourant,Integer de1 , Integer de2){
            System.out.println("Joueur " + joueurCourant.getNomJoueur() +" :");
            System.out.println("Vous avez fais "+ de1 + " et "+ de2 + " et vous êtes maintenant sur la case " +carreauCourant.getNomCarreau() + ".");           
        }
	/**
	 * 
	 * @param nom
	 * @param prixAchat
	 */
	public boolean messageDemandeAchat(CarreauPropriete carreauP) { 
//             if (carreauP instanceof ProprieteAConstruire){
//                 System.out.println(" et appartient au groupe " + (ProprieteAConstruire)carreauP.getGroupe() + " ."); //ERREUR NORMAL NE PAS TOUCHER 
//             }
//             else {
//                 System.out.println(".");
//             }
                      
            System.out.println("La propriété vaut "+ String.valueOf(carreauP.getPrixAchat())+" gils.");
            System.out.print("Voulez vous l'acheter (y/n) ?  ");
            
            Scanner sc = new Scanner(System.in);
            String rep;
            rep = "default";
            while (!rep.equals("y") && !rep.equals("n")){
                rep = sc.nextLine();
                if (!rep.equals("y") && !rep.equals("n")){
                    System.out.println("Mauvaise saisie, veuiller recommencer..");
                }            
            }
            return rep.equals("y");
            

	}
        
        public void messageConfirmeAchat(){
                System.out.println("Propriété achetée.");
        }
        public void messageInfosJoueurs(Joueur joueur,Carreau carreau){ 
            
            HashSet<CarreauPropriete> listeProp = new HashSet<CarreauPropriete>();
            
            for (ProprieteAConstruire prop : joueur.getProprietesAConstruire()){
                listeProp.add(prop);
            }
            for (Compagnie comp : joueur.getCompagnies()){
                listeProp.add(comp);
            }
            for (Gare gare : joueur.getGares()){
                listeProp.add(gare);
            }
            
            System.out.println("Informations sur le joueur " + joueur.getNomJoueur() +" :");
            System.out.println("Position: "+ carreau.getNomCarreau()+" Argent: "+Integer.valueOf(joueur.getCash())+" gils");
            if (listeProp.isEmpty()){
                System.out.println("Terrains: Aucuns");
            }
            else{
                System.out.println("Terrains: ");
                for (CarreauPropriete carreauPropriete : listeProp){
                    System.out.println("- " + carreauPropriete.getNom());
                }          
            } 
            System.out.println("");
        }


        
        
       public ProprieteAConstruire messageDemandeChoixProp(){
            System.out.println("Sur quel propriété voulez vous construire (Saisir le numéro ? ");
            int prop;
            Scanner sc = new Scanner(System.in);
            prop = sc.nextInt();
            
            ProprieteAConstruire rep = null;
            for (ProprieteAConstruire p : this.getMonopoly().getJoueurCourant().getProprietesAConstruire()){
                if (prop == p.getNumero()){
                    rep = p;
                }
            }
                  
          return rep;
      } 
        
        
    /**
     * 
     * @return the monopoly
     */
    private Monopoly getMonopoly() {
        return monopoly;
    }
    
    public void messagePlusImmobilier(){
        System.out.println("Construction: Aucune possibilitée. Plus d'immobilier à la banque.");
    }
    
    public void messageAfficherGroupe(Groupe g){
        System.out.println(" Groupe: " + g.getCouleur().toString() + "   Nombre de propriété: " + g.getProprietes().size());
    }
    public void messageAfficherCarte (Carte carte){
        System.out.println(carte.getTexte());
    }
    
    public Groupe messageDemandeChoixGroupe(HashSet<Groupe> liste){
        System.out.print(" Saississez le nom du groupe voulu (la couleur):  ");
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
    
    public void messagePasConstruction(){
        System.out.println("Construction: Pas de possibilité.\n");
    }

    void messagePassageDepart() {
        System.out.println(this.getMonopoly().getJoueurCourant().getNomJoueur() + "passe par la case départ et gagne 200 gils");
    }
    
    public void messageCarteCommunautaire(){
        System.out.println("Vous êtes tombé sur la case Caisse Communautaire ! Vous tirez une carte communautaire !");
    }
    
    public void messageCarteChance(){
        System.out.println("Vous êtes tombé sur la case Chance ! Vous tirez une carte Chance !");
    }
    
    public void messageDebutPartie(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Bonjour et bienvenue dans ce super Monopoly ! \nCopyRight Perez Stocker Rousseau Couiller.");
        System.out.println("\nInscription des joueurs:");
    }
    
    public void messageDeterminationOrdre(){
        System.out.println("\nNous allons maintenant déterminer quel joueur commencera à jouer par un lancé de dé. \nLe score correspond à la somme de vos deux dés.");
    }
    
    public void messageJoueurCommence(Joueur joueur){
        System.out.println("Le joueur " +joueur.getNomJoueur() + " a fait le plus haut score et va donc commencer.\n");
    }
    
    public void messageFinTour(){
        System.out.println("Fin du tour, appuyer sur entrée pour continuer.");
        String fin;
        Scanner sc = new Scanner(System.in);
        fin = sc.nextLine();
        
    }
    
    public boolean messageDemandeReconstruire(){
        System.out.print("Voulez vous faire une autre construction ? (y/n)  ");
        
        Scanner sc = new Scanner(System.in);
        String rep;
        rep = "default";
        
        while (!rep.equals("y") && !rep.equals("n")){
            rep = sc.nextLine();
            if (!rep.equals("y") && !rep.equals("n")){
            System.out.println("Mauvaise saisie, veuiller recommencer..");
            }            
        }
        return rep.equals("y");
    }
    
    public boolean messageDemandeVouloirConstruire(){
        System.out.println("Construction: Vous avez la possibilité");
        System.out.print("Voulez vous construire ? (y/n)  ");
        
        Scanner sc = new Scanner(System.in);
        String rep;
        rep = "default";
        
        while (!rep.equals("y") && !rep.equals("n")){
            rep = sc.nextLine();
            if (!rep.equals("y") && !rep.equals("n")){
            System.out.println("Mauvaise saisie, veuiller recommencer..");
            }            
        }
        return rep.equals("y");
    }
    
    public boolean messageDemandeContinuerConstruire(){
        System.out.print(" Voulez vous toujours construire ? (y/n)  ");
        
                Scanner sc = new Scanner(System.in);
        String rep;
        rep = "default";
        
        while (!rep.equals("y") && !rep.equals("n")){
            rep = sc.nextLine();
            if (!rep.equals("y") && !rep.equals("n")){
            System.out.println("Mauvaise saisie, veuiller recommencer..");
            }            
        }
        return rep.equals("y");
    }
    
    public void messageInfoPrison(Joueur j, int de1, int de2){
       System.out.println("Joueur " + j.getNomJoueur() + " :");
       System.out.println("Vous êtes en prison depuis " + j.getNbTourPrison() + " tours.");
       System.out.println("Résultats des dés: " + String.valueOf(de1 + " et " + String.valueOf(de2)));
    }
    
    public void messagePrisonPaye(){
        System.out.println(" Vous ");
    }
}