package com.symbolit.excusesdedev.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Common configuration elements for the application.
 *
 * @author Cecile
 */
@Configuration
public class ApplicationConfiguration {

    /**
     * Allow the creation of a ModelMapper bean (object)
     *
     * @return a new ModelMapper bean
     *
     * @author Cecile
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
