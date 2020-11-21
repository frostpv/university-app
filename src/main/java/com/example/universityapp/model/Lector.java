package com.example.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lector")
public class Lector {
    @Id
    private Long id;
    private String name;
    private Integer salary;
    @ManyToOne
    private Degree degree;
}
