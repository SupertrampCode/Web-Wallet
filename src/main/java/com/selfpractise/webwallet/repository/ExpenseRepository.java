package com.selfpractise.webwallet.repository;

import com.selfpractise.webwallet.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
