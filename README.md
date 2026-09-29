# HELLDIVERS-BR Capacitor V1

Primeira prova de conceito do HELLDIVERS-BR usando Capacitor 8.

## Objetivo desta V1

Esta versão carrega diretamente o site móvel oficial:

`https://helldivers-br.pages.dev`

Isso significa que a Home, Central de Guerra, Ordem Maior, Mapa, Arsenal, menu inferior, menu lateral, tema Meridia, imagens, CSS e JavaScript são os mesmos que o usuário vê no Chrome, mas dentro do WebView do APK.

> Esta V1 é propositalmente um teste de **paridade visual imediata**. Ela depende de internet para a interface principal. A próxima fase recomendada é empacotar o HTML/CSS/JS dentro do APK e manter apenas APIs/mídia dinâmica externas.

## Importante: instala lado a lado

O `appId` desta prova é:

`br.com.helldiversbr.capacitor`

Ele é diferente do app Kotlin/Compose atual (`br.com.helldiversbr.app`), então você pode instalar os dois no mesmo celular e comparar lado a lado sem substituir a V6.

## Build pelo GitHub Actions

1. Crie um repositório novo, por exemplo `Helldivers-BR-Capacitor`.
2. Envie todos os arquivos deste ZIP para a raiz do repositório.
3. Abra **Actions**.
4. Selecione **Build APK Capacitor**.
5. Clique em **Run workflow**.
6. Quando ficar verde, baixe o artifact `HELLDIVERS-BR-Capacitor-V1`.
7. Extraia o ZIP do artifact e instale `app-debug.apk`.

## Base técnica

- Capacitor 8.5.2
- Node 22+
- Android SDK 36
- Java 21
- GitHub Actions

## Próxima fase

Depois de testar esta V1 no aparelho real:

- decidir se o comportamento do WebView ficou visualmente igual ao Chrome;
- corrigir links externos/back button/downloads se necessário;
- preparar V2 **bundled/offline-first**, copiando a versão real do repositório do site para `www/`;
- manter APIs de guerra ao vivo;
- integrar recursos nativos como notificações, compartilhamento e haptics.

## V1.2
A V1.2 aplica o ícone HELLDIVERS-BR e trata as áreas seguras do Android para evitar sobreposição com status/navigation bars em Android 15/16.
