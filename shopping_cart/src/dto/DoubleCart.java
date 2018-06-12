package dto;

public class DoubleCart {

	private CartEntity publicCartEntity;
	private CartEntity privateCartEntity;

	public CartEntity getPublicCartEntity() {
		return publicCartEntity;
	}

	public void setPublicCartEntity(CartEntity publicCartEntity) {
		this.publicCartEntity = publicCartEntity;
	}

	public CartEntity getPrivateCartEntity() {
		return privateCartEntity;
	}

	public void setPrivateCartEntity(CartEntity privateCartEntity) {
		this.privateCartEntity = privateCartEntity;
	}

}
