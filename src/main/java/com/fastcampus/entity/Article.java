package com.fastcampus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

// Getter -> 프로퍼티들이 전부 Getter 설정
@Getter
@ToString
@Table(indexes = {
        // 인덱싱
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
// 엔티티를 구성하기 위한 조건
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter // Setter
    @Column(nullable = false)
    private String title;               // 제목
    @Setter
    @Column(nullable = false, length = 10000)
    private String content;             // 본문
    @Setter
    private String hashtag;             // 해쉬태그
    @CreatedDate    // 들어올 때 시스템 날짜 값 들어옴
    private LocalDateTime createdAt;    // 생성일시
    @CreatedBy  // ConfigJPA 에서 설정
    @Column(nullable = false, length = 100)     // Null 이 아니고 100자 이내
    private String createdBy;           // 생성자
    @LastModifiedDate
    private LocalDateTime modifiedAt;   // 수정일시
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private  String modifiedBy;         // 수정자



    // 엔티티로서의 기능을 만족시키기 위한 JPA Entity 는 기본생성자를 가지고 있어야 한다.
    // 평소에는 오픈하지 않을 거기 때문에 protected 로 설정 합니다. private 는 오류가 납니다.
    protected Article(){}

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
