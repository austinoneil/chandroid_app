package com.chan.weava.forechanapp;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chan.weava.forechanapp.data.Board;

import java.util.ArrayList;

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
 * @since 9/19/14
 */
public class BoardsFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.boards_fragment, container, false);
        Parcelable[] boards = this.getArguments().getParcelableArray("boards");
        ArrayList<Board> boardList = new ArrayList<>();
        for(int i = 0; i < boards.length; i++)
        {
            boardList.add((Board) boards[i]);
        }

        ListView boardsList = (ListView) view.findViewById(R.id.board_list);
        boardsList.setAdapter(new BoardsListAdapter(this.getActivity(), R.layout.boards_row, boardList));
        return view;
    }
}
