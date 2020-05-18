package com.mysql.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Hanz
 * @date 2020/5/18
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
