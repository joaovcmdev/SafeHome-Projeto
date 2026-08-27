package br.edu.safehome.patterns.observer;
public class HomePublisher {
    private HomeObserver observer;
    public void subscribe(HomeObserver observer){this.observer=observer;}
    public void publish(String ref,String event){if(observer!=null)observer.update(ref,event);}
}
