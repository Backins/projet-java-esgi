package com.company;

import java.util.*;

public class Plateau {
    private HashMap<String, Case> tableau = new HashMap<String, Case>();
    private boolean etatPartie;
    private String[] listeColonne = {"A","B","C","D","E","F","G","H"};
    HashMap<String, Integer> mapKeyTableau = new HashMap<String, Integer>();
/*
    Déclaration des pièces
*/
    //Piece noir
    private Pion p1 = new Pion(0);private Pion p2 = new Pion(0);
    private Pion p3 = new Pion(0);private Pion p4 = new Pion(0);
    private Pion p5 = new Pion(0);private Pion p6 = new Pion(0);
    private Pion p7 = new Pion(0);private Pion p8 = new Pion(0);

    private Tour t1 = new Tour(0);private Tour t2 = new Tour(0);
    private Fou f1 = new Fou(0);private Fou f2 = new Fou(0);
    private Cavalier c1 = new Cavalier(0);private Cavalier c2 = new Cavalier(0);
    private Roi r1 = new Roi(0);private Reine d1 = new Reine(0);

    //Pieces blanches
    private Pion P1 = new Pion(1);private Pion P2 = new Pion(1);
    private Pion P3 = new Pion(1);private Pion P4 = new Pion(1);
    private Pion P5 = new Pion(1);private Pion P6 = new Pion(1);
    private Pion P7 = new Pion(1);private Pion P8 = new Pion(1);

    private Tour T1 = new Tour(0);private Tour T2 = new Tour(0);
    private Fou F1 = new Fou(0);private Fou F2 = new Fou(0);
    private Cavalier C1 = new Cavalier(0);private Cavalier C2 = new Cavalier(0);
    private Roi R1 = new Roi(0);private Reine D1 = new Reine(0);
/*
    Fin déclaration des pièces
*/
    public Plateau(){
        etatPartie = true;
        mapKeyTableau.put("A",0);mapKeyTableau.put("B",1); mapKeyTableau.put("C",2); mapKeyTableau.put("D",3); mapKeyTableau.put("E",4); mapKeyTableau.put("F",5); mapKeyTableau.put("G",6); mapKeyTableau.put("H",7);
    /*
        Affectation des pièces
    */
        // Pieces noir
        tableau.put(listeColonne[0]+1, new Case(t1, "t1"));tableau.put(listeColonne[7]+1, new Case(t2, "t2"));
        tableau.put(listeColonne[1]+1, new Case(c1, "c1"));tableau.put(listeColonne[6]+1, new Case(c2, "c2"));
        tableau.put(listeColonne[2]+1, new Case(f1, "f1"));tableau.put(listeColonne[5]+1, new Case(f2, "f2"));
        tableau.put(listeColonne[3]+1, new Case(r1, "r1"));tableau.put(listeColonne[4]+1, new Case(d1, "d1"));

        tableau.put(listeColonne[0]+2, new Case(p1, "p1"));tableau.put(listeColonne[1]+2, new Case(p2, "p2"));
        tableau.put(listeColonne[2]+2, new Case(p3, "p3"));tableau.put(listeColonne[3]+2, new Case(p4, "p4"));
        tableau.put(listeColonne[4]+2, new Case(p5, "p5"));tableau.put(listeColonne[5]+2, new Case(p6, "p6"));
        tableau.put(listeColonne[6]+2, new Case(p7, "p7"));tableau.put(listeColonne[7]+2, new Case(p8, "p8"));

        for(int i = 0; i<8; i++){
            for(int j=3; j<7; j++){
                tableau.put(listeColonne[i]+j, new Case());
            }
        }

        // Pieces blanche
        tableau.put(listeColonne[0]+7, new Case(P1, "P1"));tableau.put(listeColonne[1]+7, new Case(P2, "P2"));
        tableau.put(listeColonne[2]+7, new Case(P3, "P3"));tableau.put(listeColonne[3]+7, new Case(P4, "P4"));
        tableau.put(listeColonne[4]+7, new Case(P5, "P5"));tableau.put(listeColonne[5]+7, new Case(P6, "P6"));
        tableau.put(listeColonne[6]+7, new Case(P7, "P7"));tableau.put(listeColonne[7]+7, new Case(P8, "P8"));

        tableau.put(listeColonne[0]+8, new Case(T1, "T1"));tableau.put(listeColonne[7]+8, new Case(T2, "T2"));
        tableau.put(listeColonne[1]+8, new Case(C1, "C1"));tableau.put(listeColonne[6]+8, new Case(F2, "C2"));
        tableau.put(listeColonne[2]+8, new Case(F1, "F1"));tableau.put(listeColonne[5]+8, new Case(C2, "F2"));
        tableau.put(listeColonne[3]+8, new Case(R1, "R1"));tableau.put(listeColonne[4]+8, new Case(D1, "D1"));
    /*
        Fin affectation des pièces
    */
    }

    public boolean getEtatPartie(){
        return etatPartie;
    }

    public void affichePlateau(){
        System.out.println("X-AA-BB-CC-DD-EE-FF-GG-HH -X");
        for(int i=1; i<9;i++){
            System.out.print((i)+"-");
            for(int j=0; j<8;j++){
                System.out.print(tableau.get(listeColonne[j]+i).getNomAfficher()+"-");
            }
            System.out.println(i);
        }
        System.out.println("X-AA-BB-CC-DD-EE-FF-GG-HH -X");
    }

    public Case getPieceCase(String positionCase){
        return tableau.get(positionCase);
    }

    public boolean deplacerPiece(String caseChoix, String caseCible){
        int deplacementLargeur = mapKeyTableau.get(caseCible.substring(0,1)) - mapKeyTableau.get(caseChoix.substring(0,1));
        int deplacementHauteur = Integer.parseInt(caseCible.substring(1)) - Integer.parseInt(caseChoix.substring(1));
        if(tableau.get(caseChoix).getPiece().movePieceHauteur(deplacementHauteur, deplacementLargeur)){
            if(tableau.get(caseCible).getContent()){
                System.out.println("Coquinou, la case est pleine, et le code est pas prêt");
            } else {
                tableau.get(caseCible).setPiece(tableau.get(caseChoix).getPiece() , tableau.get(caseChoix).getNomAfficher());
                tableau.get(caseChoix).removePiece();
            }
        }
        return true;
    }
}
