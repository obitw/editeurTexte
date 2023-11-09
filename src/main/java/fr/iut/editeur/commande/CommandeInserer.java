package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeInserer extends CommandeDocument{

        public CommandeInserer(Document document, String[] parameters) {
            super(document, parameters);
        }

        @Override
        public void executer() {
            if (parameters.length < 3) {
                System.err.println("Format attendu : inserer;depart;insertion");
                return;
            }

            try {
                int depart = Integer.parseInt(parameters[1]);
                String insertion = parameters[2];

                if (depart < 0 || depart > this.document.getTexte().length()) {
                    System.err.println("Indice de départ invalide.");
                    return;
                }

                this.document.inserer(depart, insertion);
                super.executer();
            } catch (NumberFormatException e) {
                System.err.println("L'indice de départ doit être un entier.");
            }
        }
}
