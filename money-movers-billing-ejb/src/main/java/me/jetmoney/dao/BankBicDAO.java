package me.jetmoney.dao;

import me.jetmoney.entity.BankBic;

import javax.ejb.Local;

/**
 * Created by Denis Murzin
 *      on 27.09.16.
 */
@Local
public interface BankBicDAO extends BaseDAO<BankBic> {

    BankBic findByCode(String code);

}
