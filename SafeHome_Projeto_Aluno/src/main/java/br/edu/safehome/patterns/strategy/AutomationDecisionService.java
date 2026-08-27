package br.edu.safehome.patterns.strategy;
import br.edu.safehome.model.SensorReading;
public class AutomationDecisionService {
    private AutomationStrategy strategy;
    public void setStrategy(AutomationStrategy strategy){this.strategy=strategy;}

    public String decide(SensorReading reading){
        if("SMOKE".equals(reading.type) && reading.value > 0) return "UNLOCK_ALL";
        if("TEMPERATURE".equals(reading.type) && reading.value > 30) return "TURN_ON_AC";
        return strategy==null ? "NO_ACTION" : strategy.decide(reading);
    }
}
