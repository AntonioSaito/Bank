package com.SaitoStore.SaitoBank.models;

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


}
