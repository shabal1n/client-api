package kz.dar.academy.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    @NotNull(message = "Client ID can not be null")
    private String clientId;
    @NotNull(message = "Client name can not be null")
    private String name;
    private String surname;
    private String email;
}
