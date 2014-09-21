package com.chan.weava.forechanapp.networkRetrieve;

import com.chan.weava.forechanapp.data.Board;
import com.chan.weava.forechanapp.utils.JsonParseStrings;
import com.chan.weava.forechanapp.utils.RequestURLStrings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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
    private ArrayList<Board> boards = new ArrayList<>();

    @Override
    public void parseJsonObjectToArray() throws ExecutionException, InterruptedException, JSONException
    {
        JSONArray jsonArray = null;
        JsonRequest request = new JsonRequest(RequestURLStrings.BOARDS_REQUEST_URL);
        request.execute();
        jsonArray = request.get().getJSONArray(JsonParseStrings.JSON_ARRAY_PARSE_BOARDS);

        this.parseJsonArray(jsonArray);

        for(int i = 0; i < jsonArray.length(); i++)
        {
            System.out.println("ARRAY index-" + i + " : " + jsonArray.get(i));
        }
    }

    @Override
    public void parseJsonArray(JSONArray jsonArray) throws JSONException
    {
        String linkTitle;
        String fullTitle;

        for(int i = 0; i < jsonArray.length(); i++)
        {
            Board newBoard = new Board();
            JSONObject childJsonObject = jsonArray.getJSONObject(i);
            linkTitle = childJsonObject.getString(JsonParseStrings.PARSE_FROM_ARRAY_LINK);
            newBoard.setLinkTitle(linkTitle);
            fullTitle = childJsonObject.getString(JsonParseStrings.PARSE_FROM_ARRAY_TITLE);
            newBoard.setFullTitle(fullTitle);
            boards.add(newBoard);
        }
    }

    public ArrayList<Board> getBoards()
    {
        return this.boards;
    }
}
