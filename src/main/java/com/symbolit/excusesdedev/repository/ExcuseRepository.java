package com.symbolit.excusesdedev.repository;

import com.symbolit.excusesdedev.entity.DAO.ExcuseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the Excuse Entity
 *
 * @author Cecile
 */
@Repository
public interface ExcuseRepository extends JpaRepository<ExcuseDAO, Long> {

    @Query("SELECT e FROM ExcuseDAO e order by function('RAND')")
    List<ExcuseDAO> findOneRandom();

    Page<ExcuseDAO> findAll(Pageable pageable);
}
