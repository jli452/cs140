package quiz20200422;

public enum Continent {
	AFRICA {
		@Override
		public String toString() {
			return "Africa";
		}  
	}, ASIA {
		@Override
		public String toString() {
			return "Asia";
		}    
	}, EUROPE {
		@Override
		public String toString() {
			return "Europe";
		}  
	}, NORTH_AMERICA {
		@Override
		public String toString() {
			return "North America";
		}  
	}, OCEANIA {
		@Override
		public String toString() {
			return "Oceania";
		}  
	}, SOUTH_AMERICA {
		@Override
		public String toString() {
			return "South America";
		}  
	}
}