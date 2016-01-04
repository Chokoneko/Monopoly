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
	public void messageApresLoyer(Joueur proprietaire, Integer prix, Integer cashRestant) {
		System.out.println("Vous devez payer "+prix.toString()+" gils au joueur "+ proprietaire.getNomJoueur()+". Il vous restera "+cashRestant.toString()+" gils." );
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
             // TODO il faudrait ajouter une sécurité pour ne pas répondre n'importe quoi ?
            Scanner sc = new Scanner(System.in);               
            return (sc.nextLine().equals("Y")) ;
            
        }
        
        
        public void messageTropDeJoueurs(){
            System.out.println("Vous ne pouvez pas ajouter plus de 6 joueurs");                        
        }
         
        public void messageAfficherLancerDesJoueur(Joueur joueur, Integer score){
            System.out.println("Le joueur "+joueur.getNomJoueur()+" à fait un score de "+ score.toString() );                        
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

        
    /**
     * @return the monopoly
     */
    private Monopoly getMonopoly() {
        return monopoly;
    }

}