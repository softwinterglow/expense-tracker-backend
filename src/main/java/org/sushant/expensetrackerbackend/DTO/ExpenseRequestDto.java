package org.sushant.expensetrackerbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequestDto {
    private String title;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
}
