package org.vascoom.vascoomspring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Items {

    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    @Column(name = "is_active")
    private boolean is_active;
    private String historySearch;
}
