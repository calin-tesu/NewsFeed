package com.example.android.newsfeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class NewsArticleAdapter extends ArrayAdapter<NewsArticle> {

    private static final String TIME_SEPARATOR = "T";
    //Name of the author of the news article
    private String author;

    /**
     * Constructor
     *
     * @param context      The current context.
     * @param newsArticles is the list of news articles, which is the data source of the adapter
     */
    public NewsArticleAdapter(@NonNull Context context, @NonNull ArrayList<NewsArticle> newsArticles) {
        super(context, 0, newsArticles);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list, parent, false);
        }

        //Get the data item for this position
        NewsArticle currentArticle = getItem(position);

        //Find the TextView with the ID section_name
        TextView sectionView = listItemView.findViewById(R.id.section_name);
        sectionView.setText(currentArticle.getSectionName());

        //Find the TextView with the ID title, and set the title of the news article
        TextView titleView = listItemView.findViewById(R.id.title);
        titleView.setText(currentArticle.getWebTitle());

        TextView authorView = listItemView.findViewById(R.id.author);
        //Format the TextView for author name by adding the "by " before the his/her name
        if (currentArticle.getAuthor() != null) {
            author = getContext().getString(R.string.by_author) + currentArticle.getAuthor();
        }
        authorView.setText(author);

        TextView publicationDateView = listItemView.findViewById(R.id.publication_date);

        String[] parts = currentArticle.getPublicationDate().split(TIME_SEPARATOR);
        publicationDateView.setText(parts[0]);

        return listItemView;
    }
}
