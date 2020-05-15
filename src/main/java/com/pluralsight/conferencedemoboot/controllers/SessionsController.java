package com.pluralsight.conferencedemoboot.controllers;

import com.fasterxml.uuid.Generators;
import com.pluralsight.conferencedemoboot.models.Session;
import com.pluralsight.conferencedemoboot.repositories.SessionRepository;
import com.pluralsight.conferencedemoboot.services.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sessions")
@Transactional
public class SessionsController {

    public static Connection con;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Session> list()
    {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Session> get(@PathVariable Long id)
    {
        Optional<Session> session=sessionRepository.findById(id);
        return session;

      //  return sessionRepository.getOne(id);
    }


    @GetMapping
    @RequestMapping("sessionName/{sessionName}")
    public Optional<Session> getBySessionName(@PathVariable String sessionName)
    {

//        Optional<Session> session= Optional.ofNullable(sessionRepository.findBySession_id_Session_name(name));

        Optional<Session> session= Optional.ofNullable(sessionRepository.findBySessionName(sessionName));


        return session;

        //  return sessionRepository.getOne(id);
    }

    @GetMapping
    @RequestMapping("sessionValue/{sessionValue}")
    public Optional<Session> getBySessionValue(@PathVariable String sessionValue)
    {

//        Optional<Session> session= Optional.ofNullable(sessionRepository.findBySession_id_Session_name(name));

        Optional<Session> session= Optional.ofNullable(sessionRepository.findBySessionValue(sessionValue));


        return session;

        //  return sessionRepository.getOne(id);
    }


    @GetMapping
    @RequestMapping("sessionValueStartingWith/{sessionValue}")
    public Optional<Session> getSessionValueStartingWith(@PathVariable String sessionValue)
    {

//        Optional<Session> session= Optional.ofNullable(sessionRepository.findBySession_id_Session_name(name));

        Optional<Session> session= Optional.ofNullable(sessionRepository.findBySessionValueStartingWith(sessionValue));


        return session;

        //  return sessionRepository.getOne(id);
    }

    @GetMapping
    @RequestMapping("ListBySessionName/{name}")
    public Optional<List<Session>> ListBySessionName(@PathVariable String name)
    {
//        Optional<List<Session>> session= Optional.ofNullable(sessionRepository.findBySession_id_Session_nameList(name));

//        Optional<List<Session>> session= Optional.ofNullable(sessionRepository.findAll(new Sort(Sort.Direction.ASC, "name")));

        Optional<List<Session>> session= Optional.ofNullable(sessionRepository.findBySession_id_Session_nameList1(new Sort( "name")));




        return session;

        //  return sessionRepository.getOne(id);
    }

    @PostMapping
//    @Transactional( propagation = Propagation.REQUIRES_NEW,rollbackFor = ArithmeticException.class)
  //  @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
        public Session create(@RequestBody final Session session) throws SQLException {

       bookService.saveBook(session);

   //    bookService.saveBookTransactional(session);



//        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/First", "postgres", "root");
//
//
//        createSessions(session);

//        for (int i = 0; i < 40; i++) {
//            sessionRepository.saveAndFlush(session);
//            sessionRepository.saveAndFlush(session);
//
//
//            if(i>20)
//            {
//               throw new NullPointerException();
//            }
//
//        }


        try{


          //  createUser();
        //    throw new NullPointerException("hello");
        }catch(Exception e)
        {
//            con.rollback();
            System.out.println(e);
        }





         return null;
    }



    @RequestMapping(value="{id}", method =RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@RequestBody Session session, @PathVariable Long id)
    {
        Session existingSession=sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

   // @Transactional
    public void createUser() throws SQLException {

        List<User> usersList = new ArrayList<>();
        UUID uuid1 = Generators.timeBasedGenerator().generate();

        String uuid = uuid1.toString();

        User u = new User(uuid, "Nilesh", "choudhdary", (long) 25634);
        //   User u1 = new User(abc, "deepa989k  ", "Paid", (long) 2534634);

        usersList.add(u);
        //        usersList.add(u1);

        String SQL = "Insert into public.User(user_id, char_name,last_name,phone_no) values (?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = SessionsController.con.prepareStatement(SQL);
            //  SessionsController.con.setAutoCommit(false);
            int count = 0;
            for (User a : usersList) {
                //    System.out.println("Creating Users");


                ps.setString(1, a.getUser_id());
                ps.setString(2, a.getChar_name());
                ps.setString(3, a.getLast_name());
                ps.setLong(4, a.getPhone_no());
                ps.addBatch();

                count++;
                // execute every 100 rows or less
                if (count % 100 == 0 || count == usersList.size()) {
                    ps.executeBatch();
                }
                //    con.commit();

                // ps.executeUpdate();
            }

            //   throw new NullPointerException("hello");
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }


    }

//    //(noRollbackFor = NullPointerException.class)
//    @Transactional
//    public void createSessions(Session session) throws NullPointerException
//    {
//        for (int i = 0; i < 40; i++) {
//            sessionRepository.saveAndFlush(session);
//            sessionRepository.saveAndFlush(session);
//
//
//            if(i>20)
//            {
//                  throw new NullPointerException();
//            }
//
//        }
//
//    }

    //(noRollbackFor = NullPointerException.class)
    @Transactional(noRollbackFor = NullPointerException.class)
    public void createSessions(Session session)
    {
        for (int i = 0; i < 40; i++) {
            sessionRepository.saveAndFlush(session);
            sessionRepository.saveAndFlush(session);


            if(i>20)
            {
                throw new NullPointerException();
            }

        }

    }


}
