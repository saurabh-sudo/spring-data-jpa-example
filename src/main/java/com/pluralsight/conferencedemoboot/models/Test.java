package com.pluralsight.conferencedemoboot.models;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName ="seq1", initialValue = 1000, allocationSize = 10)
    @GeneratedValue(generator = "mySeqGen")
    private Long session_id;

    @Column(name="session_name")
    @Transient
    private String sessionName;

}



