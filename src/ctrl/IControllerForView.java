package ctrl;

import java.util.List;

import models.Rarete;

/**
 * Interface définissant les méthodes mise à disposition par le controller pour
 * la vue
 */
public interface IControllerForView {

    /**
     * Méthode importation qui va appeler l'importation des données dans le service
     * d'importation.
     */
    void importation();

    /**
     * Méthode qui déclenche l'indexation des données
     */
    void indexer();

    /**
     * Méthode déclenchée lors du clic sur le bouton du rapido 0
     */
    void onRapido0Click();

    /**
     * Méthode déclenchée lors du clic sur le bouton du rapido 1
     */
    void onRapido1Click();

    /**
     * Méthode déclenchée lors du clic sur le bouton du rapido 2
     */
    void onRapido2Click();

    /**
     * Méthode déclenchée lors du clic sur le bouton du rapido 3
     */
    void onRapido3Click();

    /**
     * Méthode déclenchée lors du clic sur le bouton du rapido 4
     * 
     * @param rarete La rareté sélectionnée par l'utilisateur
     */
    void onRapido4Click(Rarete rarete);

    /**
     * Méthode déclenchée dès l'indexation terminée pour récupérer la liste qu'il
     * faut mettre dans la ComboBox du rapido 4
     * 
     * @return la liste de toutes les rareté triée par ordre croissant de l'id
     */
    List<Rarete> getRapido4List();

    /**
     * Méthode déclenchée lors du clic sur le bouton du rapido 5
     */
    void onRapido5Click();

}
