package com.devoops.oopslog.tag.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tag {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_name")
    private String tag_name;

    @Column(name = "tag_type")
    private String tag_type;
}
