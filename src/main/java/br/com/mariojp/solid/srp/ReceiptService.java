package br.com.mariojp.solid.srp;

public class ReceiptService {
	private final TaxCalculator calculator;
	private final ReceiptFormatter formatador;

	public ReceiptService() {
		this(new TaxCalculator(), new ReceiptFormatter());
	}

	public ReceiptService(TaxCalculator calculator, ReceiptFormatter formatador) {
		this.calculator = calculator;
		this.formatador = formatador;
	}

	public String generate(Order order) {
		double subtotal = order.getItems().stream()
				.mapToDouble(i -> i.getUnitPrice() * i.getQuantity())
				.sum();
		double tax = calculator.calcularImposto(subtotal);
		double total = subtotal + tax;
		return formatador.formatar(order, subtotal, tax, total);
	}
}
