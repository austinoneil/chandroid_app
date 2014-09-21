package com.chan.weava.forechanapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;

import com.chan.weava.forechanapp.data.Board;
import com.chan.weava.forechanapp.networkRetrieve.BoardCreator;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class Main extends Activity
{
    ArrayList<Board> boards;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        boards = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new JsonRequest().execute("https://a.4cdn.org/boards.json");

        try
        {
            BoardCreator createBoards = new BoardCreator();
            createBoards.parseJsonObjectToArray();
            boards = createBoards.getBoards();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        StringBuilder buildString = new StringBuilder();
        for(int i = 0; i < boards.size(); i++)
        {
            buildString.append("title" + boards.get(i).getFullTitle() + "\n");
            buildString.append("link" + boards.get(i).getLinkTitle() + "\n");
        }

        Parcelable[] toPass = new Parcelable[boards.size()];
        for(int i = 0; i < boards.size(); i++)
        {
            toPass[i] = boards.get(i);
        }

        Bundle bundle = new Bundle();
        bundle.putParcelableArray("boards", toPass);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BoardsFragment boardsFragment = new BoardsFragment();
        boardsFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.board_list_frag, boardsFragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
