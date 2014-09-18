package com.chan.weava.forechanapp.data;

import java.util.ArrayList;

/**
 * Board
 *
 * A data class that contains information related to 4chan "Boards".
 *
 * This class is meant to retain data for all of the boards received
 * from the 4chan API.
 *
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ForeChanApp v0.1A
 * @since 9/10/14
 */
public class Board
{
    private String mLinkTitle;
    private String mFullTitle;
    private String mDescription;
    private boolean mIsFavorite;
    private boolean mIsWorkSafe;

    public Board() {}

    public String getLinkTitle() { return this.mLinkTitle; }

    public void setLinkTitle(String linkTitle) { this.mLinkTitle = linkTitle; }

    public String getFullTitle() { return this.mFullTitle; }

    public void setFullTitle(String fullTitle) { this.mFullTitle = fullTitle; }

    public String getDescription() { return this.mDescription; }

    public void setDescription(String description) { this.mDescription = description; }

    public boolean getIsFavorite() { return this.mIsFavorite; }

    public void setIsFavorite(boolean isFavorite) { this.mIsFavorite = isFavorite; }

    public boolean getIsWorkSafe() { return this.mIsWorkSafe; }

    public void setIsWorkSafe(boolean isWorkSafe) { this.mIsWorkSafe = isWorkSafe; }
}
