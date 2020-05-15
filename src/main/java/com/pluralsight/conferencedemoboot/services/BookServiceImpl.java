package com.pluralsight.conferencedemoboot.services;

import com.pluralsight.conferencedemoboot.models.Session;
import com.pluralsight.conferencedemoboot.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private SessionRepository bookRepository;



    public void saveBook(Session book) {
            Session book1 = null;
            // save book
            book1 = bookRepository.saveAndFlush(book);

    }

    @Transactional(noRollbackFor = NullPointerException.class)
        public void saveBookTransactional(Session book) {
        Session book1 = null;
        // save book
        book1 = bookRepository.save(book);
        String s1 = null;
        System.out.println(s1.hashCode());
    }


}