package com.SaitoStore.SaitoBank.models;

import com.SaitoStore.SaitoBank.dtos.ClientRecordDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_CLIENT")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String name;
    private Integer age;
    private Integer cpf;
    private String email;

    @ManyToOne
    @JoinColumn(name = ("account_id"))
    private AccountModel account;


    public ClientModel(ClientRecordDto clientRecordDto) {
        this.name = clientRecordDto.name();
        this.age = clientRecordDto.age();
        this.cpf = clientRecordDto.cpf();
        this.email = clientRecordDto.email();
    }
}
