package com.insomniard.Webservice.Board.entity;

import com.insomniard.Webservice.Account.domain.User;
import com.insomniard.Webservice.commit.entity.Commit;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
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
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL)
    private List<Commit> commits = new ArrayList<>();

    @Builder
    public Board(User user,String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.user = user;
    }
    public void update(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
