package com.chan.weava.forechanapp.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Post
 *
 * Abstract class to apply to multiple different post data classes.
 *
 * This class will apply common functionality for multiple different posts
 * provided by the 4chan API.
 *
 * Derivatives: Thread, Reply
 *
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ForeChanApp v0.1a
 * @since 9/10/14
 */
public abstract class Post
{
    private String mComment;
    private String mSubject;
    private int mPostNumber;
    private Date mDatePosted;

    // Information on the poster
    private Poster mPoster;

    // Image or WebM related to post
    private PostFile mPostFile;

    // Replies to the post
    private ArrayList<Integer> mReplies;

    public Post() {}

    public String getComment() { return this.mComment; }

    public void setComment(String comment) { this.mComment = comment; }

    public String getSubject() { return this.mSubject; }

    public void setSubject(String subject) { this.mSubject = subject; }

    public int getPostNumber() { return this.mPostNumber; }

    public void setPostNumber(int postNumber) { this.mPostNumber = postNumber; }

    public Date getDatePosted() { return this.mDatePosted; }

    public void setDatePosted(Date datePosted) { this.mDatePosted = datePosted; }

    public Poster getPoster() { return this.mPoster; }

    public void setPoster(Poster poster) { this.mPoster = poster; }

    public PostFile getPostFile() { return this.mPostFile; }

    public void setPostFile(PostFile postFile) { this.mPostFile = postFile; }

    public ArrayList<Integer> getReplies() { return this.mReplies; }

    public void setReplies(ArrayList<Integer> replies) { this.mReplies = replies; }
}
