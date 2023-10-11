package africa.semicolon.gemstube.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
        @OneToOne(fetch = FetchType.EAGER)
        private User uploader;
        private String url;
        private LocalDateTime createdAt;

}
