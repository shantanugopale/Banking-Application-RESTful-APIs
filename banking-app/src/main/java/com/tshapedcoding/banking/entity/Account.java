package com.tshapedcoding.banking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account_details",schema = "banking_app")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "account_balance")
    private double balance;

    public Account(String accountHolderName, double balance, Long id) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.id = id;
    }

    public Account() {
    }
}
