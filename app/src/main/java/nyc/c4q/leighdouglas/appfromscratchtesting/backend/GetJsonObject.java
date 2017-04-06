package nyc.c4q.leighdouglas.appfromscratchtesting.backend;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by leighdouglas on 4/5/17.
 */

public class GetJsonObject extends AsyncTask<Void, Void, Void> {
    private Listener listener;
    private String url;
    private ArrayList<ContactInfo> list = new ArrayList<>();


    public GetJsonObject(String url, Listener listener) {
        this.url = url;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... params) {
        HttpRequest httpRequest = new HttpRequest();
        String jsonString = httpRequest.requestJSONString(url);

        if (jsonString != null){
            try {

                JSONObject js = new JSONObject(jsonString);

                JSONArray contacts = js.getJSONArray("contacts");

                for (int i = 0; i < contacts.length(); i++){
                    JSONObject c = contacts.getJSONObject(i);
                    JSONObject phone = c.getJSONObject("phone");
                    Phone mPhone = new Phone(phone.getString("mobile"), phone.getString("home"), phone.getString("office"));
                    list.add(new ContactInfo(c.getString("id"), c.getString("name"), c.getString("email"), mPhone));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.d("JSON", "Couldn't download from server");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.updateList(list);

    }
}

//http://api.androidhive.info/contacts/