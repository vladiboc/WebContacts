package org.example.webcontacts.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
