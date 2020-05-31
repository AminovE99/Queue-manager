package ru.itis.queuesolution.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Organization {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String email;
}
