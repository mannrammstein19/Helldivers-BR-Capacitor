package br.com.helldiversbr.capacitor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

        WindowInsetsControllerCompat controller =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (controller != null) {
            controller.setAppearanceLightStatusBars(false);
            controller.setAppearanceLightNavigationBars(false);
        }

        WebView webView = getBridge().getWebView();
        if (webView == null) return;

        View parent = (View) webView.getParent();
        if (parent != null) parent.setBackgroundColor(Color.BLACK);

        /*
         * Android 15/16 força edge-to-edge. O site mobile foi desenhado para
         * o viewport útil do navegador, então reduzimos fisicamente o WebView
         * para a área segura. Assim:
         *  - "MENU DE NAVEGAÇÃO" não entra por baixo de hora/Wi-Fi/bateria;
         *  - a navegação inferior não fica atrás da barra do sistema;
         *  - o drawer lateral passa a terminar exatamente acima da barra
         *    inferior do próprio HELLDIVERS-BR.
         */
        ViewCompat.setOnApplyWindowInsetsListener(webView, (view, windowInsets) -> {
            Insets safe = windowInsets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                            | WindowInsetsCompat.Type.displayCutout()
            );

            ViewGroup.LayoutParams raw = view.getLayoutParams();
            if (raw instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) raw;
                if (lp.leftMargin != safe.left
                        || lp.topMargin != safe.top
                        || lp.rightMargin != safe.right
                        || lp.bottomMargin != safe.bottom) {
                    lp.leftMargin = safe.left;
                    lp.topMargin = safe.top;
                    lp.rightMargin = safe.right;
                    lp.bottomMargin = safe.bottom;
                    view.setLayoutParams(lp);
                }
            } else {
                // Fallback seguro caso o template mude o tipo de LayoutParams.
                view.setPadding(safe.left, safe.top, safe.right, safe.bottom);
            }

            return windowInsets;
        });

        ViewCompat.requestApplyInsets(webView);
    }
}
