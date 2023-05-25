package com.dachsmate.entity;

import com.dachsmate.views.CardView;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "Card.findCardById", query = "from Card as u where u.id = :id " ),
    @NamedQuery( name = "Card.findAllCards", query = "from Card as u order by id desc " ),
} )
@Entity
public class Card {
    private Integer id;
    private String code;
    private Integer balance;
    private Integer userId;

    public static Card newInstance(CardView cardView){

        Card card =new Card();
        card.setCode(cardView.getCode());
        card.setBalance(cardView.getBalance());


        return card;
    }
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Basic
    @Column(name = "balance", nullable = false)
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(balance, card.balance) && Objects.equals(userId, card.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, userId);
    }
}
