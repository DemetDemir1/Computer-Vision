//Author: Demet Demir
//Program to make a VideoSnapshot

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture; 
    
public class Cam_Snapshot1 {
public static void main (String args[]){
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	VideoCapture camera = new VideoCapture(0);
	
	if(!camera.isOpened()){
		System.out.println("Error");
	}
	else {
		StringBuilder pictureName = new StringBuilder();
		String newString = new String();
		String picture = new String();
		int counter = 0;
		picture = "snapshot";
		Mat frame = new Mat();
	    while(true){
	    	if (camera.read(frame)){
	    		System.out.println("Frame Obtained");
	    		System.out.println("Captured Frame Width " + 
	    		frame.width() + " Height " + frame.height());
	    		newString = Integer.toString(counter);
	    		pictureName = pictureName.append(picture).append(newString);
	    		Imgcodecs.imwrite(pictureName+".jpg", frame);
	    		counter++;
	    		System.out.println("OK");
	    		System.out.println(pictureName);
	    		break;
	    	}
	    }	
	}
	camera.release();
}
}   