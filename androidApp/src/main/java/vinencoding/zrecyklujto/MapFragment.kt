package vinencoding.zrecyklujto

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class MapFragment : Fragment() {

    val mapyczHtml: String = "<!doctype html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<script src=\"https://api.mapy.cz/loader.js\"></script>\n" +
            "\t<script>Loader.load()</script>\n" +
            "</head>\n" +
            "\n" +
            "<body style=\"margin: 0; padding: 0\">\n" +
            "\t<div id=\"mapa\" style=\"width:100vw; height:100vh;\"></div>\n" +
            "\t<script type=\"text/javascript\">\n" +
            "\t\tvar stred = SMap.Coords.fromWGS84(14.41, 50.08);\n" +
            "\t\tvar mapa = new SMap(JAK.gel(\"mapa\"), stred, 10);\n" +
            "\t\tmapa.addDefaultLayer(SMap.DEF_BASE).enable();\n" +
            "\t\tmapa.addDefaultControls();\t      \t      \n" +
            "\t</script>\n" +
            "</body>\n" +
            "</html>"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webview: WebView = view.findViewById(R.id.webview)
        webview.settings.javaScriptEnabled = true
        webview.loadData(mapyczHtml, "text/html", "UTF-8") // todo search for containers with https://api.mapy.cz/view?page=geocoding
    }
}