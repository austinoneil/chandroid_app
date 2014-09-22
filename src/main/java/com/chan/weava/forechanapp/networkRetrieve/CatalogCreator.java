package com.chan.weava.forechanapp.networkRetrieve;

import com.chan.weava.forechanapp.data.ChanThread;
import com.chan.weava.forechanapp.utils.DebugUtils;
import com.chan.weava.forechanapp.utils.JsonParseStrings;
import com.chan.weava.forechanapp.utils.RequestURLStrings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * [Insert Class Name]
 * <p/>
 * [Insert Class Description]
 * <p/>
 * [Insert Class Details]
 * <p/>
 * <Insert Class Derivatives/Dependencies>
 * <p/>
 * <Insert Class's Associated Design Patterns>
 *
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ForeChanApp v[Insert Version Number]
 * @since 9/22/14
 */
public class CatalogCreator implements JsonParseInterface
{
    private String mBoardName;
    private int mPageNumber;
    private ArrayList<ChanThread> threads;

    public CatalogCreator(String boardName, int pageNumber)
    {
        this.mBoardName = boardName;
        this.mPageNumber = pageNumber;
    }

    @Override
    public void parseJsonObjectToArray() throws JSONException, InterruptedException, ExecutionException
    {
        JSONArray jsonArray;
        JsonRequest request =
                new JsonRequest(RequestURLStrings.THREADS_REQUEST_URL_BEGIN + mBoardName + "/" + mPageNumber + ".json");
        request.execute();
        jsonArray = request.get().getJSONArray(JsonParseStrings.JSON_ARRAY_PARSE_THREADS);
        JSONArray postArr = new JSONArray();

        for(int i = 0; i < jsonArray.length(); i++)
        {
            postArr = jsonArray.getJSONObject(i).getJSONArray(JsonParseStrings.JSON_ARRAY_PARSE_POSTS);
            if(DebugUtils.inDebug)
            {
                for (int j = 0; j < postArr.length(); j++)
                {
                    System.out.println("POSTS ARR: " + postArr.get(j));
                }
            }
        }

        this.parseJsonArray(postArr);


        if(DebugUtils.inDebug)
        {
            for (int i = 0; i < jsonArray.length(); i++)
            {
                System.out.println("ARRAY index-" + i + " : " + jsonArray.get(i));
            }
        }
    }

    @Override
    public void parseJsonArray(JSONArray jsonArray) throws JSONException
    {
        String comment;
        String name;
        String subject;
        String tripcode;
        int postNumber;
        int omittedReplies;
        int omittedImages;
        int numReplies;
        int numImages;

        int resto;


        for(int i = 0; i < jsonArray.length(); i++)
        {
            ChanThread newThread = new ChanThread();
            JSONObject childJsonObject = jsonArray.getJSONObject(i);
            resto = childJsonObject.getInt(JsonParseStrings.PARSE_FROM_ARRAY_RESTO);

            //This means that this is the OP
            if(resto == 0)
            {
                comment = childJsonObject.getString(JsonParseStrings.PARSE_FROM_ARRAY_COMMENT);
                newThread.setComment(comment);
                name = childJsonObject.getString(JsonParseStrings.PARSE_FROM_ARRAY_NAME);
                newThread.setPosterName(name);
                subject = childJsonObject.getString(JsonParseStrings.PARSE_FROM_ARRAY_SUBJECT);
                newThread.setSubject(subject);
                tripcode = childJsonObject.getString(JsonParseStrings.PARSE_FROM_ARRAY_TRIPCODE);
                newThread.setPosterTripcode(tripcode);
                omittedReplies = childJsonObject.getInt(JsonParseStrings.PARSE_FROM_ARRAY_OMITTED_POSTS);
                newThread.setOmittedReplies(omittedReplies);
                omittedImages = childJsonObject.getInt(JsonParseStrings.PARSE_FROM_ARRAY_OMITTED_IMAGES);
                newThread.setOmittedImages(omittedImages);
                numReplies = childJsonObject.getInt(JsonParseStrings.PARSE_FROM_ARRAY_REPLIES);
                newThread.setNumReplies(numReplies);
                numImages = childJsonObject.getInt(JsonParseStrings.PARSE_FROM_ARRAY_IMAGES);
                newThread.setNumImages(numImages);
                postNumber = childJsonObject.getInt(JsonParseStrings.PARSE_FROM_ARRAY_POST_NUMBER);
                newThread.setPostNumber(postNumber);

                threads.add(newThread);
            }
        }
    }

    public ArrayList<ChanThread> getThreads()
    {
        return this.threads;
    }
}