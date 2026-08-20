# Visão parcial do legado

```mermaid
classDiagram
 class SafeHomeService
 class Device
 class SensorReading
 class AutomationRule
 class AcmeHomeLegacyApi
 class ZenIoTLegacyApi
 class SensorHubLegacyApi
 SafeHomeService --> Device
 SafeHomeService --> SensorReading
 SafeHomeService --> AutomationRule
 SafeHomeService --> AcmeHomeLegacyApi
 SafeHomeService --> ZenIoTLegacyApi
 SafeHomeService --> SensorHubLegacyApi
```
