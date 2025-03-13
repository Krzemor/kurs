package com.kodilla.testing.forum;

public class ForumComment {

    private ForumPost forumPost;
    private String author;
    private String commentBody;

    public ForumComment(ForumPost forumPost, String author, String commentBody) {
        this.forumPost = forumPost;
        this.author = author;
        this.commentBody = commentBody;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getAuthor() {
        return author;
    }

    public String getCommentBody() {
        return commentBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumComment)) return false;

        ForumComment that = (ForumComment) o;

        if (!forumPost.equals(that.forumPost)) return false;
        if (!commentBody.equals(that.commentBody)) return false;
        return author.equals(that.author);
    }

    @Override
    public int hashCode() {
        int result = forumPost.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + commentBody.hashCode();
        return result;
    }
}
