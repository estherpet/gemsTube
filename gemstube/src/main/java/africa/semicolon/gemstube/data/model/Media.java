package africa.semicolon.gemstube.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        private String title;
        private String description;
        @ManyToOne(fetch = FetchType.EAGER)
        private User uploader;
        private String url;
        private LocalDateTime createdAt;
        @Enumerated(EnumType.STRING)
        private Type type;
        @PrePersist
        public void setCreatedAt(){
            this.createdAt = LocalDateTime.now();
        }

}
