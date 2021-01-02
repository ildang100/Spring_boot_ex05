package com.sduty.spring_boot_ex05.repository;

import com.sduty.spring_boot_ex05.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {

}
