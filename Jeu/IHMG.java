
import Jeu.Carreau;
import Jeu.CarreauPropriete;
import Jeu.Joueur;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    
    
    
    public void CreationPlateau() {
        // Instanciation de la fenêtre 
        fenetrePrincipale = new JFrame("Test IHM Contact");
        // Indique de sortir du programme lorsque la fenêtre est fermée par l'utilisateur
        fenetrePrincipale.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        fenetrePrincipale.setSize(900, 800);
        
        fenetrePrincipale.getContentPane().setLayout(new BorderLayout());
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
            
            PopUpMessage("Possessions","Le joueur "+joueur.getNomJoueur()+" est sur la case "+ carreau.getNomCarreau()+" il possède "+Integer.valueOf(joueur.getCash())+" gils");
            if (joueur.getProprietes()==null){
                PopUpMessage("Pauvre","Ce joueur ne possède aucunes terres");
            }
            else{
                System.out.println("Ce joueur ne possède les terres suivantes :");
                for (CarreauPropriete carreauPropriete : joueur.getProprietes()){
                    //System.out.println(carreauPropriete.getNom()); TODO modifier tout ça
                }                    
            }            
        }

    
    
    
    
    
    
    
    
    
    
    
}









