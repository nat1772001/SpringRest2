package com.sia.taco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sia.taco.entities.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {

}
