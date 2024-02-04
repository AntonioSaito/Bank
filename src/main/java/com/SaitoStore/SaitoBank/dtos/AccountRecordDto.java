package com.SaitoStore.SaitoBank.dtos;

import com.SaitoStore.SaitoBank.models.ClientModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record AccountRecordDto(double balance, String numberAccount, ClientModel clientModel, LocalDateTime dateRegisterAccount) {
}
