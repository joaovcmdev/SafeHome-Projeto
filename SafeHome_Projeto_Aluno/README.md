# SafeHome — Projeto Semestral

O SafeHome simula uma plataforma de automação residencial/IoT com sensores, dispositivos, comandos, alertas e integrações com equipamentos de diferentes fabricantes.

O projeto inicial **compila e executa**, porém representa um legado propositalmente imperfeito. O aluno deverá analisar e evoluir o sistema progressivamente conforme os conteúdos apresentados em aula.

## Escopo inicial
- sensores de presença, temperatura e fumaça;
- lâmpadas, fechaduras e climatização;
- comandos remotos;
- alertas;
- automações;
- dispositivos de diferentes fabricantes;
- integrações externas.

## Execução
Requer Java 17.

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out br.edu.safehome.Main
```

As atividades estão em `atividades/README_SafeHome_AulaXX.md`.

> O aluno deve analisar comportamento, necessidade e consequências. Nomes de classes associados a padrões não comprovam que o padrão esteja corretamente aplicado.
