package com.dachsmate.controller;

import com.dachsmate.entity.Card;
import com.dachsmate.services.CardService;
import com.dachsmate.views.CardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = CardController.MAIN)
public class CardController {

    @Autowired
    CardService cardService;

    public static final String MAIN = "api/main";
    public static final String MAIN_CARD = "/card";
    //  public static final String MAIN_CARD = "/card";
    //  public static final String MAIN_CARD = "/card";

    // Request mapping names

    public static final String CARD_LOGIN = "/login";
    public static final String CARD_NEW = "/newCard";
    public static final String CARD_UPDATE = "/updateCard";
    public static final String CARD_DELETE = "/deleteCards";
    public static final String CARD_LIST = "/cards";

   // @PostMapping(MAIN_CARD + CARD_LOGIN)
   // public Card login(@RequestBody CardView cardView) {

    //    Card card = cardService.findCardForLoginPassword(cardView.getName(), cardView.getPassword());
   //     return card;
   // }

    @PostMapping(MAIN_CARD + CARD_NEW)
    public Card createCard(@RequestBody CardView cardView) {
        Card card = cardService.saveCard(cardView);
        return card;
    }

    @PostMapping(MAIN_CARD + CARD_UPDATE)
    public Card updateCard(@RequestBody CardView cardView) {
        Card card = cardService.findCardById(cardView.getId());
        if (card != null) {
            return cardService.updateCard(card, cardView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_CARD + CARD_DELETE)
    public String deleteCard(@RequestBody CardView cardView) {
        Card card = cardService.findCardById(cardView.getId());
        if (card != null) {
            return cardService.deleteCard(card);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_CARD + CARD_LIST)
    public List<Card> updateCard() {
        return cardService.findAllCards();
    }

}
