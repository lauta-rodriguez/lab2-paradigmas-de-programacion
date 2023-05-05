package parser;

import subscription.Subscription;
import subscription.SingleSubscription;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Esta clase implementa el parser del  archivo de suscripcion (json)
 * Leer https://www.w3docs.com/snippets/java/how-to-parse-json-in-java.html
 * */

public class SubscriptionParser extends GeneralParser {

    public Subscription parse(String path) {
        Subscription subscription = new Subscription(path);

        try {
            FileReader reader = new FileReader(path);
            JSONArray jsonArray = new JSONArray(new JSONTokener(reader));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String url = obj.getString("url");
                String urlType = obj.getString("urlType");
                List<String> urlParams = new ArrayList<String>();

                JSONArray urlParamsJsonArray = obj.getJSONArray("urlParams");
                for (int j = 0; j < urlParamsJsonArray.length(); j++) {
                    String urlParam = urlParamsJsonArray.getString(j);
                    urlParams.add(urlParam);
                }
                
                SingleSubscription single = new SingleSubscription(url, urlParams, urlType);
                subscription.addSingleSubscription(single);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return subscription;
    }
}