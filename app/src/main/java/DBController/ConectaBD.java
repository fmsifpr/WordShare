package DBController;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConectaBD {

    private static String URL_GLOBAL_DB = "http://10.21.40.27/web_service/";

    public int insertUsuarios(Context context, String nome, String email, String senha) throws IOException {
        if (!checkNetworkConnection(context)) {
            return 0;
        }
        checkThreadPolicy();
        String values = "nome="+nome+"&"+"senha="+senha+"&"+"email="+email;
        URL url = new URL(URL_GLOBAL_DB + "webService/cadastro.php?"+values);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = bufferedReader.readLine();
        if (response.equals("false")) {
            Toast.makeText(context, "Erro no BD Global!", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }
    }
    private boolean checkNetworkConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    private void checkThreadPolicy(){
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}