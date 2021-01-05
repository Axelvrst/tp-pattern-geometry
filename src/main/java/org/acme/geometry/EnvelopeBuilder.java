package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeBuilder {
	
	private List<Coordinate> coords;

    public EnvelopeBuilder() {
        this.coords = new ArrayList<Coordinate>();
    }

    public void insert(Coordinate coordinate) {
        this.coords.add(coordinate);
    }

    public Envelope build() {
        if(coords.isEmpty()) {
        	return new Envelope();
        }
        
        else {
            double firstX = coords.get(0).getX();
            double firstY = coords.get(0).getY();
            double Xmin = 0.0;
            double Xmax = 0.0;
            double Ymin = 0.0;
            double Ymax = 0.0;
            
            for (Coordinate coordinate : coords) {
            	Xmin = Math.min(firstX, coordinate.getX());
            	Ymin = Math.min(firstY, coordinate.getY());
            	Xmax = Math.max(firstX, coordinate.getX());
            	Ymax = Math.max(firstY, coordinate.getY());
            }
            
            return new Envelope(new Coordinate(Xmin, Ymin), new Coordinate(Xmax, Ymax));
        }
    }

}
