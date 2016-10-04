package me.jetmoney.dao;

import me.jetmoney.entity.BankBic;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * Created by Denis Murzin
 *      on 27.09.16.
 */
@Stateless
public class BankBicDAOImpl extends BaseDAOImpl<BankBic> implements BankBicDAO {

    @Override
    public BankBic findByCode(String code) {
        try {
            return getEntityManager()
                    .createQuery("select d from BankBic d where d.bankCode = :bankCode", BankBic.class)
                    .setParameter("bankCode", code)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
