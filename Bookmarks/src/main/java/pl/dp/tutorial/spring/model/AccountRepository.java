/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dp.tutorial.spring.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniel
 */
public interface AccountRepository extends JpaRepository<Account, Long>{
    Optional<Account> findByUsername(String username);
}
