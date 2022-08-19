package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Card;
import com.example.demo.service.CardService;

@RestController
public class CardServiceController {
    @Autowired
    CardService cardService;

    @RequestMapping(value="/cardservice", method=RequestMethod.GET)
    public ResponseEntity<List<Card>> listOfCardsService(){
        List<Card> cardsAsService = cardService.getAllCards();
        return new ResponseEntity<List<Card>>(cardsAsService, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/cardservice", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Card> insertCardService(@RequestBody Card card){
        Card savedCardService = cardService.save(card);
        return new ResponseEntity<Card>(savedCardService, HttpStatus.CREATED);
    }

    @RequestMapping(value="/cardservice/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Card> deleteCardUsingPathVariable(@PathVariable int id){
        Optional<Card> selectedCard = cardService.getCard(id);
        if (selectedCard.isPresent()){
            cardService.delete(id);
            return new ResponseEntity<Card>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }    
    }    
}



