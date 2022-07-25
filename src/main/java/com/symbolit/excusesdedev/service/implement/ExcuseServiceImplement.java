package com.symbolit.excusesdedev.service.implement;

import com.symbolit.excusesdedev.entity.DAO.ExcuseDAO;
import com.symbolit.excusesdedev.entity.DTO.ExcuseDTO;
import com.symbolit.excusesdedev.repository.ExcuseRepository;
import com.symbolit.excusesdedev.service.implement.mapper.ExcuseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The Excuse Service layer, implemented with the ExcuseService Interface for low coupling
 *
 * @author Cecile
 */
@Service
@Transactional
public class ExcuseServiceImplement implements ExcuseService {

    @Autowired
    private ExcuseRepository excuseRepository;
    @Autowired
    private ExcuseMapper excuseMapper;

    @Override
    public Optional<ExcuseDTO> findOne(Long id) {
        return Optional.ofNullable(this.excuseMapper
                .excuseDAOToExcuseDTO(this.excuseRepository.findById(id).orElse(null)));
    }

    @Override
    public Optional<ExcuseDTO> findOneRandom() {
        return Optional.ofNullable(this.excuseMapper
                .excuseDAOToExcuseDTO(this.excuseRepository.findOneRandom().get(0)));
    }

    @Override
    public List<ExcuseDTO> findAll() {
        List<ExcuseDAO> listExcuseDAO = this.excuseRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        return listExcuseDAO.stream().map(excuseDAO -> this.excuseMapper.excuseDAOToExcuseDTO(excuseDAO))
                .collect(Collectors.toList());
    }
    @Override
    public Page<ExcuseDTO> findAll(Pageable pageable) {
        return this.excuseRepository.findAll(pageable).map(this.excuseMapper::excuseDAOToExcuseDTO);
    }

    @Override
    public ExcuseDTO save(ExcuseDTO excuseDTO) {
        ExcuseDAO excuseDAO = this.excuseMapper.excuseDTOToExcuseDAO(excuseDTO);
        excuseDAO = this.excuseRepository.save(excuseDAO);
        return this.excuseMapper.excuseDAOToExcuseDTO(excuseDAO);
    }

}
