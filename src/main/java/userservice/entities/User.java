package userservice.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User { 
	// Getter ve Setter metodlarını otomatik olarak oluşturur
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String id;

    @Column(unique = true, nullable = false)
	private String email;

    @Column(nullable = false)
	private String password;
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private UserRole role = UserRole.USER;
	
    @CreationTimestamp
	private LocalDateTime createdAt;

    @UpdateTimestamp
	private LocalDateTime updatedAt;
}

