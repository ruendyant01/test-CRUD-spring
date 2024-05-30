package org.vascoom.vascoomspring.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.vascoom.vascoomspring.criteria.UserCriteria;
import org.vascoom.vascoomspring.entities.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, PagingAndSortingRepository<Users, Long> {

    List<Users> findAllByIsActiveTrue();

    Optional<Users> findByUsername(String username);
}
