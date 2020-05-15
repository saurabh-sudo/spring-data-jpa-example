package com.pluralsight.conferencedemoboot.controllers;


import com.pluralsight.conferencedemoboot.models.Speaker;
import com.pluralsight.conferencedemoboot.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers/")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list()
    {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id)
    {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker session)
    {
        return speakerRepository.saveAndFlush(session);
    }


//    @DeleteMapping
//    @RequestMapping(value="{id}")
     @RequestMapping(value="{id}", method =RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@RequestBody Speaker speaker, @PathVariable Long id)
    {
        Speaker existingSession=speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSession,"speaker_id");
        return speakerRepository.saveAndFlush(existingSession);
    }



}
