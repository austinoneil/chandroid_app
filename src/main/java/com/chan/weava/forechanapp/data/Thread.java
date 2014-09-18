package com.chan.weava.forechanapp.data;

/**
 * Thread
 *
 * A data class that contains information relating to 4chan "Thread" posts.
 *
 * This class is meant to contain data for all of the threads received
 * from the 4chan API.
 *
 * This class extends the abstract method Post
 *
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ForeChanApp v0.1A
 * @since 9/10/14
 */
public class Thread extends Post
{
    private boolean mIsSticky;
    private int mNumReplies;
    private int mNumImages;

    public Thread() {}

    public boolean getIsSticky() { return this.mIsSticky; }

    public void setIsSticky(boolean isSticky) { this.mIsSticky = isSticky; }

    public int getNumReplies() { return this.mNumReplies; }

    public void setNumReplies(int numReplies) { this.mNumReplies = numReplies; }

    public int getNumImages() { return this.mNumImages; }

    public void setNumImages(int numImages) { this.mNumImages = numImages; }
}
