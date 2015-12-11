package Jeu;


import Jeu.Carreau;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Monopoly {

	private IHM ihm;
	private HashMap<Integer,Carreau> carreaux;
	private ArrayList<Joueur> joueurs;
	private int nbMaisons = 32;
	private int nbHotels = 12;
	private int de1;
	private int de2;

        public Monopoly(String dataFilename){
            carreaux = new HashMap();
            joueurs = new ArrayList<>() ;
            ihm = new IHM();
            
		buildGamePlateau(dataFilename);
                this.inscrireJoueurs();
	}
	
	private void buildGamePlateau(String dataFilename)  // pour le moment les groupes sont crées chaque fois, il faudrait juste add la case si le groupe existe 
	{
		try{
                        HashMap<CouleurPropriete,Groupe> listeGroupes = new HashMap() ;
			ArrayList<String[]> data = readDataFile("src/Data/"+dataFilename, ",");                       
			
			//TODO: create cases instead of displaying
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
        
        //pouet
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
        
        public Joueur premierJoueur() {
            int score, scoreMax = 0;
            Joueur joueurMax=this.getJoueurs().get(0);
            for (int i=0 ; i < this.getJoueurs().size() ; i++){
                score = this.jetDe() + this.jetDe();
                this.getIhm().messageAfficherLancerDesJoueur(this.getJoueurs().get(i),score);
                if (score > scoreMax){
                    scoreMax = score;
                    joueurMax = this.getJoueurs().get(i);
                }               
            }
            return joueurMax;
        }
        
	/**
	 * 
	 * @param j
	 */
	public void jouerUnCoup(Joueur j) {
		// TODO - implement Monopoly.jouerUnCoup
		throw new UnsupportedOperationException();
	}

	private void lancerDesAvancer() {
		// TODO - implement Monopoly.lancerD�sAvancer
		throw new UnsupportedOperationException();
	}

	public int jetDe() {
            Random randomJD = new Random();
            return randomJD.nextInt(6)+1;
	}

	/**
	 * 
	 * @param numCase
	 */
	public Carreau getCarreau(int numCase) {
		
            return this.getCarreaux().get(numCase);
		//throw new UnsupportedOperationException();
	}

//	public Collection<Joueur> getJoueurs() {
//		// TODO - implement Monopoly.getJoueurs
//		throw new UnsupportedOperationException();
//	}

	/**
	 * 
	 * @param jProprio
	 * @param loyer
	 * @param cashRestant
	 */
	public void messageApresLoyer(Joueur jProprio, int loyer, int cashRestant) {
		// TODO - implement Monopoly.messageApresLoyer
		throw new UnsupportedOperationException();
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
	public boolean messageDemandeAchat(String nomC, int prixA) {
		// TODO - implement Monopoly.messageDemandeAchat
		throw new UnsupportedOperationException();
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
     * @param joueurs the joueurs to set // todo
     */
    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    /**
     * @return the nbMaisons
     */
    public int getNbMaisons() {
        return nbMaisons;
    }

    /**
     * @return the nbHotels
     */
    public int getNbHotels() {
        return nbHotels;
    }

}
