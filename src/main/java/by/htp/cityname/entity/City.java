package by.htp.cityname.entity;

public final class City {

	private String _strName;
	private char _chrFirstChar;
	private char _chrLastChar;
	private char[] chrExceptionsChar = {'й','ы','ь', 'ъ'};
	
	public City(String _strName) {
		super();
		this._strName = _strName;
		char[] chrArray = _strName.toCharArray();
		this._chrFirstChar = chrArray[0];
		this._chrLastChar = defineCorrectLastChar(chrArray);
	}
	
	private char defineCorrectLastChar(char[] chrArray){
		char chrLastSymb = chrArray[chrArray.length-1];
		for (int i=chrArray.length-1; i > 0; i-- ) {
			for (char symb: chrExceptionsChar){
				if (chrArray[i]==symb) {
					chrLastSymb = chrArray[i-1];
				}
			}
		}
		return chrLastSymb;
	}

	public String get_strName() {
		return _strName;
	}

	public char get_chrFirstChar() {
		return _chrFirstChar;
	}


	public char get_chrLastChar() {
		return _chrLastChar;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _chrFirstChar;
		result = prime * result + _chrLastChar;
		result = prime * result + ((_strName == null) ? 0 : _strName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (_chrFirstChar != other._chrFirstChar)
			return false;
		if (_chrLastChar != other._chrLastChar)
			return false;
		if (_strName == null) {
			if (other._strName != null)
				return false;
		} else if (!_strName.equals(other._strName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [_strName=" + _strName + ", _chrFirstChar=" + _chrFirstChar + ", _chrLastChar=" + _chrLastChar
				+ "]";
	}
	
	
	
}
