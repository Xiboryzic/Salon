package com.vishnevsky.salon.repository;

import com.vishnevsky.salon.model.Contact;
import com.vishnevsky.salon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    List<Contact> findByClient(User client);

    @Query(nativeQuery = true, value ="SELECT * FROM contact WHERE client_id = <client_id>")
    Map<String, Integer> findbyClient();

}
