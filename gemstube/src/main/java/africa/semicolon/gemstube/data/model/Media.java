package africa.semicolon.gemstube.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        private String title;
        private String description;
        private String url;
        private LocalDateTime createdAt;

}
