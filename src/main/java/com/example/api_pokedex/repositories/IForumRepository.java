package com.example.api_pokedex.repositories;

import com.example.api_pokedex.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IForumRepository extends JpaRepository <Forum,Long> {
}
