package com.pluralsight.conferencedemoboot.repositories;

import com.pluralsight.conferencedemoboot.models.Session;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> , JpaSpecificationExecutor {



//    @Query("select u from session u where u.session_name = ?1")
@Query("select u from session u where u.sessionName = ?1")
    Session findBySession_id_Session_name(String name);

    Session findBySessionName(String session_name);

 Session findBySessionValue(String sessionValue);

    Session findBySessionValueStartingWith(String sessionValue);





    @Query("select u from session u where u.sessionName = ?1")
    List<Session> findBySession_id_Session_nameList(String name);

    @Query("select u from session u where u.sessionName = ?1")
    List<Session> findBySession_id_Session_nameList1( Sort name);


}
