package com.apress.spring.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @Data is a convenient shortcut annotation that bundles the features of
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Journal extends BaseEntity implements Serializable {


    private String title;
    private String summary;
    private Date created;
}
