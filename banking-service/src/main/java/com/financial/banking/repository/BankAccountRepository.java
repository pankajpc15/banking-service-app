
package com.financial.banking.repository;

import com.financial.banking.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
