package com.company;

import java.lang.reflect.Type;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Plateau Plateau = new Plateau();
        Scanner scannerString = new Scanner(System.in);
        boolean partieTerminee = false;
        int numJoueur = 0;
        boolean nextJoueur;
        boolean entreeValide = false;

        System.out.println("");
        Plateau.getPlateau();
        System.out.println("");

        do{
            if(Plateau.getPartieFinie() == true) {
                break;
            }
            if(numJoueur%2 == 0){
                System.out.println("Tour du joueur 1");
            } else{
                System.out.println("Tour du joueur 2");
            }
            numJoueur++;

            do{
                System.out.print("Choisissez la case :");
                String caseChoisi = scannerString.nextLine();
                if(isValidLetter(caseChoisi)){
                    System.out.println("Toto");
                    if(isValidNumber(caseChoisi)){
                        entreeValide = true;
                        System.out.println("Tata");
                    } else{
                        break;
                    }
                } else {
                    break;
                }
                if(Plateau.getPieceCase(caseChoisi).isTaken()){
                    System.out.println("La case " + caseChoisi + " contient la pièce : " + Plateau.getPieceCase(caseChoisi).getNomAffiche());
                    System.out.print("Choisissez la case cible : ");
                    String caseCible = scannerString.nextLine();

                    if(isValidLetter(caseCible)){
                        if(isValidNumber(caseChoisi)){
                            entreeValide = true;
                        } else{
                            break;
                        }
                    } else {
                        break;
                    }
                    Plateau.deplacerPiece(caseChoisi, caseCible);
                    nextJoueur = true;
                } else {
                    System.out.println("La case est vide, veuillez recommencer votre choix.");
                    nextJoueur = false;
                }
            } while (nextJoueur == false);

            if(entreeValide == false){
                System.out.println("La saisie n'est pas valide.");
                break;
            }

            System.out.println("");
            Plateau.getPlateau();
            System.out.println("");

        }while(partieTerminee == false);


    }

    public static boolean isValidLetter(String Saisie){
        switch (Saisie.substring(0,1)){
            case "A":
                return true;
            case "B":
                return true;
            case "C":
                return true;
            case "D":
                return true;
            case "E":
                return true;
            case "F":
                return true;
            case "G":
                return true;
            case "H":
                return true;
            default:
                return false;
        }
    }
    public static boolean isValidNumber(String Saisie){
        switch (Saisie.substring(1,2)){
            case "1":
                return true;
            case "2":
                return true;
            case "3":
                return true;
            case "4":
                return true;
            case "5":
                return true;
            case "6":
                return true;
            case "7":
                return true;
            case "8":
                return true;
            default:
                return false;
        }
    }
}

class Plateau {
    /* Contient toutes les pièces */
    private HashMap<String, Case> tableau = new HashMap<String, Case>();
    private boolean partieFinie;
    private String[] listeColonne = {"A","B","C","D","E","F","G","H"};
    /*  Permet d'associer à une lettre de colonne un numéro ; ex A = 0*/
    HashMap<String, Integer> mapKeyTableau = new HashMap<String, Integer>();
    /*
        Déclaration des pièces
    */
    //Piece noir (couleur == 0)
    private Pion p1 = new Pion(0);private Pion p2 = new Pion(0);
    private Pion p3 = new Pion(0);private Pion p4 = new Pion(0);
    private Pion p5 = new Pion(0);private Pion p6 = new Pion(0);
    private Pion p7 = new Pion(0);private Pion p8 = new Pion(0);

    private Tour t1 = new Tour(0);private Tour t2 = new Tour(0);
    private Fou f1 = new Fou(0);private Fou f2 = new Fou(0);
    private Cavalier c1 = new Cavalier(0);private Cavalier c2 = new Cavalier(0);
    private Roi r1 = new Roi(0);private Reine d1 = new Reine(0);

    //Pieces blanches (couleur == 1)
    private Pion P1 = new Pion(1);private Pion P2 = new Pion(1);
    private Pion P3 = new Pion(1);private Pion P4 = new Pion(1);
    private Pion P5 = new Pion(1);private Pion P6 = new Pion(1);
    private Pion P7 = new Pion(1);private Pion P8 = new Pion(1);

    private Tour T1 = new Tour(1);private Tour T2 = new Tour(1);
    private Fou F1 = new Fou(1);private Fou F2 = new Fou(1);
    private Cavalier C1 = new Cavalier(1);private Cavalier C2 = new Cavalier(1);
    private Roi R1 = new Roi(1);private Reine D1 = new Reine(1);


    public Plateau(){
        partieFinie = false;
        mapKeyTableau.put("A",0);mapKeyTableau.put("B",1); mapKeyTableau.put("C",2); mapKeyTableau.put("D",3); mapKeyTableau.put("E",4); mapKeyTableau.put("F",5); mapKeyTableau.put("G",6); mapKeyTableau.put("H",7);
    /*
        Affectation des pièces
    */
        // Pieces noires
        tableau.put(listeColonne[0]+2, new Case(p1, "p1"));tableau.put(listeColonne[1]+2, new Case(p2, "p2"));
        tableau.put(listeColonne[2]+2, new Case(p3, "p3"));tableau.put(listeColonne[3]+2, new Case(p4, "p4"));
        tableau.put(listeColonne[4]+2, new Case(p5, "p5"));tableau.put(listeColonne[5]+2, new Case(p6, "p6"));
        tableau.put(listeColonne[6]+2, new Case(p7, "p7"));tableau.put(listeColonne[7]+2, new Case(p8, "p8"));

        tableau.put(listeColonne[0]+1, new Case(t1, "t1"));tableau.put(listeColonne[7]+1, new Case(t2, "t2"));
        tableau.put(listeColonne[1]+1, new Case(c1, "c1"));tableau.put(listeColonne[6]+1, new Case(c2, "c2"));
        tableau.put(listeColonne[2]+1, new Case(f1, "f1"));tableau.put(listeColonne[5]+1, new Case(f2, "f2"));
        tableau.put(listeColonne[3]+1, new Case(r1, "r1"));tableau.put(listeColonne[4]+1, new Case(d1, "d1"));

        for(int i = 0; i<8; i++){
            for(int j=3; j<7; j++){
                tableau.put(listeColonne[i]+j, new Case());
            }
        }

        // Pieces blanches
        tableau.put(listeColonne[0]+7, new Case(P1, "P1"));tableau.put(listeColonne[1]+7, new Case(P2, "P2"));
        tableau.put(listeColonne[2]+7, new Case(P3, "P3"));tableau.put(listeColonne[3]+7, new Case(P4, "P4"));
        tableau.put(listeColonne[4]+7, new Case(P5, "P5"));tableau.put(listeColonne[5]+7, new Case(P6, "P6"));
        tableau.put(listeColonne[6]+7, new Case(P7, "P7"));tableau.put(listeColonne[7]+7, new Case(P8, "P8"));

        tableau.put(listeColonne[0]+8, new Case(T1, "T1"));tableau.put(listeColonne[7]+8, new Case(T2, "T2"));
        tableau.put(listeColonne[1]+8, new Case(C1, "C1"));tableau.put(listeColonne[6]+8, new Case(F2, "C2"));
        tableau.put(listeColonne[2]+8, new Case(F1, "F1"));tableau.put(listeColonne[5]+8, new Case(C2, "F2"));
        tableau.put(listeColonne[3]+8, new Case(R1, "R1"));tableau.put(listeColonne[4]+8, new Case(D1, "D1"));

    }

    public boolean getPartieFinie(){
        return partieFinie;
    }

    public void getPlateau(){
        System.out.println("X--A--B--C--D--E--F--G--H-X");
        for(int i=1; i<9;i++){
            System.out.print((i)+"-");
            for(int j=0; j<8;j++){
                System.out.print(tableau.get(listeColonne[j]+i).getNomAffiche()+"-");
            }
            System.out.println(i);
        }
        System.out.println("X--A--B--C--D--E--F--G--H-X");
    }

    public Case getPieceCase(String positionCase){
        return tableau.get(positionCase);
    }

    public boolean deplacerPiece(String caseChoix, String caseCible){
        int deplacementLargeur = mapKeyTableau.get(caseCible.substring(0,1)) - mapKeyTableau.get(caseChoix.substring(0,1));
        int deplacementHauteur = Integer.parseInt(caseCible.substring(1)) - Integer.parseInt(caseChoix.substring(1));

        String TypePieceChoisi = tableau.get(caseChoix).getNomAffiche().substring(0,1).toUpperCase();
        String TypePieceCible;
        if(tableau.get(caseCible).isTaken()){
            TypePieceCible = tableau.get(caseCible).getNomAffiche().substring(0,1).toUpperCase();
        } else{
            TypePieceCible = null;
        }

        System.out.println();

        if(tableau.get(caseChoix).getPiece().checkLegalMovement(deplacementHauteur, deplacementLargeur)){
            if(deplacementHauteur > 0 && deplacementLargeur > 0) {
                //A1 vers B2
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("La case est prise par une pièce de la même couleur");
                    }
                    else {
                        if(TypePieceCible.compareToIgnoreCase("R") == 0){
                            partieFinie = true;
                            System.out.println("Echec pour l'adversaire");
                        }
                        tableau.get(caseCible).removePiece();
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                } else {
                    if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    } else{
                        System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                    }

                }
            }
            if(deplacementHauteur > 0 && deplacementLargeur < 0){
                // B1 vers A2
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("La case est prise par une pièce de la même couleur");
                    }
                    else {
                        if(TypePieceCible.compareToIgnoreCase("R") == 0){
                            partieFinie = true;
                            System.out.println("Echec pour l'adversaire");
                        }
                        tableau.get(caseCible).removePiece();
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                } else {
                    if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    } else{
                        System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                    }
                }
            }
            if(deplacementHauteur < 0 && deplacementLargeur > 0){
                //A2 vers B1
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("La case est prise par une pièce de la même couleur");
                    }
                    else {
                        if(TypePieceCible.compareToIgnoreCase("R") == 0){
                            partieFinie = true;
                            System.out.println("Echec pour l'adversaire");
                        }
                        tableau.get(caseCible).removePiece();
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                } else {
                    if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    } else{
                        System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                    }
                }
            }
            if(deplacementHauteur < 0 && deplacementLargeur < 0){
                //B2 vers A1
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("Le déplacement désiré n'est pas autorisé sur cette pièce");
                    }
                    else {
                        if(TypePieceCible.compareToIgnoreCase("R") == 0){
                            partieFinie = true;
                            System.out.println("Echec pour l'adversaire");
                        }
                        tableau.get(caseCible).removePiece();
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    }
                } else {
                    if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                        tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                        tableau.get(caseChoix).removePiece();
                    } else{
                        System.out.println("Les pions ne peuvent pas se déplacer en diagonale");
                    }
                }
            }
            if(deplacementHauteur > 0 && deplacementLargeur == 0){
                //A1 vers A2
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("La case est prise par une pièce de la même couleur");
                    }
                    else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent manger qu'en diagonale");
                        }
                    }
                } else {
                    tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                    tableau.get(caseChoix).removePiece();
                }
            }
            if(deplacementHauteur < 0 && deplacementLargeur == 0){
                //A2 vers A1
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("La case est prise par une pièce de la même couleur");
                    }
                    else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent manger qu'en diagonale");
                        }
                    }
                } else {
                    tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                    tableau.get(caseChoix).removePiece();
                }
            }
            if(deplacementHauteur == 0 && deplacementLargeur > 0){
                //A1 vers B1
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("La case est prise par une pièce de la même couleur");
                    }
                    else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent manger qu'en diagonale");
                        }
                    }
                } else {
                    tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                    tableau.get(caseChoix).removePiece();
                }
            }
            if(deplacementHauteur == 0 && deplacementLargeur < 0){
                //B1 vers A1
                if(tableau.get(caseCible).isTaken()){
                    if(tableau.get(caseChoix).getPiece().getCouleurPiece() == tableau.get(caseCible).getPiece().getCouleurPiece()){
                        System.out.println("La case est prise par une pièce de la même couleur");
                    }
                    else {
                        if(TypePieceChoisi.compareToIgnoreCase("P") != 0){
                            if(TypePieceCible.compareToIgnoreCase("R") == 0){
                                partieFinie = true;
                                System.out.println("Echec pour l'adversaire");
                            }
                            tableau.get(caseCible).removePiece();
                            tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece(), tableau.get(caseChoix).getNomAffiche());
                            tableau.get(caseChoix).removePiece();
                        } else{
                            System.out.println("Les pions ne peuvent manger qu'en diagonale");
                        }
                    }
                } else {
                    tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAffiche());
                    tableau.get(caseChoix).removePiece();
                }
            }
        } else {
            System.out.println("Le déplacement désiré n'est pas autorisé sur cette pièce");
        }
        return true;
    }
}

class Case {
    private boolean isTaken;
    private Piece piece;
    private String nomAffiche;

    public Case() {
        isTaken = false;
        nomAffiche = "  ";
    }

    public Case(Piece LeNomPiece, String LeNomAffiche) {
        isTaken = true;
        piece = LeNomPiece;
        nomAffiche = LeNomAffiche;
    }

    public String getNomAffiche() {
        return nomAffiche;
    }
    public boolean isTaken(){
        return isTaken;
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece LaPiece, String LeNomAffiche){
        piece = LaPiece;
        nomAffiche = LeNomAffiche;
        isTaken = true;
    }
    public void removePiece(){
        piece = null;
        nomAffiche = "  ";
        isTaken = false;
    }
}

class Piece {
    //0 = noire
    //1 = blanche
    private int couleurPiece;
    protected boolean isFirstMovement;

    public Piece(int LaCouleurPiece){
        couleurPiece = LaCouleurPiece;
        isFirstMovement = true;
    }

    public int getCouleurPiece() {
        return couleurPiece;
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        return true;
    }
}

class Pion extends Piece{
    public Pion(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        //Permet d'éviter de tester pour les mouvements négatifs aussi
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(largeur == 1 && hauteur == 1){
            isFirstMovement = false;
            return true;
        } else if(hauteur == 1 && largeur == 0){
            isFirstMovement = false;
            return true;
        } else if(hauteur == 2 && largeur==0 && isFirstMovement){
            isFirstMovement = false;
            return true;
        } else {
            return false;
        }
    }
}

class Tour extends Piece {
    public Tour(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur > 0 && largeur == 0){
            return true;
        } else if(largeur >0 && hauteur == 0){
            return true;
        } else {
            return false;
        }
    }
}

class Cavalier extends Piece {
    public Cavalier(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur == 2 && largeur == 1){
            return true;
        } else if(hauteur == 1 && largeur == 2){
            return true;
        } else {
            return false;
        }
    }
}

class Fou extends Piece {
    public Fou(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur > 0 && largeur > 0){
            return true;
        } else {
            return false;
        }
    }
}

class Reine extends Piece {
    public Reine(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur > 0 && largeur > 0){
            return true;
        } else if(hauteur > 0 && largeur == 0){
            return true;
        } else if(hauteur == 0 && largeur > 0){
            return true;
        } else {
            return false;
        }
    }
}

class Roi extends Piece {
    public Roi(int LaCouleurPiece) {
        super(LaCouleurPiece);
    }

    public boolean checkLegalMovement(int hauteur, int largeur){
        if(largeur < 0){
            largeur = largeur * -1;
        }
        if(hauteur < 0){
            hauteur = hauteur * -1;
        }

        if(hauteur == 1 && largeur == 1){
            return true;
        } else if(hauteur == 1 && largeur == 0){
            return true;
        } else if(hauteur == 0 && largeur == 1){
            return true;
        } else {
            return false;
        }
    }
}

