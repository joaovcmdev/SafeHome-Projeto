# ADR — Separação de Responsabilidades da SafeHomeService

## Contexto

A classe `SafeHomeService` concentrava diversas responsabilidades do sistema, como leitura de sensores, controle de dispositivos, execução de automações e funções de segurança. Essa concentração tornava o código mais difícil de compreender, testar e manter.

## Decisão

Decidimos separar as responsabilidades da `SafeHomeService` em módulos específicos dentro de `service/modules`.

Foram criadas as seguintes classes:

* `sensor_service` — responsável pela leitura dos sensores.
* `Device_service` — responsável pela execução de comandos dos dispositivos.
* `Automation_service` — responsável pela avaliação das automações e regras.
* `Security_service` — responsável pelas funções de segurança e emergência.

A `SafeHomeService` permanece como serviço principal, utilizando os módulos para executar cada responsabilidade.

## Vantagens

* Facilita a manutenção do código.
* Cada módulo possui uma responsabilidade específica.
* Reduz a concentração de funcionalidades na `SafeHomeService`.
* Facilita a localização e alteração de funcionalidades.
* Torna o código mais organizado e compreensível.
* Facilita a realização de testes individuais.

## Desvantagens

* Aumenta a quantidade de classes no projeto.
* Cria a necessidade de comunicação entre a `SafeHomeService` e os novos módulos.
* Pode aumentar a complexidade inicial para compreender a estrutura do sistema.
