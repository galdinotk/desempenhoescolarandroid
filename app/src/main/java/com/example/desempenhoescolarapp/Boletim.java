package com.example.desempenhoescolarapp;

public class Boletim {
    private String notaArt1 = null;
    private String notaArt2 = null;
    private String notaArt3 = null;
    private String notaArtFinal = null;
    private String faltaArt1 = null;
    private String faltaArt2 = null;
    private String faltaArt3 = null;
    private String faltaArtFinal = null;

    private String notaCie1 = null;
    private String notaCie2 = null;
    private String notaCie3 = null;
    private String notaCieFinal = null;
    private String faltaCie1 = null;
    private String faltaCie2 = null;
    private String faltaCie3 = null;
    private String faltaCieFinal = null;

    private String notaEF1 = null;
    private String notaEF2 = null;
    private String notaEF3 = null;
    private String notaEFFinal = null;
    private String faltaEF1 = null;
    private String faltaEF2 = null;
    private String faltaEF3 = null;
    private String faltaEFFinal = null;

    private String notaGeo1 = null;
    private String notaGeo2 = null;
    private String notaGeo3 = null;
    private String notaGeoFinal = null;
    private String faltaGeo1 = null;
    private String faltaGeo2 = null;
    private String faltaGeo3 = null;
    private String faltaGeoFinal = null;

    private String notaHis1 = null;
    private String notaHis2 = null;
    private String notaHis3 = null;
    private String notaHisFinal = null;
    private String faltaHis1 = null;
    private String faltaHis2 = null;
    private String faltaHis3 = null;
    private String faltaHisFinal = null;

    private String notaIng1 = null;
    private String notaIng2 = null;
    private String notaIng3 = null;
    private String notaIngFinal = null;
    private String faltaIng1 = null;
    private String faltaIng2 = null;
    private String faltaIng3 = null;
    private String faltaIngFinal = null;

    private String notaMat1 = null;
    private String notaMat2 = null;
    private String notaMat3 = null;
    private String notaMatFinal = null;
    private String faltaMat1 = null;
    private String faltaMat2 = null;
    private String faltaMat3 = null;
    private String faltaMatFinal = null;

    private String notaPor1 = null;
    private String notaPor2 = null;
    private String notaPor3 = null;
    private String notaPorFinal = null;
    private String faltaPor1 = null;
    private String faltaPor2 = null;
    private String faltaPor3 = null;
    private String faltaPorFinal = null;

    private String notaRel1 = null;
    private String notaRel2 = null;
    private String notaRel3 = null;
    private String notaRelFinal = null;
    private String faltaRel1 = null;
    private String faltaRel2 = null;
    private String faltaRel3 = null;
    private String faltaRelFinal = null;


    public Boletim() {
        this.notaArt1 = " ";
        this.notaArt2 = " ";
        this.notaArt3 = " ";
        this.notaArtFinal = " ";
        this.faltaArt1 = " ";
        this.faltaArt2 = " ";
        this.faltaArt3 = " ";
        this.faltaArtFinal = " ";
        this.notaCie1 = " ";
        this.notaCie2 = " ";
        this.notaCie3 = " ";
        this.notaCieFinal = " ";
        this.faltaCie1 = " ";
        this.faltaCie2 = " ";
        this.faltaCie3 = " ";
        this.faltaCieFinal = " ";
        this.notaEF1 = " ";
        this.notaEF2 = " ";
        this.notaEF3 = " ";
        this.notaEFFinal = " ";
        this.faltaEF1 = " ";
        this.faltaEF2 = " ";
        this.faltaEF3 = " ";
        this.faltaEFFinal = " ";
        this.notaGeo1 = " ";
        this.notaGeo2 = " ";
        this.notaGeo3 = " ";
        this.notaGeoFinal = " ";
        this.faltaGeo1 = " ";
        this.faltaGeo2 = " ";
        this.faltaGeo3 = " ";
        this.faltaGeoFinal = " ";
        this.notaHis1 = " ";
        this.notaHis2 = " ";
        this.notaHis3 = " ";
        this.notaHisFinal = " ";
        this.faltaHis1 = " ";
        this.faltaHis2 = " ";
        this.faltaHis3 = " ";
        this.faltaHisFinal = " ";
        this.notaIng1 = " ";
        this.notaIng2 = " ";
        this.notaIng3 = " ";
        this.notaIngFinal = " ";
        this.faltaIng1 = " ";
        this.faltaIng2 = " ";
        this.faltaIng3 = " ";
        this.faltaIngFinal = " ";
        this.notaMat1 = " ";
        this.notaMat2 = " ";
        this.notaMat3 = " ";
        this.notaMatFinal = " ";
        this.faltaMat1 = " ";
        this.faltaMat2 = " ";
        this.faltaMat3 = " ";
        this.faltaMatFinal = " ";
        this.notaPor1 = " ";
        this.notaPor2 = " ";
        this.notaPor3 = " ";
        this.notaPorFinal = " ";
        this.faltaPor1 = " ";
        this.faltaPor2 = " ";
        this.faltaPor3 = " ";
        this.faltaPorFinal = " ";
        this.notaRel1 = " ";
        this.notaRel2 = " ";
        this.notaRel3 = " ";
        this.notaRelFinal = " ";
        this.faltaRel1 = " ";
        this.faltaRel2 = " ";
        this.faltaRel3 = " ";
        this.faltaRelFinal = " ";
    }

    public Boletim(String notaArt1, String notaArt2, String notaArt3, String notaArtFinal, String faltaArt1, String faltaArt2, String faltaArt3, String faltaArtFinal, String notaCie1, String notaCie2, String notaCie3, String notaCieFinal, String faltaCie1, String faltaCie2, String faltaCie3, String faltaCieFinal, String notaEF1, String notaEF2, String notaEF3, String notaEFFinal, String faltaEF1, String faltaEF2, String faltaEF3, String faltaEFFinal, String notaGeo1, String notaGeo2, String notaGeo3, String notaGeoFinal, String faltaGeo1, String faltaGeo2, String faltaGeo3, String faltaGeoFinal, String notaHis1, String notaHis2, String notaHis3, String notaHisFinal, String faltaHis1, String faltaHis2, String faltaHis3, String faltaHisFinal, String notaIng1, String notaIng2, String notaIng3, String notaIngFinal, String faltaIng1, String faltaIng2, String faltaIng3, String faltaIngFinal, String notaMat1, String notaMat2, String notaMat3, String notaMatFinal, String faltaMat1, String faltaMat2, String faltaMat3, String faltaMatFinal, String notaPor1, String notaPor2, String notaPor3, String notaPorFinal, String faltaPor1, String faltaPor2, String faltaPor3, String faltaPorFinal, String notaRel1, String notaRel2, String notaRel3, String notaRelFinal, String faltaRel1, String faltaRel2, String faltaRel3, String faltaRelFinal) {
        this.notaArt1 = notaArt1;
        this.notaArt2 = notaArt2;
        this.notaArt3 = notaArt3;
        this.notaArtFinal = notaArtFinal;
        this.faltaArt1 = faltaArt1;
        this.faltaArt2 = faltaArt2;
        this.faltaArt3 = faltaArt3;
        this.faltaArtFinal = faltaArtFinal;
        this.notaCie1 = notaCie1;
        this.notaCie2 = notaCie2;
        this.notaCie3 = notaCie3;
        this.notaCieFinal = notaCieFinal;
        this.faltaCie1 = faltaCie1;
        this.faltaCie2 = faltaCie2;
        this.faltaCie3 = faltaCie3;
        this.faltaCieFinal = faltaCieFinal;
        this.notaEF1 = notaEF1;
        this.notaEF2 = notaEF2;
        this.notaEF3 = notaEF3;
        this.notaEFFinal = notaEFFinal;
        this.faltaEF1 = faltaEF1;
        this.faltaEF2 = faltaEF2;
        this.faltaEF3 = faltaEF3;
        this.faltaEFFinal = faltaEFFinal;
        this.notaGeo1 = notaGeo1;
        this.notaGeo2 = notaGeo2;
        this.notaGeo3 = notaGeo3;
        this.notaGeoFinal = notaGeoFinal;
        this.faltaGeo1 = faltaGeo1;
        this.faltaGeo2 = faltaGeo2;
        this.faltaGeo3 = faltaGeo3;
        this.faltaGeoFinal = faltaGeoFinal;
        this.notaHis1 = notaHis1;
        this.notaHis2 = notaHis2;
        this.notaHis3 = notaHis3;
        this.notaHisFinal = notaHisFinal;
        this.faltaHis1 = faltaHis1;
        this.faltaHis2 = faltaHis2;
        this.faltaHis3 = faltaHis3;
        this.faltaHisFinal = faltaHisFinal;
        this.notaIng1 = notaIng1;
        this.notaIng2 = notaIng2;
        this.notaIng3 = notaIng3;
        this.notaIngFinal = notaIngFinal;
        this.faltaIng1 = faltaIng1;
        this.faltaIng2 = faltaIng2;
        this.faltaIng3 = faltaIng3;
        this.faltaIngFinal = faltaIngFinal;
        this.notaMat1 = notaMat1;
        this.notaMat2 = notaMat2;
        this.notaMat3 = notaMat3;
        this.notaMatFinal = notaMatFinal;
        this.faltaMat1 = faltaMat1;
        this.faltaMat2 = faltaMat2;
        this.faltaMat3 = faltaMat3;
        this.faltaMatFinal = faltaMatFinal;
        this.notaPor1 = notaPor1;
        this.notaPor2 = notaPor2;
        this.notaPor3 = notaPor3;
        this.notaPorFinal = notaPorFinal;
        this.faltaPor1 = faltaPor1;
        this.faltaPor2 = faltaPor2;
        this.faltaPor3 = faltaPor3;
        this.faltaPorFinal = faltaPorFinal;
        this.notaRel1 = notaRel1;
        this.notaRel2 = notaRel2;
        this.notaRel3 = notaRel3;
        this.notaRelFinal = notaRelFinal;
        this.faltaRel1 = faltaRel1;
        this.faltaRel2 = faltaRel2;
        this.faltaRel3 = faltaRel3;
        this.faltaRelFinal = faltaRelFinal;
    }

    public String getNotaArt1() {
        return notaArt1;
    }

    public String getNotaArt2() {
        return notaArt2;
    }

    public String getNotaArt3() {
        return notaArt3;
    }

    public String getNotaArtFinal() {
        return notaArtFinal;
    }

    public String getFaltaArt1() {
        return faltaArt1;
    }

    public String getFaltaArt2() {
        return faltaArt2;
    }

    public String getFaltaArt3() {
        return faltaArt3;
    }

    public String getFaltaArtFinal() {
        return faltaArtFinal;
    }

    public String getNotaCie1() {
        return notaCie1;
    }

    public String getNotaCie2() {
        return notaCie2;
    }

    public String getNotaCie3() {
        return notaCie3;
    }

    public String getNotaCieFinal() {
        return notaCieFinal;
    }

    public String getFaltaCie1() {
        return faltaCie1;
    }

    public String getFaltaCie2() {
        return faltaCie2;
    }

    public String getFaltaCie3() {
        return faltaCie3;
    }

    public String getFaltaCieFinal() {
        return faltaCieFinal;
    }

    public String getNotaEF1() {
        return notaEF1;
    }

    public String getNotaEF2() {
        return notaEF2;
    }

    public String getNotaEF3() {
        return notaEF3;
    }

    public String getNotaEFFinal() {
        return notaEFFinal;
    }

    public String getFaltaEF1() {
        return faltaEF1;
    }

    public String getFaltaEF2() {
        return faltaEF2;
    }

    public String getFaltaEF3() {
        return faltaEF3;
    }

    public String getFaltaEFFinal() {
        return faltaEFFinal;
    }

    public String getNotaGeo1() {
        return notaGeo1;
    }

    public String getNotaGeo2() {
        return notaGeo2;
    }

    public String getNotaGeo3() {
        return notaGeo3;
    }

    public String getNotaGeoFinal() {
        return notaGeoFinal;
    }

    public String getFaltaGeo1() {
        return faltaGeo1;
    }

    public String getFaltaGeo2() {
        return faltaGeo2;
    }

    public String getFaltaGeo3() {
        return faltaGeo3;
    }

    public String getFaltaGeoFinal() {
        return faltaGeoFinal;
    }

    public String getNotaHis1() {
        return notaHis1;
    }

    public String getNotaHis2() {
        return notaHis2;
    }

    public String getNotaHis3() {
        return notaHis3;
    }

    public String getNotaHisFinal() {
        return notaHisFinal;
    }

    public String getFaltaHis1() {
        return faltaHis1;
    }

    public String getFaltaHis2() {
        return faltaHis2;
    }

    public String getFaltaHis3() {
        return faltaHis3;
    }

    public String getFaltaHisFinal() {
        return faltaHisFinal;
    }

    public String getNotaIng1() {
        return notaIng1;
    }

    public String getNotaIng2() {
        return notaIng2;
    }

    public String getNotaIng3() {
        return notaIng3;
    }

    public String getNotaIngFinal() {
        return notaIngFinal;
    }

    public String getFaltaIng1() {
        return faltaIng1;
    }

    public String getFaltaIng2() {
        return faltaIng2;
    }

    public String getFaltaIng3() {
        return faltaIng3;
    }

    public String getFaltaIngFinal() {
        return faltaIngFinal;
    }

    public String getNotaMat1() {
        return notaMat1;
    }

    public String getNotaMat2() {
        return notaMat2;
    }

    public String getNotaMat3() {
        return notaMat3;
    }

    public String getNotaMatFinal() {
        return notaMatFinal;
    }

    public String getFaltaMat1() {
        return faltaMat1;
    }

    public String getFaltaMat2() {
        return faltaMat2;
    }

    public String getFaltaMat3() {
        return faltaMat3;
    }

    public String getFaltaMatFinal() {
        return faltaMatFinal;
    }

    public String getNotaPor1() {
        return notaPor1;
    }

    public String getNotaPor2() {
        return notaPor2;
    }

    public String getNotaPor3() {
        return notaPor3;
    }

    public String getNotaPorFinal() {
        return notaPorFinal;
    }

    public String getFaltaPor1() {
        return faltaPor1;
    }

    public String getFaltaPor2() {
        return faltaPor2;
    }

    public String getFaltaPor3() {
        return faltaPor3;
    }

    public String getFaltaPorFinal() {
        return faltaPorFinal;
    }

    public String getNotaRel1() {
        return notaRel1;
    }

    public String getNotaRel2() {
        return notaRel2;
    }

    public String getNotaRel3() {
        return notaRel3;
    }

    public String getNotaRelFinal() {
        return notaRelFinal;
    }

    public String getFaltaRel1() {
        return faltaRel1;
    }

    public String getFaltaRel2() {
        return faltaRel2;
    }

    public String getFaltaRel3() {
        return faltaRel3;
    }

    public String getFaltaRelFinal() {
        return faltaRelFinal;
    }

    public void setNotaArt1(String notaArt1) {
        this.notaArt1 = notaArt1;
    }

    public void setNotaArt2(String notaArt2) {
        this.notaArt2 = notaArt2;
    }

    public void setNotaArt3(String notaArt3) {
        this.notaArt3 = notaArt3;
    }

    public void setNotaArtFinal(String notaArtFinal) {
        this.notaArtFinal = notaArtFinal;
    }

    public void setFaltaArt1(String faltaArt1) {
        this.faltaArt1 = faltaArt1;
    }

    public void setFaltaArt2(String faltaArt2) {
        this.faltaArt2 = faltaArt2;
    }

    public void setFaltaArt3(String faltaArt3) {
        this.faltaArt3 = faltaArt3;
    }

    public void setFaltaArtFinal(String faltaArtFinal) {
        this.faltaArtFinal = faltaArtFinal;
    }

    public void setNotaCie1(String notaCie1) {
        this.notaCie1 = notaCie1;
    }

    public void setNotaCie2(String notaCie2) {
        this.notaCie2 = notaCie2;
    }

    public void setNotaCie3(String notaCie3) {
        this.notaCie3 = notaCie3;
    }

    public void setNotaCieFinal(String notaCieFinal) {
        this.notaCieFinal = notaCieFinal;
    }

    public void setFaltaCie1(String faltaCie1) {
        this.faltaCie1 = faltaCie1;
    }

    public void setFaltaCie2(String faltaCie2) {
        this.faltaCie2 = faltaCie2;
    }

    public void setFaltaCie3(String faltaCie3) {
        this.faltaCie3 = faltaCie3;
    }

    public void setFaltaCieFinal(String faltaCieFinal) {
        this.faltaCieFinal = faltaCieFinal;
    }

    public void setNotaEF1(String notaEF1) {
        this.notaEF1 = notaEF1;
    }

    public void setNotaEF2(String notaEF2) {
        this.notaEF2 = notaEF2;
    }

    public void setNotaEF3(String notaEF3) {
        this.notaEF3 = notaEF3;
    }

    public void setNotaEFFinal(String notaEFFinal) {
        this.notaEFFinal = notaEFFinal;
    }

    public void setFaltaEF1(String faltaEF1) {
        this.faltaEF1 = faltaEF1;
    }

    public void setFaltaEF2(String faltaEF2) {
        this.faltaEF2 = faltaEF2;
    }

    public void setFaltaEF3(String faltaEF3) {
        this.faltaEF3 = faltaEF3;
    }

    public void setFaltaEFFinal(String faltaEFFinal) {
        this.faltaEFFinal = faltaEFFinal;
    }

    public void setNotaGeo1(String notaGeo1) {
        this.notaGeo1 = notaGeo1;
    }

    public void setNotaGeo2(String notaGeo2) {
        this.notaGeo2 = notaGeo2;
    }

    public void setNotaGeo3(String notaGeo3) {
        this.notaGeo3 = notaGeo3;
    }

    public void setNotaGeoFinal(String notaGeoFinal) {
        this.notaGeoFinal = notaGeoFinal;
    }

    public void setFaltaGeo1(String faltaGeo1) {
        this.faltaGeo1 = faltaGeo1;
    }

    public void setFaltaGeo2(String faltaGeo2) {
        this.faltaGeo2 = faltaGeo2;
    }

    public void setFaltaGeo3(String faltaGeo3) {
        this.faltaGeo3 = faltaGeo3;
    }

    public void setFaltaGeoFinal(String faltaGeoFinal) {
        this.faltaGeoFinal = faltaGeoFinal;
    }

    public void setNotaHis1(String notaHis1) {
        this.notaHis1 = notaHis1;
    }


    public void setNotaHis2(String notaHis2) {
        this.notaHis2 = notaHis2;
    }

    public void setNotaHis3(String notaHis3) {
        this.notaHis3 = notaHis3;
    }

    public void setNotaHisFinal(String notaHisFinal) {
        this.notaHisFinal = notaHisFinal;
    }

    public void setFaltaHis1(String faltaHis1) {
        this.faltaHis1 = faltaHis1;
    }

    public void setFaltaHis2(String faltaHis2) {
        this.faltaHis2 = faltaHis2;
    }

    public void setFaltaHis3(String faltaHis3) {
        this.faltaHis3 = faltaHis3;
    }

    public void setFaltaHisFinal(String faltaHisFinal) {
        this.faltaHisFinal = faltaHisFinal;
    }

    public void setNotaIng1(String notaIng1) {
        this.notaIng1 = notaIng1;
    }

    public void setNotaIng2(String notaIng2) {
        this.notaIng2 = notaIng2;
    }

    public void setNotaIng3(String notaIng3) {
        this.notaIng3 = notaIng3;
    }

    public void setNotaIngFinal(String notaIngFinal) {
        this.notaIngFinal = notaIngFinal;
    }

    public void setFaltaIng1(String faltaIng1) {
        this.faltaIng1 = faltaIng1;
    }

    public void setFaltaIng2(String faltaIng2) {
        this.faltaIng2 = faltaIng2;
    }

    public void setFaltaIng3(String faltaIng3) {
        this.faltaIng3 = faltaIng3;
    }

    public void setFaltaIngFinal(String faltaIngFinal) {
        this.faltaIngFinal = faltaIngFinal;
    }

    public void setNotaMat1(String notaMat1) {
        this.notaMat1 = notaMat1;
    }

    public void setNotaMat2(String notaMat2) {
        this.notaMat2 = notaMat2;
    }

    public void setNotaMat3(String notaMat3) {
        this.notaMat3 = notaMat3;
    }

    public void setNotaMatFinal(String notaMatFinal) {
        this.notaMatFinal = notaMatFinal;
    }

    public void setFaltaMat1(String faltaMat1) {
        this.faltaMat1 = faltaMat1;
    }

    public void setFaltaMat2(String faltaMat2) {
        this.faltaMat2 = faltaMat2;
    }

    public void setFaltaMat3(String faltaMat3) {
        this.faltaMat3 = faltaMat3;
    }

    public void setFaltaMatFinal(String faltaMatFinal) {
        this.faltaMatFinal = faltaMatFinal;
    }

    public void setNotaPor1(String notaPor1) {
        this.notaPor1 = notaPor1;
    }

    public void setNotaPor2(String notaPor2) {
        this.notaPor2 = notaPor2;
    }

    public void setNotaPor3(String notaPor3) {
        this.notaPor3 = notaPor3;
    }

    public void setNotaPorFinal(String notaPorFinal) {
        this.notaPorFinal = notaPorFinal;
    }

    public void setFaltaPor1(String faltaPor1) {
        this.faltaPor1 = faltaPor1;
    }

    public void setFaltaPor2(String faltaPor2) {
        this.faltaPor2 = faltaPor2;
    }

    public void setFaltaPor3(String faltaPor3) {
        this.faltaPor3 = faltaPor3;
    }

    public void setFaltaPorFinal(String faltaPorFinal) {
        this.faltaPorFinal = faltaPorFinal;
    }

    public void setNotaRel1(String notaRel1) {
        this.notaRel1 = notaRel1;
    }

    public void setNotaRel2(String notaRel2) {
        this.notaRel2 = notaRel2;
    }

    public void setNotaRel3(String notaRel3) {
        this.notaRel3 = notaRel3;
    }

    public void setNotaRelFinal(String notaRelFinal) {
        this.notaRelFinal = notaRelFinal;
    }

    public void setFaltaRel1(String faltaRel1) {
        this.faltaRel1 = faltaRel1;
    }

    public void setFaltaRel2(String faltaRel2) {
        this.faltaRel2 = faltaRel2;
    }

    public void setFaltaRel3(String faltaRel3) {
        this.faltaRel3 = faltaRel3;
    }

    public void setFaltaRelFinal(String faltaRelFinal) {
        this.faltaRelFinal = faltaRelFinal;
    }
}
