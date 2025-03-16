package com.tshapedcoding.banking.controller;

import com.tshapedcoding.banking.dto.AccountDto;
import com.tshapedcoding.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    ADD Account REST API
//    http://localhost:8080/api/accounts
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

//    GET Account REST API
//    http://localhost:8080/api/accounts/1
    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
        AccountDto  accountDto = accountService.getAccount(id);
        return ResponseEntity.ok(accountDto);
    }

//    Deposit REST API
//    http://localhost:8080/api/accounts/1/deposit
    @PutMapping("{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request)
    {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);

    }

//    WITHDRAW REST API
//    http://localhost:8080/api/accounts/1/withdraw
    @PutMapping("{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request)
    {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }


//    GET All Accounts REST API
//    http://localhost:8080/api/accounts/
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts()
    {
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }

//    DELETE Account REST API
//    http://localhost:8080/api/accounts/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id)
    {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Account is Deleted Successfully");
    }

}
