package org.sushant.expensetrackerbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sushant.expensetrackerbackend.Entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}