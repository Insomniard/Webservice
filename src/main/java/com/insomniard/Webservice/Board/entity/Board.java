package com.insomniard.Webservice.Board.entity;

import com.insomniard.Webservice.Account.domain.User;
import com.insomniard.Webservice.commit.entity.Commit;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@ToString
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String contents;

    @Column(nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private List<Commit> commit;

    @Builder
    public Board(User user,String title, String contents, String author, List<Commit> commit) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.user = user;
        this.commit = new ArrayList<Commit>();
    }

    public void update(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
