package br.edu.safehome.patterns.strategy;
import br.edu.safehome.model.SensorReading;
public interface AutomationStrategy {
    String decide(SensorReading reading);
}
