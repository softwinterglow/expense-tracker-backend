package org.sushant.expensetrackerbackend.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sushant.expensetrackerbackend.DTO.ExpenseRequestDto;
import org.sushant.expensetrackerbackend.DTO.ExpenseResponseDto;
import org.sushant.expensetrackerbackend.Services.ExpenseServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("expense")
public class ExpenseController {

    private final ExpenseServices expenseServices;

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpenses() {
        return ResponseEntity.ok(expenseServices.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseServices.getExpenseById(id));
    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        return ResponseEntity.status(201).body(expenseServices.createExpense(expenseRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> updateExpense(@PathVariable Long id, @RequestBody ExpenseRequestDto expenseRequestDto) {
        return ResponseEntity.ok(expenseServices.updateExpense(id, expenseRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseServices.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
