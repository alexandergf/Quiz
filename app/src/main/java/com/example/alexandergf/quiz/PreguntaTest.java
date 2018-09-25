package com.example.alexandergf.quiz;

public class PreguntaTest {
    //Camps (fields) o atributs
    private String text;
    private  String[] respostes;
    private  int correcte;

    //metode constructor
    public PreguntaTest(String text, String[] respostes, int correcte) {
        this.text = text;
        this.respostes = respostes;
        this.correcte = correcte;
    }

    //getter y setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getRespostes() {
        return respostes;
    }

    public void setRespostes(String[] respostes) {
        this.respostes = respostes;
    }

    public int getCorrecte() {
        return correcte;
    }

    public void setCorrecte(int correcte) {
        this.correcte = correcte;
    }
}
