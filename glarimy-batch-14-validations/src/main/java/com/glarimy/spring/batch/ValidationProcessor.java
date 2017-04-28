package com.glarimy.spring.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

public class ValidationProcessor implements ItemProcessor<Book, Book> {
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public Book process(Book item) throws Exception {
		DataBinder binder = new DataBinder(item);
		binder.setValidator(validator);
		binder.validate();
		BindingResult results = binder.getBindingResult();
		if (results.hasErrors())
			throw new ValidationException(results.toString());
		return item;
	}
}
