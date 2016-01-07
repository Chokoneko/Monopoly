package Jeu;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author couillec
 */
public class IHMG {
    
    public static JFrame fenetrePrincipale;               // Une fenêtre dans laquelle on va afficher l'IHM du jeu
    private static JFrame fenetreMessage;               // Une fenêtre dans laquelle on va afficher l'IHM du jeu
    private JPanel       panPlateau;                      // pannel pour afficher le plateau  
    public Monopoly      monopoly; 
    
    
    
    
    
    
    public void CreationPlateau() {
        // Instanciation de la fenêtre 
        fenetrePrincipale = new JFrame("Test IHM Contact");
        // Indique de sortir du programme lorsque la fenêtre est fermée par l'utilisateur
        fenetrePrincipale.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        fenetrePrincipale.setSize(900, 800);
        
        fenetrePrincipale.getContentPane().setLayout(new BorderLayout());
        panPlateau = new JPanel();
        fenetrePrincipale.getContentPane().add(panPlateau, BorderLayout.CENTER);
        panPlateau.setLayout(new GridLayout(13,13)); // découpage des cases, les angles sont des carré de deux carreau, les autres des rectagles de 1 par 2
    }
    
    public void CreationCases() {
//        panPlateau.add(pan1);
    }
    
    public void PopUpMessage (String titreMessage, String texteMessage) {
        // Instanciation de la fenêtre 
        fenetreMessage = new JFrame(titreMessage);
        // Indique de sortir du programme lorsque la fenêtre est fermée par l'utilisateur
        fenetreMessage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        fenetreMessage.setSize(350,250);
        
        fenetreMessage.getContentPane().setLayout(new BorderLayout());
        //add texte
        fenetreMessage.add(new JLabel(texteMessage));
        //add button 
    }
    
    public void messageApresLoyer(Joueur proprietaire, Integer prix, Integer cashRestant) {
		      PopUpMessage("Payez votre loyer","Vous devez payer "+prix.toString()+" gils au joueur "+ proprietaire.getNomJoueur()+". Il vous restera "+cashRestant.toString()+" gils." );
	}


        public String messageDemanderNom (){
            PopUpMessage("Nom","Entrer votre nom");
            //TODO textfiled, changer le type de popup ?            
            return null ;
            
        }
         public boolean messageAjouterJoueur (){
           PopUpMessage("Ajout Joueur","Voulez vous ajouter un autre joueur ?");
             // TODO changer de popup et button
                 
            return false ;
            
        }
        
        
        public void messageTropDeJoueurs(){
            PopUpMessage("Trop de joueur","Vous ne pouvez pas ajouter plus de 6 joueurs");                        
        }
         
        public void messageAfficherLancerDesJoueur(Joueur joueur, Integer score){
            PopUpMessage("Résultat des dés","Le joueur "+joueur.getNomJoueur()+" à fait un score de "+ score.toString() );                        
        }
         
        public void messageAfficherInfoLancerDes(Joueur joueurCourant,Carreau carreauCourant,Integer score){
            this.messageAfficherLancerDesJoueur(joueurCourant, score);
           PopUpMessage("blabla","Il est maintenant sur la case "+ carreauCourant.getNomCarreau());      
           //TODO réunir en une seule
        }
	/**
	 * 
	 * @param nom
	 * @param prixAchat
	 */
//	public boolean messageDemandeAchat(CarreauPropriete carreauP, int prixAchat) { // TODO le groupe/gare/compagnie
//		System.out.print("La propriété "+carreauP.getNom()+" appartient au groupe ");
//                if (carreauP){
//                    
//                }
//                System.out.print();                
//                System.out.println(" et vaut"+carreauP.getPrixAchat()+"gils.");//TODO Integer ou int ?
//                System.out.println("Voulez vous l'acheter ?");
//		throw new UnsupportedOperationException();
//	}
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
            System.out.println("----------------------------------------------------------");
            System.out.println("Informations sur le joueur " + joueur.getNomJoueur() +" :");
            System.out.println("Position: "+ carreau.getNomCarreau()+"|      Argent: "+Integer.valueOf(joueur.getCash())+" gils");
            if (listeProp.isEmpty()){
                System.out.println("Terrains: Aucuns");
            }
            else{
                System.out.println("Terrains: ");
                for (CarreauPropriete carreauPropriete : listeProp){
                    System.out.println("- " + carreauPropriete.getNom());
                }          
            } 
            System.out.println("----------------------------------------------------------");
            System.out.println("");
        
        }

	public String saisieRep() {
		Scanner sc = new Scanner(System.in);
                return sc.nextLine();
	}

       
         
        
        public void messageFaillite(){
             System.out.println("Vous n'avez plus d'argent "+this.getMonopoly().getJoueurCourant().getNomJoueur() +". Vous êtes éliminé . ");
             System.out.println("Tout vos bien ont été saisi et sont de nouveau disponible à l'achat.");
             System.out.println("Il ne reste plus que "+ this.getMonopoly().getJoueurs().size() + " joueur dans la partie !");
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
	public boolean messageDemandeAchat(CarreauPropriete carreauP) { 
             if (carreauP instanceof ProprieteAConstruire){
                 System.out.println("Elle appartient au groupe " + carreauP.getGroupe().getCouleur().toString() + " ."); //ERREUR NORMAL NE PAS TOUCHER 
             }
                      
            System.out.println("La propriété vaut "+ String.valueOf(carreauP.getPrixAchat())+" gils.");
            //System.out.println("Vous disposez de "+ String.valueOf(this.getMonopoly().getJoueurCourant().getCash())+" gils.");
            //System.out.print("Voulez vous l'acheter, il vous restera "+ String.valueOf(this.getMonopoly().getJoueurCourant().getCash()-carreauP.getPrixAchat())+"(y/n) ?  ");
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
        System.out.println("------------------------------------------------------\n");
    }
    
    public void messageFinTour(){
        System.out.println("Fin du tour, appuyer sur entrée pour continuer.");
        String fin;
        Scanner sc = new Scanner(System.in);
        fin = sc.nextLine();
        System.out.println("------------------------------------------------------\n");
        
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
    
    public void messagePrisonPaye(Joueur j){
        System.out.println("Toujours pas de double");
        System.out.println("Vous avez purgé votre peine et payer 50gils");
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
    
    public void messageCaseArgentPaie(CarreauArgent carreau){
        System.out.println("Vous devez payer "+ carreau.getMontant() +" gils.");
    }
    
    public void messageCaseArgentRien(){
        System.out.println("Aucune action possible.");
    }

            
            

    public void dessinerPlateau(){       
        
        //trait du haut
        for(int i=0;i<13;i++){
            System.out.print("___");
        }
        System.out.println("");
        //ligne de case du haut
        System.out.print("|__");
        System.out.print("___");
        for(int i=0;i<9;i++){
            System.out.print("|__");
        }
        System.out.print("|__");
        System.out.print("__|");
        
        System.out.println("");

        System.out.print("|__");
        System.out.print("___");
        for(int i=0;i<9;i++){
            System.out.print("|__");
        }
        System.out.print("|__");
        System.out.print("__|");
        
        for(int i=0;i<13;i++){
            System.out.print("___");
        }
        System.out.println("");

        // lignes 
        for(int j=0;j<9;j++){
           System.out.print("|__");
            System.out.print("__|");
            for(int i=0;i<9;i++){
                System.out.print("___");
            }
            System.out.print("|__");
            System.out.print("__|");
            for(int i=0;i<13;i++){
                System.out.print("___");
            }
            System.out.println("");

        }
         
        //ligne de case du bas
        System.out.print("|__");
        System.out.print("___");
        for(int i=0;i<9;i++){
            System.out.print("|__");
        }
        System.out.print("|__");
        System.out.print("__|");
        
        System.out.println("");

        System.out.print("|__");
        System.out.print("___");
        for(int i=0;i<9;i++){
            System.out.print("|__");
        }
        System.out.print("|__");
        System.out.print("__|");
        
        for(int i=0;i<13;i++){
            System.out.print("___");
        }
        System.out.println("");

        
    }
    
    
    
    
    
    
    
    
    
    
}









