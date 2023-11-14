package fr.iut.editeur.commande.factory;

import fr.iut.editeur.commande.*;
import fr.iut.editeur.document.Document;

public class CommandeFactory {

    private static CommandeFactory instance;

    public static CommandeFactory getInstance() {
        if(instance == null) {
            instance = new CommandeFactory();
        }
        return instance;
    }

    private CommandeFactory() {}

    /**
     * Crée une commande en fonction de son nom
     * @param name nom de la commande
     * @param document  document sur lequel la commande va s'appliquer
     * @param parameters action à effectuer
     * @return l'objet commande crée
     */
    public Commande createCommand(String name, Document document, String[] parameters) {
        switch (name) {
            case "inserer": return new CommandeInserer(document, parameters);
            case "ajouter" : return new CommandeAjouter(document, parameters);
            case "remplacer": return new CommandeRemplacer(document, parameters);
            case "majuscules": return new CommandeMajuscules(document, parameters);
            case "effacer": return new CommandeEffacer(document, parameters); //feature finie
            case "clear": return new CommandeClear(document, parameters);
            default: return null;
        }
    }

}
