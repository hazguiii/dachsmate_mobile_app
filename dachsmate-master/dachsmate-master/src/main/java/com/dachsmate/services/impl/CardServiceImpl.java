package com.dachsmate.services.impl;

import com.dachsmate.dao.CardDao;
import com.dachsmate.entity.Card;
import com.dachsmate.services.CardService;
import com.dachsmate.views.CardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;



    @Override
    public Card findCardById(Integer id) {
        return cardDao.findCardById(id);
    }

    @Override
    public Card saveCard(CardView cardView) {
        return cardDao.save(Card.newInstance(cardView));
    }

    @Override
    public Card updateCard(Card card, CardView cardView) {

        card.setCode(cardView.getCode());
        card.setBalance(cardView.getBalance());


        cardDao.saveAndFlush(card);
        return card;
    }

    @Override
    public List<Card> findAllCards() {
        return cardDao.findAll();
    }

    @Override
    public String deleteCard(Card card) {
        cardDao.delete(card);
        return "ok";
    }
}
