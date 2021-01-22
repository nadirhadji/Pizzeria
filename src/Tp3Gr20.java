import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Hadji Nadir
 * Code permanant : HADN08069703
 * Courriel : fc191918@ens.uqam.ca
 */
public class Tp3Gr20 {

    //Constantes de classe

    private static final int MENU_MIN = 1;
    private static final int MENU_MAX = 8;
    private static final String INTRO = "Logicel de gestion de pizzeria\n";
    private static final String OUTRO = "FIN NORMALE DU PROGRAMME";
    private final static String MSG_ENTER = "Appuyez sur [ENTREE] pour continuer...";
    private final static String MSG_SOL_GENERAL = "votre choix : ";

    private static final String MENU_PRINCIPAL = "MENU PRINCIPAL\n\n"+
            "1 – Commander une pizza\n" +
            "2 – Afficher les commandes en cours de traitements\n" +
            "3 – Modifier une pizza (commande en cours de traitement seulement)\n" +
            "4 – Envoyer une pizza a la livraison\n" +
            "5 – Afficher les livraisons en cours\n" +
            "6 – Confirmer une livraison\n" +
            "7 – Afficher les pizzas qui ont ete livrees\n" +
            "8 – Quitter le programme\n";

    ///////////////////////////////////////////////////////////////////////////
    // Messages pour option 1 : Commander une pizza
    ///////////////////////////////////////////////////////////////////////////

    private static final String MSG_CMD_AJOUTEE = "\nCommande ajoutée\n";

    private static final String MSG_SOL_TAILLE = "\nTaille (grandeur) de la pizza :\n";
    private static final String MSG_SOL_VIANDE = "\nChoix de viande :\n ";
    private static final String MSG_SOL_VIANDE_X = "\nChoix de la viande en extra :\n";
    private static final String MSG_SOL_GARN = "\nChoix de garniture :\n";
    private static final String MSG_SOL_GARN_X = "\nChoix de la garniture en extra :\n";
    private static final String MSG_SOL_CROUTE = "\nType de croûte :\n";

    private static final String MSG_ERR_TAILLE =
            "Erreur de grandeur : saisir un entier entre "+
                    Pizza.MIN_GRANDEUR+" et "+Pizza.MAX_GRANDEUR+"\n";

    private static final String MSG_ERR_VIANDE =
            "Erreur de viande : saisir un entier entre"+
                    Pizza.MIN_VIANDE+" et "+Pizza.MAX_VIANDE+"\n";

    private static final String MSG_ERR_GARN =
            "Erreur de garniture : saisir un entier entre"+
                    Pizza.MIN_GARN+" et "+Pizza.MAX_GARN+"\n";

    private static final String MSG_ERR_CROUTE =
            "Erreur de croute : saisir un entier entre"+
                    Pizza.MIN_CROUTE+" et "+Pizza.MAX_CROUTE+"\n";

    //////////////////////////////////////////////////////////////////////////
    // Messages pour option 2 : Afficher les commandes en cours de traitements
    //////////////////////////////////////////////////////////////////////////

    private static final String CMD_ENCOURS_VIDE =
            "Il n'y a aucune commande en traitement\n";

    ///////////////////////////////////////////////////////////////////////////
    // Messages pour option 3 : Modifier une pizza
    ///////////////////////////////////////////////////////////////////////////

    private static final String MSG_SOL_MODIF_PIZZA = "Veuillez saisir"+
            " le numero de pizza à modifer : ";

    private static final String MSG_ERR_MODIF_PIZZA = "Veillez saisir" +
            " un numero de pizza superieur à 0 \n";

    private static final String MSG_MODIF_CMD_ENCOURS_VIDE =
            "Impossible de modifier une pizza car " +
                    "il n'y a aucune commande en cours \n";

    private static final String MSG_MODIF_CMD_INEXISTANTE =
            "Impossible de modifier cette pizza car cette pizza n'est " +
                    "pas dans les commandes en cours de traitement\n";

    private static final String MSG_CONF_MODIF = "Voulez vous continuer à"+
            " modifier la pizza en cours? Taper O pour oui , N pour non : \n";

    private static final String MSG_ERR_CONF_MODIF = "Veuillez saisir un " +
            "choix valide (O = Oui , N = Non) \n";

    private static final String MSG_MODIF_ANNULEE = "Modification annulée \n";

    private static final String MSG_MODIF_SUCCESS  = "Modification effectuée \n";

    private static final String MSG_MODIF_TAILLE = "La taille de la pizza est ";

    private static final String MSG_SOL_MODIF_TAILLE =
            ". Entrez la nouvelle taille : ";

    private static final String MSG_MODIF_VIANDE = "La viande de la pizza est ";

    private static final String MSG_SOL_MODIF_VIANDE =
            ". Entrez la nouvelle viande : ";

    private static final String MSG_MODIF_GARN = "La garniture de la pizza est ";

    private static final String MSG_SOL_MODIF_GARN =
            ". Entrez la nouvelle garniture : ";

    private static final String MSG_MODIF_CROUTE = "La croute de la pizza est ";

    private static final String MSG_SOL_MODIF_CROUTE =
            ". Entrez la nouvelle croute : ";

    private static final String MSG_MODIF_XGARN =
            "La garniture en extra de la pizza est ";

    private static final String MSG_SOL_MODIF_XGARN =
            ". Entrez la nouvelle garniture en extra : ";

    private static final String MSG_MODIF_XVIANDE =
            "La viande en extra de la pizza est ";

    private static final String MSG_SOL_MODIF_XVIANDE =
            ". Entrez la nouvelle viande en extra : ";

    ///////////////////////////////////////////////////////////////////////////
    // Messages pour option 4 : Envoyer une pizza en livraison
    ///////////////////////////////////////////////////////////////////////////

    private static final String MSG_SOL_LIVRAISON_PIZZA = "Veuillez saisir"+
            " le numero de pizza à livrer : \n";

    private static final String MSG_CONF_ENVOIE = "Voulez vous continuer et"+
            " livrer la pizza en cours? Taper O pour oui , N pour non : \n";

    private static final String MSG_ERR_ENVOIE_LIVRAISON_VIDE =
            "Impossible de d'envoyer une pizza a la livraison car" +
                    " il n'y a aucune commande en cours\n";

    private static final String MSG_ERR_LIVRAISON_INNEXISTANTE =
            "Impossible de livrer cette pizza car cette pizza n'est " +
                    "pas dans les commandes en cours de traitement\n";

    private static final String MSG_LIVRAISON_ANNULEE =
            "Envoie en livraison annulée \n";

    private static final String MSG_LIVRAISON_SUCCESS =
            "Processus de livraison de la pizza en cours \n";

    ///////////////////////////////////////////////////////////////////////////
    // Messages pour option 5 : Afficher les livraisons en cours
    ///////////////////////////////////////////////////////////////////////////

    private static final String MSG_ERR_LIVRAISON_ENCOURS_VIDE =
            "Il n'y a aucune livraison en cours \n";

    private static final String MSG_SOL_CONF_LIVRAISON_PIZZA =
            "Veuillez saisir le numero de pizza livrée avec succés : ";

    ///////////////////////////////////////////////////////////////////////////
    // Messages pour option 6 : Confirmer une livraison
    ///////////////////////////////////////////////////////////////////////////

    private static final String MSG_ERR_LIST_LIVRAISON_VIDE =
            "Impossible de confirmer une livraison car il n'y " +
                    "a aucune livraison en cours\n";

    private static final String MSG_ERR_CMD_A_LIVRER_INEXISTANTE =
            "Impossible de confirmer la livraison car cette pizza " +
                    "n'est pas en cours de livraison\n";

    public static final String MSG_CONF_lIVRAISON = "Voulez vous continuer et"+
            " confirmer la pizza en cours? Taper O pour oui , N pour non : ";

    private static final String MSG_CONF_LIVRAISON_ANNULEE =
            "Confirmation de livraison annulée \n";

    private static final String MSG_CONF_LIVRAISON_SUCCESS =
            "Livraison faite \n";

    ///////////////////////////////////////////////////////////////////////////
    // Messages pour option 7 : Afficher mes pizza livrée
    ///////////////////////////////////////////////////////////////////////////

    private static final String MSG_CMD_LIVREE_VIDE =
            "Il n'y a aucune commande qui a été livrée \n";

    ///////////////////////////////////////////////////////////////////////////
    // Messages d'erreur géneraux
    ///////////////////////////////////////////////////////////////////////////

    private static final String MSG_ERR_EXCEPTION_NUM =
            "Veillez saisir une valeur numérique \n";

    private static final String MSG_ERR_EXCEPTION_ALPHA =
            "Veillez saisir une lettre \n";

    //Messages - validation choix menu
    private final static String MSG_SOLL_MENU = "Entrez votre choix : ";
    private final static String MSG_ERR_MENU = "\nErreur, entrez une valeur entre "
            + MENU_MIN + " et " + MENU_MAX  + ".";

    ///////////////////////////////////////////////////////////////////////////
    //Nom des fichier
    ///////////////////////////////////////////////////////////////////////////
    private static final String FIC_EN_TRAITEMENT = "CommandesEnTraitement.txt";

    private static final String ENTETE_EN_TRAITEMENT =
            "\t\t\tCOMMANDES EN TRAITEMENT";

    private static final String FIC_EN_LIVRAISON =
            "CommandesEnCoursDeLivraison.txt";

    private static final String ENTETE_EN_LIVRAISON =
            "\t\t\tCOMMANDES EN LIVRAISON";

    private static final String FIC_LIVREE = "CommandesLivrees.txt";

    private static final String ENTETE_LIVREE =
            "\t\t\tCOMMANDES LIVREE";

    private static final String FIC_ERR_TRAITEMENT =
            "Il n'y a pas de commande en traitement";

    private static final String FIC_ERR_LIVRAISON =
            "Il n'y a pas de commande en cours de livraison";

    private static final String FIC_ERR_LIVREE =
            "Il n'y a pas de commande livrée";

    /***********
     * METHODES
     ***********/

    /**
     * Cette methode affiche une presentation du logiciel, et demande de taper
     * ENTREE pour continuer.
     */
    private static void presenterLogiciel() {
        System.out.println(INTRO);
    }

    /**
     * Cette methode marque une pause, et demande a l'utilisateur de taper ENTREE
     * pour continuer. Lorsque l'utilisateur tape ENTREE, le programme se poursuit.
     */
    private static void pause () {
        System.out.print(MSG_ENTER);
        Clavier.lireFinLigne();
        System.out.println();
    }

    /**
     * Cette methode affiche le menu principal de l'application
     */
    private static void afficherMenu() {
        System.out.println(MENU_PRINCIPAL + "\n\n");
        pause();
    }

    /**
     * Cette methode affiche un message de fin du programme (MSG_FIN_PROG).
     */
    private static void afficherFinProg () {
        System.out.println("\n\n" + OUTRO);
    }

    /**
     * Récupérer une pizza dans un tableau de pizza
     *
     * @param tab un tableau de pizza
     * @param id l'identifiant d'une pizza
     * @return Une pizza si présente dans le tableau sinon
     * retourne null.
     */
    private static Pizza obtenirPizza (Pizza [] tab, int id ){

        Pizza reponse = null;
        int compteur = 0;
        boolean trouve = false;

        while (compteur < tab.length -1 && !trouve ) {

            if(tab[compteur] != null && tab[compteur].getId() == id) {
                reponse = tab[compteur];
                trouve = true;
            }
            compteur = compteur + 1;
        }
        return reponse;
    }

    /**
     * Affiche toute les pizza présente dans un tableau
     *
     * @param tab un tableau d'objet Pizza
     * @param msgTabVide Le message a afficher si le tableau est vide
     */
    private static void afficherTableauPizza(Pizza [] tab, String msgTabVide ){

        int index = 0;
        int tailleTab = tab.length;
        String resultat = "";

        if(tab[index] == null)
            System.out.println(msgTabVide);
        else {
            while(index < tailleTab && tab[index] != null) {
                resultat = resultat + tab[index].toString()+"\n";
                index = index + 1;
            }
        }
        System.out.println(resultat);
    }

    /****************
     * PIZZERIA UTILS
     ****************/

    /**
     * Cette methode cherche la position d'une pizza dans un tableau de pizza
     * avec un id donnée en argument.
     *
     * @param id le id de la pizza a trouver
     * @param tab Un tableau de pizza
     *
     * @return un entier qui représente la position de la pizza ayant
     * pour id la valeur passé en argument. Si le id n'est pas trouvé,
     * cette methode retourne -1.
     */
    private static int obtenirPositionParId(int id , Pizza [] tab ) {

        int reponse = -1;
        int compteur = 0;
        int tailleTab = tab.length;
        boolean trouve = false;

        while(compteur < tailleTab - 1 && !trouve) {

            if(tab[compteur] != null && tab[compteur].getId() == id) {
                reponse = compteur;
                trouve = true;
            }
            compteur = compteur + 1;
        }

        return reponse;
    }

    /**
     * Augmente la taille d'un tableau de pizza de 5 si il est plein
     *
     * @param tab le tableau qui doit changer de tailler si plein
     * @return un nouveau tableau avec la copie des anciens elements
     * et 5 nouvelles cases
     */
    private static Pizza [] augmenterTailleTableauCinq ( Pizza [] tab ){

        Pizza [] nouvelTab = null;
        int tailleCourante = tab.length;
        int tailleFutur = tailleCourante + 5;

        if(tab[tailleCourante - 1] != null) {

            nouvelTab = new Pizza[tailleFutur];

            for(int i = 0 ; i < tailleCourante; i++)
                nouvelTab[i] = tab[i];
        }
        else
            nouvelTab = tab;

        return nouvelTab;
    }

    /**
     * Cette methode va inserer une pizza dans un tableau de pizza
     *
     * @param tab un tableau de pizza
     * @param pizza un object de type Pizza.
     */
    private static void insererPizzaDansTab(Pizza [] tab, Pizza pizza) {

        int tailleTab = tab.length - 1;
        int compteur = 0;

        while ( (tab[compteur] != null) && (compteur <= tailleTab) )
            compteur = compteur + 1;

        tab[compteur] = pizza;
    }

    /**
     * Cette methode retire une pizza qui est présente dans un tableau de pizza
     *
     * @param tab un tableau d'objet de type Pizza
     * @param pizzaId l'id de la pizza a retirer.
     */
    private static void retirerPizzaDeTab(Pizza [] tab, int pizzaId) {

        int position = obtenirPositionParId(pizzaId, tab);
        int dernierePosition = tab.length - 1;

        if(position == dernierePosition)
            tab[dernierePosition] = null;
        else {
            for(int i = position ; i < dernierePosition - 1 ; i++)
                tab[i] = tab[i+1];
            tab[dernierePosition] = null;
        }
    }

    /**
     * Cette methode demande a l'utilisateur d'entrer un nombre entier en
     * utilisant le message de sollicitation donne msgSoll. Tant que la valeur
     * entree n'est pas valide, la methode affiche le msg d'erreur donne, msgErr,
     * et redemande d'entrer un autre nombre entier.
     *
     * Un nombre entier valide est un nombre entier >= 0, entre min et max.
     * Si min est < 0 ou si max < min, la methode retourne -1.
     *
     * @param msgSoll le message de sollicitation pour le nombre entier a saisir.
     * @param msgErr le message d'erreur a afficher lorsque le nombre entier
     *               saisi est invalide.
     * @param min la valeur minimum pour un nombre entier valide.
     *            Antecedent : doit etre >= 0
     * @param max la valeur maximum pour un nombre entier valide.
     *            Antecedent : doit etre >= min
     * @return le nombre entier valide saisi par l'utilisateur.
     */
    private static int validerEntier (String msgSoll, String msgErr,
                                     int min, int max) {
        int entier = -1;

        if (min >= 0 && max >= min) {

            do {
                System.out.print(msgSoll);
                entier = Clavier.lireInt();
                if (entier < min || entier > max) {
                    System.out.println(msgErr);
                }
            } while (entier < min || entier > max);
        }
        return entier;
    }

    /**
     * Cette methode valide la saisie d'un utilisateur lorsqu'il doit
     * saisir O ou N pour Oui et Non.
     *
     * @param msgSoll Le message de sollicitation à la saisie
     * @param msgErr Le message d'erreur si la saisie est invalide
     * @return une saisie valide.
     */
    private static char validerConfirmation(String msgSoll, String msgErr) {

        char conf = 0;
        boolean confValide = true;

        do {
            try {
                System.out.print(msgSoll);
                conf = Clavier.lireCharLn();
                confValide = true;
                if (conf != 'o' && conf != 'O' && conf != 'n' && conf != 'N') {
                    System.out.println(msgErr);
                    confValide = false;
                }
            } catch (RuntimeException r) {
              System.out.println(MSG_ERR_EXCEPTION_ALPHA);
            }
        } while (!confValide);

        return conf;
    }

    /**
     * Cette methode valide le choix d'option dans le menu
     * @return un choix d'option valide pour le menu
     */
    private static int validerMenu() {

        int valeur = -1;

        do {
            try {
                valeur = validerEntier(MSG_SOLL_MENU,MSG_ERR_MENU,
                        MENU_MIN,MENU_MAX);
            } catch (NumberFormatException e) {
                System.out.println(MSG_ERR_EXCEPTION_NUM);
            }
        } while (valeur < 0 || valeur > 9);

        return valeur;
    }

    /**
     * Cette methode enregristre dans une fichier le contenue d'un tableau
     * de pizza.
     *
     * @param nomFichier le nom que le fichier portera.
     * @param tab le tableau de pizza.
     */
    private static void enregistrerDansFichier(String nomFichier,
                                              String enTete,
                                              String msgErr,
                                              Pizza[] tab) {

        FileWriter ficAEcrire;
        PrintWriter sortie;
        int compteur = 0;
        int tailleTab = tab.length;

        try {
            ficAEcrire = new FileWriter(nomFichier); //IOException possible
            sortie = new PrintWriter(ficAEcrire);

            sortie.println(enTete);

            if(tab[0] == null)
                sortie.println(msgErr);
            else {
                while(compteur < tailleTab && tab[compteur] != null) {
                    sortie.println(tab[compteur].toString()+"\n");
                    compteur = compteur + 1;
                }
            }
            sortie.close();

        } catch (IOException ioe) {
            System.out.println("Erreur d'entree/sortie !");
        }
    }

    /*******************************************
     * Méthodes pour créer ou modifier une pizza
     ******************************************/

    /**
     * Fait une liste qui lie le numero a saisir en fonction
     * de sa correspondance.
     *
     * @param ingredients Une liste d'ingredients
     * @return la liste de tout les ingredient avec leurs code
     */
    private static String obtenirListDeChoix(String [] ingredients) {

        String resultat = "";

        for (int i = 0 ; i < ingredients.length ; i++)
            resultat = resultat + i + " - " + ingredients[i] + "\n";

        return resultat;
    }

    /**
     * Cette methode permet de valider le choix d'un ingredient dans une pizza
     *
     * @param valeur l'ingredient a valider (croute, viande, grandeur, etc.)
     * @param msgSol Message de sollicitation de l'ingredient
     * @param msgErr Message d'erreur si le choix est numerique mais invalide
     * @param minVal Valeur minimum du choix pour l'ingredient
     * @param maxVal Valeur maximum du chois pour l'ingredient
     * @param list List des choix possible par ingredient
     * @return un entier valide choisie par l'utilisateur pour un ingredient.
     */
    private static int validerIngredient(int valeur, String msgSol,
                                        String msgErr, int minVal, int maxVal,
                                        String [] list) {
        System.out.println(msgSol);
        System.out.println(obtenirListDeChoix(list));
        do {
            try {
                valeur = validerEntier(MSG_SOL_GENERAL,msgErr,
                        minVal,maxVal);
            } catch (NumberFormatException e) {
                System.out.println(MSG_ERR_EXCEPTION_NUM);
            }
        } while (valeur < minVal || valeur > maxVal);

        return valeur;
    }

    /**
     * Demande de saisie des ingredients et creation de l'objet pizza
     *
     * @return la pizza crée suite a la saisie de toute les informatons
     */
    private static Pizza creerUnePizza() {

        Pizza pizza;

        int grandeur = Pizza.MIN_GRANDEUR - 1;
        int viande = Pizza.MIN_VIANDE - 1;
        int viandeX = Pizza.MIN_VIANDE - 1;
        int garniture = Pizza.MIN_GARN - 1;
        int garnitureX = Pizza.MIN_GARN - 1;
        int croute = Pizza.MIN_CROUTE - 1;

        String [] grandeurs = Pizza.getGrandeurs();
        String [] viandes = Pizza.getViandes();
        String [] garnitures = Pizza.getGarnitures();
        String [] croutes = Pizza.getCroutes();

        grandeur = validerIngredient(grandeur,MSG_SOL_TAILLE,MSG_ERR_TAILLE,
                Pizza.MIN_GRANDEUR,Pizza.MAX_GRANDEUR,grandeurs);

        viande = validerIngredient(viande,MSG_SOL_VIANDE,MSG_ERR_VIANDE,
                Pizza.MIN_VIANDE,Pizza.MAX_VIANDE,viandes);

        viandeX = validerIngredient(viandeX,MSG_SOL_VIANDE_X,MSG_ERR_VIANDE,
                Pizza.MIN_VIANDE,Pizza.MAX_VIANDE,viandes);

        garniture = validerIngredient(garniture,MSG_SOL_GARN,MSG_ERR_GARN,
                Pizza.MIN_GARN,Pizza.MAX_GARN,garnitures);

        garnitureX = validerIngredient(garnitureX,MSG_SOL_GARN_X,MSG_ERR_GARN,
                Pizza.MIN_GARN,Pizza.MAX_GARN,garnitures);

        croute = validerIngredient(croute,MSG_SOL_CROUTE,MSG_ERR_CROUTE,
                Pizza.MIN_CROUTE,Pizza.MAX_CROUTE,croutes);

        pizza = new Pizza(viande,garniture,grandeur,croute,viandeX,garnitureX);

        return pizza;
    }

    /**
     * Formate un choix parmi un tableau de choix. Par exemple
     * (2) Moyenne.
     * @param choix un entier représentant un choix
     * @param tab une table de choix presente dans la classe Pizza
     * @return le choix de l'utilisateur formatée.
     */
    private static String formaterChoix(int choix, String [] tab) {
        return "("+choix+")"+" "+tab[choix];
    }

    /**
     * Modifier une pizza soit proposer une modification pour chaque ingredient
     *
     * @param pizza la pizza a modifier
     * @return la pizza modifiée
     */
    private static Pizza modifierPizza(Pizza pizza) {

        int grandeur = -1;
        int viande = -1;
        int viandeX = -1;
        int garniture = -1;
        int garnitureX = -1;
        int croute = -1;

        String [] grandeurs = Pizza.getGrandeurs();
        String [] viandes = Pizza.getViandes();
        String [] garnitures = Pizza.getGarnitures();
        String [] croutes = Pizza.getCroutes();

        //Modification Grandeur
        String msgSolGrandeur =  MSG_MODIF_TAILLE +
                formaterChoix(pizza.getGrandeur(),grandeurs) +
                MSG_SOL_MODIF_TAILLE+"\n";

        grandeur = validerIngredient(grandeur,msgSolGrandeur,
                MSG_ERR_MODIF_PIZZA,Pizza.MIN_GRANDEUR,Pizza.MAX_GRANDEUR,
                grandeurs);

        pizza.setGrandeur(grandeur);

        //Modification Viande
        String msgSolViande =  MSG_MODIF_VIANDE +
                formaterChoix(pizza.getViande(),viandes) +
                MSG_SOL_MODIF_VIANDE+"\n";

        viande = validerIngredient(viande,msgSolViande,
                MSG_ERR_MODIF_PIZZA,Pizza.MIN_VIANDE,Pizza.MAX_VIANDE,
                viandes);

        pizza.setViande(viande);

        //Modification viande extra
        String msgSolViandeX =  MSG_MODIF_XVIANDE +
                formaterChoix(pizza.getExtraViande(),viandes) +
                MSG_SOL_MODIF_XVIANDE+"\n";

        viandeX = validerIngredient(viandeX,msgSolViandeX,
                MSG_ERR_MODIF_PIZZA,Pizza.MIN_VIANDE,Pizza.MAX_VIANDE,
                viandes);

        pizza.setExtraViande(viandeX);

        //Modification garniture
        String msgSolGarn =  MSG_MODIF_GARN +
                formaterChoix(pizza.getGarniture(),garnitures) +
                MSG_SOL_MODIF_GARN+"\n";

        garniture = validerIngredient(garniture,msgSolGarn,
                MSG_ERR_MODIF_PIZZA,Pizza.MIN_GARN,Pizza.MAX_GARN,
                garnitures);

        pizza.setGarniture(garniture);

        //Modification garniture extra
        String msgSolGarnX =  MSG_MODIF_XGARN +
                formaterChoix(pizza.getExtraGarniture(),garnitures) +
                MSG_SOL_MODIF_XGARN+"\n";

        garnitureX = validerIngredient(garnitureX,msgSolGarnX,
                MSG_ERR_MODIF_PIZZA,Pizza.MIN_GARN,Pizza.MAX_GARN,
                garnitures);

        pizza.setExtraGarniture(garnitureX);

        //modification croute
        String msgSolCroute =  MSG_MODIF_CROUTE +
                formaterChoix(pizza.getCroute(),croutes) +
                MSG_SOL_MODIF_CROUTE+"\n";

        croute = validerIngredient(croute,msgSolCroute,
                MSG_ERR_MODIF_PIZZA,Pizza.MIN_CROUTE,Pizza.MAX_CROUTE,
                croutes);

        pizza.setCroute(croute);

        return pizza;
    }

    /******************************************************
     * METHODES SPECIALISEE EN FONCTION DES OPTIONS DU MENU
     ******************************************************/

    /**
     * Cette methode creer une pizza et la met dans un tableau de pizza
     *
     * @param tab un tableau de pizza
     */
    private static void commanderPizza(Pizza [] tab) {

        Pizza pizza = creerUnePizza();
        insererPizzaDansTab(tab,pizza);
        System.out.println(MSG_CMD_AJOUTEE);
    }

    /**
     * Affiche le tableau de pizza en cours de traitement si non vide
     * sinon affiche le message d'erreur CMD_ENCOURS_VIDE
     * @param commandesEnTraitement tableau des commandes en traitements.
     */
    private static void afficherCommandesEnTraitement(Pizza []
                                                     commandesEnTraitement) {
        afficherTableauPizza(commandesEnTraitement,CMD_ENCOURS_VIDE);
    }

    /**
     * Modifier une pizza a partir de son ID dans le tableau des
     * commandes en traitement a condition qu'elle existe
     *
     * @param commandesEnTraitement le tableau des commandes en traitements
     */
    private static void modifierPizza(Pizza [] commandesEnTraitement) {

        int pizzaId = 0;
        Pizza pizza = null;
        char confirmation;

        if(commandesEnTraitement[0] == null)
            System.out.println(MSG_MODIF_CMD_ENCOURS_VIDE);
        else {

            //Saisie et validation du numero de pizza
            do {
                try {
                    pizzaId = validerEntier(MSG_SOL_MODIF_PIZZA,
                            MSG_ERR_MODIF_PIZZA,1,999);
                } catch (NumberFormatException e) {
                    System.out.println(MSG_ERR_EXCEPTION_NUM);
                }
            } while (pizzaId < 1 || pizzaId > 999);

            //recherche de la pizza dans le tableau des commandes en
            //traitement
            pizza = obtenirPizza(commandesEnTraitement,pizzaId);

            if (pizza == null)
                System.out.println(MSG_MODIF_CMD_INEXISTANTE);
            else {
                System.out.println(pizza.toString());
                confirmation = validerConfirmation(MSG_CONF_MODIF,
                        MSG_ERR_CONF_MODIF);

                if(confirmation == 'n' || confirmation == 'N')
                    System.out.println(MSG_MODIF_ANNULEE);
                else {
                    pizza = modifierPizza(pizza);
                    confirmation = validerConfirmation(MSG_CONF_MODIF,
                            MSG_ERR_CONF_MODIF);

                    if(confirmation == 'n' || confirmation == 'N')
                        System.out.println(MSG_MODIF_ANNULEE);
                    else {
                        int position = obtenirPositionParId(pizzaId,
                                commandesEnTraitement);
                        commandesEnTraitement[position] = pizza;
                        System.out.println(MSG_MODIF_SUCCESS);
                    }
                }
            }
        }
    }

    /**
     * Envoyer une pizza en livraison soit saisir un id de pizza,
     * verifier si elle est traitement et si elle existe dans ce tableau,
     * la supprimer de cette table et l'envoyer dans le tableau des
     * commandes en livraison.
     *
     * @param commandesEnTraitement tableau des commandes en traitement
     * @param commandesEnLivraison tableau des commandes en livraison
     */
    private static void envoyerPizzaEnLivraison(Pizza [] commandesEnTraitement,
                                        Pizza [] commandesEnLivraison) {

        Pizza pizza = null;
        int pizzaId = 0;
        char confirmation;

        if(commandesEnTraitement[0] == null)
            System.out.println(MSG_ERR_ENVOIE_LIVRAISON_VIDE);
        else {
            //Saisie et validation du numero de pizza
            do {
                try {
                    pizzaId = validerEntier(MSG_SOL_LIVRAISON_PIZZA,
                            MSG_ERR_MODIF_PIZZA, 1, 999);
                } catch (NumberFormatException e) {
                    System.out.println(MSG_ERR_EXCEPTION_NUM);
                }
            } while (pizzaId < 1 || pizzaId > 999);

            //recherche de la pizza dans le tableau des commandes en
            //traitement
            pizza = obtenirPizza(commandesEnTraitement, pizzaId);

            if (pizza == null)
                System.out.println(MSG_ERR_LIVRAISON_INNEXISTANTE);
            else {
                System.out.println(pizza.toString());
                confirmation = validerConfirmation(MSG_CONF_ENVOIE,
                        MSG_ERR_CONF_MODIF);

                if (confirmation == 'n' || confirmation == 'N')
                    System.out.println(MSG_LIVRAISON_ANNULEE);
                else {
                    insererPizzaDansTab(commandesEnLivraison,pizza);
                    retirerPizzaDeTab(commandesEnTraitement,pizzaId);
                    System.out.println(MSG_LIVRAISON_SUCCESS);
                }
            }
        }
    }

    /**
     * Afficher le tableau des livraison en cours
     *
     * @param commandesEnLivraison tableau des commandes en livraison
     */
    private static void afficherLivraisonEnCours(Pizza [] commandesEnLivraison) {
        afficherTableauPizza(commandesEnLivraison,
                MSG_ERR_LIVRAISON_ENCOURS_VIDE);
    }

    /**
     * Confirmer une livraion transfert une pizza du tableau des pizza
     * en cours de livraison vers le tableau des pizza livrée.
     *
     * @param commandesEnLivraison tableau des pizza en livraion
     * @param commandeLivree tableau des pizza livrée
     */
    private static void confirmerLivraison(Pizza [] commandesEnLivraison,
                                   Pizza [] commandeLivree) {

        Pizza pizza = null;
        int pizzaId = 0;
        char confirmation;

        if(commandesEnLivraison[0] == null)
            System.out.println(MSG_ERR_LIST_LIVRAISON_VIDE);
        else {
            //Saisie et validation du numero de pizza
            do {
                try {
                    pizzaId = validerEntier(MSG_SOL_CONF_LIVRAISON_PIZZA,
                            MSG_ERR_MODIF_PIZZA, 1, 999);
                } catch (NumberFormatException e) {
                    System.out.println(MSG_ERR_EXCEPTION_NUM);
                }
            } while (pizzaId < 1 || pizzaId > 999);

            //recherche de la pizza dans le tableau des commandes en
            //traitement
            pizza = obtenirPizza(commandesEnLivraison, pizzaId);

            if (pizza == null)
                System.out.println(MSG_ERR_CMD_A_LIVRER_INEXISTANTE);
            else {
                System.out.println(pizza.toString());
                confirmation = validerConfirmation(MSG_CONF_lIVRAISON,
                        MSG_ERR_CONF_MODIF);

                if (confirmation == 'n' || confirmation == 'N')
                    System.out.println(MSG_CONF_LIVRAISON_ANNULEE);
                else {
                    insererPizzaDansTab(commandeLivree,pizza);
                    retirerPizzaDeTab(commandesEnLivraison,pizzaId);
                    System.out.println(MSG_CONF_LIVRAISON_SUCCESS);
                }
            }
        }
    }

    /**
     * Affiche le tableau des commandes livree
     *
     * @param commandeLivree tableau des commandes livree
     */
    private static void afficherCommandeLivree(Pizza [] commandeLivree) {
        afficherTableauPizza(commandeLivree,
                MSG_CMD_LIVREE_VIDE);
    }

    public static void main(String[] args) {

        //tableau de pizza en fonction de leurs status
        Pizza [] commandesEnTraitement = new Pizza[10];
        Pizza [] commandesEnLivraison = new Pizza[10];
        Pizza [] commandeLivree = new Pizza[10];

        int choixMenu;    //choix au menu

        //presentation du logiciel
        presenterLogiciel();

        //boucle principale du programme
        do {
            //obtenir choix menu
            afficherMenu();
            choixMenu = validerMenu();
            System.out.println();

            //executer choix menu
            switch (choixMenu) {

                //Commander une pizza
                case 1 :
                    commandesEnTraitement = augmenterTailleTableauCinq(
                            commandesEnTraitement);
                    commanderPizza(commandesEnTraitement);
                    break;

                //Afficher les commandes en cours de traitements
                case 2 :
                    afficherCommandesEnTraitement(commandesEnTraitement);
                    break;

                //Modifier une pizza (commande en cours de traitement seulement)
                case 3 :
                    modifierPizza(commandesEnTraitement);
                    break;

                //Envoyer une pizza a la livraison
                case 4 :
                    commandesEnLivraison = augmenterTailleTableauCinq(
                            commandesEnLivraison);
                    envoyerPizzaEnLivraison(commandesEnTraitement,
                            commandesEnLivraison);
                    break;

                //Afficher les livraisons en cours
                case 5 :
                    afficherLivraisonEnCours(commandesEnLivraison);
                    break;

                //Confirmer une livraison
                case 6 :
                    commandeLivree =
                            augmenterTailleTableauCinq(commandeLivree);
                    confirmerLivraison(commandesEnLivraison,commandeLivree);
                    break;

                //Afficher les pizzas qui ont ete livrees
                case 7 :
                    afficherCommandeLivree(commandeLivree);
                    break;
            }

        } while (!(choixMenu == MENU_MAX));

        enregistrerDansFichier(FIC_EN_TRAITEMENT,ENTETE_EN_TRAITEMENT,
                FIC_ERR_TRAITEMENT,commandesEnTraitement);

        enregistrerDansFichier(FIC_EN_LIVRAISON,ENTETE_EN_LIVRAISON,
                FIC_ERR_LIVRAISON,commandesEnLivraison);

        enregistrerDansFichier(FIC_LIVREE,ENTETE_LIVREE,
                FIC_ERR_LIVREE,commandeLivree);

        afficherFinProg();
    }
}