package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {

    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 4) {
            System.err.println("Format attendu : remplacer;depart;fin;chaine");
            return;
        }

        try {
            int depart = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);
            String chaine = parameters[3];

            if (depart < 0 || fin < 0 || depart >= fin || fin > this.document.getTexte().length()) {
                System.err.println("Indices de départ et de fin invalides.");
                return;
            }

            String texte = this.document.getTexte();
            String texteRemplace = texte.substring(0, depart) + chaine + texte.substring(fin);

            this.document.setTexte(texteRemplace);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices de départ et de fin doivent être des entiers.");
        }
    }
}
