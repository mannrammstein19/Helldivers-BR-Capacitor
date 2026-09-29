# HELLDIVERS-BR Capacitor V1.1

Correção do workflow do GitHub Actions.

## Problema corrigido
O `android-actions/setup-android@v3` passou a tentar instalar o pacote legado `tools` via `sdkmanager`.
Esse pacote não é mais disponibilizado no repositório atual do Android SDK e a Action encerrava com código 1 antes da compilação.

## Alteração
- removido `android-actions/setup-android@v3`;
- reutilizado o Android SDK já presente no runner `ubuntu-latest`;
- localização robusta do `sdkmanager`;
- aceitação automática das licenças;
- instalação explícita de:
  - `platform-tools`
  - `platforms;android-36`
  - `build-tools;36.0.0`
- restante do fluxo Capacitor mantido.

Nenhuma alteração visual ou funcional no aplicativo.
