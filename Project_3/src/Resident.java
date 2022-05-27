
public class Resident {
	private String id;
	private String fullName;
	private int age;
	private char gender;

	public Resident(String ID) {
		this.id = ID;
	}

	public Resident(String id, String fullName, int age, char gender) {
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		long result = 0;
		for (int i = 0; i < this.id.length(); i++) {
			result += ((int) id.charAt(i)) * Math.pow(2, i);
		}
		return (int) result;

	}

	public String getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Resident [id=" + id + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender + "]";
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

}
