package org.example.webcontacts.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// TODO убрать всеконструктор после уборки инищиалицации в менеджере (сервисе)
@AllArgsConstructor
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
