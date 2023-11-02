package africa.semicolon.gemstube.data.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    private User commenter;
    @ManyToOne
    private Media media;
    private LocalDateTime updatedAt = LocalDateTime.now();
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    public void setCreatedAt(){
        updatedAt = LocalDateTime.now();
    }
}
