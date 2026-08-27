package br.edu.safehome.patterns.observer;
public class ResidentObserver implements HomeObserver {
    public void update(String ref,String event){System.out.println("RESIDENT "+ref+" "+event);}
}
