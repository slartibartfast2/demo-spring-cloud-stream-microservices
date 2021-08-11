package ea.slartibartfast.transactionapi.controller;

import ea.slartibartfast.transactionapi.model.vo.UserTransactionVo;
import ea.slartibartfast.transactionapi.service.UserTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user-transaction")
@RequiredArgsConstructor
public class UserTransactionController {

    private final UserTransactionService userTransactionService;

    @PostMapping
    public ResponseEntity<Void> createAccount(@Valid @RequestBody UserTransactionVo userTransactionVo) {
        userTransactionService.createUserTransaction(userTransactionVo);
        return ResponseEntity.ok().build();
    }
}
