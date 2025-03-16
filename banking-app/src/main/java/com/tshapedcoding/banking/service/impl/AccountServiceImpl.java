package com.tshapedcoding.banking.service.impl;

import com.tshapedcoding.banking.dto.AccountDto;
import com.tshapedcoding.banking.entity.Account;
import com.tshapedcoding.banking.mapper.AccountMapper;
import com.tshapedcoding.banking.repository.AccountRepository;
import com.tshapedcoding.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveObj = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveObj);
    }

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not Exists in the Database.."));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not Exists in the Database.."));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not Exists in the Database.."));
        if(amount <= account.getBalance())
        {
            double total = account.getBalance() - amount;
            account.setBalance(total);
            Account saveAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDto(saveAccount);
        }
        else {
            throw new RuntimeException("Insufficient Balance");
        }
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not Exists in the Database.."));

        accountRepository.deleteById(id);
    }
}
