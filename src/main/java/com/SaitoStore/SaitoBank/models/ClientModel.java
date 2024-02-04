package com.SaitoStore.SaitoBank.models;

import com.SaitoStore.SaitoBank.dtos.ClientRecordDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_CLIENT")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "Name is mandatory.")
    private String numberClient;
    private String name;
    @Min(value = 18, message = "Age is less than 18 years old.")
    private Integer age;
    @Email(message = "Email invalid.")
    private String email;
    private LocalDate dateRegisterClient;

    @OneToMany(mappedBy = "clientModel", cascade = CascadeType.ALL)
    private List<AccountModel> Accounts;

    public ClientModel(ClientRecordDto clientRecordDto) {
        this.name = clientRecordDto.name();
        this.age = clientRecordDto.age();
        this.cpf = clientRecordDto.cpf();
        this.email = clientRecordDto.email();
    }
}
