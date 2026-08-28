# Diagrama de Componentes - Device Service

## 1. Componente analisado

O componente escolhido foi o `Device_service`, responsável pelo controle e execução de comandos nos dispositivos do sistema SafeHome.

---

## 2. Diagrama de Componentes

```mermaid
flowchart TD

    DeviceService[Device_service]

    Repository[InMemoryRepository]
    AcmeAPI[AcmeHomeLegacyApi]
    ZenAPI[ZenIoTLegacyApi]
    Publisher[HomePublisher]

    DeviceService -- LOCALLIZAR DISPOSITIVO --> Repository
    DeviceService -- ENVIAR COMANDO --> AcmeAPI
    DeviceService -- ENVIAR COMANDO --> ZenAPI
    DeviceService -- PUBLICAR AÇÃO --> Publisher
```

---

