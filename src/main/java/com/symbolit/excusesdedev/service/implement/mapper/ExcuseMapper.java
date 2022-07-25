package com.symbolit.excusesdedev.service.implement.mapper;

import com.symbolit.excusesdedev.entity.DAO.ExcuseDAO;
import com.symbolit.excusesdedev.entity.DTO.ExcuseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

/**
 * A mapper for the Excuse Entity, allowing to turn DAO into DTO and DTO into DAO. Uses the ModelMapper library.
 *
 * @author Cecile
 */
@Service
public class ExcuseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ExcuseDTO excuseDAOToExcuseDTO(ExcuseDAO excuseDAO) {
        return this.modelMapper.map(excuseDAO, ExcuseDTO.class);
    }

    public ExcuseDAO excuseDTOToExcuseDAO(ExcuseDTO excuseDTO) {
        return this.modelMapper.map(excuseDTO, ExcuseDAO.class);
    }

}
