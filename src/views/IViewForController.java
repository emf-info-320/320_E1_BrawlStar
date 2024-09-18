package views;

/**
 * Interface définissant les méthodes mise à disposition par la vue pour le
 * controller
 */
public interface IViewForController {

    /**
     * Méthode qui démarre la vue
     */
    void start();

    /**
     * Méthode qui affichera dans la zone des rapport le message donné en
     * paramètre.
     * 
     * @param message Le message à afficher dans la zone de rapport
     */
    void afficheRapport(String message);
}
