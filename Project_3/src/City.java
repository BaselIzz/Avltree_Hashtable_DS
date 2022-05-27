
public class City implements Comparable<City> {
	private String cityName;
	private String cityFile;

	public City(String cName, String fName) {
		this.cityName = cName;
		this.cityFile = fName;
	}

	public City(String cName) {
		this.cityName = cName;

	}

	@Override
	public String toString() {
		return cityName + "";
	}

	public String getCityName() {
		return cityName;
	}

	public String getCityFile() {
		return cityFile;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCityFile(String cityFile) {
		this.cityFile = cityFile;
	}

	@Override
	public int compareTo(City o) {

		return this.cityName.compareToIgnoreCase(o.cityName);
	}

}
