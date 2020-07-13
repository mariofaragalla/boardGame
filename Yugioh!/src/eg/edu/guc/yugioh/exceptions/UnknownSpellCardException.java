package eg.edu.guc.yugioh.exceptions;

public class UnknownSpellCardException extends UnexpectedFormatException{
	private String unknownSpell;
	private String Message;
	public UnknownSpellCardException(String sourceFile, int sourceLine,
			String unknownSpell) {
		super(sourceFile, sourceLine);
		this.unknownSpell = unknownSpell;
		this.Message=Message;
	}

	public String getUnknownSpell() {
		return unknownSpell;
	}

	public void setUnknownSpell(String unknownSpell) {
		this.unknownSpell = unknownSpell;
	}

	public String getMessage() {
		return super.getMessage();
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
}
