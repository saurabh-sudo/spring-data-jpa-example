package com.pluralsight.conferencedemoboot.repositories;

import com.pluralsight.conferencedemoboot.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {


}
