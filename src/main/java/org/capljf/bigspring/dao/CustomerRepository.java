package org.capljf.bigspring.dao;

import org.capljf.bigspring.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jifang.liu created on 2019/4/15 20:12
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstName(String firstName);

    @Query("from Customer c where c.firstName=:firstName and c.lastName=:lastName")
    Customer findUser(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
