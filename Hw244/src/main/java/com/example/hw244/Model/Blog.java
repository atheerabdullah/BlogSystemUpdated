package com.example.hw244.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blog {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(columnDefinition = "varchar(20) not null")
        @NotEmpty(message = "the title should not null")
        private String title;


        @NotNull
        @Column(columnDefinition = "varchar(20) not null check (category='health' or category='education' or category='programming')")
        private String category;


        @Column(columnDefinition = "varchar(300) not null")
        @NotEmpty(message = "300 letters accept")
        private String body;

        @Column(columnDefinition = "boolean default false not null")
        private boolean isPublished = false;
}
