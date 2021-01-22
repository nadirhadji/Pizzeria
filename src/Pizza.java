
/**
 * I N F 1 1 2 0
 *
 * Classe servant a faire des pizzas.
 * 
 * Les informations a conserver sur une pizza sont les suivantes:
 * 
 * Le type de viande, un entier. 
 * Les valeurs possibles sont :  0 (Aucune), 1 (pepperoni), 2 (bacon), 3 (jambon), 
 *                               4 (viande fumee),  5 (poulet), 6 (saucisses italiennes). 
 *                               La valeur par defaut est 1.
 * 
 * Le type de garniture, un entier.   
 * Les valeurs possibles sont :  0 (Aucune), 1 (champignons), 2 (piments), 3 (oignons), 4 (olives), 
 *                               5 (ananas).  La valeur par defaut est 2.
 *                               
 * La grandeur, un entier. 
 * Les valeurs possibles sont :  0  (Extra petite), 1 (Petite), 2 (Moyenne), 3 (Grande),  
 *                               4 (Jumbo). La valeur par defaut est 2.
 *                               
 * Un extra de viande, un entier. 
 * Les valeurs possibles sont :  0 (Aucune), 1 (pepperoni), 2 (bacon), 3 (jambon), 4 (viande fumee),
 *                               5 (poulet), 6 (saucisses italiennes). La valeur par defaut est 0.
 *                               
 * Une garniture en extra, un entier.
 * Les valeurs possibles sont :  0 (Aucune), 1 (champignons), 2 (piments), 3 (oignons), 4 (olives), 
 *                               5 (ananas).   La valeur par defaut est 0.
 *                               
 * Un type de croûte, un entier.  
 * Les valeurs possibles sont :  0 (Ordinaire), 1 (Mince), 2 (Trois Cereales), 3 (Epaisse), 4 (Fromage). 
 *                               La valeur par defaut est 0.
 *                               
 * Un numero d’identification distinct (nombre entier positif). 
 * Les numeros debutent a 1 et sont consecutifs. Chaque pizza a un numero DIFFERENT qui lui est propre. 
 * Les numeros sont generes automatiquement par la classe Pizza.
 * 
 */

/**
 * Classe servant a faire des pizzas.
 *
 * @author Hadji Nadir
 * Code permanant : HADN08069703
 * courriel : fc191918@ens.uqam.ca
 */
public class Pizza {

    //Variable de CLASSE pour generer le numero de pizza
    //MARCHE PAS
    public static int count = 0;

    //Variables d'instance
    private int id;
    private int viande;
    private int garniture;
    private int grandeur;
    private int croute;
    private int extraViande;
    private int extraGarniture;

    //Constantes de classe privees
    private static final String [] GARNITURES = {"Aucune", "champignons", "piments", "oignons", "olives", "ananas"};
    private static final String [] VIANDES = {"Aucune", "pepperoni", "bacon", "jambon", "viande fumee", "poulet", "saucisses italiennes"};
    private static final String [] GRANDEURS = {"Extra petite", "Petite", "Moyenne", "Grande", "Jumbo"};
    private static final String [] CROUTES = {"Ordinaire", "Mince", "Trois Cereales", "Epaisse", "Fromage"};

    //Constantes de classe publiques
    public static final int VIANDE_DEFAUT = 1;
    public static final int GARNITURE_DEFAUT = 2;
    public static final int EXTRA_DEFAUT = 0;
    public static final int GRANDEUR_DEFAUT = 2;
    public static final int CROUTE_DEFAUT = 0;
    
    public static final int MIN_GARN = 0;
    public static final int MAX_GARN = GARNITURES.length - 1;
    public static final int MIN_VIANDE = 0;
    public static final int MAX_VIANDE = VIANDES.length - 1;
    public static final int MIN_GRANDEUR = 0;
    public static final int MAX_GRANDEUR = GRANDEURS.length - 1;
    public static final int MIN_CROUTE = 0;
    public static final int MAX_CROUTE = CROUTES.length - 1;
    
    
    //Methodes de classe

    /**
     * Retourne la chaine de caractere corrrespondant au numero de garniture
     * recu en parametre. Si le no ne correspond pas a une garniture existante,
     * la methode retourne la chaine vide.
     *
     * @param no le numéro correspond pas a une garniture
     * @return la chaine de caractere corrrespondant au numero de garniture
     */
    public static String garniture (int no){

        String resultat;

        if(no > MAX_GARN || no < MIN_GARN)
            resultat = "";
        else
            resultat = GARNITURES[no];

        return resultat;
    }

    /**
     * Retourne la chaine de caractere corrrespondant au numero de viande
     * recu en parametre. Si le no ne correspond pas a une viande existante,
     * la methode retourne la chaine vide.
     *
     * @param no numero correspondant a une viande existante
     * @return la chaine de caractere corrrespondant au numero de viande
     */
    public static String viande (int no){

        String resultat;

        if(no > MAX_VIANDE || no < MIN_VIANDE)
            resultat = "";
        else
            resultat = VIANDES[no];

        return resultat;
    }

    /**
     * Retourne la chaine de caractere corrrespondant au numero de grandeur
     * recu en parametre. Si le no ne correspond pas a une grandeur existante,
     * la methode retourne la chaine vide.
     *
     * @param no numero correspond a une grandeur existante
     * @return la chaine de caractere corrrespondant au numero de grandeur
     */
    public static String grandeur (int no){

        String resultat;

        if(no > MAX_GRANDEUR || no < MIN_GRANDEUR)
            resultat = "";
        else
            resultat = GRANDEURS[no];

        return resultat;
    }

    /**
     * Retourne la chaine de caractere corrrespondant au numero de croute
     * recu en parametre. Si le no ne correspond pas a une croute existante,
     * la methode retourne la chaine vide.
     *
     * @param no un numero correspond a une croute
     * @return la chaine de caractere corrrespondant au numero de croute
     */
    public static String croute (int no){

        String resultat;

        if(no > MAX_CROUTE || no < MIN_CROUTE)
            resultat = "";
        else
            resultat = CROUTES[no];

        return resultat;
    }

    /////////////////
    //CONSTRUCTEURS//
    /////////////////

    /**
     * Cree une pizza avec tous les attributs aux valeurs par defaut
     */
    public Pizza(){
        count = count + 1;
        this.id = count;
        this.viande = VIANDE_DEFAUT;
        this.garniture = GARNITURE_DEFAUT;
        this.grandeur = GRANDEUR_DEFAUT;
        this.croute = CROUTE_DEFAUT;
        this.extraViande = EXTRA_DEFAUT;
        this.extraGarniture = EXTRA_DEFAUT;
    }

    /**
     * Cree une pizza avec AUCUN extra et les informations en
     * parametre.
     * Lorsqu'un parametre est invalide, l'attribut correspondant est
     * mis a la valeur par defaut.
     *
     * @param viande entier compris en MIN_VIANDE et MAX_VIANDE
     * @param garniture entier compris en MIN_GARN et MAX_GARN
     * @param grandeur entier compris en MIN_GRANDEUR et MAX_GRANDEUR
     * @param croute entier compris en MIN_CROUTE et MAX_CROUTE
     */
    public Pizza(int viande, int garniture, int grandeur, int croute){

        count = count + 1;

        this.id = count;

        if (viande(viande).isEmpty())
            this.viande = VIANDE_DEFAUT;
        else
            this.viande = viande;

        if(garniture(garniture).isEmpty())
            this.garniture = GARNITURE_DEFAUT;
        else
            this.garniture = garniture;

        if(grandeur(grandeur).isEmpty())
            this.grandeur = GRANDEUR_DEFAUT;
        else
            this.grandeur = grandeur;

        if(croute(croute).isEmpty())
            this.croute = CROUTE_DEFAUT;
        else
            this.croute = croute;

        this.extraViande = EXTRA_DEFAUT;

        this.extraViande = EXTRA_DEFAUT;
    }

    /**
     * Cree une pizza avec les informations en parametre.
     * Lorsqu'un parametre est invalide, l'attribut correspondant est
     * mis a la valeur par defaut.
     *
     * @param viande entier compris en MIN_VIANDE et MAX_VIANDE
     * @param garniture entier compris en MIN_GARN et MAX_GARN
     * @param grandeur entier compris en MIN_GRANDEUR et MAX_GRANDEUR
     * @param croute entier compris en MIN_CROUTE et MAX_CROUTE
     * @param extraViande entier compris entre 0 et 6 inclue
     * @param extraGarniture entier comris entre 0 et 5 inclue
     */
    public Pizza(int viande, int garniture, int grandeur, int croute,
                 int extraViande, int extraGarniture){

        count = count + 1;

        this.id = count;

        if(viande(viande).isEmpty())
            this.viande = VIANDE_DEFAUT;
        else
            this.viande = viande;

        if(garniture(garniture).isEmpty())
            this.garniture = GARNITURE_DEFAUT;
        else
            this.garniture = garniture;

        if(grandeur(grandeur).isEmpty())
            this.grandeur = GRANDEUR_DEFAUT;
        else
            this.grandeur = grandeur;

        if (croute(croute).isEmpty())
            this.croute = CROUTE_DEFAUT;
        else
            this.croute = croute;

        if (viande(extraViande).isEmpty())
            this.extraViande = EXTRA_DEFAUT;
        else
            this.extraViande = extraViande;

        if (garniture(extraGarniture).isEmpty())
            this.extraGarniture = EXTRA_DEFAUT;
        else
            this.extraGarniture = extraGarniture;
    }

    /////////////////////////////
    //ACCESSEURS (GETTERS)//
    /////////////////////////////

    /**
     * Retourne la valeur de l'attribut id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne la valeur de l'attribut viande
     * @return viande
     */
    public int getViande() {
        return viande;
    }

    /**
     * Retourne la valeur de l'attribut garniture
     * @return garniture
     */
    public int getGarniture() {
        return garniture;
    }

    /**
     * Retourne la valeur de l'attribut granduer
     * @return grandeur
     */
    public int getGrandeur() {
        return grandeur;
    }

    /**
     * Retourne la valeur de l'attribut  croute
     * @return croute
     */
    public int getCroute() {
        return croute;
    }

    /**
     * Retourne la valeur de l'attribut  extraViande
     * @return extraViande
     */
    public int getExtraViande() {
        return extraViande;
    }

    /**
     * Retourne la valeur de l'attribut extraGarniture
     * @return extraGarniture
     */
    public int getExtraGarniture() {
        return extraGarniture;
    }

    public static String [] getGarnitures() {
        return GARNITURES;
    }

    public static String [] getViandes() {
        return VIANDES;
    }

    public static String [] getGrandeurs() {
        return GRANDEURS;
    }

    public static String [] getCroutes() {
        return CROUTES;
    }

    ///////////////////////////
    //MODIFICATEURS (SETTERS)//
    ///////////////////////////

    /**
     * Modifie la croute de la pizza.
     * Si la valeur recu en parametre ne fait pas
     * partie des valeurs permises, aucune modification
     * n'est effectuee et aucun message d'erreur n'est
     * affiche.
     *
     * @param c une entier valide de croute.
     */
    public void setCroute(int c){

        if(!croute(c).isEmpty())
            this.croute = c;
    }

    /**
     *  Modifie la grandeur de la pizza.
     *  Si la valeur recu en parametre ne fait pas
     *  partie des valeurs permises, aucune modification
     *  n'est effectuee et aucun message d'erreur n'est
     *  affiche.
     *
     * @param g un entier valide de granduer
     */
    public void setGrandeur(int g){

        if(!grandeur(g).isEmpty())
            this.grandeur = g;
    }

    /**
     * Modifie la viande de la pizza.
     *  Si la valeur recu en parametre ne fait pas
     *  partie des valeurs permises, aucune modification
     *  n'est effectuee et aucun message d'erreur n'est
     *  affiche.
     *
     * @param v un entier valide de viande
     */
    public void setViande(int v){

        if(!viande(v).isEmpty())
            this.viande = v;
    }

    /**
     * Modifie la garniture de la pizza.
     * Si la valeur recu en parametre ne fait pas
     * partie des valeurs permises, aucune modification
     * n'est effectuee et aucun message d'erreur n'est
     * affiche.
     *
     * @param g un entier valide de g
     */
    public void setGarniture(int g){

        if(!garniture(g).isEmpty())
            this.garniture = g;
    }

    /**
     * Modifie la viande en extra de la pizza.
     * Si la valeur recu en parametre ne fait pas
     * partie des valeurs permises, aucune modification
     * n'est effectuee et aucun message d'erreur n'est
     * affiche.
     *
     * @param eV un entier valide de extraViande
     */
    public void setExtraViande(int eV){

        if (!viande(eV).isEmpty())
            this.extraViande = eV;
    }

    /**
     * Modifie la garniture en extra de la pizza.
     * Si la valeur recu en parametre ne fait pas
     * partie des valeurs permises, aucune modification
     * n'est effectuee et aucun message d'erreur n'est
     * affiche.
     *
     * @param eG un entier valide de extraGarniture
     */
    public void setExtraGarniture(int eG){

        if(!garniture(eG).isEmpty())
            this.extraGarniture = eG;
    }
    
    /////////////////////////////////////
    /// METHODE UTILITAIRE D'INSTANCE ///
    /////////////////////////////////////

    /**
     * Retourne une chaine de caracteres contenant les
     * caracteristiques de la pizza.
     * Pour chacune des informations, on doit mettre une
     * description de l'information, suivie de sa valeur.
     * Chaque information doit être sur une ligne
     * differente (utilisez \n la ou cela s'applique).
     *
     * @return le descriptif de la pizza instanciée.
     */
    public String toString(){

        String resultat;

        String id = "ID: "+this.id+"\n";

        String grandeur = "Grandeur: "+grandeur(this.grandeur) +
                " (# "+this.grandeur+")"+"\n";

        String croute = "Croute: "+croute(this.croute) +
                " (# "+this.croute+")"+"\n";

        String viande = "Viande: "+viande(this.viande) +
                " (# "+this.viande+")"+"\n";

        String extraViande = "Extra Viande: "+viande(this.extraViande) +
                " (# "+this.extraViande+")"+"\n";

        String garniture = "Garniture: "+garniture(this.garniture) +
                " (# "+this.garniture+")"+"\n";

        String extraGarniture = "Extra Garniture: " +
                garniture(this.extraGarniture) +
                " (# "+this.extraGarniture+")"+"\n";

        resultat = id + grandeur + croute + viande + extraViande + garniture +
                   extraGarniture;
        
        return resultat;
    }
}
