package Jeu;


import Jeu.Monopoly;
import java.util.Scanner;

public class IHM {

	private Monopoly monopoly;

        
	/**
	 * 
	 * @param proprietaire
	 * @param prix
	 * @param cashRestant
	 */
	public void messageApresLoyer(Joueur proprietaire, int prix, int cashRestant) {
		// TODO - implement IHM.messageApresLoyer
		throw new UnsupportedOperationException();
	}

	public boolean saisieRep() {
		// TODO - implement IHM.saisieRep
		throw new UnsupportedOperationException();
	}

        public String messageDemanderNom (){
            System.out.println("Nom : ?");
            Scanner sc = new Scanner(System.in);            
            return sc.nextLine() ;
            
        }
         public boolean messageAjouterJoueur (){
            System.out.println("Voulez vous ajouter un autre joueur ? (Y/N)");
             // TODO il faudrait ajouter une sécurité pour ne pas répondre n'importe quoi
            Scanner sc = new Scanner(System.in);               
            return (sc.nextLine().equals("Y")) ;
            
        }
        
        
        public void messageTropDeJoueurs(){
            System.out.println("Vous ne pouvez pas ajouter plus de 6 joueurs");                        
        }
         
        public void messageAfficherLancerDesJoueur(Joueur joueur, Integer score){
            System.out.println("Le joueur "+joueur.getNomJoueur()+" à fait un score de "+ score.toString() );                        
        }
         
        public void messageAfficherInfoLancerDes(){
            System.out.println("Joueur : "+ this.getMonopoly().getNumeroJoueurCourant() +" Dé 1 : " + this.getMonopoly().getDe1() +" Dé 1 : " + this.getMonopoly().getDe1());                       
        }
	/**
	 * 
	 * @param nom
	 * @param prixAchat
	 */
	public boolean messageDemandeAchat(String nom, int prixAchat) {
		// TODO - implement IHM.messageDemandeAchat
		throw new UnsupportedOperationException();
	}

    /**
     * @return the monopoly
     */
    public Monopoly getMonopoly() {
        return monopoly;
    }

}