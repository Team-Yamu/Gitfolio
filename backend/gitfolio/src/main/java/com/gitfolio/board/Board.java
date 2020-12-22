package com.gitfolio.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonAutoDetect;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private Blob viewContent;

    @Lob
    @Column(nullable = false)
    private Blob originalContent;

    @Column(nullable = false)
    private Long registerId;

    @Column(nullable = false)
    private LocalDateTime registerDateTime;

    @Column
    private LocalDateTime updateDateTime;

    @Column
    private String previewImageUrl;

    @Column
    private String tag;

    @Column
    private int view;

    public Board() {
        this.view = 0;
        this.registerDateTime = LocalDateTime.now();
        this.updateDateTime = this.registerDateTime;
    }
}
