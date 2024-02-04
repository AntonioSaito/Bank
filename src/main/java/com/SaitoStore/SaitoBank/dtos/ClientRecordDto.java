package com.SaitoStore.SaitoBank.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;


public record ClientRecordDto(String numberAccount, @NotBlank String name,
                              @NotNull Integer age, @Email String email, LocalDate dateRegisterClient) {
}
