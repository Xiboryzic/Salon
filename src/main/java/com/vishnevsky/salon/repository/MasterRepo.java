package com.vishnevsky.salon.repository;

import com.vishnevsky.salon.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface MasterRepo extends JpaRepository<Master, Long> {

    List<Master> findByRang(Integer rang);
    List<Master> findByName(String name);

    @Query(nativeQuery = true, value ="SELECT * FROM master WHERE rang = :rang")
    Map<String, Integer> findbyRang();

    @Query(nativeQuery = true, value ="SELECT * FROM master WHERE name = :neam")
    Map<String, Integer> findbyName();

}
