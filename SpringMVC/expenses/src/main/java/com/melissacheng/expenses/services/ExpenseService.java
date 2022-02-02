package com.melissacheng.expenses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.expenses.models.Expense;
import com.melissacheng.expenses.repositories.ExpenseRepository;

@Service
public class ExpenseService {
//	private final ExpenseRepository expenseRepository; 
//	
//	public ExpenseService(ExpenseRepository expenseRepository) {
//		this.expenseRepository = expenseRepository;
//	}
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	// Method that calls the query to return all expenses
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	// Add an expense
	public Expense addExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
}
