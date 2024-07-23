package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {

	// private final AtomicLong counter = new AtomicLong();
	private SimpleMath Math = new SimpleMath();

	// Request Soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, Set a Numeric Value!");
		}

		return Math.sum(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}

	// Request Subtracao
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, Set a Numeric Value!");
		}

		return Math.subtraction(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}

	// Request Divisao
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, Set a Numeric Value!");
		}

		return Math.division(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}

	// Request Multiplicacao
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, Set a Numeric Value!");
		}

		return Math.multiplication(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}

	// Request Media
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, Set a Numeric Value!");
		}

		return Math.mean(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo));
	}

	// Request Raiz quadrada
	@RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
	public Double sqrt(
			@PathVariable(value = "number") String number) throws Exception {

		if (!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please, Set a Numeric Value!");
		}

		return Math.sqrt(NumberConverter.convertDouble(number));
	}

}
