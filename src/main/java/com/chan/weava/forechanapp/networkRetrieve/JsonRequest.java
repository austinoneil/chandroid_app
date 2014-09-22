package com.chan.weava.forechanapp.networkRetrieve;

import android.os.AsyncTask;

import com.chan.weava.forechanapp.utils.DebugUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * JSON Request
 *
 * JSON Request will start a new Async Task that requests and retrieves JSON Data from a
 * passed URL.
 *
 * This class was made to abstract the creating of a JSON request thread so that it is as simple
 * as extending JsonRequest and calling execute.
 *
 * @see AsyncTask
 *
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ForeChanApp v0.1A
 * @since 9/16/14
 */
public class JsonRequest extends AsyncTask<Void, Void, JSONObject>
{
    public boolean isDone = false;
    private String url;

    public JsonRequest(String url) { this.url = url; }

    private JSONObject readJsonFromURL(String url) throws IOException, JSONException
    {
        InputStream inputStream = new URL(url).openStream();
        try
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject jsonObject = new JSONObject(jsonText);
            return jsonObject;
        } finally {
            inputStream.close();
        }
    }

    private String readAll(BufferedReader reader) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while((line = reader.readLine()) != null)
        {
            stringBuilder.append(line);
            if(DebugUtils.inDebug)
            {
                System.out.println("Reading in JSON lines");
            }
        }
        if(DebugUtils.inDebug)
        {
            System.out.println("I have finished doing this stuff");
        }
        return stringBuilder.toString();
    }

    @Override
    protected JSONObject doInBackground(Void... params)
    {
        if(DebugUtils.inDebug)
        {
            System.out.println("URL: " + this.url);
        }
        JSONObject jsonObject = null;
        try
        {
            jsonObject = readJsonFromURL(url);
        } catch(IOException e) {
            e.printStackTrace();
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject result)
    {
        if(DebugUtils.inDebug)
        {
            System.out.println(result.toString());
        }
        isDone = true;
    }
}
