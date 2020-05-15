package com.pluralsight.conferencedemoboot.services;

import java.util.List;

import com.pluralsight.conferencedemoboot.models.Session;
import com.pluralsight.conferencedemoboot.models.Speaker;
import org.springframework.stereotype.Component;


@Component
public interface BookService {
    public void saveBook(Session book);
    public void saveBookTransactional(Session book);



}
