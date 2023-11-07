package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeMajuscules extends CommandeDocument {

    public CommandeMajuscules(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : majuscules;depart;fin");
            return;
        }

        try {
            int depart = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);

            if (depart < 0 || fin < 0 || depart >= fin || fin > this.document.getTexte().length()) {
                System.err.println("Indices de départ et de fin invalides.");
                return;
            }

            this.document.majuscules(depart, fin);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices de départ et de fin doivent être des entiers.");
        }
    }
}