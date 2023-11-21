package com.bookapp.service;

import com.bookapp.JSON.BookJSON;
import com.bookapp.JSON.Item;
import com.bookapp.JSON.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleAPI {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${api_key}")
    private String apiKey;

    public Root get5BooksByTitle(String title) {

        String baseUrl = "https://www.googleapis.com/books/v1/volumes?q=intitle:";
        String endUrl = "&maxResults=5&key=";

        String searchUrl = baseUrl + title + endUrl + apiKey;

        Root results = restTemplate.getForObject(searchUrl, Root.class);

        return results;
    };

    public List<BookJSON> googleSearchResultsByTitle(Root root) {

        List<Item> items = root.getItems();
        List<BookJSON> books = new ArrayList<>();

        for (Item book : items) {

            String ISBN = "";
            String author = "";
            String coverUrl = "";
            int pageCount = 0;

            String title = book.getVolumeInfo().getTitle();

            try {
                pageCount = book.getVolumeInfo().getPageCount();
            }catch(Exception e){
                pageCount = 0;
            }
            try {
                author = book.getVolumeInfo().getAuthors().get(0);
            }catch(Exception e){
                author = "Author Unavailable";
            }
            try {
                coverUrl = book.getVolumeInfo().getImageLinks().getThumbnail();
            }catch(Exception e){
                coverUrl = "";
            }
            try {
                if (book.getVolumeInfo().getIndustryIdentifiers().get(0) != null) {
                    ISBN = book.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier();
                }
            }catch(Exception e) {
                ISBN = "";
            }

            BookJSON book1 = new BookJSON(title, author, ISBN, coverUrl, pageCount);

            books.add(book1);
        }
        return books;
    };

    public Root getByIsbn(String searchText) {

        String baseUrl = "https://www.googleapis.com/books/v1/volumes?q=isbn:";
        String endUrl = "&key=";
        String searchUrl = baseUrl + searchText + endUrl + apiKey;

        return restTemplate.getForObject(searchUrl, Root.class);

    };

    public BookJSON googleSearchResultsByISBN(Root root, String searchText) {

        String ISBN = "";
        String author = "";
        String coverUrl = "";
        int pageCount = 0;

        String title = root.getItems().get(0).getVolumeInfo().getTitle();
        try {
            author = root.getItems().get(0).getVolumeInfo().getAuthors().get(0);
        }catch(Exception e){
            author = "Author Unavailable";
        }
        try {
            coverUrl = root.getItems().get(0).getVolumeInfo().getImageLinks().getThumbnail();
        }catch(Exception e){
            coverUrl = "";
        }
        try {
            ISBN = searchText;
        }catch(Exception e) {
            ISBN = "";
        }

        BookJSON book = new BookJSON(title, author, ISBN, coverUrl, pageCount);
        return book;

    }



}


