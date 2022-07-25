package com.symbolit.excusesdedev.entity.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


/**
 * Excuse entity in the form of a DAO (Data Access Object)
 *
 * @author Cecile
 */
@Entity
@Table (name = "excuse")
public class ExcuseDAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "httpSequenceGenerator")
    @SequenceGenerator(name = "httpSequenceGenerator")
    @Column (name = "http_code", nullable = false)
    private Long httpCode;

    @Column (name = "tag", nullable = false)
    private String tag;

    @Column (name = "message", nullable = false)
    private String message;

}
