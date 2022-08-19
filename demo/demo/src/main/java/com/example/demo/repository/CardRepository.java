package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Card;


@Repository
public interface CardRepository extends JpaRepository<Card, Integer> { // Card means it's a repository of cards. The primary key is of type Integer.
    public List<Card> findAllByOrderByIdAsc(); // interface so method needs no body. Return type is a List of Cards. findAllBy is a one line query. First By acts as delimeter. 
    public Card save (Card savedCard); // public function that takes in Card object and returns a Card object. Spring boot recognizes the names of the methods.
    public Optional<Card> findById(int id); // public function that finds card by ID and takes the id as a parameter.
}
