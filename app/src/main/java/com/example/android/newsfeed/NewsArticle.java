package com.example.android.newsfeed;

class NewsArticle {

    //Title of the article
    private final String mWebTitle;

    //Website url for the article
    private final String mWebUrl;

    //Section name of the article
    private final String mSectionName;

    //Author of the article
    private final String mAuthor;

    //The date when the article was published
    private final String mPublicationDate;

    //Create a new NewsArticle object
    public NewsArticle(String webTitle, String webUrl, String sectionName, String author, String publicationDate) {
        mWebTitle = webTitle;
        mWebUrl = webUrl;
        mSectionName = sectionName;
        mAuthor = author;
        mPublicationDate = publicationDate;
    }

    public String getWebTitle() {
        return mWebTitle;
    }

    public String getWebUrl() {
        return mWebUrl;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }
}
