package serviceTest;

import com.SaitoStore.SaitoBank.exceptions.AccountException.PositiveBalanceException;
import com.SaitoStore.SaitoBank.models.AccountModel;
import com.SaitoStore.SaitoBank.repositories.AccountRepository;
import com.SaitoStore.SaitoBank.services.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class accountDeletExceptionTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void accountDeleteException() {

        AccountModel accountModel = new AccountModel();
        accountModel.setId(UUID.randomUUID());
        accountModel.setNumberAccount(String.valueOf(5215));
        accountModel.setBalance(100);
        accountModel.setDateRegisterAccount(LocalDateTime.now());

        when(accountRepository.findById(any(UUID.class))).thenReturn(Optional.of(accountModel));

        Assertions.assertThrows(PositiveBalanceException.class, () -> {
            accountService.deleteByIdAccount(UUID.randomUUID());
        });

    }
}
