package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> getAllCards(){
        List<Card> cards = cardRepository.findAllByOrderByIdAsc();
        return cards;
    }

    public Card save(Card cardToBeAdded){
        Card c = cardRepository.saveAndFlush(cardToBeAdded);
        return c;
    }

    public Optional<Card> getCard(int id){
        return cardRepository.findById(id);
    }

    public void delete(int id){
        cardRepository.deleteById(id);
    }
}
