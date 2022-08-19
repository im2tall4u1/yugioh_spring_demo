package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CardRepository;
import com.example.demo.model.Card;
import java.util.*;





@RestController
public class CardController {
    @Autowired
    CardRepository cardRepository;
    


    

    @RequestMapping(value="/card", method=RequestMethod.GET)
    public ResponseEntity<List<Card>> listOfCards(){
        List<Card> cards = cardRepository.findAllByOrderByIdAsc();
        return new ResponseEntity<List<Card>>(cards, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/card", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Card> insertCard(@RequestBody Card card){
        Card c = cardRepository.save(card);
        return new ResponseEntity<Card>(c, HttpStatus.CREATED);
    }


    @RequestMapping(value="/cardbyid", method=RequestMethod.GET)
    public ResponseEntity<Card> singularCard(@RequestParam int id){
        Optional<Card> selectedCard = cardRepository.findById(id);
        if (selectedCard.isPresent()){
            return new ResponseEntity<Card>(selectedCard.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/card/{id}", method=RequestMethod.GET) // {} is a path variable. So in this case, it is id
    public ResponseEntity<Card> singularCardUsingPathVariable(@PathVariable int id){
        Optional<Card> selectedCard = cardRepository.findById(id);
        if (selectedCard.isPresent()){
            return new ResponseEntity<Card>(selectedCard.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/card/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Card> deleteCardUsingPathVariable(@PathVariable int id){
        Optional<Card> selectedCard = cardRepository.findById(id);
        if (selectedCard.isPresent()){
            cardRepository.deleteById(id);
            return new ResponseEntity<Card>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }    
    }    
}