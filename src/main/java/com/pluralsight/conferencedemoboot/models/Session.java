package com.pluralsight.conferencedemoboot.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.List;

@Entity(name="session")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    public class Session  extends Auditable<String> {


        // @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        @SequenceGenerator(name = "mySeqGen", sequenceName ="seq1", initialValue = 1000, allocationSize = 10)
        @GeneratedValue(generator = "mySeqGen")
        private Long session_id;

    @Column(name="session_name")
    private String sessionName;

    //    @Transient
//    @JsonSerialize
//    @JsonDeserialize
//
  //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    @JsonProperty
    private String session_description;

    public String getSessionValue() {
        return sessionValue;
    }

    public void setSessionValue(String sessionValue) {
        this.sessionValue = sessionValue;
    }

    private Integer session_length;

    @Column(name="sessionValue")
    private String sessionValue;

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Session()
    {

    }

    @ManyToMany
    @JoinTable(
            name="session_speakers",
            joinColumns = @JoinColumn(name="session_id"),
            inverseJoinColumns = @JoinColumn(name="speaker_id")
    )
    private List<Speaker> speakers;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers){
        this.speakers = speakers;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }




    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }
}
