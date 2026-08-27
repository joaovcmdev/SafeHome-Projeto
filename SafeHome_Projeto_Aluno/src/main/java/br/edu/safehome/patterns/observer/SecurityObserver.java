package br.edu.safehome.patterns.observer;
public class SecurityObserver implements HomeObserver {
    public void update(String ref,String event){System.out.println("SECURITY "+ref+" "+event);}
}
