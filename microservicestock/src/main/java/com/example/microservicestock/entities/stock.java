package com.example.microservicestock.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class stock implements Serializable {
        @Id
        @Setter(AccessLevel.NONE)
        long idStock;
        String nameStock;
        //LocalDateTime createdAt;
        //LocalDateTime updatedAt;


}
