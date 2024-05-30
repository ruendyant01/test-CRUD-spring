package org.vascoom.vascoomspring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.vascoom.vascoomspring.entities.enums.Role;

@Entity
@Data
@RequiredArgsConstructor
public class Roles {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;
}
