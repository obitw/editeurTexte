package fr.iut.editeur.document;

import junit.framework.TestCase;

public class DocumentTest extends TestCase {

    public void testAjouter() {
        Document document = new Document();
        document.ajouter("Bonjour");
        assertEquals("Bonjour", document.getTexte());
    }

    public void testRemplacer() {
        Document document = new Document();
        document.setTexte("Hello, World!");
        document.remplacer(0, 5, "Hi");
        assertEquals("Hi!", document.getTexte()); //test ne passe pas
    }

    public void testEffacer() {
        Document document = new Document();
        document.setTexte("Hello, World!");
        document.effacer(5, 12);
        assertEquals("Hello!", document.getTexte());
    }

    public void testClear() {
        Document document = new Document();
        document.setTexte("Hello, World!");
        document.clear();
        assertEquals("", document.getTexte());
    }

    public void testInserer() {
        Document document = new Document();
        document.setTexte("Hello!");
        document.inserer(5, ", World");
        assertEquals("Hello, World!", document.getTexte());
    }
}
