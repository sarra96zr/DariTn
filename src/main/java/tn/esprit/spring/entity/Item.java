package tn.esprit.spring.entity;

public class Item {
	private Meubles meuble;
	private int quantity;

	public Item() {
	}

	public Item(Meubles product, int quantity) {
		this.meuble = product;
		this.quantity = quantity;
	}

	public Meubles getMeuble() {
		return meuble;
	}

	public void setProduct(Meubles product) {
		this.meuble = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
