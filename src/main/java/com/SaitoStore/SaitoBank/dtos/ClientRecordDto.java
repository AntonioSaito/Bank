package com.SaitoStore.SaitoBank.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientRecordDto(@NotBlank String name, @NotNull Integer age,
                              @NotNull Integer cpf, @NotBlank String email) {
}
