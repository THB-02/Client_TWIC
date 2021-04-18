package com.twic.operations;

public class Operation {

	public Operation() {

	}

	public double calculDistance(String ville1, String ville2) {
		System.out.println(ville1);
		System.out.println(ville2);

		String[] coordVille1 = ville1.split(",");
		double lattitudeVille1 = Double.parseDouble(coordVille1[0]);
		double longitudeVille1 = Double.parseDouble(coordVille1[1]);

		String[] coordVille2 = ville2.split(",");
		double lattitudeVille2 = Double.parseDouble(coordVille2[0]);
		double longitudeVille2 = Double.parseDouble(coordVille2[1]);

		double x = (longitudeVille2 - longitudeVille1) * Math.cos((lattitudeVille2 + lattitudeVille1)/2);
		double y = lattitudeVille2 - lattitudeVille1;
		double z = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		double k = 1.852*60;
		double distance = Math.abs(Math.round(k*z*100.0)/100.0);
		
		double distance2 = Math.abs(6378*Math.acos(Math.sin(lattitudeVille1)*Math.sin(lattitudeVille2)
				+Math.cos(lattitudeVille1)*Math.cos(lattitudeVille2)*Math.cos(longitudeVille2-longitudeVille1)));
		
		System.out.println(distance2);
		
		return distance;
	}
}
