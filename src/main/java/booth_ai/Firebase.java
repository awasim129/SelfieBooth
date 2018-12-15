package booth_ai;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Copyright (C) 2018 xterminate
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author xterminate
 */
public class Firebase {
    
    private static final String BASE_URL = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/";
    private static final String OPERATION_AUTH = "verifyPassword";
    private static final String OPERATION_REFRESH_TOKEN = "token";
    private static final String OPERATION_ACCOUNT_INFO = "getAccountInfo";
    
     private String firebaseKey;

    private static Firebase instance = null;

    protected Firebase() {
       firebaseKey = GLOBAL_VARS.FIREBASE_WEB_AUTH;
    }

    public static Firebase getInstance() {
      if(instance == null) {
         instance = new Firebase();
      }
      return instance;
    }
    
    public String auth(String username, String password) throws Exception { 

        HttpURLConnection urlRequest = null;
        String token = null;

        try {
            URL url = new URL(BASE_URL+OPERATION_AUTH+"?key="+firebaseKey);
            urlRequest = (HttpURLConnection) url.openConnection();
            urlRequest.setDoOutput(true);
            urlRequest.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStream os = urlRequest.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write("{\"email\":\""+username+"\",\"password\":\""+password+"\",\"returnSecureToken\":true}");
            osw.flush();
            osw.close();

            urlRequest.connect();

            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) urlRequest.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 

            token = rootobj.get("idToken").getAsString();

        } catch (Exception e) {
            return null;
        } finally {
            urlRequest.disconnect();
        }

        return token;
    }

    public String getAccountInfo(String token) throws Exception {

        HttpURLConnection urlRequest = null;
        String email = null;

        try {
            URL url = new URL(BASE_URL+OPERATION_ACCOUNT_INFO+"?key="+firebaseKey);
            urlRequest = (HttpURLConnection) url.openConnection();
            urlRequest.setDoOutput(true);
            urlRequest.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStream os = urlRequest.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write("{\"idToken\":\""+token+"\"}");
            osw.flush();
            osw.close();
            urlRequest.connect();

            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) urlRequest.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 

            email = rootobj.get("users").getAsJsonArray().get(0).getAsJsonObject().get("displayName").getAsString();

        } catch (Exception e) {
            return null;
        } finally {
            urlRequest.disconnect();
        }

        return email;

    }
    
    public FirebaseOptions connect() throws FileNotFoundException, IOException {
    FileInputStream serviceAccount =
  new FileInputStream(GLOBAL_VARS.FIREBASE_AUTH_FILE_PATH);

FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .setDatabaseUrl(GLOBAL_VARS.FIREBASE_URL)
  .build();

return options;


}
    
    
}