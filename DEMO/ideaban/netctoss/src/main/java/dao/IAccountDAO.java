package dao;

import entity.Account;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/11/18 23:37
 */
public interface IAccountDAO {
    List<Account> findAll();
    Account findById(Integer accountId);
    void save(Account account);
    void delete(Integer accountId);
    void update(Account account);
    void updateStatus(Account account);

    Account findByIdcordNo(String idcardNo);
}
