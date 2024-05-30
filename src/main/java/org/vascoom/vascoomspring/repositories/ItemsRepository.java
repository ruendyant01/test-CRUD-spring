package org.vascoom.vascoomspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.vascoom.vascoomspring.entities.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long>, PagingAndSortingRepository<Items, Long> {

}
