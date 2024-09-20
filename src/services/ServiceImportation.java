package services;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.Brawler;
import models.Evenement;
import models.Rarete;
import models.Statistique;

/**
 * Classe du Service d'importation.
 * Cette classe parcours les différents fichier JSON du jeu et les sauvegarde
 * dans des listes.
 */
public class ServiceImportation {
    /**
     * Le chemin de base
     */
    public static final String PATH_BASE = "src/services/ressources";
    /**
     * Le nom du fichier contenant les informations sur les brawlers
     */
    public static final String BRAWLERS = "brawlers.json";
    /**
     * Le nom du fichier contenant les informations sur les évènements
     */
    public static final String EVENTS = "events.json";

    /**
     * Constructeur de la classe ServiceImportation
     */
    public ServiceImportation() {

    }

    /**
     * Méthode qui importe les brawlers
     * 
     * @return Une liste contenant tous les brawler du jeu.
     */
    public List<Brawler> importerBrawlers() {
        Path resourcesPath = Paths.get(PATH_BASE);
        ArrayList<Brawler> brawlers = new ArrayList<Brawler>();

        // Lecture des Brawlers
        try (FileReader reader = new FileReader(resourcesPath.resolve(BRAWLERS).toFile())) {
            // Utilisez Gson pour parser le fichier JSON
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            // Traitez chaque objet du tableau
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                // Extraire les valeurs spécifiques
                String nom = jsonObject.get("name").getAsString();
                int id = jsonObject.get("id").getAsInt();

                JsonObject jsonRarete = jsonObject.getAsJsonObject("rarity");
                String rarete = jsonRarete.get("name").getAsString();
                int idRarete = jsonRarete.get("id").getAsInt();

                JsonObject jsonClass = jsonObject.getAsJsonObject("class");
                String classe = jsonClass.get("name").getAsString();

                // Crée l'objet
                brawlers.add(new Brawler(id, nom, new Rarete(idRarete, rarete), classe));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return brawlers;
    }

    /**
     * Méthode qui importe les événements
     * 
     * @return Une liste contenant tous les événements du jeu.
     */
    public List<Evenement> importerEvenements() {
        Path resourcesPath = Paths.get(PATH_BASE);
        ArrayList<Evenement> events = new ArrayList<Evenement>();
        ServiceDate serviceDate = new ServiceDate();

        // Lecture des Brawlers
        try (FileReader reader = new FileReader(resourcesPath.resolve(EVENTS).toFile())) {
            // Utilisez Gson pour parser le fichier JSON
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            // Traitez chaque objet du tableau
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                // Extraire les valeurs spécifiques
                JsonObject slotObject = jsonObject.getAsJsonObject("slot");
                String nom = slotObject.get("name").getAsString();
                int id = slotObject.get("id").getAsInt();

                String jsonDate = jsonObject.get("startTime").getAsString();
                Instant instant = Instant.parse(jsonDate);
                Date dateDebut = Date.from(instant);

                String jsonEndDate = jsonObject.get("endTime").getAsString();
                Instant instantEnd = Instant.parse(jsonEndDate);
                Date dateFin = Date.from(instantEnd);

                JsonObject jsonMap = jsonObject.getAsJsonObject("map");
                JsonArray stats = jsonMap.getAsJsonArray("stats");
                ArrayList<Statistique> statistiques = new ArrayList<Statistique>();
                for (int j = 0; j < stats.size(); j++) {
                    JsonObject statsObject = stats.get(j).getAsJsonObject();
                    int idBrawler = statsObject.get("brawler").getAsInt();
                    double pVictoire = statsObject.get("winRate").getAsDouble();
                    double pUtilisation = statsObject.get("useRate").getAsDouble();

                    Statistique s = new Statistique(idBrawler, pVictoire, pUtilisation);
                    statistiques.add(s);
                }

                String gameMode = jsonMap.getAsJsonObject("gameMode").get("name").getAsString();

                // Crée l'objet
                events.add(new Evenement(id, nom, dateDebut, dateFin, statistiques, gameMode, serviceDate));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return events;
    }
}
