package com.selfpractise.webwallet.repository;

import com.selfpractise.webwallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
