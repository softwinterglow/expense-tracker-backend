package org.sushant.expensetrackerbackend.Services;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.sushant.expensetrackerbackend.DTO.ExpenseRequestDto;
import org.sushant.expensetrackerbackend.DTO.ExpenseResponseDto;
import org.sushant.expensetrackerbackend.Entity.Expense;
import org.sushant.expensetrackerbackend.Repository.ExpenseRepository;

import java.lang.ref.PhantomReference;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServices {

    private final ModelMapper modelMapper;
    private final ExpenseRepository expenseRepository;

    public List<ExpenseResponseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(expense-> modelMapper.map(expense, ExpenseResponseDto.class))
                .toList();
    }

    public ExpenseResponseDto getExpenseById(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id :" + id));
        return modelMapper.map(expense, ExpenseResponseDto.class);
    }

    public ExpenseResponseDto createExpense(ExpenseRequestDto expenseRequestDto){
        Expense expense = modelMapper.map(expenseRequestDto, Expense.class);
        Expense savedExpense = expenseRepository.save(expense);
        return modelMapper.map(savedExpense, ExpenseResponseDto.class);
    }

    public ExpenseResponseDto updateExpense(Long id, ExpenseRequestDto expenseRequestDto){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        expense.setTitle(expenseRequestDto.getTitle());
        expense.setAmount(expenseRequestDto.getAmount());
        expense.setCategory(expenseRequestDto.getCategory());
        expense.setDate(expenseRequestDto.getDate());

        Expense updatedExpense = expenseRepository.save(expense);
        return modelMapper.map(updatedExpense, ExpenseResponseDto.class);
    }

    public void deleteExpense(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        expenseRepository.delete(expense);
    }





}
