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
    private String viewContent;

    @Column(nullable = false)
    private String originalContent;

    @Column(nullable = false)
    private Long registerId;

    @Column(nullable = false)
    private LocalDateTime registerDateTime;

    @Column
    private String previewImageUrl;

    @Column
    private String tag;

    @Column
    private int view;

    public Board() {
        this.view = 0;
        this.registerDateTime = LocalDateTime.now();
    }
}
