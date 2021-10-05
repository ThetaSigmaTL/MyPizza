package com.company.repository.data;

import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Transaction;
import com.company.model.enums.AccountStatus;
import com.company.model.enums.TransactionType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataSourceImpl implements DataSource {
    private final Storage storage;

    private List<Account> accountConstructor(List <String> accountFileToConstruct){
        List<Account> constructed = new ArrayList<>();
        for (String accountState : accountFileToConstruct) {
            String[] constructorTemp = accountState.split(";");
            String accountNum = constructorTemp[0];
            String customerId = constructorTemp[1];
            BigDecimal balance = new BigDecimal(constructorTemp[2]);
            AccountStatus status = AccountStatus.valueOf(constructorTemp[3]);
            constructed.add(new Account(accountNum, balance, status, customerId));
        }
        return constructed;
    }

    @Override
    public List<Account> getAccounts() {
        List<String> accountListToConstruct;
        accountListToConstruct = storage.readAccountsFile();
        return accountConstructor(accountListToConstruct);
    }

    private List<Customer> customerConstructor(List<String> customerFileToConstruct){
        List<Customer> constructed = new ArrayList<>();
        for (String customerState : customerFileToConstruct){
            String[] constructorTemp = customerState.split(";");
            String firstName = constructorTemp[0];
            String lastName = constructorTemp[1];
            String id = constructorTemp[2];
            String passID = constructorTemp[3];
            constructed.add(new Customer(firstName,lastName,id,passID));
        }
        return constructed;
    }

    @Override
    public List<Customer> getCustomers() {
        List<String> customerListToConstruct;
        customerListToConstruct = storage.readCustomersFile();
        return customerConstructor(customerListToConstruct);
    }
    private List <Transaction> transactionConstructor(List<String> transactonFileToConstruct){
        List<Transaction> constructed = new ArrayList<>();
        for (String transactionState : transactonFileToConstruct){
            String[] constructorTemp = transactionState.split(";");
            int transactionID = Integer.parseInt(constructorTemp[0]);
            int payeeID = Integer.parseInt(constructorTemp[1]);
            int senderID = Integer.parseInt(constructorTemp[2]);
            BigDecimal sum = new BigDecimal(constructorTemp[3]);
            TransactionType transactionType = TransactionType.valueOf(constructorTemp[4]);
            constructed.add(new Transaction(transactionID,payeeID,senderID,sum,transactionType));
        }
        return constructed;
    }
    @Override
    public List<Transaction> getTransactions() {
        List<String> transactionListToConstruct;
        transactionListToConstruct = storage.readTransactionsFile();
        return transactionConstructor(transactionListToConstruct);
    }

    public DataSourceImpl(Storage storage) {

        this.storage = storage;
    }
}
