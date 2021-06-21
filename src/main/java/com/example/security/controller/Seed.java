package com.example.security.controller;

import com.example.security.entity.Account;
import com.example.security.entity.Product;
import com.example.security.repository.AccountRepository;
import com.example.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/seed/generate")
public class Seed {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @RequestMapping(method = RequestMethod.POST)
    public String seed(){
        List<Account> accounts = Arrays.asList(
                new Account(1,"ducnm","Nguyễn Đức",passwordEncoder.encode("123456"), 1, 1, (Collections.emptySet())),
                new Account(2,"ducnm1","Nguyễn Đức",passwordEncoder.encode("123456"),1, 1, (Collections.emptySet()))
        );
        accountRepository.saveAll(accounts);
        List<Product> products = Arrays.asList(
                new Product(1,"Tivi",2000000.00),
                new Product(2,"Máy giặt",10000000.0),
                new Product(3,"Nồi cơm",2000000.0),
                new Product(4,"Bộ đàm",1000000.0),
                new Product(5,"Công tơ",500000.0),
                new Product(6,"Điều hòa",22000000.0),
                new Product(7,"Lò nướng",400000.0),
                new Product(8,"Lò vi sóng",300000.0),
                new Product(9,"Bàn là",1000000.0),
                new Product(10,"Loa",25000000.0)
        );
        productRepository.saveAll(products);
        return   "ok";
    }
}
