package com.tshapedcoding.banking.mapper;

import com.tshapedcoding.banking.dto.AccountDto;
import com.tshapedcoding.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(

                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getId()
        );
    }
        );
    }
}
