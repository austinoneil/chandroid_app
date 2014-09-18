package com.chan.weava.forechanapp.networkRetrieve;

import com.chan.weava.forechanapp.utils.RequestURLStrings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * BoardCreator
 *
 * Board Creator retrieves a JSON object and parses that data to be stored as Board objects.
 *
 * This class will parse a JSON object created specifically for Board objects.
 *
 * This class implements JsonParseInterface.
 *
 * >TBA
 *
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ForeChanApp v0.1A
 * @since 9/16/14
 */
public class BoardCreator implements JsonParseInterface
{
    @Override
    public void parseJsonObjectToArray() throws ExecutionException, InterruptedException, JSONException
    {
        JSONArray jsonArray = null;
        JsonRequest request = new JsonRequest(RequestURLStrings.BOARDS_REQUEST_URL);
        request.execute();
        jsonArray = request.get().getJSONArray("boards");

        for(int i = 0; i < jsonArray.length(); i++)
        {
            System.out.println("ARRAY index-" + i + " : " + jsonArray.get(i));
        }
    }

    @Override
    public void setAssociatedObjectData()
    {

    }
}
