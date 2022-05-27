
public class HashEntry<T> {
	private String key;
	private T value;
	private int status;

	public HashEntry(String key, T value, int status) {

		this.key = key;
		this.value = value;
		this.status = status;
	}

	public String getKey() {
		return key;
	}

	public T getValue() {
		return value;
	}

	public int getStatus() {
		return status;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "" + value + "\n";
	}

}
