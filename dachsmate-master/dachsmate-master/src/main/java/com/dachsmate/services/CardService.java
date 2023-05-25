package com.dachsmate.services;

import com.dachsmate.entity.Card;
import com.dachsmate.views.CardView;

import java.util.List;

public interface CardService {


    Card findCardById(Integer id);

    Card saveCard(CardView cardView);

    Card updateCard(Card card, CardView cardView);

    String deleteCard(Card card);

    List<Card> findAllCards();
}
