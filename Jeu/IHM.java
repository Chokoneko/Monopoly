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
                System.out.print("Voulez vous ajouter un autre joueur ? (y/n) ");
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
         
        public void messageAfficherInfoLancerDes(Joueur joueurCourant,Carreau carreauCourant,int de1 , int de2){
            System.out.println("Joueur " + joueurCourant.getNomJoueur() +" :");
            System.out.println("Vous avez fait "+ de1 + " et "+ de2 + " et vous êtes maintenant sur la case " +carreauCourant.getNomCarreau() + ".");           
        }
	/**
	 * 
	 * @param nom
	 * @param prixAchat
	 */
	public boolean messageDemandeAchat(CarreauPropriete carreauP, Joueur joueur) { 
             if (carreauP instanceof ProprieteAConstruire){
                 System.out.println("Elle appartient au groupe " + carreauP.getGroupe().getCouleur().toString() + " ."); //ERREUR NORMAL NE PAS TOUCHER 
             }
            
            System.out.print("La propriété vaut "+ String.valueOf(carreauP.getPrixAchat())+" gils.");
            System.out.println(" Vous disposez de "+ String.valueOf(joueur.getCash())+" gils.");
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
        
        public void messageConfirmeAchat(Joueur j){
                System.out.println("\nPropriété achetée. Il vous reste " +String.valueOf(j.getCash()) + "gils.");
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
            System.out.println("Position: "+ carreau.getNomCarreau()+"     Argent: "+Integer.valueOf(joueur.getCash())+" gils");
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


        
        
       public ProprieteAConstruire messageDemandeChoixProp(Joueur j){
            System.out.print("Sur quel propriété voulez vous construire (Saisir le numéro) ?  ");
            int prop;
            Scanner sc = new Scanner(System.in);
            prop = sc.nextInt();
            
            ProprieteAConstruire rep = null;
            for (ProprieteAConstruire p : j.getProprietesAConstruire()){
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
    
    public void messageAfficherGroupe(HashSet<Groupe> liste){
        System.out.println("\nVos groupes constructibles: ");
        for (Groupe groupe : liste){
            System.out.println("Groupe: " + groupe.getCouleur().toString() + "   Nombre de propriété: " + groupe.getProprietes().size());
        }
    }
    public void messageAfficherCarte (Carte carte){
        System.out.println(carte.getTexte());
    }
    
    public Groupe messageDemandeChoixGroupe(HashSet<Groupe> liste){
        System.out.print("Saississez le nom du groupe voulu (la couleur):  ");
        String groupe;
        Scanner sc = new Scanner(System.in);
        //while (CouleurPropriete.valueOf(groupe) == null){
            groupe = sc.nextLine(); 
            //if (CouleurPropriete.valueOf(groupe) == null){
                //System.out.println("Mauvaise saisie, recommencez.");
            //}
        //}
        
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
    
    
    public void messageAfficherProp(HashSet<ProprieteAConstruire> liste){
        System.out.println("\nVos propriétés:");
        for (ProprieteAConstruire prop : liste){
            System.out.print("Propriété: " + prop.getNom() + "    Numéro: " +prop.getNumero()) ;
            System.out.println("    Nombre de maison: " + prop.getNbMaisons() + "    Nombre d'hotel: " +prop.getNbHotel());
        }
        System.out.print("");
    }
    
    public void messagePasConstruction(){
        System.out.println("Construction: Pas de possibibilité.\n");
    }

    void messagePassageDepart(Joueur j) {
        System.out.println(j.getNomJoueur() + " passe par la case départ et gagne 200 gils");
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
        System.out.println("------------------------------------------------------\n");
    }
    
    public void messageFinTour(){
        System.out.println("Fin du tour, appuyer sur entrée pour continuer.");
        String fin;
        Scanner sc = new Scanner(System.in);
        fin = sc.nextLine();
        System.out.println("------------------------------------------------------\n");
        
    }
    
    public boolean messageDemandeReconstruire(Joueur j){
        System.out.println("Construction bien effectuée. Il vous reste " + String.valueOf(j.getCash()) +"gils.");
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
        System.out.println("");
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
        System.out.print("\nVoulez vous toujours construire ? (y/n)  ");
        
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
    
    public void messageInfoPrison(Joueur j){
       System.out.println("Joueur " + j.getNomJoueur() + " :");
       System.out.println("Vous êtes en prison depuis " + j.getNbTourPrison() + " tours.");
    }
    
    public void messageAfficherDes(int de1, int de2){
        System.out.println("Résultats des dés: " + String.valueOf(de1 + " et " + String.valueOf(de2)));
    }
    
    public void messagePrisonPaye(Joueur j){
        System.out.println("Toujours pas de double");
        System.out.println("Vous avez purgé votre peine et payer 50 gils");
        System.out.println("Vous avancez et êtes maintenant sur la case " + j.getPositionCourante().getNomCarreau());
    }
    
    public void messageRestePrison(){
        System.out.println("Toujours pas de double.\nVous restez en prison.");
    }
    
    public void messageDoublePrison(Joueur j){
        System.out.println("Vous avez fait un double et sortez de la prison! ");
        System.out.println("Vous avancez et êtes maintenant sur la case " + j.getPositionCourante().getNomCarreau());
    }
    
    public void messageAllerPrison(Joueur joueurCourant, int de1, int de2){
        System.out.println("Joueur " + joueurCourant.getNomJoueur() +" :");
        System.out.println("Vous avez fait un 3ème double (" + String.valueOf(de1) + " et " + String.valueOf(de2) + ") !");
        System.out.println("Vous êtes envoyé directement en prison.");
    }
    
    public void messageCaseArgentPaie(CarreauArgent carreau, Joueur j){
        System.out.println("Vous devez payer "+carreau.getMontant() +" gils. Il vous reste " + String.valueOf(j.getCash()));
    }
    
    public void messageCaseArgentRien(){
        System.out.println("Aucune action possible.");
    }
    
    public boolean messageUtiliserLiberation(){
        System.out.println("Vous avez une carte libéré de prison. Voulez vous l'utiliser ? (y/n)");
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
    
    public void messageLiberer(){
        System.out.println("Vous avez utilisé votre carte, vous êtes donc liberé de prison.");
    }
    
    public void messageNouvellePosition(Carreau carreau){
        System.out.println("Vous êtes maintenant sur la case " +carreau.getNomCarreau());
    }
}