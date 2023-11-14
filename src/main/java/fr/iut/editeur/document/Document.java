package fr.iut.editeur.document;

public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }


    /**
     * Remplace le texte entre start et end par le remplacement
     * @param start debut de la selection
     * @param end fin de la selection
     * @param remplacement texte de remplacement
     */
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    /**
     * Met en majuscule le texte entre start et end
     * @param start debut de la selection
     * @param end fin de la selection
     */
    public void majuscules(int start, int end) {
        String leftPart = texte.substring(0, start);
        String middlePart = texte.substring(start, end).toUpperCase();
        String rightPart = texte.substring(end);

        texte = leftPart + middlePart + rightPart;
    }

    /**
     * Met en minuscule le texte entre start et end
     * @param start debut de la selection
     * @param end fin de la selection
     */
    public void effacer(int start, int end) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);

        texte = leftPart + rightPart;
    }

    /**
     * Efface tout le texte
     */
    public void clear() {
        texte = "";
    }

    /**
     * Insere le texte a la position start
     * @param start debut de la selection
     * @param insertion texte a inserer
     */
    public void inserer(int start, String insertion) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(start);

        texte = leftPart + insertion + rightPart;
    }


    @Override
    public String toString() {
        return this.texte;
    }
}
