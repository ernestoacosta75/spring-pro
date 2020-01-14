package com.apress.spring.web;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JournalController {

    @Autowired
    JournalRepository journalRepository;


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journal", journalRepository.findAll());
        return "index";
    }

    /**
     * Returns the journal list with the response as JSON data.
     * That's possible using the "@ResponseBody" annotation.
     * When this annotation is used, Spring MVC will automatically
     * use the correct HTTP message converters to transform the
     * response into JSON data.
     * @return Journal list as JSON data format.
     */
    @RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Journal> getJournal() {
        return journalRepository.findAll();
    }
}
