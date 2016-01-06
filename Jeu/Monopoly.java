package Jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.shuffle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Monopoly {

	private IHM ihm;
	private HashMap<Integer,Carreau> carreaux;
        private LinkedList<Carte> cartesCaisseCommunaute;
        private LinkedList<Carte> cartesChance;
        private ArrayList<Joueur> joueurs;
	private int nbMaisonsRestant = 32;
	private int nbHotelsRestant = 12;
	private int de1;
	private int de2;
        private int numeroJoueurCourant ;

        public Monopoly(String dataFilename, String dataCards1, String dataCards2){
            carreaux = new HashMap();
            joueurs = new ArrayList<>() ;
            ihm = new IHM();
            cartesCaisseCommunaute = new LinkedList<>();
            cartesChance = new LinkedList<>() ;
            
            
		buildGamePlateau(dataFilename);
                
                buildGameCards(dataCards1, cartesCaisseCommunaute);
                buildGameCards(dataCards2, cartesChance);
                
	}
        
	
	private void buildGamePlateau(String dataFilename)  
	{
		try{
                        HashMap<CouleurPropriete,Groupe> listeGroupes = new HashMap() ;
			ArrayList<String[]> data = readDataFile("src/Data/"+dataFilename, ",");                       
			
			
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];       // type : P propriété, G gare, C Compagnie, CT case tirage, CA case Argent, CM case mouvement
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        Groupe g ; 
                                        if(listeGroupes.get(CouleurPropriete.valueOf(data.get(i)[3]))==null){
                                            g=new Groupe(CouleurPropriete.valueOf(data.get(i)[3]),Integer.parseInt(data.get(i)[10]),Integer.parseInt(data.get(i)[11]));
                                            listeGroupes.put(CouleurPropriete.valueOf(data.get(i)[3]),g);
                                         }
                                        else{
                                            g=listeGroupes.get(CouleurPropriete.valueOf(data.get(i)[3]));
                                        }
                                        int tabLoyer[] = {Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5]),Integer.parseInt(data.get(i)[6]),Integer.parseInt(data.get(i)[7]),Integer.parseInt(data.get(i)[8]),Integer.parseInt(data.get(i)[9])};
                                        ProprieteAConstruire pAC = new ProprieteAConstruire (this,//monop
                                                                                            Integer.parseInt(data.get(i)[1]),//num
                                                                                            data.get(i)[2],//nom
                                                                                            Integer.parseInt(data.get(i)[4]), //prix achat
                                                                                            tabLoyer,//tableau loyer
                                                                                            g);//groupe
                                       this.addCarreau(pAC);
                                }
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        Gare g = new Gare(this,
                                                          Integer.parseInt(data.get(i)[1]),
                                                          data.get(i)[2],
                                                          Integer.parseInt(data.get(i)[3]));
                                        this.addCarreau(g);
                                        
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        Compagnie comp = new Compagnie(this,
                                                                       Integer.parseInt(data.get(i)[1]),
                                                                       data.get(i)[2],
                                                                       Integer.parseInt(data.get(i)[3]));
                                        this.addCarreau(comp);
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        CarreauTirage cT = new CarreauTirage(this,
                                                                             Integer.parseInt(data.get(i)[1]),
                                                                             data.get(i)[2]);
                                        this.addCarreau(cT);
                                        
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        CarreauArgent cA = new CarreauArgent(this,
                                                                             Integer.parseInt(data.get(i)[1]),
                                                                             data.get(i)[2],
                                                                             Integer.parseInt(data.get(i)[3]));
                                        this.addCarreau(cA);
                                        
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        CarreauMouvement cM = new CarreauMouvement(this,
                                                                                   Integer.parseInt(data.get(i)[1]),
                                                                                   data.get(i)[2]);
                                        this.addCarreau(cM);
                                        
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
                
        
	}
        
        
        private void buildGameCards(String dataCards, LinkedList<Carte> paquetCarte)  
	{
		try{
                        
			ArrayList<String[]> data = readDataFile("src/Data/"+dataCards, ",");                       
			
			
			for(int i=0; i<data.size(); ++i){
				String carteType = data.get(i)[0];       
				if(carteType.compareTo("CL") == 0){                                 // Carte liberer de prison
                                    System.out.println(data.get(i)[2]);
                                    CarteLiberePrison CLP = new CarteLiberePrison(this,data.get(i)[2],Integer.valueOf(data.get(i)[1]));
                                    paquetCarte.add(CLP);
                                }
				else if(carteType.compareTo("CA") == 0){                            // Carte Argent
					System.out.println(data.get(i)[3]);
                                        CarteArgentAbsolu CA = new CarteArgentAbsolu(this,data.get(i)[3],Integer.valueOf(data.get(i)[1]),Integer.valueOf(data.get(i)[2]));
                                        paquetCarte.add(CA);
				}
				else if(carteType.compareTo("CAA") == 0){                           // Carte Argent Anniv
					System.out.println(data.get(i)[3]);
                                        CarteArgentAnniversaire CAA = new CarteArgentAnniversaire(this,data.get(i)[3],Integer.valueOf(data.get(i)[1]),Integer.valueOf(data.get(i)[2]));
                                        paquetCarte.add(CAA);
				}
				else if(carteType.compareTo("Prison") == 0){                        // Carte deplacement Prison
					System.out.println(data.get(i)[3]);
                                        CarteAllerPrison Prison = new CarteAllerPrison(this,data.get(i)[3],Integer.valueOf(data.get(i)[1]),this.getCarreau(Integer.valueOf(data.get(i)[2])));
                                        paquetCarte.add(Prison);
				}
				else if(carteType.compareTo("MA") == 0){                            // Carte deplacement Absolu
					System.out.println(data.get(i)[4]);
                                        CarteMouvementAbsolu DA = new CarteMouvementAbsolu(this,data.get(i)[4],Integer.valueOf(data.get(i)[1]),this.getCarreau(Integer.valueOf(data.get(i)[2])),data.get(i)[3].compareTo("->") == 0);
                                        paquetCarte.add(DA);
                                }
				else if(carteType.compareTo("MR") == 0){                           // Carte deplacement Relatif
					System.out.println(data.get(i)[3]);
                                        CarteMouvementRelatif DR = new CarteMouvementRelatif(this,data.get(i)[3],Integer.valueOf(data.get(i)[1]),Integer.valueOf(data.get(i)[2]));
                                        paquetCarte.add(DR);
				}
                                else if(carteType.compareTo("ARP") == 0){                         // Carte deplacement Relatif
					System.out.println(data.get(i)[4]);
                                        CarteArgentRelatifPossessions CARP = new CarteArgentRelatifPossessions(this,data.get(i)[4],Integer.valueOf(data.get(i)[1]),Integer.valueOf(data.get(i)[2]),Integer.valueOf(data.get(i)[3]));
                                        paquetCarte.add(CARP);
				}
				else
					System.err.println("[buildGameCards()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGameCards()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGameCard()] : Error while reading file!");
		}
                
        
	}
        
        
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
        

        public void inscrireJoueurs (){
            //Demander les noms de J1 et J2
            
            
            String nom1 = this.getIhm().messageDemanderNom() ;
            this.getJoueurs().add(new Joueur(this,nom1));
            String nom2 = this.getIhm().messageDemanderNom() ;
            this.getJoueurs().add(new Joueur(this,nom2));
            
            boolean continuer  = this.getIhm().messageAjouterJoueur() ;
            
            // boucle rajout des joueurs
            while (continuer && this.getJoueurs().size()<6) {
                String nom = this.getIhm().messageDemanderNom() ;
                this.getJoueurs().add(new Joueur(this,nom));
                if(this.getJoueurs().size()<6){
                    continuer = this.getIhm().messageAjouterJoueur() ;
                }
                else
                {
                    this.getIhm().messageTropDeJoueurs();
                }
                
            }
            
                       
        }
        public boolean partieContinue (){
            return this.getJoueurs().size()>=2; 
        }
        public void JouerJeu(){
            this.ordreJoueurs();
            while (this.partieContinue()){
                for (Joueur j : this.getJoueurs()){
                    this.jouerUnCoup(j);
                }
            }
        }
        
        
        public void ordreJoueurs() {
            int score, scoreMax = 0;
            int indiceJMax = 0;
            for (int i=0 ; i < this.getJoueurs().size() ; i++){
                score = this.jetDe() + this.jetDe();
                this.getIhm().messageAfficherLancerDesJoueur(this.getJoueurs().get(i),score);
                if (score > scoreMax){
                    scoreMax = score;
                    indiceJMax=i;
                }
            }

           
           ArrayList<Joueur> listeSwitch = new ArrayList<>();
           
           
           for (int i=indiceJMax; i<this.getJoueurs().size();i++){
               listeSwitch.add(this.getJoueurs().get(i));
           }
           for (int i=0; i<indiceJMax;i++){
               listeSwitch.add(this.getJoueurs().get(i));
           }
           this.getJoueurs().clear();
           this.setJoueurs(listeSwitch) ;
        }
        
	/**
	 * 
	 * @param j
	 */
	public void jouerUnCoup(Joueur j) {
            Carreau positionJoueur;
            positionJoueur = this.lancerDesAvancer();
            
            positionJoueur.action(j);
        }

        public void passerParDepart () {
            this.getJoueurCourant().setCash(this.getJoueurCourant().getCash()+200);
            this.getIhm().messagePassageDepart();
        }
        
        
	private Carreau lancerDesAvancer() {
            de1 = this.jetDe();
            de2 = this.jetDe();
            Joueur jC = this.getJoueurCourant();
            //this.getIhm().messageAfficherLancerDesJoueur(jC, de1+de2);
            if (de1 == de2) {
                jC.incrementerNbDouble();                
            } 
            else {
                jC.reinitialiserNbDouble();
            }            
            
            if (jC.getNbDouble() == 3) {
                jC.setPositionCourante(this.getCarreau(11));
                jC.incrementerNbTourPrison();
            }
            else {
                jC.setPositionCourante(getCarreau(this.getJoueurCourant().getPositionCourante().getNumero()+de1+de2));           
            }
                        
            this.getIhm().messageAfficherInfoLancerDes(this.getJoueurCourant(),this.getCarreau(getJoueurCourant().getPositionCourante().getNumero()),de1+de2);
            
                        
            for (Joueur joueur : this.getJoueurs()){
               this.getIhm().messageInfosJoueurs(joueur,this.getCarreau(joueur.getPositionCourante().getNumero()));
            }
            
            return (this.getJoueurCourant().getPositionCourante());
            
	}

        
        public void tirerUneCarte(LinkedList<Carte> paquetCartes){
            if (paquetCartes == getCartesCaisseCommunaute()){
                if (getCartesCaisseCommunaute().getLast().getNumero()==1){
                    getCartesCaisseCommunaute().getLast().actionCarte();
                    getCartesCaisseCommunaute().removeLast();
                }
                else { 
                    getCartesCaisseCommunaute().getLast().actionCarte();
                    getCartesCaisseCommunaute().push(getCartesCaisseCommunaute().getLast());
                    getCartesCaisseCommunaute().removeLast();
                }
            } else 
                if (getCartesChance().getLast().getNumero()==1){
                    getCartesChance().getLast().actionCarte();
                    getCartesChance().removeLast();
                }
                else {
                    getCartesChance().getLast().actionCarte();
                    getCartesChance().push(getCartesChance().getLast());
                    getCartesChance().removeLast();
            }
        }
        
	public int jetDe() {
            Random randomJD = new Random();
            return randomJD.nextInt(6)+1;
	}
        
        public void faillite(Joueur j){
            j.reinitStats();
            joueurs.remove(j);
            this.getIhm().messageFaillite();
            
        }

	/**
	 * 
	 * @param numCase
	 */
	public Carreau getCarreau(int numCase) {
		
            return this.getCarreaux().get(numCase);
		//throw new UnsupportedOperationException();
	}

	

	/**
	 * 
	 * @param jProprio
	 * @param loyer
	 * @param cashRestant
	 */
	public void messageApresLoyer(Joueur jProprio, Integer loyer, Integer cashRestant) {
		this.getIhm().messageApresLoyer(jProprio, loyer, cashRestant);
	}

	public int getDe1() {
		return this.de1;
	}

	public int getDe2() {
		return this.de2;
	}

	/**
	 * 
	 * @param nomC
	 * @param prixA
	 */
	public boolean messageDemandeAchat(CarreauPropriete carreau) {
            boolean rep;
            rep = this.getIhm().messageDemandeAchat(carreau);
            return rep;
	}

    /**
     * @return the ihm
     */
    public IHM getIhm() {
        return ihm;
    }

    /**
     * @param ihm the ihm to set
     */
    public void setIhm(IHM ihm) {
        this.ihm = ihm;
    }

    /**
     * @return the carreaux
     */
    public HashMap<Integer,Carreau> getCarreaux() {
        return carreaux;
    }

    /**
     * @param carreaux the carreaux to set
     */
    public void addCarreau(Carreau carreau) {
        this.getCarreaux().put(carreau.getNumero(), carreau);
    }

    /**
     * @return the joueurs
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
    
    /**
     * 
     */
    public void setJoueurs(ArrayList<Joueur> njoueurs) {
        joueurs=njoueurs;
    }

    /**
     * @return the nbMaisons
     */
    public int getNbMaisonsRestant() {
        return nbMaisonsRestant;
    }

    /**
     * @return the nbHotels
     */
    public int getNbHotelsRestant() {
        return nbHotelsRestant;
    }

    /**
     * @return the numeroJoueurCourant
     */
    public int getNumeroJoueurCourant() {
        return numeroJoueurCourant;
    }
     /**
     * @return the JoueurCourant
     */
    public Joueur getJoueurCourant() {
        return this.getJoueurs().get(this.getNumeroJoueurCourant());
    }

    /**
     * @param numeroJoueurCourant the numeroJoueurCourant to set
     */
    public void setNumeroJoueurCourant(int numeroJoueurCourant) {
        this.numeroJoueurCourant = numeroJoueurCourant;
    }
    
    public void messageRefusAchat(Joueur joueur, CarreauPropriete carreau){
        this.getIhm().messageRefusAchat(joueur, carreau);
    }
        
        
    public void messagePlusImmobilier(){
        this.getIhm().messagePlusImmobilier();
    }
    
    public void setNbMaisonsRestant(int newNb){
        this.nbMaisonsRestant = newNb    ;   
    }
    
    public void setNbHotelsRestant(int newNb){
        this.nbHotelsRestant = newNb;
    }
    
    public void messageAfficherGroupe(Groupe g){
        this.getIhm().messageAfficherGroupe(g);
    }
    
    public void messageAfficherProp(ProprieteAConstruire prop){
        this.getIhm().messageAfficherProp(prop);
    }
    
    public void messagePasDeGroupeEntier(){
        this.getIhm().messagePasDeGroupeEntier();
    }
    
    public void messagePasGroupeConstructible(){
        this.getIhm().messagePasGroupeConstructible();
    }

    public Groupe messageDemandeChoixGroupe(HashSet<Groupe> liste){
        return this.getIhm().messageDemandeChoixGroupe(liste);
    }
    public ProprieteAConstruire messageDemandeChoixProp(){
        return this.getIhm().messageDemandeChoixProp();
    }
    
    /**
     * @return the carteCaisseCommunaute
     */
    public LinkedList<Carte> getCartesCaisseCommunaute() {
        return cartesCaisseCommunaute;
    }

    /**
     * @return the carteChance
     */
    public LinkedList<Carte> getCartesChance() {
        return cartesChance;
    }
    
    


}
