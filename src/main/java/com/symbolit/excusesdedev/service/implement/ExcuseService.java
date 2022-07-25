package com.symbolit.excusesdedev.service.implement;

import com.symbolit.excusesdedev.entity.DTO.ExcuseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * The interface ExcuseService for low coupling between the corresponding Controller and Service layers
 *
 * @author Cecile
 */
public interface ExcuseService {

    Optional<ExcuseDTO> findOne(Long id);

    Optional<ExcuseDTO> findOneRandom();

    List<ExcuseDTO> findAll();

    Page<ExcuseDTO> findAll(Pageable pageable);

    ExcuseDTO save (ExcuseDTO excuseDTO);

}
