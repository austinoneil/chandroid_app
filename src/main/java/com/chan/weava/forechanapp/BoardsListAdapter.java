package com.chan.weava.forechanapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
 * @since 9/20/14
 */
public class BoardsListAdapter extends ArrayAdapter<Board>
{
    private final Context context;
    private final int resourceID;
    private ArrayList<Board> list;

    public BoardsListAdapter(Context context, int resource, ArrayList<Board> list) {
        super(context, resource, list);

        this.context = context;
        this.resourceID = resource;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resourceID, parent, false);

        TextView boardTitle = (TextView) rowView.findViewById(R.id.board_title);
        TextView boardLink = (TextView) rowView.findViewById(R.id.board_link);

        boardTitle.setText(list.get(position).getFullTitle());
        boardLink.setText("/" + list.get(position).getLinkTitle() + "/");

        return rowView;

    }

}
