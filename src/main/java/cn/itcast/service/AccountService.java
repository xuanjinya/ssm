package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

/**
 * @Author: Yaking
 * @Date: 2019-07-18 23:38
 * @Describe:
 */
public interface AccountService {
    //查询所有的账户信息
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}
