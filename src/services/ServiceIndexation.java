package services;

/**
 * Classe représentant le service d'indexation de l'application.
 */
public class ServiceIndexation {

    /**
     * Le constructeur de la classe Service indexation. C'est ici que TOUS attributs
     * sont initialisé
     */
    public ServiceIndexation() {
    }

    /**
     * Méthode appelée une fois avant que l'indexation des données soit faite. C'est
     * ici qu'il faut vider les différentes structures de données
     */
    public void avantIndexation() {
    }

    /**
     * Méthode appelée pour indexer vos données. C'est ici que vos différentes
     * structures de données doivent être remplie pour ensuite pouvoir être
     * utilisées dans les méthodes "rapido..."
     * 
     * @param elements La liste de tous les élément de jeu (Brawlers + Évènements)
     *                 en vrac
     */
    public void indexation(List<ElementDeJeu> elements) {

    }

    /**
     * Méthode appelée une fois après que l'indexation soit faite. C'est ici que
     * vous allez faire les dernier traitements sur vos structures de données.
     */
    public void apresIndexation() {
    }

    /**
     * Méthode rapido qui répond à la question : "Quel est le nombre
     * d'éléments de jeu qui ont été importés et indexés?".
     * 
     * @return Le nombre total d'éléments importés et indexés.
     */
    public int rapido0_NombreElements() {
    }

    /**
     * Méthode rapido qui doit répondre rapidement à la question "Lister tous les
     * brawlers présents dans la liste passée en paramètres"
     * Cette liste doit être retournée sans doublons par ordre de rareté (id de la
     * rareté) de la moins rare à la plus rare, puis du nom alphabétiquement.
     * 
     * @return La liste de tous les brawlers trié par rareté (id de la rareté)
     *         croissante puis du nom de manière alphabétique.
     */
    public List<Brawler> rapido1_ListeBrawlers() {
    }

    /**
     * Méthode rapido qui doit répondre rapidement à la question "Lister toutes les
     * classes des brawlers". Cette liste doit être sans doublons et par ordre
     * alphabétique.
     * 
     * @return La liste de toutes les classes sans doublons et par ordre
     *         alphabétique.
     */
    public List<String> rapido2_ListeDesClasses() {
    }

    /**
     * Méthode rapido qui doit répondre rapidement à la question "Lister tous les
     * évènements". Cette liste doit respecter l'ordre de démarrage de l'évènement,
     * du plus vieux au plus jeune les doublons sont autorisés.
     * 
     * @return La liste de tous les évènements dans l'ordre de la plus vieille date
     *         de début à la plus jeune date de début.
     */
    public List<Evenement> rapido3_TousLesEvenements() {
    }

    /**
     * Donne la liste des raretés des différents brawler, sans doublons par ordre
     * croissant de l'id.
     * 
     * @return la liste des raretés, sans doublons, par ordre croissant de l'id
     */
    public List<Rarete> getRapido4List_RareteDuBrawler() {
    }

    /**
     * Méthode rapido qui doit répondre rapidement à la question "Lister tous les
     * brawler de la rareté sélectionnée". Cette Liste doit être triée de manière
     * alphabétique sur le nom du brawler.
     * 
     * @param nomDeLaRarete Le nom de la rareté sélectionnée.
     * @return La liste de tous les brawlers de la rareté sélectionnée dans l'ordre
     *         alphabétique du nom du brawler.
     */
    public List<Brawler> rapido4_brawlerParRarete(String nomDeLaRarete) {
    }

    /**
     * Méthode rapido qui doit répondre rapidement à la question "Quel est le nombre
     * d'évènement par mode de jeu".
     * La liste doit être ordrée par le mode de jeu ayant le moins d'événements à
     * celui qui en a le plus uniquement.
     * 
     * @return Une liste contenant des string représentant le nombre d'événement
     *         pour ce mode de jeu suivi du texte " événement(s) pour le mode : ",
     *         puis le mode de jeu.
     */
    public List<String> rapido5_NombreEvenementParModeDeJeu() {
    }

}
