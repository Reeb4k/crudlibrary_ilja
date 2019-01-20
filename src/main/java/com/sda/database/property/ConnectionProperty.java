package com.sda.database.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionProperty {

    private String drivername;
    private  String dataBaseUrl;
    private String username;
    private String password;

}
