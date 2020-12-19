package com.gitfolio.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long registerId;

    @Column(nullable = false)
    private LocalDateTime registerDateTime;

    @Column
    private String tag;

    public Board() {
        this.registerDateTime = LocalDateTime.now();
    }
}
