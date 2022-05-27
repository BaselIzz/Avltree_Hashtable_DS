
public class HashTable<T> {

	private int currentSize;
	private final int TableSize = 11;

	private HashEntry table[];

	public HashTable(int tSize) {
		table = new HashEntry[tSize];
		currentSize = 0;
	}

	public HashTable() {
		table = new HashEntry[TableSize];
		currentSize = 0;
	}

	private int search(String key) {
		int i = 0;
		int Hashcode = sHash(key);
		int hash = iHash(Hashcode, i);
		while (table[hash] != null && table[hash].getStatus() != 0) {
			if (key.equals(table[hash].getKey())) {
				if (table[hash].getStatus() == 2) {
					System.out.println("Not Exist");
					return -1;
				}
				System.out.println(table[hash].toString());
				return hash;

			}
			++i;
			hash = iHash(Hashcode, i);
		}
		System.out.println("Not Exist");
		return -1;

	}

	public String Find(String key) {
		int i = 0;
		int Hashcode = sHash(key);
		int hash = iHash(Hashcode, i);
		while (table[hash] != null && table[hash].getStatus() != 0) {
			if (key.equals(table[hash].getKey())) {
				if (table[hash].getStatus() == 2) {
					System.out.println("Not Exist");
					return null;
				}
				System.out.println(table[hash].toString());
				return table[hash].toString();

			}
			++i;
			hash = iHash(Hashcode, i);
		}
		System.out.println("Not Exist");
		return null;

	}

	public String delete(String key) {
		int postion = search(key);
		if (postion == -1)
			return "Not Found";
		else {
			table[postion].setStatus(2);
			currentSize--;
			return table[postion].toString();
		}
	}

	public Boolean isFull() {
		return currentSize == table.length / 2;
	}

	public void insert(String key, T value) {

		if (isFull()) {
			rehash();
		}
		int i = 0;
		int hashcode = value.hashCode();
		int hash = iHash(hashcode, i);
		while (table[hash] != null && table[hash].getStatus() != 0) {
			if (key.equals(table[hash].getKey())) {
				table[hash].setValue(value);
				if (table[hash].getStatus() == 2) {
					table[hash].setStatus(1);
					currentSize++;
				}
				return;
			}
			if ((table[hash].getStatus() == 2)) {
				break;
			}

			++i;
			hash = (iHash(hashcode, i));
		}
		table[hash] = new HashEntry(key, value, 1);
		currentSize++;

	}

	public int iHash(int key, int loopCount) {
		return (key + (loopCount * loopCount)) % table.length;
	}

	/* search hash */
	public int sHash(String key) {
		int result = 0;
		for (int i = 0; i < key.length(); i++) {
			result += ((int) key.charAt(i)) * Math.pow(2, i);
		}
		return result;
	}
	/* --search hash */

	public void print() {
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				if (table[i].getStatus() != 2) {
					System.out.print("index ---->  " + i + "  ------->   ");
					System.out.print(table[i].toString());
				}
			}
		}
	}

	private void rehash() {
		HashTable newlist;
		newlist = new HashTable(getprime(table.length));
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				newlist.insert(table[i].getKey().toString(), table[i].getValue());
			}
		}
		table = newlist.table;

	}

	private int getprime(int number) {
		int num = 2;

		int result = (number * num);
		while (isprime(result) != true) {
			result++;

		}
		return result;
	}

	private static boolean isprime(int i) {
		for (int j = 2; j < i; j++) {
			if (i % j == 0)
				return false;
		}

		return true;
	}

	public int getTablesize() {
		return table.length;
	}

	public String printonfile() {
		String result = "";
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				if (table[i].getStatus() != 2) {

					result += table[i].toString();
				}
			} else {
				result += "\n";
			}

		}
		return result;
	}

	public int printTablesize() {
		return table.length;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void makeEmpty() {
		table = new HashEntry[TableSize];
		currentSize = 0;
	}
}
