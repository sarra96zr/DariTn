package tn.esprit.spring.entity;

public enum Type_Meuble {
	
	ARMOIRES("Armoire"),
	BUFFET("Buffet"),
	FAUTEUIL("Fauteuils"),
	AUTRE("Autre");
	    
	private String text;
	

	Type_Meuble(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
}

